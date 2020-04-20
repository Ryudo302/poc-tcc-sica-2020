'use strict'

import React from 'react';
import api from './Client';
import Container from 'react-bootstrap/Container';

import AtivosList from './components/AtivosList';
import MenuLateral from './components/MenuLateral';

import '../resources/static/css/App.css';

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            ativos: []
        };
    }

    componentDidMount() {
        api('/api/ativos', { method: 'GET' })
            .then(response => response.json())
            .then(ativos => {
                ativos.forEach(ativo => {
                    ativo.urlImagem = '/api/ativos/' + ativo.id + '/imagem';
                });

                this.setState({ ativos: ativos });
            });
    }

    render() {
        return (
            <div id="wrapper">
            
            	<MenuLateral />

                <div id="content-wrapper" className="d-flex flex-column">

	                <div id="content">
	
		                <Container>
		                    <AtivosList ativos={this.state.ativos} />
		                </Container>
		                    
		            </div>
		        </div>
            </div>
        )
    }
}

export default App;
