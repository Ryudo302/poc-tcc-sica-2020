import React from 'react';
import Container from 'react-bootstrap/Container';
import AuthService from '../services/AuthService';

class Login extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            username: '',
            password: '',
            loginFalhou: false,
            loginSucesso: false
        };

        this.handleChangeInput = this.handleChangeInput.bind(this);
        this.efetuarLogin = this.efetuarLogin.bind(this);
    }

    handleChangeInput(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    efetuarLogin() {
        AuthService.executeBasicAuth(this.state.username, this.state.password)
            .then(response=> {
                this.props.history.push(`/`);
                this.props.loginCallback();
            }).catch(() => {
                this.setState({
                    loginSucesso: false,
                    loginFalhou: true
                })
            });
    }

    render() {
        return (
            <Container>
                <h1>Login</h1>
                <div className="container">
                    {this.state.loginFalhou && <div className="alert alert-warning">Invalid Credentials</div>}
                    {this.state.loginSucesso && <div>Login Sucessful</div>}
                    User Name: <input type="text" name="username" value={this.state.username} onChange={this.handleChangeInput} />
                    Password: <input type="password" name="password" value={this.state.password} onChange={this.handleChangeInput} />
                    <button className="btn btn-success" onClick={this.efetuarLogin}>Login</button>
                </div>
            </Container>
        )
    }
}

export default Login;