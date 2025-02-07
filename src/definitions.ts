export interface BixiePOSPrinterPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
