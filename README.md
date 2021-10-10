# read-sms

Capacitor Plugin to read the user's SMS

## Install

```bash
npm install read-sms
npx cap sync
```

## Supported Platforms

| Platforms | Supported |
|-----------|-----------|
| Android   |     ✅     |
| iOS       |     ❌     |
| Web       |     🤷‍♂️     |
## API

<docgen-index>

* [`getSMS(...)`](#getsms)
* [`checkPermission()`](#checkpermission)
* [`requestPermission()`](#requestpermission)
* [Interfaces & Types](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### getSMS(...)
- Read User's SMS if permission is granted.
- If permission is not granted it will request for the permission first.
- Return the array of objects having keys from ```SMS_INTERFACE```.
- You can fiter SMS by passing an object to getSMS.

| Options Value      	| Default Value 	| Comment                                                                               	|
|-----------	|---------------	|---------------------------------------------------------------------------------------	|
| timestamp 	|       0       	| Make sure the timestamp have 13 digit (i.e It should represent milliseconds format).  	|
| pageSize  	|       10      	| Number of messages that will be return.                                               	|
| sender    	|      N/A      	| By Default no sender value is applied  .                                               	|

```typescript
getSMS(options: {
    timestamp?: string;
    pageSize?: number;
    sender?: string;
}) => SMS_INTERFACE[]
```

| Param         | Type                                                                     |
| ------------- | ------------------------------------------------------------------------ |
| **`options`** | <code>{ timestamp?: string; pageSize?: number; sender?: string; }</code> |

**Returns:** <code>SMS_INTERFACE[]</code>

--------------------


### checkPermission()
- Check if user has granted the SMS Read permission.
- Value return is either ```granted``` OR ```denied```.

```typescript
checkPermission() => PERMISSION
```

**Returns:** <code>PERMISSION</code>

--------------------

### requestPermission()
- Request the User for the SMS Read permission.
- Return ```granted``` if user accepts the permission, otherwise returns ```denied```.

```typescript
requestPermission() => PERMISSION
```

**Returns:** <code>PERMISSION</code>

--------------------

## Sample Usage
[Complete Example](https://github.com/Ayush-Rajniwal/Capacitor-read-sms-plugin-demo)
```typescript
...
import { Plugins } from "@capacitor/core";
import "read-sms";
const { ReadSMS } = Plugins;
...

const Home: React.FC = () => {

const [msg, setMsg] = useState<any>([]);
const [permStatus, setPermStatus] = useState("");
const readSMS = async () => {
    const sms = (await ReadSMS.getSMS()).value;
    setMsg((val:any) => [...val, ...sms]);
    console.log(sms, "value of SMS");
}

const requestPermission = async () => {
    const permission = (await ReadSMS.requestPermission()).value;
setPermStatus(permission);
    console.log(permission, "permission");
}

const checkPermission = async () => {
    const permission = (await ReadSMS.checkPermission()).value;
setPermStatus(permission);
    console.log(permission, "checkPermission");
}
return <YOUR_JSX_CODE/>
}
```
--------------------

### Interfaces & TYPES

### PERMISSION
Possible values:
-  ```granted```
 - ```denied```


#### SMS_INTERFACE

| Prop                     | Type                |
| ------------------------ | ------------------- |
| **`address`**            | <code>string</code> |
| **`body`**               | <code>string</code> |
| **`creator`**            | <code>string</code> |
| **`date`**               | <code>string</code> |
| **`date_sent`**          | <code>string</code> |
| **`error_code`**         | <code>string</code> |
| **`ipmsg_id`**           | <code>string</code> |
| **`locked`**             | <code>string</code> |
| **`protocol`**           | <code>string</code> |
| **`read`**               | <code>string</code> |
| **`reply_path_present`** | <code>string</code> |
| **`seen`**               | <code>string</code> |
| **`service_center`**     | <code>string</code> |
| **`status`**             | <code>string</code> |
| **`sub_id`**             | <code>string</code> |
| **`thread_id`**          | <code>string</code> |
| **`type`**               | <code>string</code> |
| **`_id`**                | <code>string</code> |

</docgen-api>
