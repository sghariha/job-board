import React, { Component } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import '../Stylesheets/LoginPage.css';

class LoginForm extends Component {

    render() {
        var email = this.props.email;
        let emailHint = null;
        if (email !== null && email !== "" && (!email.includes("@") || !email.includes("."))) {
            emailHint = <Form.Text className="help-msg">Please enter a valid email</Form.Text>;
        }

        let invalidCredentials = null;
        if (this.props.invalidEmail) {
            invalidCredentials = <Form.Text className="help-msg">Email address not recognized</Form.Text>;
        }
        else if (this.props.invalidPassword) {
            invalidCredentials = <Form.Text className="help-msg">Incorrect password</Form.Text>;
        }

        return (
        <Row className="justify-content-lg-center">
            <Col md></Col>
            <Col md>
                <Form className="login-form">
                    {invalidCredentials}
                    <Form.Group controlId="formBasicEmail">
                        <Form.Label>Email address</Form.Label>
                        <Form.Control type="email" value={this.props.email} onChange={this.props.updateEmailState} />
                        {emailHint}
                    </Form.Group>

                    <Form.Group controlId="formBasicPassword">
                        <Form.Label>Password</Form.Label>
                        <Form.Control type="password" value={this.props.password} onChange={this.props.updatePasswordState}/>
                    </Form.Group>

                    <Form.Group controlId="formGridState">
                        <Form.Label>User Type</Form.Label>
                        <Form.Control as="select" value={this.props.userType} onChange={this.props.updateUserTypeState}>
                            <option>Job Seeker</option>
                            <option>Job Poster</option>
                        </Form.Control>
                    </Form.Group>

                    <Button variant="outline-info" onClick={this.props.handleLogin}>Login</Button>
                </Form>
            </Col>
            <Col md></Col>
        </Row> 
        );
    }
}

export default LoginForm;