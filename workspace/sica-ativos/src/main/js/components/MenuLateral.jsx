import React from 'react';

import Button from 'react-bootstrap/Button';

class MenuLateral extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {
        const handleClick = () => {
            document.querySelector('body').classList.toggle('sidebar-toggled');
            document.querySelector('.sidebar').classList.toggle('toggled');
            //if (document.querySelector('.sidebar').classList.contains('toggled')) {
               // $('.sidebar .collapse').collapse('hide');
            //}
        };

        return (
    		<ul className="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <a className="sidebar-brand d-flex align-items-center justify-content-center" href="/">
                    <div className="sidebar-brand-icon rotate-n-15">
                    <i className="fas fa-truck"></i>
                    </div>
                    <div className="sidebar-brand-text mx-3">Ativos</div>
                </a>

                <hr className="sidebar-divider my-0" />

                <li className="nav-item active">
                    <a className="nav-link" href="/">
                    <i className="fas fa-list-alt"></i>
                    <span>Consulta</span></a>
                </li>
                
                <hr className="sidebar-divider d-none d-md-block" />

                <div className="text-center d-none d-md-inline">
                  <button className="rounded-circle border-0" id="sidebarToggle" onClick={handleClick}></button>
                </div>
            </ul>
        );
    }
}

export default MenuLateral;
