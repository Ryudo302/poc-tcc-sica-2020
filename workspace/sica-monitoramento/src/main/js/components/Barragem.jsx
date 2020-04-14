import React from 'react';
import Alert from 'react-bootstrap/Alert';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Modal from 'react-bootstrap/Modal';
import api from '../Client';
import SensoresList from './SensoresList';

class Barragem extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            barragem: {
                id: props.idBarragem,
                sensores: []
            },
            relatorioEstabilidade: { classificacao: {} },
            mensagem: null
        };

        this.buscarUltimoRelatorioEstabilidade = this.buscarUltimoRelatorioEstabilidade.bind(this);
        this.handleFecharModal = this.handleFecharModal.bind(this);
        this.handleFecharMensagem = this.handleFecharMensagem.bind(this);
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
                        mensagem: "Não há nenhum relatório cadastrado."
                    });
                }
            });
    }

    handleFecharModal() {
        this.setState({
            relatorioEstabilidade: { classificacao: {} }
        });
    };

    handleFecharMensagem() {
        this.setState({
            mensagem: null
        });
    }

    render() {
        const numberFormatter = new Intl.NumberFormat('pt-BR');
        const dateFormatter = new Intl.DateTimeFormat('pt-BR', {
            day: 'numeric', month: 'numeric', year: 'numeric'
        });

        let barragem = this.state.barragem;

        return (
            <>
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
                            <strong>Capacidade total:</strong> {numberFormatter.format(barragem.capacidadeTotal)} m³<br />
                            <strong>Volume atual:</strong> {numberFormatter.format(barragem.volume)} m³<br />
                            <strong>Altura maciço:</strong> {barragem.alturaMacico} m<br /><br />
                            <Button variant="secondary" size="sm" onClick={this.buscarUltimoRelatorioEstabilidade}><i className="fas fa-tasks"></i> Último Relatório de Estabilidade</Button>
                        </Card.Text>

                        {this.state.mensagem ?
                            <Alert variant="warning" onClose={this.handleFecharMensagem} dismissible>
                                <p>{this.state.mensagem}</p>
                            </Alert>
                            : ''
                        }

                        <SensoresList sensores={barragem.sensores} />
                    </Card.Body>
                </Card>

                <Modal show={this.state.relatorioEstabilidade.id > 0} onHide={this.handleFecharModal}>
                    <Modal.Header closeButton>
                        <Modal.Title>Relatório de estabilidade de barragem</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <p><strong>Dano Potencial Associado (DPA):</strong> {this.state.relatorioEstabilidade.danoPotencialAssociado}</p>
                        <p><strong>Categoria de Risco:</strong> {this.state.relatorioEstabilidade.categoriaRisco}</p>
                        <p>
                            <strong>Classificação:</strong> {this.state.relatorioEstabilidade.classificacao.codigo}<br />
                            <small>{this.state.relatorioEstabilidade.classificacao.descricao}</small>
                        </p>
                        <p><strong>Data da última inspeção:</strong> {dateFormatter.format(this.state.relatorioEstabilidade.dataUltimaInspecao)}</p>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button variant="primary" onClick={this.handleFecharModal}>
                            Fechar
                        </Button>
                    </Modal.Footer>
                </Modal>
            </>
        )
    }
}

export default Barragem;
