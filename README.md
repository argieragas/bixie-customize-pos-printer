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
* [`SamplePrinter(...)`](#sampleprinter)

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


### SamplePrinter(...)

```typescript
SamplePrinter(options: { name: string; }) => Promise<{ value: string; }>
```

| Param         | Type                           |
| ------------- | ------------------------------ |
| **`options`** | <code>{ name: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------

</docgen-api>
