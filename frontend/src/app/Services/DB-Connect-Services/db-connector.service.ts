import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AuthService} from '../Iam-Services/auth.service';
import {endpoints} from '../../../assets/endpoints/endpoints';

@Injectable()
export class DbConnectorService {

  constructor(private http: HttpClient, private authService: AuthService) {}

  getAllTargetURLs(): Observable<any> {
    return this.http.get(`${endpoints.target_urls}`);
  }

}
