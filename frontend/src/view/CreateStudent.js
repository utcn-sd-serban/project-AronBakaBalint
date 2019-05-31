import React from "react";

const CreateStudent = ({ onCreate, onChange }) => (
    <div className="container">
        <h2>Add Person</h2>
            <div className="form-group">
                <label>Name: </label>
                <input 
                    onChange={ e => onChange("name", e.target.value) } />
            </div>
            <div className="form-group">
                <label>Passw: </label>
                <input 
                    onChange={ e => onChange("password", e.target.value) } />
            </div>
            <div className="form-group">
                <label>Role: </label>
                <input 
                    onChange={ e => onChange("role", e.target.value) } />
            </div>
            <button className="btn btn-secondary" onClick={onCreate}>Add</button>
    </div>
);

export default CreateStudent;