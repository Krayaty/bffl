import { Component, OnInit } from '@angular/core';
import {DbConnectorService} from '../../../Services/DB-Connect-Services/db-connector.service';

@Component({
  selector: 'app-shorten-section',
  templateUrl: './shorten-section.component.html',
  styleUrls: ['./shorten-section.component.css']
})
export class ShortenSectionComponent implements OnInit {
  document: any;
  private urlTF;
  private wishURLTF;

  columnDefs = [
    { field: 'name', headerName: 'URL', sortable: true, resizable: true, filter: true, checkboxSelection: true },
    { field: 'type',  headerName: 'Typ', sortable: true, filter: true, resizable: true }
  ];

  rowData = [];

  constructor(private dbconnector: DbConnectorService) {}

  ngOnInit(): void {
    this.urlTF = document.getElementById('originalURL') as HTMLInputElement;
    this.wishURLTF = document.getElementById('wishURL') as HTMLInputElement;
    this.showAllURLsFromUser();
  }

  showAllURLsFromUser(): void {
    this.dbconnector.getAllURLsFromUser()
      .subscribe(
        data => {
          this.rowData = data;
        },
        error => {
          console.log(error);
        });
  }

  shortenURL(): string {

    // Timestamp (needed in the database)
    const timestamp = Date.now();

    // User-ID
    // tslint:disable-next-line:variable-name
    const user_id = this.getUserID();
    // Group-ID

    // tslint:disable-next-line:variable-name
    const group_id = this.getGroupID();
    //

    let url = this.urlTF.value;
    let wishURL = this.wishURLTF.value;

    if (URL_In_Database(wishURL) === true) {
      url = wishURL;
      // tslint:disable-next-line:variable-name
      const url_id = this.createID();
      this.saveURL(url, url_id, user_id, group_id);
    }
    else {
      const additionToURL = String(this.createRandomChar());
      wishURL = wishURL + additionToURL;
      this.shortenURL();
    }
    this.showAllURLsFromUser();
    return url;
  }

  URL_In_Database(wishURL: string): boolean {
    this.dbconnector.getAllTargetURLs();
    return true;
  }

  createRandomChar(): string {
    let max = 3;
    let min = 1;
    let randomNumber: number = Math.floor(Math.random() * (max - min + 1)) + min;

    switch (randomNumber) {
      case(1):
        max = 57;
        min = 48;
        randomNumber = Math.floor(Math.random() * (max - min + 1)) + min;
        let res = String.fromCharCode(randomNumber);
        return res;
      case(2):
        max = 90;
        min = 65;
        randomNumber = Math.floor(Math.random() * (max - min + 1)) + min;
        res = String.fromCharCode(randomNumber);
        return res;
      case(3):
        max = 122;
        min = 97;
        randomNumber = Math.floor(Math.random() * (max - min + 1)) + min;
        res = String.fromCharCode(randomNumber);
        return res;
    }
  }

  getUserID(): number {
    return 0;
  }

  getGroupID(): number {
  return 0;
  }

  createID(): string {
    let id = '';
    let i: number;
    for ( i = 0; i < 10; i++){
      id += this.createRandomChar();
    }
    return id;
  }

  // tslint:disable-next-line:variable-name
  saveURL(url: string, id: string, user_id: number, group_id: number): boolean{
    this.dbconnector.saveNewURL(url);
    return true;
  }
}
