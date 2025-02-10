# bixie-customize-pos-printer

Customize Bixie printer plugin

## Install

```bash
npm install bixie-customize-pos-printer
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`connectToDevice(...)`](#connecttodevice)
* [`testPrint()`](#testprint)
* [`printTicket(...)`](#printticket)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### connectToDevice(...)

```typescript
connectToDevice(options: { address: string; }) => Promise<{ value: string; success: string; error: string; }>
```

| Param         | Type                              |
| ------------- | --------------------------------- |
| **`options`** | <code>{ address: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; success: string; error: string; }&gt;</code>

--------------------


### testPrint()

```typescript
testPrint() => Promise<{ value: string; }>
```

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### printTicket(...)

```typescript
printTicket(options: { firstName: string; drawDate: string; datePrinted: string; qrcode: string; games: string; total: string; drawTime: string; agentCode: string; maxSize: number; }) => Promise<{ success: string; error: string; }>
```

| Param         | Type                                                                                                                                                                           |
| ------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **`options`** | <code>{ firstName: string; drawDate: string; datePrinted: string; qrcode: string; games: string; total: string; drawTime: string; agentCode: string; maxSize: number; }</code> |

**Returns:** <code>Promise&lt;{ success: string; error: string; }&gt;</code>

--------------------

</docgen-api>
