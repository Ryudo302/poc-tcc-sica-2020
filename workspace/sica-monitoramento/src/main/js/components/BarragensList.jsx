import React from 'react';
import Tab from 'react-bootstrap/Tab';
import Tabs from 'react-bootstrap/Tabs';
import api from '../Client';
import Barragem from './Barragem';

class BarragensList extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            barragens: []
        };
    }

    componentDidMount() {
        this.carregarDadosBasicosBarragens();
    }

    carregarDadosBasicosBarragens() {
        api('/api/barragens', { method: 'GET' })
            .then(response => response.json())
            .then(barragens => {
                this.setState({ barragens: barragens });
            });
    }

    render() {
        let idPrimeiraBarragem = this.state.barragens.length ? this.state.barragens[0].id : '';

        return (
            <Tabs defaultActiveKey={"barragem-" + idPrimeiraBarragem} id="barragens">
                {this.state.barragens.map(barragem =>
                    <Tab key={"barragem-" + barragem.id} eventKey={"barragem-" + barragem.id} title={barragem.nome}>
                        <Barragem idBarragem={barragem.id} />
                    </Tab>
                )}
            </Tabs>
        )
    }

    nivelEmergenciaToBadgeVariant(nivelEmergencia) {
        switch (nivelEmergencia) {
            case 0: return 'success';
            case 1: return 'info';
            case 2: return 'warning';
            case 3: return 'danger';
        }
    }
}

export default BarragensList;
