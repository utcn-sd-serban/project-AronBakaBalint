import React, { Component } from "react";
import model from "../model/model";

import AddParent from "../view/AddParent";
import addParentPresenter from "../presenter/addParentPresenter";

const mapModelStateToComponentState = modelState => ({
    students: modelState.students,
});

export default class SmartCreateStudent extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState(model.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        model.addListener("change", this.listener);
    }

    componentWillUnmount() {
        model.removeListener("change", this.listener);
    }

    render() {
        return (
            <AddParent
                onAddParent={addParentPresenter.onAddParent}
                />
        );
    }
}