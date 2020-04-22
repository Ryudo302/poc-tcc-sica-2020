import React from 'react';
import Col from 'react-bootstrap/Col';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import logo from '../../resources/static/img/logo192.png';
import AuthService from '../services/AuthService';

class Home extends React.Component {

    render() {
        const usuarioLogado = AuthService.isUserLoggedIn();

        return (
            <div className="vertical-center">
                <Container>
                    <Row className="justify-content-center">
                        <Col md={8}>
                            <div className="text-center">
                                <div className="d-flex flex-column flex-wrap justify-content-center text-light">
                                    <h2>Sistema de Controle Ambiental - SICA</h2>
                                    <h4>Bem-vindo!</h4>
                                    {!usuarioLogado && <p>Por favor, efetue login para continuar.</p>}
                                </div>
                                <img src={logo} alt="Logo do sistema" className="logo" />
                            </div>
                        </Col>
                    </Row>
                </Container>
            </div>
        );
    }
}

export default Home;