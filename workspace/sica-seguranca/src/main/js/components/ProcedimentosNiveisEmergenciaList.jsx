import React from 'react';
import Col from 'react-bootstrap/Col';
import ListGroup from 'react-bootstrap/ListGroup';
import Row from 'react-bootstrap/Row';
import Tab from 'react-bootstrap/Tab';
import ProcedimentosList from './ProcedimentosList';

class ProcedimentosNiveisEmergenciaList extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            niveisEmergencia: props.niveisEmergencia
        };
    }

    static getDerivedStateFromProps(nextProps, prevState) {
        if (nextProps.niveisEmergencia.length !== prevState.niveisEmergencia.length) {
            return {
                niveisEmergencia: nextProps.niveisEmergencia
            };
        } else {
            return null;
        }
    }

    render() {
        const quantidadeNiveis = this.state.niveisEmergencia.length;

        return (
            <Tab.Container id="procedimentos-niveis-emergencia">
                <Row>
                    <Col sm={quantidadeNiveis}>
                        <ListGroup as="ul" horizontal>
                            {this.state.niveisEmergencia.map(nivelEmergencia =>
                                <ListGroup.Item as="li" key={nivelEmergencia.nivel} action href={"#nivel-" + nivelEmergencia.nivel} disabled={nivelEmergencia.procedimentos.length ? false : true}>
                                    {nivelEmergencia.nivel}
                                </ListGroup.Item>
                            )}
                        </ListGroup>
                    </Col>
                </Row>
                <Row>
                    <Col sm={12}>
                        <Tab.Content>
                            {this.state.niveisEmergencia.map(nivelEmergencia =>
                                <Tab.Pane key={nivelEmergencia.nivel} eventKey={"#nivel-" + nivelEmergencia.nivel}>
                                    <ProcedimentosList procedimentos={nivelEmergencia.procedimentos} />
                                </Tab.Pane>
                            )}
                        </Tab.Content>
                    </Col>
                </Row>
            </Tab.Container>
        );
    }
}

export default ProcedimentosNiveisEmergenciaList;