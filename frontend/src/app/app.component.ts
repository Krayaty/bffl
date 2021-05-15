import { Component } from '@angular/core';
import {DbConnectorService} from './Services/DB-Connect-Services/db-connector.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'BFFL-Shortener';

  constructor(public dbconnector: DbConnectorService) {}
}


