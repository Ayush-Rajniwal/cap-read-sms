import { registerPlugin } from '@capacitor/core';

import type { ReadSMSPlugin } from './definitions';

const ReadSMS = registerPlugin<ReadSMSPlugin>('ReadSMS', {
  web: () => import('./web').then(m => new m.ReadSMSWeb()),
});

export * from './definitions';
export { ReadSMS };
