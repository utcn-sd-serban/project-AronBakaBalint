import React from "react";
import model from "../model/model";

const StudentDetails = ({ subjects, onMarkStudent, marks }) => (
    <div>
        <span>{subjects.username}</span>
        <br/>
        <ul>
        {
            marks.map((mark, index) => (
                <div key={index}>
                {
                        mark
                }
                </div>
            ))
        }
        </ul>
        <br/>
        <input onChange={ e => {model.setMark(e.target.value)}}></input>
        <button onClick={() => {model.markStudent(); onMarkStudent()}}>Mark</button>
        <br/>
        <br/>
    </div>
);

export default StudentDetails;