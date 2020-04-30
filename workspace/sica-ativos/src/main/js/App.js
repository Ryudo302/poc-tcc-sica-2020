'use strict'

import React from 'react';
import Container from 'react-bootstrap/Container';
import '../resources/static/css/App.css';
import api from './Client';
import AtivosList from './components/AtivosList';
import FiltrosConsulta from './components/FiltrosConsulta';
import MenuLateral from './components/MenuLateral';
import TratamentoErro from './components/TratamentoErro';

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            ativos: [],
            filtros: {}
        };

        this.mudarFiltros = this.mudarFiltros.bind(this);
        this.atualizarConsulta = this.atualizarConsulta.bind(this);
    }

    componentDidMount() {
       this.atualizarConsulta();
    }

    mudarFiltros(novosFiltros) {
        this.setState({
            filtros: novosFiltros
        });
        this.atualizarConsulta(novosFiltros);
    }

    atualizarConsulta(novosFiltros) {
        let filtros = (novosFiltros || this.state.filtros);
        let queryParams = Object.keys(filtros).map(key => key + '=' + filtros[key] + '&');

        api('/api/ativos?' + queryParams, { method: 'GET' })
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

                        <TratamentoErro>
                            <Container>
                                <FiltrosConsulta filtrosCallback={this.mudarFiltros} />
                                <AtivosList ativos={this.state.ativos} />
                            </Container>
                        </TratamentoErro>
		                    
		            </div>
		        </div>
            </div>
        )
    }
}

export default App;
