import React from "react";
import model from "../model/model";

const StudentDetails = ({ subjects, onMarkStudent, subjectList, marks, averages }) => (
    <div>
        <span>{subjects.username}</span>
        <br/>
        <hr/>
        <input onChange={ e => {model.setMark(e.target.value)}}></input>
        <button onClick={() => {model.markStudent(); onMarkStudent()}}>Mark</button>
        <br/>
        <br/>
        
        <div className="col-md-12">
        <table className="table" border="1">
            <thead className="thead-dark">
                <tr>
                    <th>Subject</th>
                    <th>Marks</th>
                    <th>Average</th>
                </tr>
            </thead>
            <tbody>
                {
                    subjectList.map((subject,index) => (
                        <tr>
                        <td>{subject}</td>
                        <td>{marks[index]}</td>
                        <td>{averages[index]}</td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
        </div>
        <br/>
        
    </div>
);

export default StudentDetails;