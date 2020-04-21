import api from '../Client';

export const USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser';
export const AUTH_TOKEN_ATTRIBUTE_NAME = 'authToken';

class AuthService {

    executeBasicAuth(username, password) {
        let token = this.createBasicAuthToken(username, password);
        sessionStorage.setItem(AUTH_TOKEN_ATTRIBUTE_NAME, token);

        return api('/api/auth', {
            method: 'GET'
        }).then(response => {
            if (response.ok) {
                sessionStorage.setItem(USER_NAME_SESSION_ATTRIBUTE_NAME, username);
            } else {
                throw new Error(response.statusText);
            }
        });
    }

    logout() {
        sessionStorage.removeItem(USER_NAME_SESSION_ATTRIBUTE_NAME);
        sessionStorage.removeItem(AUTH_TOKEN_ATTRIBUTE_NAME);
    }

    createBasicAuthToken(username, password) {
        return 'Basic ' + Buffer.from(`${username}:${password}`, 'utf8').toString('base64');
    }


    getAuthToken() {
        return sessionStorage.getItem(AUTH_TOKEN_ATTRIBUTE_NAME);
    }

    getLoggedInUsername() {
        return sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME) || '';
    }

    isUserLoggedIn() {
        return sessionStorage.getItem(USER_NAME_SESSION_ATTRIBUTE_NAME) !== null;
    }
}

export default new AuthService();