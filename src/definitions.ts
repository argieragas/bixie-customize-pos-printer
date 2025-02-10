export interface BixiePOSPrinterPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  connectToDevice(options: { address: string }): Promise<{ value: string, success: string, error: string}>;
  testPrint(): Promise<{ value: string }>;
  printTicket(options: {
    firstName: string;
    drawDate: string;
    datePrinted: string;
    qrcode: string;
    games: string;
    total: string;
    drawTime: string;
    agentCode: string;
    maxSize: number;
  }): Promise<{success: string, error: string}>;
}