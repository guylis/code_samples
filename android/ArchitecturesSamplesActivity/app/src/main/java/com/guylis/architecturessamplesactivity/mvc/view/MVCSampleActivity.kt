package com.guylis.architecturessamplesactivity.mvc.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.guylis.architecturessamplesactivity.R
import com.guylis.architecturessamplesactivity.databinding.ActivityMvcBinding
import com.guylis.architecturessamplesactivity.mvc.controller.MyController


class MVCSampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMvcBinding

    // the model and controller are tightly coupled
    private val controller = MyController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvcBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setTitle(R.string.display_text_mvc_title)

        updateViewWithModel()
        // view->controller view notifies the controller on button click
        binding.displayButtonCounter.setOnClickListener {

            // controller->model data is updated
            controller.updateCounter()

            updateViewWithModel()
        }

        // view->view-model view notifies the view-model on input text
        binding.displayNameInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val newText: String = s.toString()
                controller.updateName(newText)
                updateViewWithModel()
            }
        })

    }

    private fun updateViewWithModel() {
        // model->controller retrieving the model data
        // controller->view updating the view
        binding.displayTextCounter.text = getString(R.string.display_text_counter, controller.getCounter())
        binding.displayName.text = getString(R.string.display_name_label, controller.getName())
    }
}