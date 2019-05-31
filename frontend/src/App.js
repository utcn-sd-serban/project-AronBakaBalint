import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import { HashRouter, Switch, Route } from "react-router-dom";
import SmartStudentsList from './view/SmartStudentsList';
import SmartCreateStudent from './view/SmartCreateStudent';
import SmartStudentDetails from './view/SmartStudentDetails';
import SmartFilterResult from './view/SmartFilterResult';
import SmartLogin from './view/SmartLogin';
import SmartAddParent from './view/SmartAddParent'

const App = () => (
  <div className="App">
    <HashRouter>
      <Switch>
        <Route exact={true} component={SmartLogin} path="/" />
        <Route exact={true} component={SmartStudentsList} path="/student-list" />
        <Route exact={true} component={SmartCreateStudent} path="/create-student" />
        <Route exact={true} component={SmartStudentDetails} path="/student-details/:index" />
        <Route exact={true} component={SmartFilterResult} path="/filter-result" />
        <Route exact={true} component={SmartAddParent} path="/add-parent" />
      </Switch>
    </HashRouter>
  </div>
);


export default App;