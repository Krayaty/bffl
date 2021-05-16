import {Component, OnInit, ViewChild} from '@angular/core';
import {AgGridAngular} from 'ag-grid-angular';
import {DbConnectorService} from '../../../Services/DB-Connect-Services/db-connector.service';
import {AuthService} from '../../../Services/Iam-Services/auth.service';
import {GroupName} from '../../../DBReturnTypes/DBReturnTypes';

@Component({
  selector: 'app-choose-group-page',
  templateUrl: './choose-group-page.component.html',
  styleUrls: ['./choose-group-page.component.css']
})
export class ChooseGroupPageComponent implements OnInit {

  constructor(private dbconnector: DbConnectorService, private authService: AuthService) { }

  @ViewChild('agGrid') agGrid: AgGridAngular;

  api;
  columnApi;
  selectedData;
  rowData: GroupName[];

  columnDefs = [{
    field: 'groupName',
    headerName: 'Gruppe',
    hide: false,
    sortable: true,
    filter: true,
    resizable: true
  }];

  ngOnInit(): void {
    setTimeout(() => { this.retrieveAllGroups(); }, 200);
  }

  retrieveAllGroups(): void {
    this.dbconnector.getAllGroupsOfUser()
      .subscribe(data => {
          const groupNames: GroupName[] = [];
          data.forEach(entry => {
            groupNames.push(new GroupName(entry));
          });
          this.rowData = groupNames;
        },
        error => {
          console.log(error);
        });
  }

  getSelectedRows(): void {
    const selectedNodes = this.api.getSelectedNodes();
    this.selectedData = selectedNodes.map(node => node.data);
    this.selectedData = JSON.stringify(this.selectedData);
    this.selectedData = this.selectedData.split('"groupName":"', 2).pop();
    this.selectedData = this.selectedData.split('"}]', 1);
    this.dbconnector.activeGroup = this.selectedData;
    this.dbconnector.testConnection();
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
    this.dbconnector.testConnection();
    window.location.reload();
  }
}
