import {Component, Input, OnInit} from '@angular/core';
import {LogInOutService} from '../../../Services/Login-Services/log-in-out.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private logInOutService: LogInOutService) {}

  ngOnInit(): void {}

  public getLogInOutService(): LogInOutService{
    return this.logInOutService;
  }

}
