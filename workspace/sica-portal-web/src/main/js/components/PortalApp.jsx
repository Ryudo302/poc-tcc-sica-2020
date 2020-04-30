import React from 'react';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link, Redirect, Route, Switch, withRouter } from 'react-router-dom';
import api from '../Client';
import AuthService from '../services/AuthService';
import AuthenticatedRoute from './AuthenticatedRoute';
import Home from './Home';
import Login from './Login';
import Modulo from './Modulo';
import TratamentoErro from './TratamentoErro';

class PortalApp extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            modulos: [],
            moduloAtual: null
        };

        this.carregarModulos = this.carregarModulos.bind(this);
        this.alterarModulo = this.alterarModulo.bind(this);
        this.logout = this.logout.bind(this);
    }

    componentDidMount() {
        if (AuthService.isUserLoggedIn()) {
            this.carregarModulos();
        }
    }

    carregarModulos() {
        api('/api/modulos', { method: 'GET' })
            .then(response => response.json())
            .then(response => {
                if (response.status == 401) {
                    throw Error();
                } else {
                    return response;
                }
            })
            .then(modulos => {
                this.setState({ modulos: modulos });
            })
            .catch(error => {
                this.logout();
            });
    }

    alterarModulo(modulo) {
        if (AuthService.isUserLoggedIn()) {
            this.setState({
                moduloAtual: modulo
            });

            this.props.history.push('/modulo');
        } else {
            console.log("Usuário não autenticado");
            this.logout();
        }
    }

    logout() {
        AuthService.logout();
        this.setState({
            modulos: [],
            moduloAtual: null
        });
    }

    render() {
        const usuarioLogado = AuthService.isUserLoggedIn();
        const usuario = AuthService.getLoggedInUsername();

        return (
            <div key={this.props.location.pathname}>
                <Navbar collapseOnSelect expand="md" className="bg-gradient-primary" bg="primary" variant="dark" sticky="top">
                    <Navbar.Brand href="/">SICA</Navbar.Brand>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                    <Navbar.Collapse id="responsive-navbar-nav">
                        <Nav className="mr-auto">
                            {this.state.modulos.map(modulo =>
                                <Nav.Link key={modulo.id} onClick={() => this.alterarModulo(modulo)}>{modulo.nome}</Nav.Link>
                            )}
                        </Nav>
                        <hr className="sidebar-divider" />
                        <Nav className="justify-content-end">
                            {!usuarioLogado && <Nav.Link as={Link} to="/login">Login</Nav.Link>}
                            {usuarioLogado && <Nav.Link as={Link} to="/logout" onClick={this.logout}>{usuario} (Logout)</Nav.Link>}
                        </Nav>
                    </Navbar.Collapse>
                </Navbar>
                <TratamentoErro>
                    <Switch>
                        <Route path="/home" exact component={Home} />
                        <Route path="/login" exact render={(props) => <Login {...props} loginCallback={this.carregarModulos} />} />
                        <AuthenticatedRoute path="/modulo" exact render={(props) => <Modulo {...props} modulo={this.state.moduloAtual} />} />
                        <Route path="*" render={() => <Redirect to="/home" />} />
                    </Switch>
                </TratamentoErro>
            </div>
        );
    }
}

export default withRouter(PortalApp);