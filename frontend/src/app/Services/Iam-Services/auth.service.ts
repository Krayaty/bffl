import { Injectable } from '@angular/core';
import {KeycloakService} from 'keycloak-angular';

@Injectable()
export class AuthService {

  constructor(private keycloakService: KeycloakService) { }

  getLoggdUser(): any {
    try{
      const userDetails = this.keycloakService.getKeycloakInstance().idTokenParsed;
      console.log('Userdetails: ' + userDetails);
      console.log('UserRoles' + this.keycloakService.getUserRoles(true));
      return userDetails;
    } catch (e){
      return undefined;
    }
  }

  logout(): void{
    this.keycloakService.logout();
  }

  redirectToProfile(): void{
    this.keycloakService.getKeycloakInstance().accountManagement();
  }

  getRoles(): string[] {
    return this.keycloakService.getUserRoles(true);
  }

}
