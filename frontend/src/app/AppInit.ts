import {KeycloakService} from 'keycloak-angular';
import {environment} from '../environments/environment';

export function keycloakInitializer(keycloak: KeycloakService): () => Promise<any> {
  return (): Promise<any> => {
    return new Promise(async (resolve, reject) => {
      try {
        await keycloak.init(environment.keycloak);
        resolve(true);
      } catch (error) {
        reject(error);
      }
    });
  };
}
