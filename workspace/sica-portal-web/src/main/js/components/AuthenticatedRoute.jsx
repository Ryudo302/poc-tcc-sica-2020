import React, { Component } from 'react';
import { Redirect, Route } from 'react-router-dom';
import AuthService from '../services/AuthService';

class AuthenticatedRoute extends Component {

    render() {
        if (AuthService.isUserLoggedIn()) {
            return <Route {...this.props} />
        } else {
            return <Redirect to="/login" />
        }

    }
}

export default AuthenticatedRoute;