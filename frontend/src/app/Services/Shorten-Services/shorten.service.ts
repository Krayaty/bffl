import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ShortenService {
  items = [];

  // tslint:disable-next-line:typedef
  getItems() {
    return this.items;
  }

  constructor() { }
}
