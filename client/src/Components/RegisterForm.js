import React, { Component } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import '../Stylesheets/LoginPage.css';

class RegisterForm extends Component {
    render() {
        var email = this.props.registerEmail;
        let emailHint = null;
        if (email !== null && email !== "" && (!email.includes("@") || !email.includes("."))) {
            emailHint = <Form.Text className="help-msg">Please enter a valid email</Form.Text>;
        }

        let nonmatchingPasswords = null;
        if (this.props.registerConfirmPassword !== '' && this.props.registerPassword !== this.props.registerConfirmPassword) {
            nonmatchingPasswords = <Form.Text className="help-msg">Passwords do not match</Form.Text>
        }

        let userAlreadyExists = null;
        if (this.props.invalidRegisterEmail === true) {
            userAlreadyExists = <Form.Text className="help-msg">User with this email already exists</Form.Text>
        }

        return (
            <Row className="justify-content-lg-center">
                <Col md></Col>
                <Col md>
                    <Form className="register-form">
                        {userAlreadyExists}
                        <Form.Group>
                            <Form.Label>Email address</Form.Label>
                            <Form.Control type="email" value={this.props.registerEmail} onChange={this.props.updateRegisterEmailState} />
                            {emailHint}
                        </Form.Group>

                        <Form.Group>
                            <Form.Label>First name</Form.Label>
                            <Form.Control type="name" value={this.props.registerFirstName} onChange={this.props.updateRegisterFirstNameState} />
                        </Form.Group>

                        <Form.Group>
                            <Form.Label>Last name</Form.Label>
                            <Form.Control type="name" value={this.props.registerLastName} onChange={this.props.updateRegisterLastNameState} />
                        </Form.Group>

                        <Form.Group>
                            <Form.Label>Date of birth</Form.Label>
                            <Form.Control type="date" value={this.props.registerDOB} onChange={this.props.updateRegisterDOBState} />
                        </Form.Group>
    
                        <Form.Group>
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" value={this.props.registerPassword} onChange={this.props.updateRegisterPasswordState}/>
                        </Form.Group>
                        
                        <Form.Group>
                            <Form.Label>Confirm Password</Form.Label>
                            <Form.Control type="password" value={this.props.registerConfirmPassword} onChange={this.props.updateRegisterConfirmPasswordState}/>
                            {nonmatchingPasswords}
                        </Form.Group>
    
                        <Button variant="outline-info" onClick={this.props.handleRegister}>Register</Button>
                    </Form>
                </Col>
                <Col md></Col>
            </Row> 
        );
    }
}

export default RegisterForm;