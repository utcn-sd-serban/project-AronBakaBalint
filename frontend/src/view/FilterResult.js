import React from "react";
import model from "../model/model";

const StudentList = ({ students, onCreateStudent, onViewDetails, onFilter, onDismissStudent, onAddParent }) => (
    <div>
        <h2>{ "Online Gradebook" }</h2>
        <br/>
        <input onChange={ e => model.setSearchWord(e.target.value) } />
        <button onClick={onFilter}>Filter By Name</button>
        {
            model.getUserType() !== "student" && model.getUserType() !== "parent" ? <button onClick={onCreateStudent}>Add new Person</button>
            : <div/>
        }
        
        <hr/>
        <div className="col-md-12">
        <table className="table" border="1">
            <thead className="thead-dark">
                <tr>
                    <th>Person ID</th>
                    <th>Person Name</th>
                    <th>Role</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                {
                    students.map((student, index) => (
                        <tr key={index}>
                            <td>{student.id}</td>
                            <td>{student.username}</td>
                            <td>{student.role}</td>
                            <td>
                                {
                                    model.getUserType() === "principal" ? <button className="btn btn-secondary" onClick={() => onDismissStudent(student.id)} >Dismiss</button>
                                    : <div/>
                                }
                                <button className="btn btn-secondary" onClick={() => {onViewDetails(student.id); model.setStudentid(student.id)}} >View Details</button>
                                {
                                    student.role === "student" && model.getUserType() !== "student" && model.getUserType() !== "parent" ? <button className="btn btn-secondary" onClick={() => onAddParent(student.id)} >Add Parent</button>
                                    : <div/>
                                }
                            </td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
        </div>
        <br/>
    </div>
);

export default StudentList;