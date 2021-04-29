import {Component, OnInit, ViewChild} from '@angular/core';
import {AgGridAngular} from 'ag-grid-angular';
import {DbConnectorService} from '../../../Services/DB-Connect-Services/db-connector.service';
import {convertToShortURLWithTarget, ShortURLWithTarget} from '../../../DBReturnTypes/DBReturnTypes';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  @ViewChild('agGrid') agGrid: AgGridAngular;


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
      filter: true,
      resizable: true
    }, {
      field: 'targetURL',
      headerName: 'Ziel-URL',
      hide: false,
      sortable: true,
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
      filter: true,
      resizable: true
    }, {
      field: 'updateFlag',
      headerName: 'änderbar?',
      hide: false,
      sortable: true,
      filter: true,
      resizable: true
    }];

  constructor(private dbconnector: DbConnectorService) {
  }

  ngOnInit(): void {
    setTimeout(() => { this.refreshAgGrid(); }, 200);
  }

  retrieveAllShortURLsByGroupName(groupName: string): void {
    this.dbconnector.getAllShortURLsByGroupName(groupName)
      .subscribe(data => {
        const shortURLWithTargetList: ShortURLWithTarget[] = [];
        data.forEach(entry => {
            shortURLWithTargetList.push(convertToShortURLWithTarget(entry));
        });
        this.rowData = shortURLWithTargetList;
        },
        error => {
          console.log(error);
        });
  }

  refreshAgGrid(): void {
    this.retrieveAllShortURLsByGroupName(this.dbconnector.activeGroup);
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
