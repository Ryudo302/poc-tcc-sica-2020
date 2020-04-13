import React from 'react';

import {
    Chart,
    LineSeries,
    SplineSeries,
} from '@devexpress/dx-react-chart-bootstrap4';

import Card from 'react-bootstrap/Card';

import stompClient from '../websocketListener';

class Sensor extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            sensor: props.sensor,
            valorAtual: 0
        };

        this.atualizarDadosSensor = this.atualizarDadosSensor.bind(this);
    }

    componentDidMount() {
        stompClient([
            { destination: '/topic/sensor', callback: this.atualizarDadosSensor }
        ]);
    }

    atualizarDadosSensor(message) {
        let leitura = JSON.parse(message.body);
        // idHardwareSensor variacao dataHora

        if (this.state.sensor.idHardware === leitura.idHardwareSensor) {
            this.setState({
                valorAtual: this.state.valorAtual += leitura.variacao
            });
        }
    }

    render() {
        let sensor = this.state.sensor;
        return (
            <Card>
                <Card.Header>{sensor.tipo.descricao} ({sensor.idHardware})</Card.Header>
                <Card.Body>
                    {this.state.valorAtual}
                </Card.Body>
            </Card>
        );
    }
}

export default Sensor;
