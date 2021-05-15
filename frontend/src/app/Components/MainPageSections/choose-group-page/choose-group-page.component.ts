import {Component, OnInit, ViewChild} from '@angular/core';
import {AgGridAngular} from 'ag-grid-angular';
import {DbConnectorService} from '../../../Services/DB-Connect-Services/db-connector.service';
import {Observable} from 'rxjs';
import {AuthService} from '../../../Services/Iam-Services/auth.service';

@Component({
  selector: 'app-choose-group-page',
  templateUrl: './choose-group-page.component.html',
  styleUrls: ['./choose-group-page.component.css']
})
export class ChooseGroupPageComponent implements OnInit {

  @ViewChild('agGrid') agGrid: AgGridAngular;

  api;
  columnApi;

  rowData: string[];

  columnDefs = [{
    field: 'groupName',
    headerName: 'Gruppe',
    hide: false,
    sortable: true,
    filter: true,
    resizable: true
  }];

  constructor(private dbconnector: DbConnectorService, private authService: AuthService) { }

  ngOnInit(): void {
    // this.rowData = this.dbconnector.getAllGroupsOfUser();
    // setTimeout(() => { this.dbconnector.getAllGroupsOfUser(); }, 200);
    setTimeout(() => { this.retrieveAllGroups(); }, 200);
  }

  public retrieveAllGroups(): void {
    this.dbconnector.getAllShortURLsByGroupName()
      .subscribe(data => {
          const groupNames: string[] = [];
          data.forEach(entry => {
            this.dbconnector.getAllGroupsOfUser();
          });
          this.rowData = groupNames;
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

  logout(): void{
    this.authService.logout();
  }

  submit(): void {
    window.location.reload();
  }
}
