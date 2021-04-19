import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {AuthService} from '../Iam-Services/auth.service';

@Injectable()
export class DbConnectorService {

  private headers = {};

  constructor(private http: HttpClient, authService: AuthService) {
    this.headers = {
      'Content-Type': 'application/json',
      Authorization: `Bearer ${authService.getAccessToken()}`,
    };
  }

  getAllTargetURLs(): Observable<any> {
    return this.http.get(`${environment.endpoints.target_urls}`, this.headers);
  }

  // Eventuell zur Sicherheit noch ändern - user_id wird über URL verschickt
  // tslint:disable-next-line:variable-name
  getGroupID(user_id: string): Observable<any> {
    return this.http.get(`${environment.endpoints.group_id}&user_id=${user_id}`, this.headers);
  }

  // tslint:disable-next-line:variable-name max-line-length
  saveNewURL(timestamp: number, delete_flag: string, update_flag: string, group_id: string, tag_id: string, url: string, wishURL: string, scope: string): Observable<any> {
    const body = { timestamp, delete_flag, update_flag, group_id, tag_id, url, wishURL, scope };
    this.http.post<any>(`${environment.endpoints.save_url}`, body, this.headers ).subscribe(data => {
     // this.postId = data.id; ??
    });
    return this.http.post(`${environment.endpoints.save_url}`, this.headers);
  }
}
