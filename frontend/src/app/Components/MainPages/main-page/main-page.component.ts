import {Component, OnInit, ViewChild} from '@angular/core';
import {AgGridAngular} from 'ag-grid-angular';
import {DbConnectorService} from '../../../Services/DB-Connect-Services/db-connector.service';
import {ShortURLWithTarget} from '../../../DBReturnTypes/ShortUrlWithTarget';
import {MatDialog} from '@angular/material/dialog';
import {ShortUrlDetailViewComponent} from '../../SubViewComponents/short-url-detail-view/short-url-detail-view.component';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  @ViewChild('agGrid') agGrid: AgGridAngular;

  api;
  columnApi;

  rowData: ShortURLWithTarget[] = [];

  columnDefs = [{
      field: 'shortURLId',
      headerName: 'Id',
      hide: true,
      sortable: true,
      filter: true,
      resizable: true
    }, {
      field: 'groupName',
      headerName: 'Group',
      hide: false,
      sortable: true,
      filter: true,
      resizable: true
    }, {
      field: 'customSuffix',
      headerName: 'Suffix',
      hide: false,
      sortable: true,
      filter: true,
      resizable: true
    }, {
      field: 'createTimestamp',
      headerName: 'Created on',
      hide: false,
      sortable: true,
      filter: true,
      resizable: true
    }, {
      field: 'scope',
      headerName: 'Scope (in s)',
      hide: false,
      sortable: true,
      filter: true,
      resizable: true
    }, {
      field: 'targetURL',
      headerName: 'TargetURL',
      hide: false,
      sortable: true,
      filter: true,
      resizable: true
    }, {
      field: 'assignTimestamp',
      headerName: 'Assigned on',
      hide: false,
      sortable: true,
      filter: true,
      resizable: true
    }, {
      field: 'deleteFlag',
      headerName: 'deletable',
      hide: false,
      sortable: true,
      filter: true,
      resizable: true
    }, {
      field: 'updateFlag',
      headerName: 'updatable',
      hide: false,
      sortable: true,
      filter: true,
      resizable: true
    }];

  constructor(private dbconnector: DbConnectorService, private dialog: MatDialog) {}

  ngOnInit(): void {
    this.retrieveAllShortURLsByGroupName();
  }

  retrieveAllShortURLsByGroupName(): void {
    this.dbconnector.getIterator().then(iterator => {
      const list = [];
      while (iterator.hasNext()) {
        list.push(iterator.next());
      }
      this.rowData = list;
    });
  }

  openDetailView(): void {
    const selectedData = this.api.getSelectedNodes().map(node => node.data);
    this.dialog.open(ShortUrlDetailViewComponent, {
      data: selectedData,
      height: '90%',
      width: '90%',
    })
    .afterClosed().subscribe(isDataChanged => {
      if (isDataChanged) {
        this.api.refreshCells();
      }
    });
  }

  onGridReady(params): void {
    this.api = params.api;
    this.columnApi = params.columnApi;
    this.api.sizeColumnsToFit();
  }

  onGridSizeChange(params): void {
    this.api.sizeColumnsToFit();
  }
}
