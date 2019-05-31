import React from "react";
import model from "../model/model";

 const  Login = ({ onLogin }) => (
    <div className="container">
        <h2>Online Gradebook</h2>
        <br/>
            <div className="form-group" onChange={ e => model.setUser(e.target.value)}>
                <label>Username: </label>
                <input/>
            </div>
            <div className="form-group" onChange={ e => model.setPassword(e.target.value)}>
                <label>Password: </label>
                <input/>
            </div>
            <button className="btn btn-primary" onClick={onLogin}>Login</button>
    </div>
);

export default Login;