import React from 'react';

import Ativo from './Ativo';

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

export default AtivosList;
