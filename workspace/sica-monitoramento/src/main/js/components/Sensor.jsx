import React from 'react';

import {
    ArgumentAxis,
    ValueAxis,
    Chart,
    SplineSeries,
    Title
} from '@devexpress/dx-react-chart-bootstrap4';

import Card from 'react-bootstrap/Card';

import stompClient from '../websocketListener';

class Sensor extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            sensor: props.sensor,
            valorAtual: 0,
            dataHoraUltimaAtualizacao: null,
            dadosGrafico: [ ]
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

        if (this.state.sensor.idHardware === leitura.idHardwareSensor) {
            let novoValor = this.state.valorAtual += leitura.variacao;

            let dadosGrafico = this.state.dadosGrafico;
            dadosGrafico = dadosGrafico.concat({ value: novoValor, argument: dadosGrafico.length + 1 });

            this.setState({
                valorAtual: novoValor,
                dataHoraUltimaAtualizacao: leitura.dataHora,
                dadosGrafico: dadosGrafico,
            });
        }
    }

    render() {
        const dateTimeFormatter = new Intl.DateTimeFormat('pt-BR', {
            day: 'numeric', month: 'numeric', year: 'numeric',
            hour: 'numeric', minute: 'numeric', second: 'numeric',
            timeZone: 'America/Sao_Paulo'
        });
        const numberFormat = new Intl.NumberFormat('pt-BR', { maximumSignificantDigits: 2 });
        
        let sensor = this.state.sensor;

        return (
            <Card>
                <Card.Header>{sensor.tipo.descricao} (<code>{sensor.idHardware}</code>)</Card.Header>
                <Card.Body>
                    <Chart data={this.state.dadosGrafico}>
                        <ArgumentAxis showGrid />
                        <ValueAxis />
                        <SplineSeries valueField="value" argumentField="argument" />
                        <Title text={"Leitura atual: " + (this.state.valorAtual ? numberFormat.format(this.state.valorAtual) : "0.0")} />
                    </Chart>
                </Card.Body>
                <Card.Footer className="text-muted text-center">Última atualização:<br />
                    {this.state.dataHoraUltimaAtualizacao
                        ? dateTimeFormatter.format(new Date(this.state.dataHoraUltimaAtualizacao))
                        : '-'}
                </Card.Footer>
            </Card>
        );
    }
}

export default Sensor;
