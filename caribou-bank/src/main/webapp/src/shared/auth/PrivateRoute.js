import React, { Component } from 'react'
import { Route, Redirect } from 'react-router-dom'

class PrivateRoute extends Component {


    render() {

        // const USERNAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser';

        function isUserLoggedIn() {
            //let user = sessionStorage.getItem(USERNAME_SESSION_ATTRIBUTE_NAME)
           // if(user === null) return false
            return true
        }

        if(isUserLoggedIn()) {
            return <Route {...this.props} />
        } else {
            return <Redirect to="/login" />
        }
    }
}

export default PrivateRoute