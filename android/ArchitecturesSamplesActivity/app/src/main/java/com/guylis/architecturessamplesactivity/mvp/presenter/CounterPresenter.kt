package com.guylis.architecturessamplesactivity.mvp.presenter

import com.guylis.architecturessamplesactivity.mvp.model.MyModel
import com.guylis.architecturessamplesactivity.mvp.view.CounterView

class CounterPresenter(private var counterView: CounterView)  {

    // initializing the model
    private var model : MyModel = MyModel()

    fun updateCounter() {
        // presenter->model data is updated
        model.updateCounter()
        counterView.updateView()
    }

    fun updateName(name : String) {
        // presenter->model data is updated
        model.updateName(name)
        counterView.updateView()
    }

    fun getCounter(): Int {
        // model->presenter data is updated
        return model.counter
    }

    fun getName(): String {
        // model->presenter data is updated
        return model.name
    }

}