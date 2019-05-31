import model from "../model/model";

class StudentsListPresenter {

    onInit(){
        model.loadStudents();
    }

    onCreateStudent() {
        window.location.assign("#/create-student");
    }

    onViewDetails(index) {
        window.location.assign("#/student-details/" + index);
        model.getStudentDetails(index);
    }

    onDismissStudent(studentid){
        model.dismissStudent(studentid);
    }

    onAddParent(childname){
        model.setChildname(childname);
        window.location.assign("#/add-parent")
    }

    onMarkStudent(){
        window.location.assign("#/student-list")
    }
}

const studentsListPresenter = new StudentsListPresenter();

export default studentsListPresenter;