import { WebPlugin } from '@capacitor/core';

import type { BixiePOSPrinterPlugin } from './definitions';

export class BixiePOSPrinterWeb extends WebPlugin implements BixiePOSPrinterPlugin {
  SamplePrinter(options: { name: string; }): Promise<{ value: string; }> {
    throw new Error(`Method not implemented. ${options}`);
  }
  Image(options: {image: ImageData}): Promise<{value: string; }> {
    throw new Error(`Method not implemented. ${options}`);
  }
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
