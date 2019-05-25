import model from "../model/model";

class StudentsListPresenter {

    onInit(){
        model.loadStudents();
    }

    onCreateStudent() {
        window.location.assign("#/create-student");
    }

    onFilter() {
        window.location.assign("#/filter-result");
    }

    onViewDetails(index) {
        window.location.assign("#/student-details/" + index);
    }
}

const studentsListPresenter = new StudentsListPresenter();

export default studentsListPresenter;