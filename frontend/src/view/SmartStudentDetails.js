import React, { Component } from "react";
import model from "../model/model";

import StudentDetails from "./StudentDetails";
import studentsListPresenter from "../presenter/studentsListPresenter";

const mapModelStateToComponentState = modelState => ({
    subjects: modelState.subjects,
    marks: modelState.marks
});

export default class SmartStudentDetails extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState(model.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        model.addListener("change", this.listener);
    }

    componentDidUpdate(prev) {
        if (prev.match.params.index !== this.props.match.params.index) {
            this.setState(mapModelStateToComponentState(model.state, this.props));
        }
    }

    componentWillUnmount() {
        model.removeListener("change", this.listener);
    }

    render() {
        return (
            <StudentDetails
            subjects={this.state.subjects}
            marks={this.state.marks}
            onMarkStudent={studentsListPresenter.onMarkStudent}
            />
        );
    }
}