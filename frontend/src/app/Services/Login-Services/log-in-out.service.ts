import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LogInOutService {

  loggedIn: boolean;
  sessionId: number;

  constructor() {
    this.loggedIn = false;
  }

  logIn(userName: string, pw: string): boolean {
    this.loggedIn = true;
    this.sessionId = 1;
    return true;
  }

  logOut(): boolean {
    this.loggedIn = false;
    this.sessionId = NaN;
    return true;
  }

}
