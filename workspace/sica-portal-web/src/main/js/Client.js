'use strict';

import fetchDefaults from "fetch-defaults";
import fetchIntercept from 'fetch-intercept';
import AuthService from './services/AuthService';

const unregister = fetchIntercept.register({
    request: function (url, config) {
        config.headers['Authorization'] = AuthService.getAuthToken();
        console.log("Fetch Headers:", config.headers);
        return [url, config];
    },

    requestError: function (error) {
        // Called when an error occured during another 'request' interceptor call
        return Promise.reject(error);
    },

    response: function (response) {
        // Modify the reponse object
        return response;
    },

    responseError: function (error) {
        // Handle an fetch error
        return Promise.reject(error);
    }
});

const api = fetchDefaults(fetch, {
    headers: {
        Accept: ['application/json', 'text/plain']
    }
});

export default api;