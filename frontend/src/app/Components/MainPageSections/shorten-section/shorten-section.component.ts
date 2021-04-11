import { Component, OnInit } from '@angular/core';
import {DbConnectorService} from '../../../Services/DB-Connect-Services/db-connector.service';

@Component({
  selector: 'app-shorten-section',
  templateUrl: './shorten-section.component.html',
  styleUrls: ['./shorten-section.component.css']
})
export class ShortenSectionComponent implements OnInit {
  document: any;
  private urlTF = document.getElementById('originalURL') as HTMLInputElement;
  private wishURLTF = document.getElementById('wishURL') as HTMLInputElement;

  columnDefs = [
    { field: 'name', headerName: 'URL', sortable: true, resizable: true, filter: true, checkboxSelection: true },
    { field: 'type',  headerName: 'Typ', sortable: true, filter: true, resizable: true }
  ];

  rowData = [];

  constructor(private dbconnector: DbConnectorService) {}

  ngOnInit(): void {
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

    let url = this.urlTF.value;
    let wishURL = this.wishURLTF.value;

    if (this.URL_In_Database(wishURL) === true) {
      url = wishURL;
      this.saveURL(url);
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

  saveURL(url: string): boolean{
    this.dbconnector.saveNewURL(url);
    return true;
  }
}
