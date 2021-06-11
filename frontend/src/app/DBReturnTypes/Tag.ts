import {Color} from 'ag-grid-community';

export class Tag {
  private id: number;
  private title: string;
  private description: string;
  private color: Color;

  constructor(id: number, title: string, description: string, color: string) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.color = Color.fromString('#' + color);
  }

}

export function convertToTag(object: any[]): Tag {
  return new Tag(
    object[0],
    object[1],
    object[2],
    object[3]
  );
}
