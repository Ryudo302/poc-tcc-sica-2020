import React from 'react';
import Spinner from 'react-bootstrap/Spinner';
import Iframe from 'react-iframe';
import { Redirect } from 'react-router-dom';

class Modulo extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            carregando: true,
            modulo: props.modulo || {}
        };

        this.onLoadHandler = this.onLoadHandler.bind(this);
        this.iframe = React.createRef();
    }

    componentDidMount() {
        this.iframe.current && (this.iframe.current.onload = this.onLoadHandler);
    }

    componentDidUpdate() {
        this.iframe.current && (this.iframe.current.onload = this.onLoadHandler);
    }

    onLoadHandler(event) {
        this.setState({
            carregando: false
        });
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
        if (this.state.modulo.id) {
            return (
                <>
                    {this.state.carregando && <Spinner animation="border" variant="primary" className="carregando" />}
                    <iframe src={this.state.modulo.url}
                        width="100%"
                        height="100%"
                        id="modulo"
                        className="full-window"
                        display="initial"
                        position="relative"
                        ref={this.iframe} />
                </>
            );
        } else {
            return <Redirect to="/login" />
        }
    }
}

export default Modulo;