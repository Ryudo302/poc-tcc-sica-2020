import React from 'react';

class ProcedimentosList extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            procedimentos: props.procedimentos
        }
    }

    static getDerivedStateFromProps(nextProps, prevState) {
        if (nextProps.procedimentos.length !== prevState.procedimentos.length) {
            return {
                procedimentos: nextProps.procedimentos
            };
        } else {
            return null;
        }
    }

    render() {
        return (
            <>
                {this.state.procedimentos.length ?
                    <ul>
                        {this.state.procedimentos.map(procedimento =>
                            <li key={procedimento.id}>{procedimento.nome + (procedimento.descricao ? " : " + procedimento.descricao : "")}</li>
                        )}
                    </ul>
                    : <em>Nenhum</em>}
            </>
        );
    }
}

export default ProcedimentosList;
