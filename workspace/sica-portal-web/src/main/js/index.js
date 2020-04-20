'use strict';

import React from 'react';
import ReactDOM from 'react-dom';

import App from './App';

import '@fortawesome/fontawesome-free/css/all.min.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../resources/static/css/sb-admin-2.min.css';
import '../resources/static/css/index.css';

ReactDOM.render(
    <React.StrictMode>
        <App />
    </React.StrictMode>,
    document.getElementById('app')
);
