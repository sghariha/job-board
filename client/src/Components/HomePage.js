import React, { Component } from 'react';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import Form from 'react-bootstrap/Form';
import FormControl from 'react-bootstrap/FormControl';
import Button from 'react-bootstrap/Button';
import Cookies from 'js-cookie';
import { Redirect } from 'react-router-dom';

function AuthenticatedHeader(props) {
    return (
        <Navbar bg="dark" variant="dark">
            <Navbar.Brand>SimpleApply</Navbar.Brand>
            <Nav className="mr-auto">
                <Nav.Link>Home</Nav.Link>
                <Nav.Link>Resume</Nav.Link>
                <Nav.Link>Companies</Nav.Link>
            </Nav>
            <Form inline>
                <Button variant="outline-info" onClick={props.handleLogout}>Logout</Button>
            </Form>
        </Navbar>
    );
}

class HomePage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            redirectToLogin: false
        }
    }

    handleLogout() {
        Cookies.remove('token');
        this.setState({
            redirectToLogin: true
        });
    }

    render() {
        if (this.state.redirectToLogin === true) {
            return <Redirect to="/login"/>;
        }

        return (
            <div>
                <AuthenticatedHeader handleLogout={this.handleLogout.bind(this)}/>
            </div>
        );
    }
}

export default HomePage;