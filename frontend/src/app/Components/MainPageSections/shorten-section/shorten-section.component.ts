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
    {field: 'name', headerName: 'URL', sortable: true, resizable: true, filter: true, checkboxSelection: true},
    {field: 'type', headerName: 'Typ', sortable: true, filter: true, resizable: true}
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
    const url: string = this.shortenURLForm.get('originalURL').value;
    const wishURL: string = this.shortenURLForm.get('wishURL').value;
    let updateFlag: boolean = this.shortenURLForm.get('updateFlag').value;
    if (updateFlag !== true) {
      updateFlag = false;
    }
    let deleteFlag: boolean = this.shortenURLForm.get('deleteFlag').value;
    if (deleteFlag !== true) {
      deleteFlag = false;
    }
    const scope = this.shortenURLForm.get('scope').value;
    const type = this.shortenURLForm.get('type').value;
    const protocol = this.shortenURLForm.get('protocol').value;
    const owner = this.shortenURLForm.get('owner').value;
    const tags = this.shortenURLForm.get('tags').value;
    // Select the right method to write to the endpoint, dependent of the optional arguments
    if (tags != null && owner != null) {
      this.dbconnector.saveNewURLPlusOwnerAndTags(timestamp, deleteFlag, updateFlag, url, wishURL, scope, protocol, owner, tags);
    } else if (tags != null) {
      this.dbconnector.saveNewURLPlusTags(timestamp, deleteFlag, updateFlag, url, wishURL, scope, protocol, tags);
    } else if (tags != null) {
      this.dbconnector.saveNewURLPlusOwner(timestamp, deleteFlag, updateFlag, url, wishURL, scope, protocol, owner);
    } else {
      this.dbconnector.saveNewURL(timestamp, deleteFlag, updateFlag, url, wishURL, scope, protocol);
    }
  }
}
