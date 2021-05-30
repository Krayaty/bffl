import {Component, OnInit, ViewChild} from '@angular/core';
import {AgGridAngular} from 'ag-grid-angular';
import {DbConnectorService} from '../../../Services/DB-Connect-Services/db-connector.service';
import {ShortURLWithTarget} from '../../../DBReturnTypes/DBReturnTypes';
import {ButtonRendererComponent} from '../../UtilComponents/button-renderer/button-renderer.component';

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
  }, {
      field: 'Save',
      cellRenderer: 'buttonRenderer',
      cellRendererParams: {
        onClick: this.onSaveButtonClick.bind(this),
        label: 'Save'
      },
    }, {
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
    const customSuffix: string = this.getRelevantPartOfRow(selectedRow, '"customSuffix":"', 2, '",', 1);
    window.alert(customSuffix);
    const scopeString = this.getRelevantPartOfRow(selectedRow, '"scope":', 2, ',', 1);
    const scope: number = JSON.parse(scopeString);
    window.alert(scope);
    const updateFlagString = this.getRelevantPartOfRow(selectedRow, '"updateFlag":', 2, '}]', 1);
    const updateFlag: boolean = JSON.parse(updateFlagString);
    window.alert(updateFlag);
    const deleteFlagString = this.getRelevantPartOfRow(selectedRow, '"deleteFlag":', 2, ',', 1);
    const deleteFlag: boolean = JSON.parse(deleteFlagString);
    window.alert(deleteFlag);
    const targetUrl: string = this.getRelevantPartOfRow(selectedRow, '"targetURL":"', 2, '",', 1);
    window.alert(targetUrl);
    this.dbconnector.updateShortURL(customSuffix, scope, updateFlag, deleteFlag, targetUrl);
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
    const deleteFlag: string = this.getRelevantPartOfRow(selectedRow, '"deleteFlag":', 2, ',', 1);
    if ( String(deleteFlag) === String(false) ){
      window.alert('You can not delete an entry with the deleteFlag \'false\'');
      return false;
    }
    const shortUrlId = this.getRelevantPartOfRow(selectedRow, '"shortURLId":', 2, ',', 1);
    const infoAboutRow: string = this.getRelevantPartOfRow(selectedRow, shortUrlId + ',', 2, ',', 2);
    if ( confirm('Are you sure to delete the entry of ' + infoAboutRow) ) {
      this.dbconnector.removeEntryById(shortUrlId);
      this.retrieveAllShortURLsByGroupName();
      return true;
    }
  }

  getRelevantPartOfRow(selectedRow, start, times1, end, times2): string {
    let relevantPart = selectedRow.split(start, times1).pop();
    relevantPart = relevantPart.split(end, times2);
    return relevantPart;
  }

}
