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
import {formatDateFromDate, formatDateFromGrid} from '../../../Services/Util/Formatter/DateFormatter';
import {FormControl} from '@angular/forms';
import {apiUrl} from '../../../../environments/environment';
import {isTagColorLight} from '../../../Services/Util/IsColorLight';
import {Color} from 'ag-grid-community';

@Component({
  selector: 'app-short-url-detail-view',
  templateUrl: './short-url-detail-view.component.html',
  styleUrls: ['./short-url-detail-view.component.css'],
})
export class ShortUrlDetailViewComponent implements OnInit {

  targetURLRegEx = '[-a-zA-Z0-9@:%._\\+~#=\/\/]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&\\/\\/=]*)';

  updateMode: boolean;
  newTarget = new FormControl();

  originalData: ShortURLWithTarget;
  changedData: ShortURLWithTarget;

  apiTargetUrl;
  apiUrlCall;

  columnApiTargetUrl;
  columnApiUrlCall;

  rowDataTargetUrl: TargetUrl[] = [];
  rowDataUrlCall: UrlCall[] = [];

  assignedTags: Tag[] = [];
  possibleTags: Tag[] = [];

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
    resizable: true,
    valueFormatter: params => formatDateFromGrid(params)
  }];
  columnDefsUrlCall = [{
    field: 'callTimestamp',
    headerName: 'Time of Call',
    hide: false,
    sortable: true,
    filter: true,
    resizable: true,
    valueFormatter: params => formatDateFromGrid(params)
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

  constructor(public dbconnector: DbConnectorService,
              public dialog: MatDialogRef<ShortUrlDetailViewComponent>,
              public acceptDialog: MatDialog,
              @Inject(MAT_DIALOG_DATA) private shortUrl: ShortURLWithTarget) {}

  ngOnInit(): void {
    this.updateMode = false;
    this.originalData = this.shortUrl[0];
    this.changedData = this.originalData;
    this.retrieveAllTargetsOfShortURL();
    this.retrieveAllCallsOfShortURL();
    this.retrieveAllTagsAssignedToShortURL();
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

  retrieveAllTagsAssignedToShortURL(): void {
    this.dbconnector.getAllTagsAssignedToShortURL(this.originalData.shortURLId).subscribe(data => {
      const taglist: Tag[] = [];
      data.forEach(entry => {
        taglist.push(convertToTag(entry));
      });
      this.assignedTags = taglist;
    }, error => {
      if ((error as HttpErrorResponse).status === HttpStatusCode.NotFound) {
        this.assignedTags = [];
      }
      console.log(error);
    });

    this.retrieveAllPossibleTagsForShortURL();
  }

  retrieveAllPossibleTagsForShortURL(): void {
    this.dbconnector.getAllPossibleTagsForShortURL(this.originalData.shortURLId).subscribe(data => {
      const taglist: Tag[] = [];
      data.forEach(entry => {
        taglist.push(convertToTag(entry));
      });
      this.possibleTags = taglist;
    }, error => {
      console.log(error);
    });
  }

  refreshDetailView(): void {
    this.updateMode = false;
    this.retrieveShortUrl();
    this.retrieveAllTargetsOfShortURL();
    this.retrieveAllCallsOfShortURL();
    this.retrieveAllTagsAssignedToShortURL();
  }

  deleteShortUrl(): void {
    if (this.changedData.deleteFlag === false && this.dbconnector.isAdmin === false) {
      window.alert('The ShortURLs delete Flag is set. This means, that you can not delete the ShortURL as a normal User of the group');
    } else {
      const dialogMsg = 'Do you really want to delete the ShortURL with suffix' +
        '\n "' + this.changedData.customSuffix + '"?';
      this.acceptDialog.open(YesNoDialogComponent, {
        data: {
          msg: dialogMsg,
          yes: 'Accept',
          no: 'Cancel'
        },
        height: '210px',
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
  }

  changeUpdateFlag(): void {
    if (this.dbconnector.isAdmin) {
      if (this.changedData.updateFlag) {
        this.dbconnector.updateUpdateFlag(this.originalData.shortURLId, false).subscribe(data => {
          if (data as number === HttpStatusCode.Ok){
            this.retrieveShortUrl();
          }
        }, error => {
          console.log(error);
        });
      } else {
        this.dbconnector.updateUpdateFlag(this.originalData.shortURLId, true).subscribe(data => {
          if (data as number === HttpStatusCode.Ok){
            this.retrieveShortUrl();
          }
        }, error => {
          console.log(error);
        });
      }
    } else {
      window.alert('You have no permission for this action. Only Admins can change modification-flags.');
    }
  }

  changeDeleteFlag(): void {
    if (this.dbconnector.isAdmin) {
      if (this.changedData.deleteFlag) {
        this.dbconnector.updateDeleteFlag(this.originalData.shortURLId, false).subscribe(data => {
          if (data as number === HttpStatusCode.Ok){
            this.retrieveShortUrl();
          }
        }, error => {
          console.log(error);
        });
      } else {
        this.dbconnector.updateDeleteFlag(this.originalData.shortURLId, true).subscribe(data => {
          if (data as number === HttpStatusCode.Ok){
            this.retrieveShortUrl();
          }
        }, error => {
          console.log(error);
        });
      }
    } else {
      window.alert('You have no permission for this action. Only Admins can change modification-flags.');
    }
  }

  reassignOldTargetToShortUrl(row: any): void {
    if (this.changedData.updateFlag === false) {
      window.alert('The ShortURLs update Flag is set. This means, that you can not update the ShortURL as a normal User of the group');
    } else {
      const selectedTarget: TargetUrl = row.data as TargetUrl;

      if (this.changedData.targetURL === selectedTarget.url) {
        window.alert('The selected TargetURL is the current TargetURL.');
      } else {
        const dialogMsg = 'Do you really want to reassign the TargetURL' +
          '\n"' + selectedTarget.url + '" to the ShortURL with Suffix' +
          '\n"' + this.changedData.customSuffix + '"?';
        this.acceptDialog.open(YesNoDialogComponent, {
          data: {
            msg: dialogMsg,
            yes: 'Accept',
            no: 'Cancel'
          },
          height: '230px',
          width: '600px',
        }).afterClosed().subscribe(shouldUpdate => {
          if (shouldUpdate) {
            this.dbconnector.saveTargetOfShortUrlAssignment(selectedTarget.url, this.originalData.shortURLId).subscribe(data => {
              if (data as number === HttpStatusCode.Created) {
                this.changedData.targetURL = selectedTarget.url;
                setTimeout(() => { this.retrieveAllTargetsOfShortURL(); }, 200);
              }
            }, error => {
              console.log(error);
            });
          }
        });
      }
    }
  }

  assignTagToShortURL(tagId: any): void {
    this.dbconnector.saveUrlHasTagAssignment(tagId as number, this.originalData.shortURLId).subscribe(data => {
      if (data as number === HttpStatusCode.Created) {
        setTimeout(() => { this.retrieveAllTagsAssignedToShortURL(); }, 200);
      }
    }, error => {
      console.log(error);
    });
  }

  unassignTagFromShortURL(tagId: number): void {
    this.dbconnector.deleteTagToShortURLAssignment(tagId, this.originalData.shortURLId).subscribe(
      data => {
        if (data as number === HttpStatusCode.Ok) {
          setTimeout(() => { this.retrieveAllTagsAssignedToShortURL(); }, 200);
        }
      }, error => {
        console.log(error);
      }
    );
  }

  unassignTargetFromShortURL(target: any): void {
    if (this.changedData.updateFlag || this.dbconnector.isAdmin) {
      const keyPressed = target.event.key;
      if (keyPressed === 'Backspace') {
        const rowData: TargetUrl = target.node.data;
        const dialogMsg = 'Do you really want to delete Entry "' + rowData.url + '" from the ShortURL-TargetHistory?';
        this.acceptDialog.open(YesNoDialogComponent, {
          data: {
            msg: dialogMsg,
            yes: 'Accept',
            no: 'Cancel'
          },
          height: '230px',
          width: '600px',
        }).afterClosed().subscribe(shouldDelete => {
          if (shouldDelete) {
            this.dbconnector.deleteTargetToShortURLAssignment(this.originalData.shortURLId, rowData.assignTimestamp).subscribe(data => {
              if (data as number === HttpStatusCode.Ok) {
                setTimeout(() => { this.retrieveAllTargetsOfShortURL(); }, 200);
              }
            }, error => {
              console.log(error);
            });
          }
        });
      }
    }
  }

  onUpdateSubmit(): void {
    this.updateMode = false;
    this.updateTargetOfShortUrl();
  }

  updateTargetOfShortUrl(): void {
    if (this.newTarget.value !== this.changedData.targetURL) {
      this.dbconnector.saveTargetOfShortUrlAssignment(this.newTarget.value, this.originalData.shortURLId).subscribe(data => {
        if (data as number === HttpStatusCode.Created) {
          this.changedData.targetURL = this.newTarget.value;
          setTimeout(() => { this.retrieveAllTargetsOfShortURL(); }, 200);
        }
      }, error => {
        console.log(error);
      });
    }
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
    const target = apiUrl + '/s/' + this.changedData.groupName + '/' + this.changedData.customSuffix;
    window.open(target, '_blank');
    setTimeout(() => { this.retrieveAllCallsOfShortURL(); }, 300);
  }

  getFormattedScope(): string {
    return scopeToString(this.changedData.scope);
  }

  changeMode(): void {
    if (this.updateMode) {
      if (this.newTarget.value === '') {
        this.updateMode = false;
      } else {
        if (this.newTarget.value === this.changedData.targetURL) {
          this.updateMode = false;
        } else {
          const dialogMsg = 'Do you really want to cancel the update-process?';
          this.acceptDialog.open(YesNoDialogComponent, {
            data: {
              msg: dialogMsg,
              yes: 'Yes',
              no: 'No',
            },
            height: '200px',
            width: '400px',
          }).afterClosed().subscribe(shouldStopUpdate => {
            if (shouldStopUpdate) {
              this.updateMode = false;
            }
          });
        }
      }
    } else {
      this.newTarget.setValue('');
      this.updateMode = true;
    }
  }

  getEndOfValidityTimestamp(): string {
    if (this.changedData.scope === -1) {
      return 'infinity';
    }
    const endOfValidityTs: Date = new Date(this.changedData.createTimestamp.getTime() + (this.changedData.scope * 1000));
    return formatDateFromDate(endOfValidityTs);
  }

  isTagColorLight(color: Color): boolean {
    return isTagColorLight(color);
  }
}
