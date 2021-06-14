import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {DbConnectorService} from '../../../Services/DB-Connect-Services/db-connector.service';
import {convertToUrlCall, UrlCall} from '../../../DBReturnTypes/UrlCall';
import {convertToTargetUrl, TargetUrl} from '../../../DBReturnTypes/TargetUrl';
import {convertToShortURLWithTarget, ShortURLWithTarget} from '../../../DBReturnTypes/ShortUrlWithTarget';
import {scopeToString} from '../../../Services/Util/Formatter/ScopeFormatter';
import {HttpErrorResponse, HttpStatusCode} from '@angular/common/http';
import {YesNoDialogComponent} from '../yes-no-dialog/yes-no-dialog.component';
import {convertToTag, Tag} from '../../../DBReturnTypes/Tag';
import {Color} from 'ag-grid-community';
import {formatDateFromDate, formatDateFromGrid} from '../../../Services/Util/Formatter/DateFormatter';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {apiUrl} from '../../../../environments/environment';

@Component({
  selector: 'app-create-tag-dialog',
  templateUrl: './create-tag-dialog.component.html',
  styleUrls: ['./create-tag-dialog.component.css'],
})
export class CreateTagDialogComponent implements OnInit {

  createTagForm: FormGroup;

  constructor(public dbconnector: DbConnectorService,
              public dialog: MatDialogRef<CreateTagDialogComponent>,
              public acceptDialog: MatDialog) {

    this.createTagForm = new FormGroup({
      tagTitle: new FormControl('', {}),
      tagDescription: new FormControl('', {}),
      tagColor: new FormControl('', {}),
    });
  }

  ngOnInit(): void {
  }

  closeDialog(): void {
    this.dialog.close();
  }

  public createTag(): void {

    this.dbconnector.createTagForGroup(
      this.createTagForm.get('tagTitle').value,
      this.createTagForm.get('tagDescription').value,
      this.createTagForm.get('tagColor').value);

    this.closeDialog();
  }
}
