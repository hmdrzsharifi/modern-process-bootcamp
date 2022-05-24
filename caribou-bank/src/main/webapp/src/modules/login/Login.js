import React, {useState} from 'react';
import {SERVER_URL} from "../../config/constants";
import {Button, Form, FormGroup, Input, Label} from 'reactstrap';
import {toast} from 'react-toastify';
import Home from "../home/Home";

const Login = () => {
    const [user, setUser] = useState({username: '', password: ''})
    const [isAuthenticated, setIsAuthenticated] = useState(false);

    const handleChange = (event) => {
        setUser({...user, [event.target.name]: event.target.value})
    }

    const login = () => {
        fetch(SERVER_URL + 'login', {
            method: 'POST',
            body: JSON.stringify(user)
        })
            .then(res => {
                const jwtToken = res.headers.get('Authorization');
                if (jwtToken !== null) {
                    sessionStorage.setItem("jwt", jwtToken);
                    setIsAuthenticated(true);
                } else {
                    toast.warn("Check your username and password", {
                        position: toast.POSITION.BOTTOM_LEFT
                    })
                }
            })
            .catch(err => console.error(err))
    }

    //If authenticated, display Homepage & logout button
    if (isAuthenticated === true) {
        return (<Home isAuthenticated={true} />)
    } else {
        // if not authenticated, display login form
        return (
            <div className="Login">
                <h2>Sign In</h2>
                <Form className="form">
                    <FormGroup>
                        <Label for="exampleEmail">Username</Label>
                        <Input
                            type="text"
                            name="username"
                            id="username"
                            onChange={handleChange}
                        />
                    </FormGroup>
                    <FormGroup>
                        <Label for="examplePassword">Password</Label>
                        <Input
                            type="password"
                            name="password"
                            id="examplePassword"
                            placeholder="********"
                            onChange={handleChange}
                        />
                    </FormGroup>
                    <Button color="primary" onClick={login}>Submit</Button>
                </Form>
            </div>



            // <Form onSubmit={login}>
            //     <div className="mb-3">
            //         <Label for="username">Username</Label>
            //         <Input type="text" name="username" id="username"  className="form-control"
            //                onChange={handleChange}/>
            //     </div>
            //     <div className="mb-3">
            //         <Label for="password">Password</Label>
            //         <Input type="password" name="password" id="password"  className="form-control"
            //                onChange={handleChange}/>
            //     </div>
            //     <div className="d-grid">
            //         <Button variant="outlined" color="primary"
            //                 type="submit">
            //             Login
            //         </Button>
            // </div>
            // </Form>
        );
    }
}

export default Login;