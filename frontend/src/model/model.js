import { EventEmitter } from "events";
import RestClient from "../rest/RestClient";

class Model extends EventEmitter {

    constructor() {
        super();
        this.state = {
            user: "",
            password: "",
            studentid: "",
            childname: "",
            subjects: "",
            parent: "",
            marks:[],
            students: [],
            mark: "",
            newStudent: {
                name: "",
                password: "",
                role: ""
            }
        };
    }

    loadStudents(){
        const client = new RestClient(this.state.user, this.state.password);
        return client.loadStudents().then(students => {
            this.state = {
                ...this.state,
                students: students
            };
            this.emit("change", this.state);
        })
    }

    getStudentDetails(studentid){
        const client = new RestClient(this.state.user, this.state.password);
        return client.getStudentDetails(studentid).then(subjects => {
            this.state = {
                ...this.state,
                subjects: subjects,
                marks: subjects.marks
            };
            this.emit("change", this.state);
        })
    }

    markStudent(){
        const client = new RestClient(this.state.user, this.state.password);
        return client.markStudent(this.state.user, this.state.mark, this.state.studentid).then(subjects => {
            this.state = {
                ...this.state,
                subjects: subjects
            };
            this.emit("change", this.state);
        })
    }

    dismissStudent(studentid){
        const client = new RestClient(this.state.user, this.state.password);
        return client.dismissStudent(studentid).then(students => {
            this.state = {
                ...this.state,
                students: students
            };
            this.emit("change", this.state);
        })
    }

    addPerson(username, password, role) {
        const client = new RestClient(this.state.user, this.state.password);
        return client.addPerson(username, password, role).then(students => {
            this.state = {
                ...this.state,
                students: students
            };
            this.emit("change", this.state);
        })
    }

    filterByName(word){
        const client = new RestClient(this.state.user, this.state.password);
        return client.filterByName(word).then(students => {
            this.state = {
                ...this.state,
                students: students
            };
            this.emit("change", this.state);
            console.log(this.state.students)
        })
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

    getUserType(){
        for(var i=0;i<this.state.students.length; i++){
            if(this.state.students[i].username === this.state.user){
                return this.state.students[i].role;
            }
        }
    }

    addParent(){
        const client = new RestClient(this.state.user, this.state.password);
        client.addParent(this.state.parent, this.state.childname);
    }

    setUser(user){
        this.state.user = user;
    }

    setPassword(password){
        this.state.password = password;
    }

    setMark(mark){
        this.state.mark = mark;
    }

    setStudentid(id){
        this.state.studentid = id;
    }

    setSearchWord(searchWord){
        this.state.searchWord = searchWord;
    }

    setParent(parent){
        this.state.parent = parent;
    }

    setChildname(name){
        this.state.childname = name;
    }

}

const model = new Model();

export default model;