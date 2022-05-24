import React, {Component} from "react";
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from "../../shared/AppNavbar";
import {Link} from "react-router-dom";


class ClientList extends Component {

    constructor(props) {
        super(props);
        this.state = {clients: []};
        this.remove = this.remove.bind(this);
    }

    async remove(id) {
        await fetch(`/api/clients/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedClients = [...this.state.clients].filter(i => i.id !== id);
            this.setState({clients: updatedClients});
        });
    }

    componentDidMount() {
        // Read the token from the session storage
       // and include it to Authorization header
        const token = sessionStorage.getItem("jwt");

        fetch('/api/clients', {
                headers: {'Authorization': token}
              })
            .then(response => response.json())
            .then(data => this.setState({clients:data}));
    }

    render() {
        const {clients, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const clientList = clients.map(client => {
            return <tr key={client.id}>
                <td style={{whiteSpace: 'nowrap'}}>{client.firstname}</td>
                <td>{client.lastname}</td>
                <td>
                    <ButtonGroup>
                        {/*<Button size="sm" color="primary" tag={Link} to={"/clients/" + client.id}>Edit</Button>*/}
                        <Button size="sm" color="primary" >Edit</Button>
                        {/*<Button size="sm" color="danger" onClick={() => this.remove(client.id)}>Delete</Button>*/}
                        <Button size="sm" color="danger" >Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        })

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/clients/new">Add Client</Button>
                        {/*<Button color="success" >Add Client</Button>*/}
                        <h3>Clients</h3>
                        <Table className="mt-4">
                            <thead>
                            <tr>
                                <th width="30%">First Name</th>
                                <th width="30%">Last Name</th>
                                <th width="40%">Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            {clientList}
                            </tbody>
                        </Table>
                    </div>
                </Container>

            </div>
        )
    }
}

export default ClientList;
