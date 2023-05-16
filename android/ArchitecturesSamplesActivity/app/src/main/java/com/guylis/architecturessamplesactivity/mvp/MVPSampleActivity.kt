package com.guylis.architecturessamplesactivity.mvp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.guylis.architecturessamplesactivity.R
import com.guylis.architecturessamplesactivity.databinding.ActivityMvpBinding
import com.guylis.architecturessamplesactivity.mvp.presenter.CounterPresenter
import com.guylis.architecturessamplesactivity.mvp.view.CounterView


class MVPSampleActivity : AppCompatActivity(), CounterView {

    private lateinit var binding: ActivityMvpBinding

    private lateinit var presenter : CounterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setTitle(R.string.display_text_mvp_title)


        // initializing the presenter
        presenter = CounterPresenter(this)

        updateView()
        // view->presenter view notifies the controller on button click
        binding.displayButtonCounter.setOnClickListener {

            presenter.updateCounter()
        }

        // view->view-model view notifies the view-model on input text
        binding.displayNameInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val newText: String = s.toString()
                presenter.updateName(newText)
            }
        })
    }


    override fun updateView() {
        binding.displayTextCounter.text = getString(R.string.display_text_counter, presenter.getCounter())
        binding.displayName.text = getString(R.string.display_name_label, presenter.getName())

    }
}