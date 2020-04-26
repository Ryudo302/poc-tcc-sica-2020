import React from 'react';
import Alert from 'react-bootstrap/Alert';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import api from '../Client';
import stompClient from '../websocketListener';
import ModalEditarRelatorio from './ModalEditarRelatorio';
import ModalVisualizarRelatorio from './ModalVisualizarRelatorio';
import SensoresList from './SensoresList';

class Barragem extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            barragem: {
                id: props.idBarragem,
                sensores: []
            },
            relatorioEstabilidade: null,
            mensagem: null,
            incluindoRelatorio: false
        };

        this.buscarUltimoRelatorioEstabilidade = this.buscarUltimoRelatorioEstabilidade.bind(this);
        this.handleFecharMensagem = this.handleFecharMensagem.bind(this);
        this.handleFecharModalEditarRelatorio = this.handleFecharModalEditarRelatorio.bind(this);
        this.handleFecharModalVisualizarRelatorio = this.handleFecharModalVisualizarRelatorio.bind(this);
        this.cadastrarRelatorioEstabilidade = this.cadastrarRelatorioEstabilidade.bind(this);
        this.atualizarDadosBarragem = this.atualizarDadosBarragem.bind(this);
    }

    componentDidMount() {
        this.carregarDadosBarragem();

        stompClient([
            { destination: '/topic/barragem', callback: this.atualizarDadosBarragem }
        ]);
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

    atualizarDadosBarragem(message) {
        let infoBarragem = JSON.parse(message.body);

        if (this.state.barragem.id === infoBarragem.id) {
            this.setState({
                barragem: {
                	...this.state.barragem,
                    nivelEmergencia: {
                    	...this.state.barragem.nivelEmergencia,
                        nivel: infoBarragem.nivelEmergencia
                    }
                },
            });
        }
    }

    buscarUltimoRelatorioEstabilidade() {
        api('/api/relatorios-estabilidade?idBarragem=' + this.state.barragem.id + '&ultimo=true', { method: 'GET' })
            .then(response => response.json())
            .then(relatorios => {
                if (relatorios.length) {
                    this.setState({
                        relatorioEstabilidade: relatorios[0]
                    });
                } else {
                    this.setState({
                        mensagem: "Não há nenhum relatório cadastrado.",
                        relatorioEstabilidade: null
                    });
                }
            });
    }

    cadastrarRelatorioEstabilidade() {
        this.setState({
            incluindoRelatorio: true
        });
    }

    handleFecharModalVisualizarRelatorio() {
        this.setState({
            relatorioEstabilidade: null
        });
    }

    handleFecharModalEditarRelatorio() {
        this.setState({
            incluindoRelatorio: false
        });
    };

    handleFecharMensagem() {
        this.setState({
            mensagem: null
        });
    }

    render() {
        const numberFormatter = new Intl.NumberFormat('pt-BR');

        let barragem = this.state.barragem;

        return (
            <Card>
                <Card.Body>
                    {barragem.nivelEmergencia
                        ? <span className={'float-right text-center text-light nivel-emergencia nivel-emergencia-' + barragem.nivelEmergencia.nivel} style={{ fontSize: '55px' }}
                            title={barragem.nivelEmergencia.descricao}>
                            <p style={{ position: 'relative', right: '0.8rem' }}>{barragem.nivelEmergencia.nivel}</p>
                        </span>
                        : ''}
                    <Card.Title>{barragem.nome}</Card.Title>
                    <Card.Text>
                        <strong>Capacidade total:</strong> {numberFormatter.format(barragem.capacidadeTotal)} m³<br />
                        <strong>Volume atual:</strong> {numberFormatter.format(barragem.volume)} m³<br />
                        <strong>Altura maciço:</strong> {barragem.alturaMacico} m<br /><br />
                        <Button variant="secondary" size="sm" onClick={this.buscarUltimoRelatorioEstabilidade}><i className="fas fa-tasks"></i> Último Relatório de Estabilidade</Button>
                        {' '}
                        <Button variant="primary" size="sm" onClick={this.cadastrarRelatorioEstabilidade}><i className="fas fa-plus"></i> Registrar Relatório de Estabilidade</Button>
                    </Card.Text>

                    {this.state.relatorioEstabilidade
                        ? <ModalVisualizarRelatorio relatorio={this.state.relatorioEstabilidade} onClose={this.handleFecharModalVisualizarRelatorio} />
                        : ''}

                    {this.state.incluindoRelatorio
                        ? <ModalEditarRelatorio barragem={barragem} onClose={this.handleFecharModalEditarRelatorio} />
                        : ''}

                    {this.state.mensagem ?
                        <Alert variant="warning" onClose={this.handleFecharMensagem} dismissible>
                            <p>{this.state.mensagem}</p>
                        </Alert>
                        : ''
                    }

                    <SensoresList sensores={barragem.sensores} />
                </Card.Body>
            </Card>
        )
    }
}

export default Barragem;
