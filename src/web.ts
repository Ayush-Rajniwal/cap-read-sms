import { WebPlugin } from '@capacitor/core';

import type { ReadSMSPlugin } from './definitions';

export class ReadSMSWeb extends WebPlugin implements ReadSMSPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
