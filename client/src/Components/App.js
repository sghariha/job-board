import React from 'react';
import '../Stylesheets/App.css';
import LoginPage from './LoginPage';
import HomePage from './HomePage';
import {CheckAuth} from '../Utilities/Auth';
import {BrowserRouter as Router, Switch, Route, Redirect} from 'react-router-dom';

const PrivateRoute = ({component: Component, ...args}) => (
  <Route {...args} render={ (props) => (
    CheckAuth() === true ? <Component {...props} /> : 
    <Redirect to={{
      pathname: '/login',
      state: { from: props.location }
    }} />
  )} />
);

const LoginRoute = ({component: Component, ...args}) => (
  <Route {...args} render={ (props) => (
    CheckAuth() === false ? <Component {...props} /> : 
    <Redirect to={{
      pathname: '/',
      state: { from: props.location }
    }} />
  )} />
);

function App() {
  return (
    <Router>
      <Switch>
        <LoginRoute path="/login" component={LoginPage} />
        <PrivateRoute path="/" component={HomePage} />
      </Switch>
    </Router>
  );
}

export default App;
