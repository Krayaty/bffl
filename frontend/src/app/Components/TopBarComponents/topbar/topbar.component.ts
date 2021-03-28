import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../../Services/Iam-Services/auth.service';

@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.css']
})
export class TopbarComponent implements OnInit {

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  logout(): void{
    this.authService.logout();
  }

}
