import React, { Component } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import '../Stylesheets/LoginPage.css';

class RegisterForm extends Component {
    render() {
        let nonmatchingPasswords = null;
        if (this.props.registerConfirmPassword !== '' && this.props.registerPassword !== this.props.registerConfirmPassword) {
            nonmatchingPasswords = <Form.Text className="help-msg">Passwords do not match</Form.Text>
        }

        return (
            <Row className="justify-content-lg-center">
                <Col md></Col>
                <Col md>
                    <Form className="register-form">
                        <Form.Group controlId="formBasicEmail">
                            <Form.Label>Email address</Form.Label>
                            <Form.Control type="email" value={this.props.registerEmail} onChange={this.props.updateRegisterEmailState} />
                        </Form.Group>

                        <Form.Group controlId="formPlainTextName">
                            <Form.Label>First name</Form.Label>
                            <Form.Control type="name" value={this.props.registerFirstName} onChange={this.props.updateRegisterFirstNameState} />
                        </Form.Group>

                        <Form.Group controlId="formPlainTextName">
                            <Form.Label>Last name</Form.Label>
                            <Form.Control type="name" value={this.props.registerLastName} onChange={this.props.updateRegisterLastNameState} />
                        </Form.Group>

                        <Form.Group controlId="formPlainTextName">
                            <Form.Label>Date of birth</Form.Label>
                            <Form.Control type="date" value={this.props.registerDOB} onChange={this.props.updateRegisterDOBState} />
                        </Form.Group>
    
                        <Form.Group controlId="formBasicPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" value={this.props.registerPassword} onChange={this.props.updateRegisterPasswordState}/>
                        </Form.Group>
                        
                        <Form.Group controlId="formBasicPassword">
                            <Form.Label>Confirm Password</Form.Label>
                            <Form.Control type="password" value={this.props.registerConfirmPassword} onChange={this.props.updateRegisterConfirmPasswordState}/>
                            {nonmatchingPasswords}
                        </Form.Group>
    
                        <Button variant="primary">Register</Button>
                    </Form>
                </Col>
                <Col md></Col>
            </Row> 
        );
    }
}

export default RegisterForm;