import React from 'react';
import Card from 'react-bootstrap/Card';

class Ativo extends React.Component {

    render() {
        const dateFormatter = new Intl.DateTimeFormat('pt-BR', {
            day: 'numeric', month: 'numeric', year: 'numeric'
        });

        const dateTimeFormatter = new Intl.DateTimeFormat('pt-BR', {
            day: 'numeric', month: 'numeric', year: 'numeric',
            hour: 'numeric', minute: 'numeric', second: 'numeric',
            timeZone: 'America/Sao_Paulo'
        });

        return (
            <Card border="light" style={{ width: '14rem', height: '100%' }}>
                <Card.Img variant="top" src={this.props.ativo.urlImagem} />
                <Card.Body style={{ flex: '0 0 auto', marginTop: 'auto' }}>
                    <Card.Title>{this.props.ativo.tipo.descricao}</Card.Title>
                    <Card.Text>
                        {this.props.ativo.descricao}
                    </Card.Text>
                </Card.Body>
                <Card.Footer>
                    Aquisição: {dateFormatter.format(new Date(this.props.ativo.dataAquisicao))}<br />
                    Manutenções:<br />
                    <i className="fas fa-step-backward" title="Última"></i> {this.props.ativo.dataUltimaManutencao ? dateTimeFormatter.format(new Date(this.props.ativo.dataUltimaManutencao)) : "-"}<br />
                    <i className="fas fa-step-forward" title="Próxima"></i> {this.props.ativo.dataProximaManutencao ? dateTimeFormatter.format(new Date(this.props.ativo.dataProximaManutencao)) : "-"}
                </Card.Footer>
            </Card>
        )
    }
}

export default Ativo;
