import {ShortURLWithTarget} from '../../DBReturnTypes/ShortUrlWithTarget';

export class DbIterator {
  counter: number;
  rows: ShortURLWithTarget[];

  constructor(rows: ShortURLWithTarget[]) {
    this.rows = rows;
    this.counter = -1;
  }

  hasNext(): boolean {
    return this.counter + 1 < this.rows.length;
  }

  next(): ShortURLWithTarget {
    this.counter++;
    return this.rows[this.counter];
  }
}
