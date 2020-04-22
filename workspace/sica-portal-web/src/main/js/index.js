'use strict';

import '@fortawesome/fontawesome-free/css/all.min.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import ReactDOM from 'react-dom';
import '../resources/static/css/index.css';
import '../resources/static/css/sb-admin-2.min.css';
import '../resources/static/img/background.png';
import App from './App';

ReactDOM.render(
        <React.StrictMode>
            <div id="background-overlay">
                <App />
            </div>
        </React.StrictMode>,
    document.getElementById('app')
);
