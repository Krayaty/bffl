export class GroupName {
  public groupName: string;

  public constructor(groupName: string) {
    this.groupName = groupName;
  }
}

export function convertToGroupName(object: any[]): GroupName {
  return new GroupName(
    object[0]
  );
}
