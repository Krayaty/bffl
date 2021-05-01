import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {endpoints} from '../../../assets/endpoints/endpoints';

@Injectable({ providedIn: 'root' })
export class DbConnectorService {

  public activeGroup: string;

  constructor(private http: HttpClient) {}

  getAllGroupsOfUser(): Observable<any> {
    return this.http.get(`${endpoints.get.groups_of_user}`);
  }

  getAllShortURLsByGroupName(): Observable<any> {
    return this.http.get(`${endpoints.get.short_urls_by_group}`, {params: {group_name: this.activeGroup}});
  }

}
