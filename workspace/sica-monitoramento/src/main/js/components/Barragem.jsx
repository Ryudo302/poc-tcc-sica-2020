import React from 'react';
import Card from 'react-bootstrap/Card';
import api from '../Client';
import SensoresList from './SensoresList';

class Barragem extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            barragem: {
                id: props.idBarragem,
                sensores: []
            }
        };
    }

    componentDidMount() {
        this.carregarDadosBarragem();
    }

    carregarDadosBarragem() {
        api('/api/barragens/' + this.state.barragem.id, { method: 'GET' })
            .then(response => response.json())
            .then(barragem => {
                this.setState({
                    barragem: barragem
                });
            });
    }

    render() {
        let barragem = this.state.barragem;

        return (
            <Card>
                <Card.Body>
                    <Card.Title>{barragem.nome}</Card.Title>
                    <Card.Text>
                        <strong>Capacidade total:</strong> {barragem.capacidadeTotal} m³<br />
                        <strong>Volume atual:</strong> {barragem.volume} m³<br />
                    </Card.Text>
                    <SensoresList sensores={barragem.sensores} />
                </Card.Body>
            </Card>
        )
    }
}

export default Barragem;
