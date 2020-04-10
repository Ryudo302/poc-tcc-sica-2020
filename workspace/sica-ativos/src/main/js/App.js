'use strict'

import React from 'react';
import api from './client';
import Container from 'react-bootstrap/Container';

import AtivosList from './components/AtivosList';

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
            })
    }

    render() {
        return (
            <div id="wrapper">

                <ul className="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                    <a className="sidebar-brand d-flex align-items-center justify-content-center" href="/">
                        <div className="sidebar-brand-icon rotate-n-15">
                        <i className="fas fa-laugh-wink"></i>
                        </div>
                        <div className="sidebar-brand-text mx-3">Ativos</div>
                    </a>

                    <hr className="sidebar-divider my-0" />

                    <li className="nav-item active">
                        <a className="nav-link" href="index.html">
                        <i className="fas fa-fw fa-tachometer-alt"></i>
                        <span>Cadastro</span></a>
                    </li>
                    
                    <hr className="sidebar-divider d-none d-md-block" />

                    <div className="text-center d-none d-md-inline">
                      <button className="rounded-circle border-0" id="sidebarToggle"></button>
                    </div>
                </ul>
                
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
