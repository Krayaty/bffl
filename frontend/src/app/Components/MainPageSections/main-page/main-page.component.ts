import {Component, OnInit, ViewChild} from '@angular/core';
import {AgGridAngular} from 'ag-grid-angular';
import {DbConnectorService} from '../../../Services/DB-Connect-Services/db-connector.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {
  @ViewChild('agGrid') agGrid: AgGridAngular;

  api;
  columnApi;

  columnDefs = [
    { field: 'name', headerName: 'URL', sortable: true, resizable: true, filter: true, checkboxSelection: true },
    { field: 'owner', headerName: 'Besitzer', sortable: true, filter: true, resizable: true },
    { field: 'type',  headerName: 'Typ', sortable: true, filter: true, resizable: true }
  ];

  rowData = [];

  constructor(private dbconnector: DbConnectorService) {
  }

  ngOnInit(): void {
    this.retrieveAllTargetURLs();
  }

  retrieveAllTargetURLs(): void {
    this.dbconnector.getAllTargetURLs()
      .subscribe(
        data => {
          this.rowData = data;
        },
        error => {
          console.log(error);
        });
  }

  getSelectedRows(): void {
    const selectedNodes = this.api.getSelectedNodes();
    const selectedData = selectedNodes.map(node => node.data );
    const selectedDataStringPresentation = selectedData.map(node => node.make + ' ' + node.model).join(', ');

    alert(`Selected nodes: ${selectedDataStringPresentation}`);
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
