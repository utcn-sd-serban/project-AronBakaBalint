import React, { Component } from "react";
import model from "../model/model";

import StudentDetails from "./StudentDetails";

const mapModelStateToComponentState = (modelState, props) => (
    modelState.students[props.match.params.index]
)

export default class SmartStudentDetails extends Component {
    constructor(props) {
        super(props);
        this.state = mapModelStateToComponentState(model.state, props);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState, this.props));
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
                id={this.state.id}
                title={this.state.title}
                body={this.state.body}
                tags={this.state.tags}
                author={this.state.author}
                postDate={this.state.postDate}
            />
        );
    }
}