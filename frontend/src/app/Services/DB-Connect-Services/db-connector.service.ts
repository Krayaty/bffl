import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {endpoints} from '../../../assets/endpoints/endpoints';
import {environment} from '../../../environments/environment';
import {AuthService} from '../Iam-Services/auth.service';
import {AbstractControl} from '@angular/forms';

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

  // Eventuell zur Sicherheit noch ändern - user_id wird über URL verschickt
  getGroupID(userId: string): Observable<any> {
    return this.http.get(`${environment.endpoints.group_id}&user_id=${userId}`, this.headers);
  }

  // tslint:disable-next-line:max-line-length
  saveNewURL(timestamp: number, deleteFlag: boolean, updateFlag: boolean, url: string, wishURL: string, scope: AbstractControl, protocol: any): Observable<any> {
    const body = { timestamp, deleteFlag, updateFlag, url, wishURL, scope };
    this.http.post<any>(`${environment.endpoints.save_url}`, body, this.headers ).subscribe(data => {
      // this.postId = data.id; ??
    });
    return this.http.post(`${environment.endpoints.save_url}`, this.headers);
  }

  // tslint:disable-next-line:max-line-length
  saveNewURLPlusOwner(timestamp: number, deleteFlag: boolean, updateFlag: boolean, url: string, wishURL: string, scope: AbstractControl, protocol: any, owner: string): Observable<any> {
    const body = { timestamp, deleteFlag, updateFlag, url, wishURL, scope, protocol, owner};
    this.http.post<any>(`${environment.endpoints.save_url}`, body, this.headers ).subscribe(data => {
      // this.postId = data.id; ??
    });
    return this.http.post(`${environment.endpoints.save_url}`, this.headers);
  }

  // tslint:disable-next-line:max-line-length
  saveNewURLPlusTags(timestamp: number, deleteFlag: boolean, updateFlag: boolean, url: string, wishURL: string, scope: AbstractControl, protocol: any, tags: string): Observable<any> {
    const body = { timestamp, deleteFlag, updateFlag, url, wishURL, scope, protocol, tags};
    this.http.post<any>(`${environment.endpoints.save_url}`, body, this.headers ).subscribe(data => {
      // this.postId = data.id; ??
    });
    return this.http.post(`${environment.endpoints.save_url}`, this.headers);
  }

  // tslint:disable-next-line:max-line-length
  saveNewURLPlusOwnerAndTags(timestamp: number, deleteFlag: boolean, updateFlag: boolean, url: string, wishURL: string, scope: AbstractControl, protocol: any, owner: string, tags: string): Observable<any> {
    const body = { timestamp, deleteFlag, updateFlag, url, wishURL, scope, protocol, owner, tags};
    this.http.post<any>(`${environment.endpoints.save_url}`, body, this.headers ).subscribe(data => {
      // this.postId = data.id; ??
    });
    return this.http.post(`${environment.endpoints.save_url}`, this.headers);
  }
}
