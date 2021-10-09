export interface ReadSMSPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
