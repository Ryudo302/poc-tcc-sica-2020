const React = require('react');
const ReactDOM = require('react-dom');
const api = require('./client');

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
                    api('/api/ativos/' + ativo.id + '/imagem', { method: 'GET', headers: { Accept: 'image/jpeg' } })
                        .then(imagem => ativo.imagem = imagem);
                });

                this.setState({ ativos: ativos });
            })
    }

    render() {
        return (
            <AtivosList ativos={this.state.ativos} />
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
                <td>{this.props.ativo.imagem}</td>
                <td>{this.props.ativo.descricao}</td>
                <td>{this.props.ativo.tipo.descricao}</td>
            </tr>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
)
