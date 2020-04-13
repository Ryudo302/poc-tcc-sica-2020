'use strict'

import React from 'react';
import Container from 'react-bootstrap/Container';

import BarragensList from './components/BarragensList';

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

                <ul className="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                    <a className="sidebar-brand d-flex align-items-center justify-content-center" href="/">
                        <div className="sidebar-brand-icon rotate-n-15">
                            <i className="fas fa-broadcast-tower"></i>
                        </div>
                        <div className="sidebar-brand-text mx-3">Monitoramento</div>
                    </a>

                    <hr className="sidebar-divider my-0" />

                    <li className="nav-item active">
                        <a className="nav-link" href="/">
                            <i className="fas fa-industry"></i>
                            <span>Barragens</span></a>
                    </li>

                    <hr className="sidebar-divider d-none d-md-block" />

                    <div className="text-center d-none d-md-inline">
                        <button className="rounded-circle border-0" id="sidebarToggle"></button>
                    </div>
                </ul>

                <div id="content-wrapper" className="d-flex flex-column">

                    <div id="content">

                        <Container>
                            <BarragensList />
                        </Container>

                    </div>
                </div>
            </div>
        )
    }
}

export default App;
