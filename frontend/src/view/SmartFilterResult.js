import React, { Component } from "react";
import model from "../model/model";
import FilterResult from "./FilterResult";
import studentsListPresenter from "../presenter/studentsListPresenter";

const mapModelStateToComponentState = modelState => ({
    students: modelState.students,
    searchWord: modelState.searchWord
});

export default class SmartFilterResult extends Component {
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
            
            <FilterResult 
            onViewDetails={studentsListPresenter.onViewDetails}
            onCreateStudent={studentsListPresenter.onCreateStudent}
            onFilter={studentsListPresenter.onFilter}
            onDismissStudent={studentsListPresenter.onDismissStudent}
            students={this.state.students} />
        );
    }

}