'use strict';

import fetchDefaults from "fetch-defaults";

const api = fetchDefaults(fetch, {
    headers: {
        Authorization: "Bearer 42",
        Accept: 'application/json'
    }
});

export default api;
