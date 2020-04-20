import React from 'react';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Iframe from 'react-iframe';
import '../resources/static/css/App.css';

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            urlAtual: 'http://192.168.99.101:8090/'
        };
    }

    render() {
        return (
            <>
                <Navbar className="bg-gradient-primary" bg="primary" variant="dark" sticky="top">
                    <Navbar.Brand href="#home">SICA</Navbar.Brand>
                    <Nav className="mr-auto">
                        <Nav.Link href="#ativos">Ativos</Nav.Link>
                        <Nav.Link href="#monitoramento">Monitoramento</Nav.Link>
                        <Nav.Link href="#seguranca">Segurança</Nav.Link>
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