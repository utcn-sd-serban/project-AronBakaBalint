import model from "../model/model";

class AddParentPresenter {

    onAddParent() {
       model.addParent();
       window.location.assign("#/student-list");
    }

}

const addParentPresenter = new AddParentPresenter();

export default addParentPresenter;