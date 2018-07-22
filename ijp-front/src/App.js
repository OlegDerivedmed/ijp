import React, { Component } from 'react';
import './App.css';
import Authorization from './components/Authorization/Authorization';

class App extends Component {
    render() {
        return (
            <div className="App">
                <Authorization />
            </div>
        );
    }
}

export default App;
