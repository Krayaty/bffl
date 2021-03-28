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

}
