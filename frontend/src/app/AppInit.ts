import {KeycloakOptions, KeycloakService} from 'keycloak-angular';
import {environment} from '../environments/environment';

export function initializer(keycloak: KeycloakService): () => Promise<any> {
  const options: KeycloakOptions = {
    config: environment.keycloakConfig
  };
  return (): Promise<any> => keycloak.init(options);
}
