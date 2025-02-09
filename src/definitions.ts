export interface BixiePOSPrinterPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  connectToDevice(options: { address: string }): Promise<{ value: string, success: string, error: string}>;
  testPrint(): Promise<{ value: string }>;
}
