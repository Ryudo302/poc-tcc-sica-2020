import React from 'react';
import CardColumns from 'react-bootstrap/CardColumns';
import api from '../Client';
import Barragem from './Barragem';

class BarragensList extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            barragens: [],
            niveisEmergencia: []
        };
    }

    componentDidMount() {
        this.carregarBarragens();
        this.carregarNiveisEmergencia();
    }

    carregarBarragens() {
        api('/api/barragens', { method: 'GET' })
            .then(response => response.json())
            .then(barragens => {
                this.setState({ barragens: barragens });
            });
    }

    carregarNiveisEmergencia() {
        api('/api/niveis-emergencia', { method: 'GET' })
            .then(response => response.json())
            .then(niveisEmergencia => {
                this.setState({ niveisEmergencia: niveisEmergencia });
            });
    }

    render() {
        return (
            <CardColumns>
                {this.state.barragens.map(barragem =>
                    <Barragem key={barragem.id} barragem={barragem} niveisEmergencia={this.state.niveisEmergencia} />
                )}
            </CardColumns>
        );
    }
}

export default BarragensList;