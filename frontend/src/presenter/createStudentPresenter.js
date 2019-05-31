import model from "../model/model";

class CreateStudentPresenter {

    onCreateStudent() {
        model.addPerson(model.state.newStudent.name, model.state.newStudent.password, model.state.newStudent.role);
        model.changeNewStudentProperty("name", "");
        model.changeNewStudentProperty("password", "");
        model.changeNewStudentProperty("role", "");
        window.location.assign("#/student-list");
    }

    onStudentChange(property, value) {
        model.changeNewStudentProperty(property, value);
    }

}

const createStudentPresenter = new CreateStudentPresenter();

export default createStudentPresenter;