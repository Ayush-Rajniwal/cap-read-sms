package com.ayushrajniwal.plugins.readsms;

import static android.content.ContentValues.TAG;

import android.Manifest;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.getcapacitor.JSObject;
import com.getcapacitor.PermissionState;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;
import com.getcapacitor.annotation.PermissionCallback;
import java.util.ArrayList;
import org.json.JSONArray;

@CapacitorPlugin(name = "ReadSMS",  permissions = { @Permission(alias = "sms_reader", strings = { Manifest.permission.READ_SMS }) })
public class ReadSMSPlugin extends Plugin {

    private ReadSMS implementation = new ReadSMS();

     public void load() {
        Log.i(TAG, "[SMS Read Plugin]: loaded");
    }

    @PluginMethod
    public void checkPermission(PluginCall call) {
        JSObject result = new JSObject();
        if (getPermissionState("sms_reader") == PermissionState.GRANTED) {
            result.put("value", PermissionState.GRANTED.toString());
        } else {
            result.put("value", PermissionState.DENIED.toString());
        }
        call.resolve(result);
    }

    @PluginMethod
    public void requestPermission(PluginCall call) {
        requestPermissionForAlias("sms_reader", call, "requestPermissionCB");
    }

    @PermissionCallback
    private void requestPermissionCB(PluginCall call) {
        JSObject result = new JSObject();
        if (getPermissionState("sms_reader") == PermissionState.GRANTED) {
            result.put("value", PermissionState.GRANTED.toString());
        } else {
            result.put("value", PermissionState.DENIED.toString());
        }
        call.resolve(result);
    }

    @PluginMethod
    public void getSMS(PluginCall call) {
        if (getPermissionState("sms_reader") != PermissionState.GRANTED) {
            requestPermissionForAlias("sms_reader", call, "smsCallback");
        } else {
            // If permission is already granted then call the filterSMS directly
            filterSMS(call);
        }
    }

    @PermissionCallback
    private void smsCallback(PluginCall call) {
        if (getPermissionState("sms_reader") == PermissionState.GRANTED) {
            Log.i(TAG, "[SMS Read Plugin]: Permission Granted");
            filterSMS(call);
        } else {
            Log.i(TAG, "[SMS Read Plugin]: Permission Denied");
            call.reject(PermissionState.DENIED.toString());
        }
    }

    private void filterSMS(@NonNull PluginCall call) {
        JSObject result = new JSObject();
        Long timeStamp = Long.parseLong(call.getString("timestamp", "0"));
        Log.d("timestamp", " " + timeStamp);
        int pageSize = call.getInt("pageSize", 10);
        Log.d("pageSize", " " + pageSize);
        String sender = call.getString("sender");
        Log.d("sender", " " + sender);

        ArrayList messages = new ArrayList<JSObject>();

        String smsFilter = "date>=" + timeStamp.toString();
        if (sender != null) {
            smsFilter += " AND address='" + sender + "'";
        }

        Cursor cursor = getContext().getContentResolver().query(Uri.parse("content://sms/inbox"), null, smsFilter, null, null);
        if (cursor.moveToFirst()) { // must check the result to prevent exception
            do {
                JSObject message = new JSObject();
                for (int idx = 0; idx < cursor.getColumnCount(); idx++) {
                    message.put(cursor.getColumnName(idx), cursor.getString(idx));
                }
                messages.add(message);
                pageSize--;
            } while (pageSize != 0 && cursor.moveToNext());
        } else {
            // empty box, no SMS
            result.put("value", "NO_SMS");
            call.resolve(result);
        }

        JSONArray arrayOfSMS = new JSONArray(messages);
        result.put("value", arrayOfSMS);
        call.resolve(result);
    }
}
