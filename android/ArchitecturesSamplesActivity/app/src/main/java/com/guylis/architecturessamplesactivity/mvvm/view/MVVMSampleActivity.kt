package com.guylis.architecturessamplesactivity.mvvm.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.guylis.architecturessamplesactivity.R
import com.guylis.architecturessamplesactivity.databinding.ActivityMvvmBinding
import com.guylis.architecturessamplesactivity.mvvm.viewModel.MyViewModel


class MVVMSampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMvvmBinding

    private lateinit var myViewModel : MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setTitle(R.string.display_text_mvvm_title)

        // initializing the view model
        myViewModel = ViewModelProvider(this)[MyViewModel::class.java]

        // view->view-model view notifies the view-model on button click
        binding.displayButtonCounter.setOnClickListener {
            myViewModel.updateCounter()
        }

        // view->view-model view notifies the view-model on input text
        binding.displayNameInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val newText: String = s.toString()
                myViewModel.updateName(newText)
            }
        })


        // model->view-model observes the view model
        // view-model->view  update the view accordingly
        myViewModel.model.observe(this) { model ->
            // Update the UI with user information
            binding.displayTextCounter.text = getString(R.string.display_text_counter, model.counter)
            binding.displayName.text = getString(R.string.display_name_label, model.name)
        }

    }

}