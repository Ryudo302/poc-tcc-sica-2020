'use strict'

import React from 'react';
import Container from 'react-bootstrap/Container';
import '../resources/static/css/App.css';
import BarragensList from './components/BarragensList';
import MenuLateral from './components/MenuLateral';
import TratamentoErro from './components/TratamentoErro';

class App extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div id="wrapper">

                <MenuLateral />

                <div id="content-wrapper" className="d-flex flex-column">

                    <div id="content">

                        <TratamentoErro>
                            <Container fluid>
                                <BarragensList />
                            </Container>
                        </TratamentoErro>

                    </div>
                </div>
            </div>
        )
    }
}

export default App;
