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
import {FormControl} from '@angular/forms';
import {apiUrl} from '../../../../environments/environment';

@Component({
  selector: 'app-create-tag-dialog',
  templateUrl: './create-tag-dialog.component.html',
  styleUrls: ['./create-tag-dialog.component.css'],
})
export class CreateTagDialogComponent implements OnInit {

  constructor(public dbconnector: DbConnectorService,
              public dialog: MatDialogRef<CreateTagDialogComponent>,
              public acceptDialog: MatDialog) {}

  ngOnInit(): void {
  }

  closeDialog(): void {
    this.dialog.close();
  }
}
