import { Component } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {DbConnectorService} from '../../../Services/DB-Connect-Services/db-connector.service';
import {AuthService} from '../../../Services/Iam-Services/auth.service';
import {ShortenService} from '../../../Services/Shorten-Services/shorten.service';

@Component({
  selector: 'app-shorten-section',
  templateUrl: './shorten-section.component.html',
  styleUrls: ['./shorten-section.component.css']
})

export class ShortenSectionComponent {

  shortenURLForm: FormGroup;

  originalUrlRegEx = '[-a-zA-Z0-9@:%._\\+~#=\/\/]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&\\/\\/=]*)';
  customSuffixRegEx = '[a-zA-Z0-9]+[\.a-zA-Z0-9]*';

  items = this.shortenService.getItems();
  currentTags = [];

  constructor(private dbconnector: DbConnectorService,
              private authService: AuthService,
              private formBuilder: FormBuilder,
              private shortenService: ShortenService) {
    this.shortenURLForm = new FormGroup({
      originalURL: new FormControl('', {
        validators: [Validators.required, Validators.pattern(this.originalUrlRegEx)]}),
      customSuffix: new FormControl('', {
        validators: [Validators.required, Validators.pattern(this.customSuffixRegEx)]}),
      updateFlag: new FormControl('', {}),
      deleteFlag: new FormControl('', {}),
      scope: new FormControl('', {
        validators: [Validators.required]}),
      tagInput: new FormControl('', {}),
    });
  }

  shortenURL(): boolean {
    if ( this.shortenURLForm.get('originalURL').value == null || this.shortenURLForm.get('originalURL').value === '' ) {
         window.alert('Missing or wrong argument in original URL');
         return false;
    }
    if ( this.shortenURLForm.get('customSuffix').value == null || this.shortenURLForm.get('customSuffix').value === '') {
        window.alert('Missing or wrong argument in short URL');
        return false;
    }
    if ( this.shortenURLForm.get('scope').value == null || this.shortenURLForm.get('scope').value === '' ) {
        window.alert('Missing or wrong argument in scope');
        return false;
    }

    this.dbconnector.saveNewShortURLWithTags(
      this.shortenURLForm.get('customSuffix').value,
      this.shortenURLForm.get('scope').value,
      this.shortenURLForm.get('deleteFlag').value,
      this.shortenURLForm.get('updateFlag').value,
      this.shortenURLForm.get('originalURL').value,
      this.currentTags,
    );
    this.shortenURLForm.reset();
    return true;
  }

  addTag(): void {
    this.currentTags.push(this.shortenURLForm.get('tagInput').value);
    this.shortenURLForm.get('tagInput').reset();
    console.log(this.currentTags);
  }

  deleteTag(tag): void {
    this.currentTags = this.currentTags.filter(t => t != tag);
  }

  public getTagAddDisabled(): boolean {
    return ( (this.shortenURLForm.get('tagInput').value == "") ||
            (this.shortenURLForm.get('tagInput').value == null) ||
            (this.currentTags.includes(this.shortenURLForm.get('tagInput').value) ) );
  }
}
