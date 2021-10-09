import { WebPlugin } from '@capacitor/core';

import type { ReadSMSPlugin, PERMISSION, SMS_INTERFACE } from './definitions';

export class ReadSMSWeb extends WebPlugin implements ReadSMSPlugin {
  async getSMS(): Promise<{ value: SMS_INTERFACE[] }> {
    console.error(
      "We're still not that advance to support the SMS in the browser 😄",
    );
    return {
      value: [{}],
    };
  }
  async requestPermission(): Promise<{ value: PERMISSION }> {
    return {
      value: 'denied',
    };
  }
  async checkPermission(): Promise<{ value: PERMISSION }> {
    return {
      value: 'denied',
    };
  }
}
