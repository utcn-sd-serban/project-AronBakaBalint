import React from "react";
import model from "../model/model"

const AddParent = ({onAddParent}) => (
    <div className="container">
        <h2>Add Parent</h2>
            <div className="form-group">
                <label>Parent Name: </label>
                <input 
                    onChange={ e => model.setParent(e.target.value) } />
            </div>
            <button className="btn btn-secondary" onClick={onAddParent}>Add</button>
    </div>
);

export default AddParent;