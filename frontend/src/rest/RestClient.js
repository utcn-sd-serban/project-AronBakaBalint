const BASE_URL = "http://localhost:8080";

export default class RestClient{
    constructor(username, password){
        this.authorization = "Basic " + btoa(username+":"+password);
    }

    loadStudents(){
        return fetch(BASE_URL+"/persons", {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }

    filterByName(word){
        return fetch(BASE_URL+"/persons/filter?word="+word, {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }

    getStudentDetails(studentid){
        return fetch(BASE_URL+"/students/details?id="+studentid, {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }

    addPerson(username, password, role){
        return fetch(BASE_URL+"/persons", {
            method: "POST",
            body: JSON.stringify({
                username: username,
                password: password,
                role: role
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type":  "application/json"
            }
        }).then(response => response.json());
    }

    markStudent(username, mark, studentid){
        return fetch(BASE_URL+"/mark", {
            method: "POST",
            body: JSON.stringify({
                id: studentid,
                teacherName: username,
                value: mark
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type":  "application/json"
            }
        }).then(response => response.json());
    }

    dismissStudent(studentid){
        return fetch(BASE_URL+"/persons/remove?id="+studentid, {
            method: "DELETE",
            headers: {
                "Authorization": this.authorization,
                "Content-Type":  "application/json"
            }
        }).then(response => response.json());
    }

    addParent(parent, child){
        fetch(BASE_URL+"/parent", {
            method: "POST",
            body: JSON.stringify({
                childName: child,
                parentName: parent
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type":  "application/json"
            }
        });
    }
}