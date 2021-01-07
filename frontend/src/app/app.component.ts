import { Component } from '@angular/core';
import {LogInOutService} from './Services/Login-Services/log-in-out.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'BFFL-Shortener';

  constructor(private logInOutService: LogInOutService) {}

  public getLogInOutService(): LogInOutService{
    return this.logInOutService;
  }

}
