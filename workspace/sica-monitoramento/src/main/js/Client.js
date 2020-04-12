'use strict';

const fetchDefaults = require("fetch-defaults");
const api = fetchDefaults(fetch, {
    headers: {
        Authorization: "Bearer 42",
        Accept: 'application/json'
    }
});

module.exports = api;
