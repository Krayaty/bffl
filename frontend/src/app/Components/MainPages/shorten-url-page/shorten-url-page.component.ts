import { Component } from '@angular/core';
import { DbConnectorService } from '../../../Services/DB-Connect-Services/db-connector.service';
import { AuthService } from '../../../Services/Iam-Services/auth.service';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {Validators} from '@angular/forms';
import { ShortenService } from '../../../Services/Shorten-Services/shorten.service';


@Component({
  selector: 'app-shorten-url-page',
  templateUrl: './shorten-url-page.component.html',
  styleUrls: ['./shorten-url-page.component.css']
})

export class ShortenUrlPageComponent {

  shortenURLForm: FormGroup;

  targetURLRegEx = '[-a-zA-Z0-9@:%._\\+~#=\/\/]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&\\/\\/=]*)';
  customSuffixRegEx = '[a-zA-Z0-9]+[\.a-zA-Z0-9]*';

  items = this.shortenService.getItems();

  constructor(private dbconnector: DbConnectorService,
              private authService: AuthService,
              private formBuilder: FormBuilder,
              private shortenService: ShortenService) {

    this.shortenURLForm = new FormGroup({
      targetURL: new FormControl('', {
        validators: [Validators.required, Validators.pattern(this.targetURLRegEx)]
      }),
      customSuffix: new FormControl('', {
        validators: [Validators.required, Validators.pattern(this.customSuffixRegEx)]
      }),
      updateFlag: new FormControl('', {}),
      deleteFlag: new FormControl('', {}),
      scope: new FormControl('', {
        validators: [Validators.required]
      }),
      tags: new FormControl('', {}),
    });
  }

  shortenURL(): boolean {
    const assignedTagIds: number[] = [];
    if (this.shortenURLForm.get('tags').value != null) {
         assignedTagIds.push();
    }

    if ( this.shortenURLForm.get('targetURL').value == null || this.shortenURLForm.get('targetURL').value === '' ) {
         window.alert('Missing or wrong argument for TargetURL');
         return false;
    }
    if ( this.shortenURLForm.get('customSuffix').value == null || this.shortenURLForm.get('customSuffix').value === '') {
        window.alert('Missing or wrong argument for suffix of ShortURL');
        return false;
    }
    if ( this.shortenURLForm.get('scope').value == null || this.shortenURLForm.get('scope').value === '' ) {
        window.alert('Missing or wrong argument for scope');
        return false;
    }

    this.dbconnector.saveNewShortURLWithTags(
      this.shortenURLForm.get('customSuffix').value,
      this.shortenURLForm.get('scope').value,
      this.shortenURLForm.get('deleteFlag').value,
      this.shortenURLForm.get('updateFlag').value,
      this.shortenURLForm.get('targetURL').value,
      assignedTagIds
    );
    this.shortenURLForm.reset();
    return true;
  }
}
