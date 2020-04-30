import React from 'react';
import Container from 'react-bootstrap/Container';

class TratamentoErro extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            error: null,
            errorInfo: null
        };
    }

    componentDidCatch(error, errorInfo) {
        this.setState({
            error: error,
            errorInfo: errorInfo
        });
    }

    render() {
        if (this.state.errorInfo) {
            return (
                <Container className="text-light mt-4">
                    <h2>Algo deu errado.</h2>
                    <details style={{ whiteSpace: 'pre-wrap' }}>
                        {this.state.error && this.state.error.toString()}
                        <br />
                        {this.state.errorInfo.componentStack}
                    </details>
                </Container>
            );
        } else {
            return this.props.children;
        }
    }
}

export default TratamentoErro;