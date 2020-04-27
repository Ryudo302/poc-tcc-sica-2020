import React from 'react';
import Accordion from 'react-bootstrap/Accordion';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import api from '../Client';

class FiltrosConsulta extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            tiposAtivo: [],
            filtros: {}
        };

        this.mudarTipoAtivo = this.mudarTipoAtivo.bind(this);
    }

    componentDidMount() {
        api('/api/tipos-ativo', { method: 'GET' })
            .then(response => response.json())
            .then(tiposAtivo => {
                this.setState({ tiposAtivo: tiposAtivo });
            });
    }

    mudarTipoAtivo(event) {
        this.state.filtros.tipoAtivo = event.target.value;
        this.props.filtrosCallback(this.state.filtros);
    }

    render() {
        return (
            <Accordion style={{ flexWrap: 'wrap', justifyContent: 'center' }}>
                <Card>
                    <Card.Header>
                        <Accordion.Toggle as={Button} variant="link" eventKey="0">
                            Filtros
                        </Accordion.Toggle>
                    </Card.Header>
                    <Accordion.Collapse eventKey="0">
                        <Card.Body>
                            <Form.Group controlId="tipoAtivo">
                                <Form.Label>Tipo de ativo</Form.Label>
                                <Form.Control as="select" value={this.state.filtros.tipoAtivo} onChange={this.mudarTipoAtivo}>
                                    <option value="">Todos</option>
                                    {this.state.tiposAtivo.map(tipoAtivo => <option key={tipoAtivo.id} value={tipoAtivo.id}>{tipoAtivo.descricao}</option>)}
                                </Form.Control>
                            </Form.Group>
                        </Card.Body>
                    </Accordion.Collapse>
                </Card>
            </Accordion>
        );
    }
}

export default FiltrosConsulta;
