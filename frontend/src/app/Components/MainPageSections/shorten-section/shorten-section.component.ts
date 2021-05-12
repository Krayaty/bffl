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

  items = this.shortenService.getItems();

  shortenURLForm = this.formBuilder.group({
    targetURL: ['', Validators.required],
    customSuffix: ['', Validators.required],
    updateFlag: '',
    deleteFlag: '',
    scope: '',
    tags: ''
  });

  constructor(private dbconnector: DbConnectorService,
              private authService: AuthService,
              private formBuilder: FormBuilder,
              private shortenService: ShortenService) {
  }

  ngOnInit(): void {}

  onSubmit(): void {
    window.alert(this.shortenURLForm.value);
    this.shortenURLForm.reset();
  }

  shortenURL(): void {
    const targetURL: string = this.shortenURLForm.get('originalURL').value;
    const customSuffix: string = this.shortenURLForm.get('wishURL').value;
    let updateFlag: boolean = this.shortenURLForm.get('updateFlag').value;
    if (updateFlag !== true) {
      updateFlag = false;
    }
    let deleteFlag: boolean = this.shortenURLForm.get('deleteFlag').value;
    if (deleteFlag !== true) {
      deleteFlag = false;
    }
    const scope = this.shortenURLForm.get('scope').value;
    const assignedTagIds = this.shortenURLForm.get('tags').value;

    this.dbconnector.saveNewShortURLWithTags(customSuffix, scope, deleteFlag, updateFlag, targetURL, assignedTagIds);

  }
}
