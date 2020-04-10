'use strict'

import React from 'react';
import api from './client';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';
import '../resources/static/css/App.css';

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            ativos: []
        };
    }

    componentDidMount() {
        api('/api/ativos', { method: 'GET' })
            .then(response => response.json())
            .then(ativos => {
                ativos.forEach(ativo => {
                    ativo.urlImagem = '/api/ativos/' + ativo.id + '/imagem';
                });

                this.setState({ ativos: ativos });
            })
    }

    render() {
        return (
            <Container>
            	<Button />
                <AtivosList ativos={this.state.ativos} />
            </Container>
        )
    }
}

class AtivosList extends React.Component {

    render() {
        const ativos = this.props.ativos.map(ativo =>
            <Ativo key={ativo.id} ativo={ativo} />
        );
        return (
            <table>
                <tbody>
                    <tr>
                        <th>Imagem</th>
                        <th>Descrição</th>
                        <th>Tipo</th>
                    </tr>
                    {ativos}
                </tbody>
            </table>
        )
    }
}

class Ativo extends React.Component {

    render() {
        return (
            <tr>
                <td><img src={this.props.ativo.urlImagem} width={100} /></td>
                <td>{this.props.ativo.descricao}</td>
                <td>{this.props.ativo.tipo.descricao}</td>
            </tr>
        )
    }
}

export default App;
