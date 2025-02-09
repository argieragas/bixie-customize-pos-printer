import { WebPlugin } from '@capacitor/core';

import type { BixiePOSPrinterPlugin } from './definitions';

export class BixiePOSPrinterWeb extends WebPlugin implements BixiePOSPrinterPlugin {
  connectToDevice(options: { address: string; }): Promise<{ value: string; success: string; error: string; }> {
    throw new Error(`Method not implemented. ${options}`);
  }
  testPrint(): Promise<{ value: string; }> {
    throw new Error('Method not implemented.');
  }
  Image(options: {image: ImageData}): Promise<{value: string; }> {
    throw new Error(`Method not implemented. ${options}`);
  }
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
