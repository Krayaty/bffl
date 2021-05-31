import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {endpoints} from '../../../assets/endpoints/endpoints';
import {DbIterator} from './DbIterator';
import {convertToShortURLWithTarget, ShortURLWithTarget} from '../../DBReturnTypes/ShortUrlWithTarget';


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

  getShortURLById(shortUrlId: number): Observable<any> {
    return this.http.get(`${endpoints.get.short_url_by_id}`, {params: {short_url_id: shortUrlId}});
  }

  getAllTargetsOfShortURL(shortUrlId: number): Observable<any> {
    return this.http.get(`${endpoints.get.target_assignment_history_for_short_url}`, {params: {short_url_id: shortUrlId}});
  }

  getAllCallsOfShortURL(shortUrlId: number): Observable<any> {
    return this.http.get(`${endpoints.get.calls_of_short_url}`, {params: {short_url_id: shortUrlId}});
  }

  getNumberOfUrlCalls(shortUrlId: number): Observable<any> {
    return this.http.get(`${endpoints.get.number_of_url_calls}`, {params: {short_url_id: shortUrlId}});
  }

  getIterator(): Promise<DbIterator> {
    const shortURLWithTargetList: ShortURLWithTarget[] = [];
    return new Promise((resolve, reject) => {
      this.getAllShortURLsByGroupName()
        .subscribe(data => {
            data.forEach(entry => {
              shortURLWithTargetList.push(convertToShortURLWithTarget(entry));
            });
            resolve(new DbIterator(shortURLWithTargetList));
          },
          error => {
            reject(error);
          });
    });
  }

  saveNewShortURLWithTags(customSuffix: string,
                          newScope: number,
                          deleteFlag: boolean,
                          updateFlag: boolean,
                          targetURL: string,
                          assignedTagIds: number[]): void {

    const body = {
      group_name: String(this.activeGroup),
      custom_suffix: customSuffix,
      scope: newScope,
      delete_flag: deleteFlag,
      update_flag: updateFlag,
      target_url: targetURL,
      assigned_tag_ids: assignedTagIds
    };

    window.alert(JSON.stringify(body));

    this.http.post<any>(
      `${endpoints.post.create_short_url_for_group_with_tags}`,
      JSON.stringify(body),
      {headers: new HttpHeaders({ 'Content-Type': 'application/json' })}
    ).subscribe(res => res.json());
  }
}
