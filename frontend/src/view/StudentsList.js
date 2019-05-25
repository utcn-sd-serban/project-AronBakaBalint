import React from "react";
import model from "../model/model";

const StudentList = ({ students, onCreateStudent, onViewDetails, onFilterByTitle, onFilterByTag }) => (
    <div>
        <h2>{ "Online Gradebook" }</h2>
        <br/>
        <input onChange={ e => model.setSearchWord(e.target.value) } />
        <button onClick={onFilterByTag}>Filter By Name</button>
        <hr/>
        <div className="col-md-12">
        <table className="table" border="1">
            <thead className="thead-dark">
                <tr>
                    <th>Student ID</th>
                    <th>Student Name</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                {
                    students.map((student, index) => (
                        <tr key={index}>
                            <td>{student.id}</td>
                            <td>{student.username}</td>
                            <td>
                                <button className="btn btn-secondary" onClick={() => onViewDetails(student.id)} >View Details</button>
                                <button className="btn btn-secondary" onClick={() => onViewDetails(student.id)} >Mark Student</button>
                                <button className="btn btn-secondary" onClick={() => onViewDetails(student.id)} >Dismiss</button>
                            </td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
        </div>
        <button className="btn btn-primary"  onClick={onCreateStudent}>Add new Student</button>
        <br/>
    </div>
);

export default StudentList;