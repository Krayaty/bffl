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

  constructor(private dbconnector: DbConnectorService) { }

  ngOnInit(): void {
    this.urlTF = document.getElementById('originalURL') as HTMLInputElement;
    this.wishURLTF = document.getElementById('wishURL') as HTMLInputElement;
  }

  public ShortenURL(): string {

    let url = this.urlTF.value;
    let wishURL = this.wishURLTF.value;

    if (URL_In_Database(wishURL) === true) {
      url = wishURL;
      SaveURL(url);
    }
    else {
      const additionToURL = String(CreateRandomChar());
      wishURL = wishURL + additionToURL;
      ShortenURL(wishURL);
    }
    document.getElementById('resultURL').innerHTML = url.toString();
    return url;
  }


}

function ShortenURL(wishURL: string): string {
  let url: string;
  if (URL_In_Database(wishURL) === true) {
    url = wishURL;
    SaveURL(url);
  }
  else {
    const additionToURL = String(CreateRandomChar());
    wishURL = wishURL + additionToURL;
    ShortenURL(wishURL);
  }
  document.getElementById('resultURL').innerHTML = url;
  return url;
}

function URL_In_Database(wishURL: string): boolean {
  // this.dbconnector.getAllTargetURLs();
  return true;
}

function CreateRandomChar(): string {
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

function SaveURL(url: string): boolean{
  // this.dbconnector.save(url); ?
  return true;
}
