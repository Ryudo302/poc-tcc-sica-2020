import React from 'react';
import { BrowserRouter as Router } from 'react-router-dom';
import '../resources/static/css/App.css';
import PortalApp from './components/PortalApp';

class App extends React.Component {

    render() {
        return (
            <Router>
                <PortalApp />
            </Router>
        );
      }
}

export default App;