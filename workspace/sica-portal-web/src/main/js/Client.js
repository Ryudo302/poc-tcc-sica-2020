'use strict';

import fetchDefaults from "fetch-defaults";
import AuthService from './services/AuthService';

const api = fetchDefaults(fetch, {
    headers: {
        Authorization: AuthService.getAuthToken(),
        Accept: ['application/json', 'text/plain']
    }
});

export default api;