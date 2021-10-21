# cap-read-sms

Capacitor Plugin to read the user's SMS (with their permission)

### [Demo](https://github.com/Ayush-Rajniwal/Capacitor-read-sms-plugin-demo)

## Install

```bash
npm install cap-read-sms
```

Sync the plugin with capacitor.

```bash
npx cap sync
```

## Supported Platforms

| Platforms | Supported |
| --------- | --------- |
| Android   | ✅        |
| iOS       | ❌        |
| Web       | 🤷‍♂️        |

## API

<docgen-index>

- [`getSMS(...)`](#getsms)
- [`checkPermission()`](#checkpermission)
- [`requestPermission()`](#requestpermission)
- [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### getSMS(...)

```typescript
getSMS(options: { timestamp?: string; pageSize?: number; sender?: string; }) => any
```

| Param         | Type                                                                     |
| ------------- | ------------------------------------------------------------------------ |
| **`options`** | <code>{ timestamp?: string; pageSize?: number; sender?: string; }</code> |

**Returns:** <code>any</code>

---

### checkPermission()

```typescript
checkPermission() => any
```

**Returns:** <code>any</code>

---

### requestPermission()

```typescript
requestPermission() => any
```

**Returns:** <code>any</code>

---

### Interfaces

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
