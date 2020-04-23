import React, { Component } from 'react';
import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import Tabs from 'react-bootstrap/Tabs';
import Tab from 'react-bootstrap/Tab';
import '../Stylesheets/LoginPage.css';
import LoginForm from './LoginForm';
import RegisterForm from './RegisterForm';
import { Redirect } from 'react-router-dom';
import Cookies from 'js-cookie';
import {CheckCredentials} from '../Utilities/Auth';

function GenericHeader(props) {
    return (
        <Navbar bg="dark" variant="dark">
            <Navbar.Brand >SimpleApply</Navbar.Brand>
        </Navbar>
    );
}

class LoginPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            redirectToHome: false,
            email: '', 
            password: '',
            userType: 'Job Seeker',
            invalidEmail: false,
            invalidPassword: false
        }
    }

    updateUserTypeState(event) {
        this.setState({userType: event.target.value}); 
    }

    updateEmailState(event) {
        this.setState({email: event.target.value});   
    };

    updatePasswordState(event) {
        this.setState({password: event.target.value});     
    };

    handleLogin() {
        CheckCredentials(this.state.email, this.state.password)
        .then(
            (data) => {
                console.log('token is ' + data.token);
                if (data.token !== null) {
                    Cookies.set('token', data.token);
                    this.setState(() => ({
                        redirectToHome: true
                    }));
                    console.log(this.state.redirectToHome);
                }
                else if (data.message === 'Invalid email') {
                    this.setState(() => ({
                        invalidEmail: true, 
                        invalidPassword: false
                    }));
                }
                else if (data.message === 'Invalid password') {
                    this.setState(() => ({
                        invalidEmail: false, 
                        invalidPassword: true
                    }));
                }
            }
        );
    }

    render() {
        if (this.state.redirectToHome === true) {
            return <Redirect to="/"/>
        }
        return (
            <div>
                <GenericHeader className="login-header"/>
                <Tabs defaultActiveKey="login" id="uncontrolled-tab-example">
                    <Tab eventKey="login" title="Login">
                        <Container className="login-page-form-container">
                            <LoginForm
                                handleLogin={this.handleLogin.bind(this)} 
                                updateEmailState={this.updateEmailState.bind(this)}
                                updatePasswordState={this.updatePasswordState.bind(this)}
                                updateUserTypeState={this.updateUserTypeState.bind(this)}
                                email={this.state.email} 
                                password={this.state.password} 
                                userType={this.state.userType} 
                                invalidEmail={this.state.invalidEmail} 
                                invalidPassword={this.state.invalidPassword}
                            />
                        </Container>
                    </Tab>
                    <Tab eventKey="register" title="Register">
                        <Container className="login-page-form-container">
                            <RegisterForm

                            />
                        </Container>
                    </Tab>
                </Tabs>
            </div>
        );
    }
}

export default LoginPage;