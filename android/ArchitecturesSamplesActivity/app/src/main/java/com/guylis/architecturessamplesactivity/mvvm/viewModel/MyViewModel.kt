package com.guylis.architecturessamplesactivity.mvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.guylis.architecturessamplesactivity.mvvm.model.MyModel


class MyViewModel : ViewModel() {

    private val _model: MutableLiveData<MyModel> = MutableLiveData<MyModel>()
    val model : LiveData<MyModel> get() = _model


    init {
        // initializing the model
        _model.value = MyModel()
    }


    fun updateCounter() {
        // view-model->model updates the model with data
        val currentModel = _model.value
        currentModel?.let {
            it.counter++
            _model.value = it
        }
    }

    fun updateName(name : String) {
        // view-model->model updates the model with data
        val currentModel = _model.value
        currentModel?.let {
            it.name = name
            _model.value = it
        }
    }
}