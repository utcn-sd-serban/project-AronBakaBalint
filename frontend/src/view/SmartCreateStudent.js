import React, { Component } from "react";
import model from "../model/model";

import CreateStudent from "./CreateStudent";
import createStudentPresenter from "../presenter/createStudentPresenter";

const mapModelStateToComponentState = modelState => ({
    name: modelState.newStudent.name,
    grade: modelState.newStudent.grade
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
            <CreateStudent
                onCreate={createStudentPresenter.onCreateStudent}
                onChange={createStudentPresenter.onStudentChange}
                title={this.state.title}
                body={this.state.body}
                tags={this.state.tags} />
        );
    }
}