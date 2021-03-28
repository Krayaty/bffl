import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {apiUrl, environment} from '../../../environments/environment';
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

  getAllUsers(): Observable<any> {
    return this.http.get(`${apiUrl}/App_users`);
  }

  get(id): Observable<any> {
    return this.http.get(`${apiUrl}/${id}`);
  }

  create(data): Observable<any> {
    return this.http.post(apiUrl, data);
  }

  update(id, data): Observable<any> {
    return this.http.put(`${apiUrl}/${id}`, data);
  }

  delete(id): Observable<any> {
    return this.http.delete(`${apiUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(apiUrl);
  }

  findByTitle(title): Observable<any> {
    return this.http.get(`${apiUrl}?title=${title}`);
  }

  getAllTargetURLs(): Observable<any> {
    return this.http.get(`${environment.endpoints.target_urls}`, this.headers);
  }

}
