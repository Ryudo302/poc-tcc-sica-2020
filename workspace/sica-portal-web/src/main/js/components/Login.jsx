import React from 'react';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Col from 'react-bootstrap/Col';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import { Redirect } from 'react-router-dom';
import logo from '../../resources/static/img/logo192.png';
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

    efetuarLogin(event) {
        event.preventDefault();
        event.stopPropagation();

        AuthService.executeBasicAuth(this.state.username, this.state.password)
            .then(response => {
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
        if (AuthService.isUserLoggedIn()) {
            return <Redirect to="/home" />;
        } else {
            return (
                <div className="vertical-center">
                    <Container>
                        <Row className="justify-content-center">
                            <Col md={8}>
                                <Card className="card-login bg-transparent border-dark text-light">
                                    <Card.Img src={logo} alt="Logo do sistema" className="logo" />
                                    <Card.Body>
                                        <Card.Title>Login</Card.Title>

                                        <Form onSubmit={this.efetuarLogin}>
                                            <Form.Group as={Row} controlId="username">
                                                <Form.Label column sm={12} lg={2}>Usuário</Form.Label>
                                                <Col sm={12} lg={10}>
                                                    <Form.Control type="text" name="username" value={this.state.username} onChange={this.handleChangeInput} />
                                                </Col>
                                            </Form.Group>

                                            <Form.Group as={Row} controlId="password">
                                                <Form.Label column sm={12} lg={2}>Senha</Form.Label>
                                                <Col sm={12} lg={10}>
                                                    <Form.Control type="password" name="password" value={this.state.password} onChange={this.handleChangeInput} />
                                                </Col>
                                            </Form.Group>

                                            <Form.Group as={Row}>
                                                <Col sm={{ span: 10, offset: 2 }}>
                                                    <Button type="submit" variant="success">Login</Button>
                                                </Col>
                                            </Form.Group>
                                        </Form>

                                        {this.state.loginFalhou && <div className="alert alert-warning">Usuário ou senha inválido(s)!</div>}
                                        {this.state.loginSucesso && <div>Login Sucessful</div>}
                                    </Card.Body>
                                </Card>
                            </Col>
                        </Row>
                    </Container>
                </div>
            )
        }
    }
}

export default Login;