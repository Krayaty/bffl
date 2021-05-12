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

  shortenURL(): void {
    const assignedTagIds: number[] = [];
    if (this.shortenURLForm.get('tags').value != null) {
      assignedTagIds.push();
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
  }
}
