import React from "react";

const CreateStudent = ({ name, grade, onCreate, onChange }) => (
    <div className="container">
        <h2>Add Student</h2>
            <div className="form-group">
                <label>Name: </label>
                <input value={name} 
                    onChange={ e => onChange("name", e.target.value) } />
            </div>
            <div className="form-group">
                <label>Grade: </label>
                <input value={grade} 
                    onChange={ e => onChange("grade", e.target.value) } />
            </div>
            <button className="btn btn-secondary" onClick={onCreate}>Add</button>
    </div>
);

export default CreateStudent;