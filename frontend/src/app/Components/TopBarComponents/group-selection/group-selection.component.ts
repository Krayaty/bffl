import { Component, OnInit } from '@angular/core';
import {DbConnectorService} from '../../../Services/DB-Connect-Services/db-connector.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-user-selection',
  templateUrl: './group-selection.component.html',
  styleUrls: ['./group-selection.component.css']
})
export class GroupSelectionComponent implements OnInit {

  groups: string[] = [];

  constructor(private dbconnector: DbConnectorService, private router: Router) { }

  ngOnInit(): void {
    this.retrieveAllGroupsOfUser();
  }

  private retrieveAllGroupsOfUser(): void {
    this.dbconnector.getAllGroupsOfUser().subscribe(data => {
      this.groups = data;
    });
  }

  retrieveIsUserAdminOfGroup(): void {
    this.dbconnector.getIsUserAdminOfGroup(this.dbconnector.activeGroup).subscribe(data => {
      this.dbconnector.isAdmin = data;
    }, error => {
      console.log(error);
    });
  }

  groupChange(): void {
    this.retrieveIsUserAdminOfGroup();
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.router.onSameUrlNavigation = 'reload';
    this.router.navigateByUrl('/' + this.router.url, {skipLocationChange: false});
  }

  public getDBConnector(): DbConnectorService {
    return this.dbconnector;
  }

}
