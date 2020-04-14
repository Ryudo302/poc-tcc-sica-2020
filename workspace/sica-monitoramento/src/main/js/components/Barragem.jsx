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
        const numberFormat = new Intl.NumberFormat('pt-BR');
        let barragem = this.state.barragem;

        return (
            <Card>
                <Card.Body>
                    {barragem.nivelEmergencia
                        ? <span className={'float-right text-center text-light nivel-emergencia nivel-emergencia-' + barragem.nivelEmergencia.nivel} style={{ fontSize: 'xxx-large' }}
                            title={barragem.nivelEmergencia.descricao}>
                            <p style={{ position: 'relative', right: '0.8rem' }}>{barragem.nivelEmergencia.nivel}</p>
                        </span>
                        : ''}
                    <Card.Title>{barragem.nome}</Card.Title>
                    <Card.Text>
                        <strong>Capacidade total:</strong> {numberFormat.format(barragem.capacidadeTotal)} m³<br />
                        <strong>Volume atual:</strong> {numberFormat.format(barragem.volume)} m³<br />
                        <strong>Altura maciço:</strong> {barragem.alturaMacico} m
                    </Card.Text>
                    <SensoresList sensores={barragem.sensores} />
                </Card.Body>
            </Card>
        )
    }
}

export default Barragem;
