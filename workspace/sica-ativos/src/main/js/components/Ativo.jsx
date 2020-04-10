import React from 'react';

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

export default Ativo;
