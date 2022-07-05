import './App.css';
import React, {Component} from 'react';
import AppRoutes from './Routes';
import ClientList from "./entities/client/ClientList";
import {BrowserRouter, Route, Switch} from "react-router-dom";
import Login from "./modules/login/Login";
import AuthenticatedRoute from "./shared/auth/PrivateRoute";
import ClientEdit from "./entities/client/ClientEdit";

class App extends Component {

    /* state = {
         clients: []
     };*/

    /*  async componentDidMount() {
          const response = await fetch('/api/clients');
          const body = await response.json();
          this.setState({clients:body});
      }
  */
    render() {
        // const {clients} = this.state;
        return (
            <div className="App">
                <div className="container">
                    <AppRoutes />
                </div>
            </div>
        );
    }
}

export default App;
