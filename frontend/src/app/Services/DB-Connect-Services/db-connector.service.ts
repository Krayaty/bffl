import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {endpoints} from '../../../assets/endpoints/endpoints';

@Injectable({ providedIn: 'root' })
export class DbConnectorService {

  constructor(private http: HttpClient) {}

  getAllTargetURLs(): Observable<any> {
    return this.http.get(`${endpoints.target_urls}`);
  }

  getAllShortURLsByGroupName(groupName: string): Observable<any> {
    return this.http.get(`${endpoints.short_urls_with_current_target}`, {params: {group_name: groupName}});
  }

}
