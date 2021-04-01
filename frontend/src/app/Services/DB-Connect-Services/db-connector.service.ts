import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {AuthService} from '../Iam-Services/auth.service';

@Injectable()
export class DbConnectorService {

  constructor(private http: HttpClient, private authService: AuthService) {}

  getAllTargetURLs(): Observable<any> {
    return this.http.get(`${environment.endpoints.target_urls}`);
  }

}
