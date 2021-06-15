import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {endpoints} from '../../../assets/endpoints/endpoints';
import {DbIterator} from './DbIterator';
import {convertToShortURLWithTarget, ShortURLWithTarget} from '../../DBReturnTypes/ShortUrlWithTarget';
import {DatePipe} from '@angular/common';
import {Color} from 'ag-grid-community';


@Injectable({ providedIn: 'root' })
export class DbConnectorService {

  public activeGroup: string;
  public isAdmin: boolean;

  constructor(private http: HttpClient, private datePipe: DatePipe) {}

  getAllGroupsOfUser(): Observable<any> {
    return this.http.get(`${endpoints.get.groups_of_user}`);
  }

  getAllShortURLsByGroupName(): Observable<any> {
    return this.http.get(`${endpoints.get.short_urls_by_group}`, {params: {group_name: this.activeGroup}});
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

  getShortURLById(shortUrlId: number): Observable<any> {
    return this.http.get(`${endpoints.get.short_url_by_id}`, {params: {short_url_id: shortUrlId}});
  }

  getAllTargetsOfShortURL(shortUrlId: number): Observable<any> {
    return this.http.get(`${endpoints.get.target_assignment_history_for_short_url}`, {params: {short_url_id: shortUrlId}});
  }

  getAllCallsOfShortURL(shortUrlId: number): Observable<any> {
    return this.http.get(`${endpoints.get.calls_of_short_url}`, {params: {short_url_id: shortUrlId}});
  }

  getAllTagsAssignedToShortURL(shortUrlId: number): Observable<any> {
    return this.http.get(`${endpoints.get.tags_assigned_to_short_url}`, {params: {short_url_id: shortUrlId}});
  }

  getAllPossibleTagsForShortURL(shortUrlId: number): Observable<any> {
    return this.http.get(`${endpoints.get.possible_tags_for_short_url}`, {params: {short_url_id: shortUrlId}});
  }

  getTagsByGroup(): Observable<any> {
    return this.http.get(`${endpoints.get.tags_by_group}`, {params: {group_name: this.activeGroup}});
  }

  getIsUserAdminOfGroup(groupName: string): Observable<any> {
    return this.http.get(`${endpoints.get.is_user_admin_of_group}`, {params: {group_name: groupName}});
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

  saveUrlHasTagAssignment(tagId: number, shortUrlId: number): Observable<any> {

    const body = {
      tag_id: tagId,
      short_url_id: shortUrlId
    };

    return this.http.post<any>(
      `${endpoints.post.assign_tag_to_short_url}`,
      JSON.stringify(body),
      {headers: new HttpHeaders({ 'Content-Type': 'application/json' })}
    );
  }

  saveTargetOfShortUrlAssignment(newTargetUrl: string, shortUrlId: number): Observable<any> {
    const body = {
      target_url: newTargetUrl,
      short_url_id: shortUrlId
    };

    return this.http.post<any>(
      `${endpoints.post.assign_target_to_short_url}`,
      JSON.stringify(body),
      {headers: new HttpHeaders({ 'Content-Type': 'application/json' })}
    );
  }

  updateDeleteFlag(shortUrlId: number, deleteFlag: boolean): Observable<any> {
    const body = {
      short_url_id: shortUrlId,
      flag: deleteFlag
    };

    return this.http.post<any>(
      `${endpoints.post.update_delete_flag}`,
      JSON.stringify(body),
      {headers: new HttpHeaders({ 'Content-Type': 'application/json' })}
    );
  }

  updateUpdateFlag(shortUrlId: number, updateFlag: boolean): Observable<any> {
    const body = {
      short_url_id: shortUrlId,
      flag: updateFlag
    };

    return this.http.post<any>(
      `${endpoints.post.update_update_flag}`,
      JSON.stringify(body),
      {headers: new HttpHeaders({ 'Content-Type': 'application/json' })}
    );
  }

  deleteTagToShortURLAssignment(tagId: number, shortUrlId: number): Observable<any> {
    const body = {
      tag_id: tagId,
      short_url_id: shortUrlId
    };

    return this.http.post(`${endpoints.post.delete_url_has_tag_assignment}`,
      JSON.stringify(body),
      {headers: new HttpHeaders({ 'Content-Type': 'application/json' })}
    );
  }

  deleteTargetToShortURLAssignment(shortUrlId: number, assignTimestamp: Date): Observable<any> {
    const assignTsString: string = this.datePipe.transform(assignTimestamp, 'yyyy-MM-dd HH:mm:ss');
    const body = {
      short_url_id: shortUrlId,
      assign_timestamp: assignTsString
    };

    return this.http.post(`${endpoints.post.delete_target_of_short_url}`,
      JSON.stringify(body),
      {headers: new HttpHeaders({ 'Content-Type': 'application/json' })}
    );
  }

  deleteShortURL(shortURLId: number): Observable<any> {
    const body = {
      short_url_id: shortURLId
    };

    return this.http.post(`${endpoints.post.delete_short_url}`,
      JSON.stringify(body),
      {headers: new HttpHeaders({ 'Content-Type': 'application/json' })}
    );
  }

  createTagForGroup(tagTitle: string,
                    tagDescription: string,
                    tagColor: Color): void {

    const body = {
      group_name: String(this.activeGroup),
      title: tagTitle,
      description: tagDescription,
      color: tagColor.toString().substr(1, 7)
    };

    this.http.post<any>(
      `${endpoints.post.create_tag_for_group}`,
      JSON.stringify(body),
      {headers: new HttpHeaders({'Content-Type': 'application/json'})}
    ).subscribe(res => console.log(res));
  }
}
