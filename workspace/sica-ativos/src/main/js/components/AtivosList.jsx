import React from 'react';
import ListGroup from 'react-bootstrap/ListGroup';

import Ativo from './Ativo';

class AtivosList extends React.Component {

    render() {
        return (
            <div>
                <ListGroup horizontal style={{ flexWrap: 'wrap', justifyContent: 'center' }}>
                    {this.props.ativos.map(ativo =>
                        <ListGroup.Item key={ativo.id}>
                            <Ativo ativo={ativo} />
                        </ListGroup.Item>
                    )}
                </ListGroup>
            </div>
        )
    }
}

export default AtivosList;
