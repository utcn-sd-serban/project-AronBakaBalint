const BASE_URL = "http://localhost:8080";

export default class RestClient{
    constructor(username, password){
        this.authorization = "Basic " + btoa(username+":"+password);
    }

    loadStudents(){
        return fetch(BASE_URL+"/studentList", {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }

    getStudentDetails(studentid){
        return fetch(BASE_URL+"/studentList/details?id="+studentid, {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }

    createStudent(username, password){
        return fetch(BASE_URL+"/question-list", {
            method: "POST",
            body: JSON.stringify({
                id: 0,
                username: username,
                password: password,
                role: "student"
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type":  "application/json"
            }
        }).then(response => response.json());
    }

    createTeacher(username, password, subject){
        return fetch(BASE_URL+"/question-list", {
            method: "POST",
            body: JSON.stringify({
                id: 0,
                username: username,
                password: password,
                role: subject
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type":  "application/json"
            }
        }).then(response => response.json());
    }

    createParent(username, password){
        return fetch(BASE_URL+"/question-list", {
            method: "POST",
            body: JSON.stringify({
                id: 0,
                username: username,
                password: password,
                role: "parent",
                children: []
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type":  "application/json"
            }
        }).then(response => response.json());
    }

    getDetailsById(id){
        return fetch(BASE_URL+"/person-details/getDetails?id="+id, {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }
}