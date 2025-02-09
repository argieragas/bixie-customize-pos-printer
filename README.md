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

</docgen-api>
