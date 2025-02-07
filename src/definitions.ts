export interface BixiePOSPrinterPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  SamplePrinter(options: {name: string}): Promise<{value: string}>;
}
