import React from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import api from '../Client';

class ModalEditarRelatorio extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            editando: true
        };

        this.handleFecharModal = this.handleFecharModal.bind(this);
        this.salvarRelatorio = this.salvarRelatorio.bind(this);
    }

    handleFecharModal() {
        this.setState({
            editando: false
        });
        this.props.onClose && this.props.onClose();
    }

    salvarRelatorio(event) {
        event.preventDefault();
        event.stopPropagation();

        let form = event.target;

        let relatorio = {
            barragem: { id: this.props.barragem.id },
            danoPotencialAssociado: form.elements.danoPotencialAssociado.value,
            categoriaRisco: form.elements.categoriaRisco.value,
            classificacao: { codigo: form.elements.classificacao.value },
            dataUltimaInspecao: form.elements.dataUltimaInspecao.value
        };

        console.log("Salvando relatório:", relatorio);

        api('/api/relatorios-estabilidade', {
            method: 'POST',
            body: JSON.stringify(relatorio),
            headers: {
            	'Content-Type': 'application/json;charset=UTF-8'
            }
        }).then(() => {
            this.handleFecharModal();
        });
    }

    render() {
        return (
            <Modal show={this.state.editando} onHide={this.handleFecharModal}>
                <Modal.Header closeButton>
                    <Modal.Title>Relatório de estabilidade de barragem</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form onSubmit={this.salvarRelatorio} noValidate>
                        <Form.Group controlId="danoPotencialAssociado">
                            <Form.Label>Dano Potencial Associado (DPA)</Form.Label>
                            <Form.Control required as="select" custom>
                                <option>BAIXO</option>
                                <option>MEDIO</option>
                                <option>ALTO</option>
                            </Form.Control>
                        </Form.Group>

                        <Form.Group controlId="categoriaRisco">
                            <Form.Label>Categoria de Risco</Form.Label>
                            <Form.Control required as="select" custom>
                                <option>BAIXO</option>
                                <option>MEDIO</option>
                                <option>ALTO</option>
                            </Form.Control>
                        </Form.Group>

                        <Form.Group controlId="classificacao">
                            <Form.Label>Classificação</Form.Label>
                            <Form.Control required as="select" custom>
                                <option>C</option>
                                <option>B</option>
                                <option>A</option>
                            </Form.Control>
                        </Form.Group>

                        <Form.Group controlId="dataUltimaInspecao">
                            <Form.Label>Data da última inspeção</Form.Label>
                            <Form.Control required type="date" placeholder="dd/MM/yyyy" />
                        </Form.Group>

                        <Button variant="primary" type="submit">
                            Submit
                        </Button>
                    </Form>
                </Modal.Body>
            </Modal>
        );
    }
}

export default ModalEditarRelatorio;