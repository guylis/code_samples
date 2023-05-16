package com.guylis.architecturessamplesactivity.mvp.model

data class MyModel(var counter : Int = 0, var name : String = "") {

    fun updateCounter() {
        counter++
    }

    fun updateName(name : String) {
        this.name = name
    }
}

