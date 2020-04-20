import React from 'react';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Iframe from 'react-iframe';
import '../resources/static/css/App.css';
import api from './Client';

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            modulos: [],
            urlAtual: 'http://192.168.99.101:8090/'
        };

        this.alterarModulo = this.alterarModulo.bind(this);
    }

    componentDidMount() {
        api('/api/modulos', { method: 'GET' })
            .then(response => response.json())
            .then(modulos => {
                this.setState({ modulos: modulos });
            });
    }

    alterarModulo(modulo) {
        this.setState({
            urlAtual: modulo.url
        });
    }

    render() {
        return (
            <>
                <Navbar className="bg-gradient-primary" bg="primary" variant="dark" sticky="top">
                    <Navbar.Brand href="#home">SICA</Navbar.Brand>
                    <Nav className="mr-auto">
                        {this.state.modulos.map(modulo => 
                            <Nav.Link key={modulo.id} onClick={() => this.alterarModulo(modulo)}>{modulo.nome}</Nav.Link>
                        )}
                    </Nav>
                </Navbar>
                <Iframe url={this.state.urlAtual}
                    width="100%"
                    height="100%"
                    id="iframe"
                    className="full-window"
                    display="initial"
                    position="relative" />
            </>
        );
    }
}

export default App;