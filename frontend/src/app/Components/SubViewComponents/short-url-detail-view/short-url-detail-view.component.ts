import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {DbConnectorService} from '../../../Services/DB-Connect-Services/db-connector.service';
import {convertToUrlCall, UrlCall} from '../../../DBReturnTypes/UrlCall';
import {convertToTargetUrl, TargetUrl} from '../../../DBReturnTypes/TargetUrl';
import {convertToShortURLWithTarget, ShortURLWithTarget} from '../../../DBReturnTypes/ShortUrlWithTarget';
import * as moment from 'moment';
import {scopeToString} from '../../../Services/Formatter/ScopeFormatter';
import {HttpStatusCode} from '@angular/common/http';
import {YesNoDialogComponent} from '../yes-no-dialog/yes-no-dialog.component';

@Component({
  selector: 'app-short-url-detail-view',
  templateUrl: './short-url-detail-view.component.html',
  styleUrls: ['./short-url-detail-view.component.css'],
})
export class ShortUrlDetailViewComponent implements OnInit{

  originalData: ShortURLWithTarget;
  changedData: ShortURLWithTarget;

  apiTargetUrl;
  apiUrlCall;

  columnApiTargetUrl;
  columnApiUrlCall;

  rowDataTargetUrl: TargetUrl[] = [];
  rowDataUrlCall: UrlCall[] = [];

  columnDefsTargetUrl = [{
    field: 'url',
    headerName: 'TargetUrl',
    hide: false,
    sortable: true,
    filter: true,
    resizable: true
  }, {
    field: 'assignTimestamp',
    headerName: 'Assignment Time',
    cellRenderer: (data) => {
      return  moment(data.assignTimestamp). format('DD. MMM yyyy hh:ss:mm A');
    },
    hide: false,
    sortable: true,
    filter: true,
    resizable: true
  }];
  columnDefsUrlCall = [{
    field: 'callTimestamp',
    headerName: 'Time of Call',
    cellRenderer: (data) => {
      return  moment(data.callTimestamp). format('DD. MMM yyyy hh:ss:mm A');
    },
    hide: false,
    sortable: true,
    filter: true,
    resizable: true
  }, {
    field: 'clientIp',
    headerName: 'Client IP',
    hide: false,
    sortable: true,
    filter: true,
    resizable: true
  }, {
    field: 'url',
    headerName: 'TargetURL',
    hide: false,
    sortable: true,
    filter: true,
    resizable: true
  }];

  constructor(private dbconnector: DbConnectorService,
              public dialog: MatDialogRef<ShortUrlDetailViewComponent>,
              public  acceptDialog: MatDialog,
              @Inject(MAT_DIALOG_DATA) private shortUrl: ShortURLWithTarget) {}

  ngOnInit(): void {
    this.originalData = this.shortUrl[0];
    this.changedData = this.originalData;
    this.retrieveAllTargetsOfShortURL();
    this.retrieveAllCallsOfShortURL();
  }

  retrieveAllTargetsOfShortURL(): void {
    this.dbconnector.getAllTargetsOfShortURL(this.originalData.shortURLId).subscribe(data => {
        const targetHistory: TargetUrl[] = [];
        data.forEach(entry => {
          targetHistory.push(convertToTargetUrl(entry));
        });
        this.rowDataTargetUrl = targetHistory;
      },
      error => {
        console.log(error);
      });
  }

  retrieveAllCallsOfShortURL(): void {
    this.dbconnector.getAllCallsOfShortURL(this.originalData.shortURLId).subscribe(data => {
        const urlCalls: UrlCall[] = [];
        data.forEach(entry => {
          urlCalls.push(convertToUrlCall(entry));
        });
        this.rowDataUrlCall = urlCalls;
      },
      error => {
        console.log(error);
      });

  }

  retrieveShortUrl(): void {
    this.dbconnector.getShortURLById(this.originalData.shortURLId).subscribe(data => {
      if (data.length === 1) {
        this.changedData = convertToShortURLWithTarget(data[0]);
      }
    }, error => {
        console.log(error);
    });
  }

  refreshDetailView(): void {
    this.retrieveShortUrl();
    this.retrieveAllTargetsOfShortURL();
    this.retrieveAllCallsOfShortURL();
  }

  deleteShortUrl(): void {
    const dialogMsg = 'Do you really want to delete the ShortURL with suffix' +
      '\n "' + this.changedData.customSuffix + '"?';
    this.acceptDialog.open(YesNoDialogComponent, {
      data: dialogMsg,
      height: '280px',
      width: '600px',
    }).afterClosed().subscribe(shouldDelete => {
      if (shouldDelete) {
        this.dbconnector.deleteShortURL(this.originalData.shortURLId).subscribe(
          data => {
            if (data as number === HttpStatusCode.Ok){
              window.alert('Successfully deleted ShortURL: "https://api.bfflshort.de/s/' + this.changedData.groupName + '/'
                + this.changedData.customSuffix + '"\n');
              this.closeDialog();
            } else {
              window.alert('Couldn\'t delete ShortURL: "https://api.bfflshort.de/s/' + this.changedData.groupName + '/'
                + this.changedData.customSuffix + '"\n');
            }
          }
        );
      }
    });
  }

  closeDialog(): void {
    const isDataChanged = (this.originalData !== this.changedData);
    this.dialog.close(isDataChanged);
  }

  onTargetUrlGridReady(params): void {
    this.apiTargetUrl = params.api;
    this.columnApiTargetUrl = params.columnApi;
    this.apiTargetUrl.sizeColumnsToFit();
  }

  onUrlCallGridReady(params): void {
    this.apiUrlCall = params.api;
    this.columnApiUrlCall = params.columnApi;
    this.apiUrlCall.sizeColumnsToFit();
  }

  onTargetUrlGridSizeChange(params): void {
    this.apiTargetUrl.sizeColumnsToFit();
  }

  onUrlCallGridSizeChange(params): void {
    this.apiUrlCall.sizeColumnsToFit();
  }

  redirectToTarget(): void {
    const target = 'https://api.bfflshort.de/s/' + this.changedData.groupName + '/' + this.changedData.customSuffix;
    window.open(target, '_blank');
    setTimeout(() => { this.retrieveAllCallsOfShortURL(); }, 300);
  }

  getFormattedScope(): string {
    return scopeToString(this.changedData.scope);
  }
}
