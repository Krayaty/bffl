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

  @ViewChild('agGrid') agGrid: AgGridAngular;

  api;
  columnApi;

  rowData: GroupName[];

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

  onRowClicked(event: GroupName): void {
    window.alert('row' + event);
  }

  onCellClicked(event: any): void {
    window.alert('cell' + event);
  }

  onSelectionChanged(event: any): void {
    window.alert('selection' + event);
  }

  getSelectedRows(): void {
    const selectedNodes = this.api.getSelectedNodes();
    const selectedData = selectedNodes.map(node => node.data);
    alert(`Your selected Group:\n${JSON.stringify(selectedData)}`);
    window.alert(JSON.stringify(selectedData));
    this.dbconnector.activeGroup = JSON.stringify(selectedData);
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
