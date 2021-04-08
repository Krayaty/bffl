import {KeycloakOptions} from 'keycloak-angular';

export const apiUrl = 'http://localhost:5000';

const keycloakOptions: KeycloakOptions = {
  config: {
    url: 'https://auth.bfflshort.de/auth/',
    realm: 'BFFL-Realm',
    clientId: 'bffl-FE',
  },
  initOptions: {
    onLoad: 'login-required',
    checkLoginIframe: false,
  },
  enableBearerInterceptor: true,
  bearerExcludedUrls: []

};

export const environment = {
  production: false,
  keycloak: keycloakOptions,
  idp: {
    roles: {
      user: 'APP-User',
      admin: 'APP-Admin',
    },
  },
  paths: {
    public: '',
    admin: 'admin',
    user: 'user',
  }
};
