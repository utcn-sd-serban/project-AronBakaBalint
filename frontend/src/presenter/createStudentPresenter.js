import model from "../model/model";

class CreateStudentPresenter {

    onCreateStudent() {
        model.addStudent(model.state.newStudent.name, model.state.newStudent.grade);
        model.changeNewStudentProperty("name", "");
        model.changeNewStudentProperty("grade", "");
        window.location.assign("#/student-list");
    }

    onStudentChange(property, value) {
        model.changeNewStudentProperty(property, value);
    }

}

const createStudentPresenter = new CreateStudentPresenter();

export default createStudentPresenter;