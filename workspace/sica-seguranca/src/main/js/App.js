'use strict'

import React from 'react';
import Container from 'react-bootstrap/Container';

import MenuLateral from './components/MenuLateral';

import '../resources/static/css/App.css';

class App extends React.Component {

    constructor(props) {
        super(props);
    }

    componentDidMount() {
    }

    render() {
        return (
            <div id="wrapper">

                <MenuLateral />

                <div id="content-wrapper" className="d-flex flex-column">

                    <div id="content">

                        <Container fluid>
                        </Container>

                    </div>
                </div>
            </div>
        )
    }
}

export default App;
