import { registerPlugin } from '@capacitor/core';

import type { BixiePOSPrinterPlugin } from './definitions';

const BixiePOSPrinter = registerPlugin<BixiePOSPrinterPlugin>('BixiePOSPrinter', {
  web: () => import('./web').then((m) => new m.BixiePOSPrinterWeb()),
});

export * from './definitions';
export { BixiePOSPrinter };
