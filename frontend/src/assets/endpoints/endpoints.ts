import {apiUrl} from '../../environments/environment';

export const endpoints = {
  target_urls: `${apiUrl}/api/target_urls`,
  short_urls_with_current_target: `${apiUrl}/api/allShortURLsByGroup`
};
