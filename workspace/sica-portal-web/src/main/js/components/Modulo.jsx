import React from 'react';
import Iframe from 'react-iframe';

class Modulo extends React.Component {

    constructor(props) {
        super(props);
        
        this.state = {
            modulo: props.modulo || {}
        };
    }

    static getDerivedStateFromProps(nextProps, prevState) {
        if (nextProps.modulo && !prevState.modulo || nextProps.modulo && nextProps.modulo.id !== prevState.modulo.id) {
            return {
                modulo: nextProps.modulo
            };
        } else {
            return null;
        }
    }

    render() {
        return (
            <Iframe url={this.state.modulo.url}
                width="100%"
                height="100%"
                id="modulo"
                className="full-window"
                display="initial"
                position="relative" />
        );
    }
}

export default Modulo;