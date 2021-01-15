import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AgGridAngular} from 'ag-grid-angular';
import {DbConnectorService} from '../../../Services/DB-Connect-Services/db-connector.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {
  @ViewChild('agGrid') agGrid: AgGridAngular;

  columnDefs = [
    { field: 'Email', sortable: true, resizable: true, filter: true, checkboxSelection: true },
    { field: 'Vorname', sortable: true, filter: true, resizable: true },
    { field: 'Nachname', sortable: true, filter: true, resizable: true },
    { field: 'Password', sortable: true, filter: true, resizable: true }
  ];

  rowData: any;

  constructor(private dbconnector: DbConnectorService) { }

  ngOnInit(): void {
    this.retrieveAllUsers();
  }

  retrieveAllUsers(): void {
    this.dbconnector.getAllUsers()
      .subscribe(
        data => {
          this.rowData = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  getSelectedRows(): void {
    const selectedNodes = this.agGrid.api.getSelectedNodes();
    const selectedData = selectedNodes.map(node => node.data );
    const selectedDataStringPresentation = selectedData.map(node => node.make + ' ' + node.model).join(', ');

    alert(`Selected nodes: ${selectedDataStringPresentation}`);
  }

}
