import React from "react";

const StudentDetails = ({ subjects }) => (
    <div>
        <span>{ subjects.marks }</span>
        <br/>
        <input onChange={ e => {}} id="inputField"></input>
        <button onClick={() => {}}>Mark</button>
        <br/>
        <br/>
    </div>
);

export default StudentDetails;