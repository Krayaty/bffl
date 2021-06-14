export class UrlCall {
  public clientIp: string;
  public url: string;
  public callTimestamp: Date;

  public constructor(clientIp: string, url: string, callTimestamp: string) {
    this.clientIp = clientIp;
    this.url = url;
    this.callTimestamp = new Date(Date.parse(callTimestamp));
  }
}

export function convertToUrlCall(object: any[]): UrlCall {
  return new UrlCall(
    object[0],
    object[1],
    object[2]
  );
}
