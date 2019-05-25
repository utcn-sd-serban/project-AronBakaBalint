import React, { Component } from "react";
import model from "../model/model";
import FilterResult from "./FilterResult";
import studentsListPresenter from "../presenter/studentsListPresenter";

const mapModelStateToComponentState = modelState => ({
    questions: modelState.questions
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
                questions={this.filterByTag(this.state.questions, model.getSearchWord())} />
        );
    }

}