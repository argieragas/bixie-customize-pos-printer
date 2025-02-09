export interface BixiePOSPrinterPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  connectToDevice(options: { address: string }): Promise<{ value: string, success: string, error: string}>;
  testPrint(): Promise<{ value: string }>;
  printTicket(options: parameterOptions): Promise<{success: string, error: string}>;
}

export interface parameterOptions {
  firstName: string;
  drawDate: string;
  drawPrinted: string;
  qrcode: string;
  games: string;
  total: string;
  agentCode: string;
}