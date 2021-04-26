import { Component, OnInit } from '@angular/core';
import { DbConnectorService } from '../../../Services/DB-Connect-Services/db-connector.service';
import { AuthService } from '../../../Services/Iam-Services/auth.service';
import { FormBuilder } from '@angular/forms';
import {Validators} from '@angular/forms';
import { ShortenService } from '../../../Services/Shorten-Services/shorten.service';


@Component({
  selector: 'app-shorten-section',
  templateUrl: './shorten-section.component.html',
  styleUrls: ['./shorten-section.component.css']
})
export class ShortenSectionComponent implements OnInit {
  document: any;

  items = this.shortenService.getItems();
  shortenURLForm = this.formBuilder.group({
    originalURL: ['', Validators.required],
    wishURL: ['', Validators.required],
    updateFlag: '',
    deleteFlag: '',
    scope: '',
    type: '',
    owner: ['', Validators.required],
    protocol: '',
    tags: ''
  });

  columnDefs = [
    { field: 'name', headerName: 'URL', sortable: true, resizable: true, filter: true, checkboxSelection: true },
    { field: 'type',  headerName: 'Typ', sortable: true, filter: true, resizable: true }
  ];

  rowData = [];

  constructor(private dbconnector: DbConnectorService,
              private authService: AuthService,
              private formBuilder: FormBuilder,
              private shortenService: ShortenService) {
  }

  onSubmit(): void {
     window.alert(this.shortenURLForm.value);
      // window.alert(this.shortenURLForm.value);
     this.shortenURLForm.reset();
  }

  ngOnInit(): void {
  }

  shortenURL(): void {
    // Timestamp
    const timestamp = Date.now();
    // User-ID - später getAccessTokenParsed benutzen!
    const userId = this.authService.getAccessToken().sub;
    // Group-ID
    let groupId: string;
    this.dbconnector.getGroupID(userId)
      .subscribe(data => {
          groupId = data;
        },
        error => {
          console.log(error);
        });
    window.alert('GroupID: ' + groupId);
    const url: string = this.shortenURLForm.get('originalURL').value;
    const wishURL: string = this.shortenURLForm.get('wishURL').value;
    let updateFlag: boolean = this.shortenURLForm.get('updateFlag').value;
    if ( updateFlag !== true){
      updateFlag = false;
    }
    let deleteFlag: boolean = this.shortenURLForm.get('deleteFlag').value;
    if ( deleteFlag !== true){
      deleteFlag = false;
    }
    const scope = this.shortenURLForm.get('scope').value;
    const type = this.shortenURLForm.get('type').value;
    const protocol = this.shortenURLForm.get('protocol').value;
    const owner = this.shortenURLForm.get('owner').value;
    const tags = this.shortenURLForm.get('tags').value;
    const urlId = this.createID();
    const tagId = 'MeineURL';
    this.dbconnector.saveNewURL(timestamp, deleteFlag, updateFlag, groupId, tagId, url, wishURL, scope);
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

  createID(): string {
    let id = '';
    let i: number;
    for ( i = 0; i < 10; i++){
      id += this.createRandomChar();
    }
    return id;
  }
}
