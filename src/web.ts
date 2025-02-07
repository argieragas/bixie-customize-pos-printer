import { WebPlugin } from '@capacitor/core';

import type { BixiePOSPrinterPlugin } from './definitions';

export class BixiePOSPrinterWeb extends WebPlugin implements BixiePOSPrinterPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
