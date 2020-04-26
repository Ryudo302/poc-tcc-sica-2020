import React from 'react';
import Card from 'react-bootstrap/Card';
import api from '../Client';
import stompClient from '../websocketListener';
import ProcedimentosList from './ProcedimentosList';
import ProcedimentosNiveisEmergenciaList from './ProcedimentosNiveisEmergenciaList';

class Barragem extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            barragem: props.barragem
        };

        this.atualizarDadosBarragem = this.atualizarDadosBarragem.bind(this);
    }

    componentDidMount() {
        stompClient([
            { destination: '/topic/barragem', callback: this.atualizarDadosBarragem }
        ]);
    }

    atualizarDadosBarragem(message) {
        let dadosBarragem = JSON.parse(message.body);

        if (this.state.barragem.id === dadosBarragem.id) {
            api('/api/barragens/' + dadosBarragem.id, { method: 'GET' })
                .then(response => response.json())
                .then(barragem => {
                    this.setState({
                        barragem: barragem
                    });
                });
        }
    }

    static getDerivedStateFromProps(nextProps, prevState) {
        if (nextProps.barragem.id !== prevState.barragem.id) {
            return {
                barragem: nextProps.barragem
            };
        } else {
            return null;
        }
    }

    render() {
        const dateTimeFormatter = new Intl.DateTimeFormat('pt-BR', {
            day: 'numeric', month: 'numeric', year: 'numeric',
            hour: 'numeric', minute: 'numeric', second: 'numeric',
            timeZone: 'America/Sao_Paulo'
        });

        const barragem = this.state.barragem;

        return (
            <Card>
                <Card.Body>
                    {barragem.nivelEmergencia
                        ? <span className={'float-right text-center text-light nivel-emergencia nivel-emergencia-' + barragem.nivelEmergencia.nivel} style={{ fontSize: '55px' }}>
                            <p style={{ position: 'relative', right: '0.8rem' }}>{barragem.nivelEmergencia.nivel}</p>
                        </span>
                        : ''}
                    <Card.Title>{barragem.nome}</Card.Title>

                    <p><strong>Procedimentos em execução:</strong></p>
                    <ProcedimentosList procedimentos={barragem.nivelEmergencia.procedimentos} />

                    <p><strong>Procedimentos configurados:</strong></p>
                    <ProcedimentosNiveisEmergenciaList niveisEmergencia={this.props.niveisEmergencia} />
                </Card.Body>
                <Card.Footer className="text-muted text-center">
                    Última Atualização:<br />
                    {barragem.dataUltimaAtualizacao ? dateTimeFormatter.format(new Date(barragem.dataUltimaAtualizacao)) : "-"}<br />
                </Card.Footer>
            </Card>
        );
    }
}

export default Barragem;
