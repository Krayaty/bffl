import { Injectable } from '@angular/core';
import {KeycloakAuthGuard, KeycloakService} from 'keycloak-angular';
import {ActivatedRouteSnapshot, Router, RouterStateSnapshot, UrlTree} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService extends KeycloakAuthGuard {

  constructor(protected router: Router, protected keycloakAngular: KeycloakService) {
    super(router, keycloakAngular);
  }

  isAccessAllowed(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<boolean | UrlTree> {
    return new Promise(async (resolve, reject) => {
      if (!this.authenticated){
        this.keycloakAngular.getKeycloakInstance().login();
        resolve(false);
        return;
      }
      const requiredRoles = route.data.roles;
      let granted = false;
      if (!requiredRoles || requiredRoles.length === 0){
        granted = true;
      } else {
        for (const requiredRole of requiredRoles){
          if (this.roles.indexOf(requiredRoles) > -1){
            granted = true;
            break;
          }
        }
      }

      if (granted === false){
        resolve(granted);
      }
      resolve(granted);
    });
  }
}
