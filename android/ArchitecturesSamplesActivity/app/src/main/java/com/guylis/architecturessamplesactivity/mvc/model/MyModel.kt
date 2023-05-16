package com.guylis.architecturessamplesactivity.mvc.model

data class MyModel(var counter : Int = 0, var name : String = "") {

    fun updateCounter() {
        this.counter++
    }

    fun updateName(name : String) {
        this.name = name
    }
}

