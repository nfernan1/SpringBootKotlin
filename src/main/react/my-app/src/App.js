import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Form from './component/Form.js'

class App extends Component {
    constructor(props) {
        super(props);
        this.createYelp = this.createYelp.bind(this);
        this.state = {
            fields: {}
        };
    }

    onSubmit = fields => {
        this.setState({fields});
    }

    createYelp(yelp) {
        fetch('/yelp', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(yelp)

        })
            .catch(err => console.error(err))

        console.log(JSON.stringify(yelp))
    }

    render() {
        return (
          <div className="App">
            <header className="App-header">
              <img src={logo} className="App-logo" alt="logo" />
              <h1 className="App-title">Welcome to React</h1>
            </header>
            <p className="App-intro">
              To get started, edit <code>src/App.js</code> and save to reload.
            </p>
              <Form createYelp={this.createYelp} />
                <p>{JSON.stringify(this.state.fields, null, 2)}</p>
          </div>
        );
    }
}

export default App;
