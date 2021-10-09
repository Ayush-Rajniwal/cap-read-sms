export type PERMISSION = 'granted' | 'denied';

export interface SMS_INTERFACE {
  address?: string;
  body?: string;
  creator?: string;
  date?: string;
  date_sent?: string;
  error_code?: string;
  ipmsg_id?: string;
  locked?: string;
  protocol?: string;
  read?: string;
  reply_path_present?: string;
  seen?: string;
  service_center?: string;
  status?: string;
  sub_id?: string;
  thread_id?: string;
  type?: string;
  _id?: string;
}

export interface ReadSMSPlugin {
  getSMS(options: {
    timestamp?: string;
    pageSize?: number;
    sender?: string;
  }): Promise<{ value: SMS_INTERFACE[] }>;
  checkPermission(): Promise<{ value: PERMISSION }>;
  requestPermission(): Promise<{ value: PERMISSION }>;
}
