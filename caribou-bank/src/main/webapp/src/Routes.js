import {BrowserRouter, Route, Switch} from "react-router-dom";
import Login from "./modules/login/Login";
import PrivateRoute from "./shared/auth/PrivateRoute";
import React from "react";
import EntitiesRoutes from './entities/Routes';

const Routes = () => {

    return (
        <div>
            <BrowserRouter>
                {/*<Menu />*/}
                <Switch>
                    <Route path='/' exact component={Login}/>
                    <Route path="/login" exact component={Login}/>
                    {/*<Route path="/logout" exact component={Logout}/>*/}

                    {/*<PrivateRoute path="/" component={EntitiesRoutes} hasAnyAuthorities={[AUTHORITIES.USER]} />*/}
                    <PrivateRoute path="/" component={EntitiesRoutes}/>

                    {/*<PrivateRoute path='/clients' exact={true} component={ClientList}/>*/}
                    {/*<Route path='/clients/:id' component={ClientEdit}/>*/}
                </Switch>
            </BrowserRouter>
        </div>
    );
};

export default Routes;
