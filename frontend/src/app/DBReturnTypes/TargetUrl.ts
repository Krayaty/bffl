export class TargetUrl {
  public url: string;
  public assignTimestamp: Date;

  public constructor(url: string, assignTimestamp: string) {
    this.url = url;
    this.assignTimestamp = new Date(Date.parse(assignTimestamp));
  }
}

export function convertToTargetUrl(object: any[]): TargetUrl {
  return new TargetUrl(
    object[0],
    object[1]
  );
}
