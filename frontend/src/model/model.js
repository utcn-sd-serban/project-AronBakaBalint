import { EventEmitter } from "events";
import RestClient from "../rest/RestClient";

const client = new RestClient("johndoe", "abc123");

class Model extends EventEmitter {

    constructor() {
        super();
        this.state = {
            user: "",
            studentId: 3,
            students: [],
            newStudent: {
                name: "",
                grade: ""
            }
        };
    }

    loadStudents(){
        return client.loadStudents().then(students => {
            this.state = {
                ...this.state,
                students: students
            };
            this.emit("change", this.state);
            console.log(students);
        })
    }

    addStudent(studentName, grade) {
        this.state = {
            ...this.state,
            studentId: this.state.studentId + 1,
            students: this.state.students.concat([{
                id: this.state.studentId+1,
                name: studentName,
                grade: grade
            }])
        };
        this.emit("change", this.state);
    }

    changeNewStudentProperty(property, value) {
        this.state = {
            ...this.state,
            newStudent: {
                ...this.state.newStudent,
                [property]: value
            }
        };
        this.emit("change", this.state);
    }

    setUser(user){
        this.state.user = user;
    }

}

const model = new Model();

export default model;