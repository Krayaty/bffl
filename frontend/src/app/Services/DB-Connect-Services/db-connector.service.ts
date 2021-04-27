import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {endpoints} from '../../../assets/endpoints/endpoints';

@Injectable({ providedIn: 'root' })
export class DbConnectorService {

  public activeGroup: string;

  constructor(private http: HttpClient) {
    this.getAllGroupsOfUser().subscribe(data => {
      this.activeGroup = data;
    });
  }

  getAllGroupsOfUser(): Observable<any> {
    return this.http.get(`${endpoints.groups_of_user}`);
  }

  getAllShortURLsByGroupName(groupName: string): Observable<any> {
    return this.http.get(`${endpoints.short_urls_with_current_target}`, {params: {group_name: groupName}});
  }

}
