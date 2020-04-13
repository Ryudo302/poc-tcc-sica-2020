import React from 'react';
import CardColumns from 'react-bootstrap/CardColumns';
import Sensor from './Sensor';

class SensoresList extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            sensores: props.sensores
        };
    }

    static getDerivedStateFromProps(nextProps, prevState) {
        if (nextProps.sensores.length !== prevState.sensores.length) {
            return {
                sensores: nextProps.sensores
            };
        } else {
            return null;
        }
    }

    render() {
        return (
            <CardColumns>
                {this.state.sensores.map(sensor =>
                    <Sensor key={sensor.id} sensor={sensor} />
                )}
            </CardColumns>
        );
    }
}

export default SensoresList;
