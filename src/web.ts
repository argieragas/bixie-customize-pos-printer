import { WebPlugin } from '@capacitor/core';

import type { BixiePOSPrinterPlugin } from './definitions';

export class BixiePOSPrinterWeb extends WebPlugin implements BixiePOSPrinterPlugin {
  printTicket(options: {
    firstName: string;
    drawDate: string;
    datePrinted: string;
    qrcode: string;
    games: string;
    total: string;
    agentCode: string;
    drawTime: string;
    maxSize: number;
  }): Promise<{ success: string; error: string; }> {
    throw new Error(`Method not implemented. ${options}`);
  }
  connectToDevice(options: { address: string; }): Promise<{ value: string; success: string; error: string; }> {
    throw new Error(`Method not implemented. ${options}`);
  }
  testPrint(): Promise<{ value: string; }> {
    throw new Error('Method not implemented.');
  }
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
