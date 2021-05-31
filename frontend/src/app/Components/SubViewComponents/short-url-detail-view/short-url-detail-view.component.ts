import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {DbConnectorService} from '../../../Services/DB-Connect-Services/db-connector.service';
import {convertToUrlCall, UrlCall} from '../../../DBReturnTypes/UrlCall';
import {convertToTargetUrl, TargetUrl} from '../../../DBReturnTypes/TargetUrl';
import {ShortURLWithTarget} from '../../../DBReturnTypes/ShortUrlWithTarget';

@Component({
  selector: 'app-short-url-detail-view',
  templateUrl: './short-url-detail-view.component.html',
  styleUrls: ['./short-url-detail-view.component.css']
})
export class ShortUrlDetailViewComponent implements OnInit{

  originalData: ShortURLWithTarget;
  changedData: ShortURLWithTarget;

  apiTargetUrl;
  apiUrlCall;

  columnApiTargetUrl;
  columnApiUrlCall;

  rowDataTargetUrl: TargetUrl[];
  rowDataUrlCall: UrlCall[];

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
    hide: false,
    sortable: true,
    filter: true,
    resizable: true
  }];
  columnDefsUrlCall = [{
    field: 'callTimestamp',
    headerName: 'Time of Call',
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

  retrieveNumberOfUrlCalls(): number {
    if (this.rowDataUrlCall == null || this.rowDataUrlCall.length < 1){
      return 0;
    }
    return this.rowDataUrlCall.length;
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

}
