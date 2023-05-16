package com.guylis.architecturessamplesactivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.guylis.architecturessamplesactivity.databinding.ActivityMainBinding
import com.guylis.architecturessamplesactivity.mvc.view.MVCSampleActivity
import com.guylis.architecturessamplesactivity.mvp.MVPSampleActivity
import com.guylis.architecturessamplesactivity.mvvm.view.MVVMSampleActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnMVC.setOnClickListener{
            val myIntent = Intent(applicationContext, MVCSampleActivity::class.java)
            this.startActivity(myIntent)

        }

        binding.btnMVP.setOnClickListener{
            val myIntent = Intent(applicationContext, MVPSampleActivity::class.java)
            this.startActivity(myIntent)

        }

        binding.btnMVVM.setOnClickListener{
            val myIntent = Intent(applicationContext, MVVMSampleActivity::class.java)
            this.startActivity(myIntent)

        }


    }
}