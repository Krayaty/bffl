import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ShortenService {
  items = [];

  getItems(): any[] {
    return this.items;
  }

  constructor() { }
}
