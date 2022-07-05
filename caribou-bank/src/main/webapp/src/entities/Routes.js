import {Route, Switch} from "react-router-dom";
import React from "react";
import Client from 'client/index.js'

export default ({ match }) => {

return (
    <div>
        <Switch>
            <Route path={`${match.url}client`} component={Client} />
        </Switch>
    </div>
);
};