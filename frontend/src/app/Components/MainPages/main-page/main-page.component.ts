import {Component, OnInit, ViewChild} from '@angular/core';
import {AgGridAngular} from 'ag-grid-angular';
import {DbConnectorService} from '../../../Services/DB-Connect-Services/db-connector.service';
import {ShortURLWithTarget} from '../../../DBReturnTypes/ShortUrlWithTarget';
import {MatDialog} from '@angular/material/dialog';
import {ShortUrlDetailViewComponent} from '../../SubViewComponents/short-url-detail-view/short-url-detail-view.component';
import {Router} from '@angular/router';

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
      headerName: 'ID',
      hide: true,
      sortable: true,
      filter: true,
      resizable: true
    }, {
      field: 'groupName',
      headerName: 'Group',
      hide: true,
      sortable: true,
      filter: true,
      resizable: true
    }, {
      field: 'customSuffix',
      headerName: 'Base Resource',
      hide: false,
      sortable: true,
      filter: true,
      resizable: true
    }, {
      field: 'createTimestamp',
      headerName: 'Created On',
      hide: false,
      sortable: true,
      filter: true,
      resizable: true,
      valueFormatter: params => dateFormatter(params)
    }, {
      field: 'scope',
      headerName: 'Validity',
      hide: false,
      sortable: true,
      filter: true,
      resizable: true,
      valueFormatter: params => secondFormatter(params)
    }, {
      field: 'targetURL',
      headerName: 'Leads To',
      width: 500,
      hide: false,
      sortable: true,
      filter: true,
      resizable: true
    }, {
      field: 'assignTimestamp',
      headerName: 'Assigned On',
      hide: false,
      sortable: true,
      filter: true,
      resizable: true,
      valueFormatter: params => dateFormatter(params)
    }, {
      field: 'deleteFlag',
      headerName: 'Deletable',
      hide: false,
      sortable: true,
      filter: true,
      resizable: true,
      width: 100,
      headerComponentParams: {
        template: '<p>&#x270E</p>'
      },
      cellRenderer: params => checkBoxRenderer(params)
    }, {
      field: 'updateFlag',
      headerName: 'Editable',
      hide: false,
      sortable: true,
      filter: true,
      resizable: true,
      width: 100,
      headerComponentParams: {
        template: '<p>&#x1F5D1</p>'
      },
      cellRenderer: params => checkBoxRenderer(params)
    }];

  constructor(private dbconnector: DbConnectorService, private dialog: MatDialog, private router: Router) {}

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
        this.router.routeReuseStrategy.shouldReuseRoute = () => false;
        this.router.onSameUrlNavigation = 'reload';
        this.router.navigateByUrl('/' + this.router.url, {skipLocationChange: false});
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

function dateFormatter(params: any): string {
  const date = params.value.toString().split(' ');
  return date[1] + '-' + date[2] + '-' + date[3];
}

function secondFormatter(params: any): string {
  const toHours = 3600;
  const toDays = 24;
  const threeDays = 72;
  if (params.value === -1) { return 'unlimited'; }
  if (params.value < toHours * threeDays) {
    return Math.round(params.value / toHours * 10) / 10 + 'h';
  }
  return Math.round(params.value / toHours / toDays) + 'd';
}

function checkBoxRenderer(params: any): string {
  let isChecked = '';
  if (params.value) { isChecked = 'checked'; }
  return '<input type="checkbox" onclick="return false;" contenteditable="false" ' + isChecked + '>';
}
