import {Component, OnInit, ViewChild} from '@angular/core';
import {AgGridAngular} from 'ag-grid-angular';
import {DbConnectorService} from '../../../Services/DB-Connect-Services/db-connector.service';
import {ShortURLWithTarget} from '../../../DBReturnTypes/DBReturnTypes';
import { ButtonRendererComponent } from '../button-renderer.component';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  @ViewChild('agGrid') agGrid: AgGridAngular;

  frameworkComponents: any;
  api;
  columnApi;

  rowData: ShortURLWithTarget[];

  columnDefs = [{
    field: 'shortURLId',
    headerName: 'Id',
    hide: true,
    sortable: true,
    filter: true,
    resizable: true
  }, {
    field: 'groupName',
    headerName: 'Gruppe',
    hide: false,
    sortable: true,
    editable: true,
    filter: true,
    resizable: true
  }, {
    field: 'customSuffix',
    headerName: 'Suffix',
    hide: false,
    sortable: true,
    editable: true,
    filter: true,
    resizable: true
  }, {
    field: 'createTimestamp',
    headerName: 'erstellt am',
    hide: false,
    sortable: true,
    filter: true,
    resizable: true
  }, {
    field: 'scope',
    headerName: 'Gültigkeit (in s)',
    hide: false,
    sortable: true,
    editable: true,
    filter: true,
    resizable: true
  }, {
    field: 'targetURL',
    headerName: 'Ziel-URL',
    hide: false,
    sortable: true,
    editable: true,
    filter: true,
    resizable: true
  }, {
    field: 'assignTimestamp',
    headerName: 'zugewiesen am',
    hide: false,
    sortable: true,
    filter: true,
    resizable: true
  }, {
    field: 'deleteFlag',  headerName: 'löschbar?',
    hide: false,
    sortable: true,
    editable: true,
    filter: true,
    resizable: true
  }, {
    field: 'updateFlag',
    headerName: 'änderbar?',
    hide: false,
    sortable: true,
    editable: true,
    filter: true,
    resizable: true
  },
    /*{
      field: 'Edit',
      cellRenderer: 'buttonRenderer',
      cellRendererParams: {
        onClick: this.onEditButtonClick.bind(this),
        label: 'Edit'
      },
    },*/
    {
      field: 'Save',
      cellRenderer: 'buttonRenderer',
      cellRendererParams: {
        onClick: this.onSaveButtonClick.bind(this),
        label: 'Save'
      },
    },
    {
      field: 'Delete',
      cellRenderer: 'buttonRenderer',
      cellRendererParams: {
        onClick: this.onDeleteButtonClick.bind(this),
        label: 'Delete'
      },
    }];

  constructor(private dbconnector: DbConnectorService) {
    this.frameworkComponents = {
      buttonRenderer: ButtonRendererComponent,
    };
  }

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

  getSelectedRows(): any {
    const selectedNodes = this.api.getSelectedNodes();
    let selectedData = selectedNodes.map(node => node.data );
    // const selectedDataStringPresentation = selectedData.map(node => node.make + ' ' + node.model).join(', ');
    // alert(`Selected nodes: ${selectedDataStringPresentation}`);
    // return selectedDataStringPresentation;
    selectedData = JSON.stringify(selectedData);
    return selectedData;

  }

  onGridReady(params): void {
    this.api = params.api;
    this.columnApi = params.columnApi;
    this.api.sizeColumnsToFit();
  }

  onGridSizeChange(params): void {
    this.api.sizeColumnsToFit();
  }

  onSaveButtonClick(params): void
  {
    const selectedRow = this.getSelectedRows();
    let customSuffix = selectedRow.split('"customSuffix":"', 2).pop();
    customSuffix = customSuffix.split('",', 1);
    const newCustomSuffix: string = customSuffix;
    let scope = selectedRow.split('"scope":', 2).pop();
    scope = scope.split(',', 1);
    const newScope: number = JSON.parse(scope);
    let updateFlag = selectedRow.split('"updateFlag":', 2).pop();
    updateFlag = updateFlag.split('}]', 1);
    const newUpdateFlag: boolean = JSON.parse(updateFlag);
    let deleteFlag = selectedRow.split('"deleteFlag":', 2).pop();
    deleteFlag = deleteFlag.split(',', 1);
    const newDeleteFlag = JSON.parse(deleteFlag);
    let targetUrl = selectedRow.split('"targetURL":"', 2).pop();
    targetUrl = targetUrl.split('",', 1);
    const newTargetUrl: string = targetUrl;
    this.dbconnector.updateShortURL(newCustomSuffix, newScope, newUpdateFlag, newDeleteFlag, newTargetUrl);
  }

  onDeleteButtonClick(params): boolean
  {
    const selectedRow = this.getSelectedRows();
    // no row choosed?
    if ( selectedRow === '[]'){
      window.alert('Please click in the line, first');
      return false;
    }
    // get deleteFlag out of String of selected Row
    let deleteFlag = selectedRow.split('"deleteFlag":', 2).pop();
    deleteFlag = deleteFlag.split(',', 1);
    if ( String(deleteFlag) === String(false) ){
      window.alert('You can not delete an entry with the deleteFlag \'false\'');
      return false;
    }
    let shortUrlId = selectedRow.split('"shortURLId":', 2).pop();
    shortUrlId = shortUrlId.split(',', 1);
    let infoAboutRow = selectedRow.split(shortUrlId + ',', 2).pop();
    infoAboutRow = infoAboutRow.split(',', 2);
    if ( confirm('Are you sure to delete the entry of ' + infoAboutRow) ) {
      this.api.updateRowData({remove: [params.data]});
      this.dbconnector.removeEntryById(shortUrlId);
      return true;
    }
  }

}
