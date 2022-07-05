import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import House from './house';
import HouseDetail from './house-detail';
import HouseUpdate from './house-update';
import HouseDeleteDialog from './house-delete-dialog';

const Routes = ({ match }) => (
    <>
        <Switch>
            <ErrorBoundaryRoute exact path={`${match.url}/new`} component={HouseUpdate} />
            <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={HouseUpdate} />
            <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={HouseDetail} />
            <ErrorBoundaryRoute path={match.url} component={House} />
        </Switch>
        <ErrorBoundaryRoute exact path={`${match.url}/:id/delete`} component={HouseDeleteDialog} />
    </>
);

export default Routes;