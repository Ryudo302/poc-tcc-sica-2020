import React from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';

class ModalVisualizarRelatorio extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            relatorioEstabilidade: props.relatorio
        };

        this.handleFecharModal = this.handleFecharModal.bind(this);
    }

    handleFecharModal() {
        this.setState({
            relatorioEstabilidade: null
        });
        this.props.onClose && this.props.onClose();
    };

    render() {
        const dateFormatter = new Intl.DateTimeFormat('pt-BR', {
            day: 'numeric', month: 'numeric', year: 'numeric'
        });

        return (
            <Modal show={this.state.relatorioEstabilidade != null} onHide={this.handleFecharModal}>
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
                    <p><strong>Data da última inspeção:</strong> {dateFormatter.format(new Date(this.state.relatorioEstabilidade.dataUltimaInspecao))}</p>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="primary" onClick={this.handleFecharModal}>
                        Fechar
                        </Button>
                </Modal.Footer>
            </Modal>
        );
    }
}

export default ModalVisualizarRelatorio;
