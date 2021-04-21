import { Component, OnInit } from '@angular/core';
import { DbConnectorService } from '../../../Services/DB-Connect-Services/db-connector.service';
import { AuthService } from '../../../Services/Iam-Services/auth.service';
import { FormBuilder } from '@angular/forms';
import { ShortenService } from '../../../Services/Shorten-Services/shorten.service';

@Component({
  selector: 'app-shorten-section',
  templateUrl: './shorten-section.component.html',
  styleUrls: ['./shorten-section.component.css']
})
export class ShortenSectionComponent implements OnInit {
  document: any;
 /* private urlTF = document.getElementById('originalURL') as HTMLInputElement;
  private wishURLTF = document.getElementById('wishURL') as HTMLInputElement;
  private updateFlagTF = document.getElementById('update_flag') as HTMLInputElement;
  private deleteFlagTF = document.getElementById('delete_flag') as HTMLInputElement;
  private scopeTF = document.getElementById('scope') as HTMLInputElement;
*/
  items = this.shortenService.getItems();
  shortenURLForm = this.formBuilder.group({
    originalURL: '',
    wishURL: '',
    update_flag: '',
    delete_flag: '',
    scope: '',
    type: '',
    owner: '',
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
    console.log(this.shortenURLForm.value);
    // window.alert(this.shortenURLForm.value);
    this.shortenURLForm.reset();
  }

  ngOnInit(): void {
  }

  shortenURL(): void {
    window.alert('Method shortenURL() reached');

    // Timestamp
    const timestamp = Date.now();
    window.alert('Timestamp: ' + timestamp);

    // User-ID
    // später getAccessTokenParsed benutzen!
    const userId = this.authService.getAccessToken().sub;
    window.alert('UserID: ' + userId);

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
    /*
    const url = this.urlTF.value;
    window.alert('URL: ' + url);
    const wishURL = this.wishURLTF.value;
    window.alert('WishURL: ' + wishURL);
    const updateFlag: string = this.updateFlagTF.value;
    window.alert('UpdateFlag: ' + updateFlag);
    const deleteFlag: string = this.deleteFlagTF.value;
    window.alert('DeleteFlag: ' + deleteFlag);
    const scope: string = this.scopeTF.value;
    window.alert('Scope: ' + scope);
    const urlId = this.createID();
    const tagId = 'MeineURL';
    this.dbconnector.saveNewURL(timestamp, deleteFlag, updateFlag, groupId, tagId, url, wishURL, scope);
    */
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
