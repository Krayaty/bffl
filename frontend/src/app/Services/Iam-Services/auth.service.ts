import { Injectable } from '@angular/core';
import {KeycloakService} from 'keycloak-angular';

@Injectable({providedIn: 'root'})
export class AuthService {

  constructor(private keycloakService: KeycloakService) {}

  getUserProfile(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      if (this.keycloakService.getKeycloakInstance().token) {
        this.keycloakService.getKeycloakInstance()
          .loadUserProfile()
          .success(data => {
            resolve(data as any);
          })
          .error(() => {
            reject('Failed to load profile');
          });
      } else {
        reject('Not logged in');
      }
    });
  }

  getIdToken(): any {
    try{
      return this.keycloakService.getKeycloakInstance().idTokenParsed;
    } catch (e){
      return undefined;
    }
  }

  getAccessToken(): any {
    try{
      return this.keycloakService.getKeycloakInstance().tokenParsed;
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
    return this.keycloakService.getUserRoles();
  }

}
