package com.guylis.architecturessamplesactivity.mvc.controller

import com.guylis.architecturessamplesactivity.mvc.model.MyModel


class MyController {

    // initializing the model
    private var model : MyModel = MyModel()


    fun updateCounter() {
        model.updateCounter()
    }

    fun updateName(name : String) {
        model.updateName(name)
    }
    fun getCounter() : Int {
        return model.counter
    }

    fun getName() : String {
        return model.name
    }
}