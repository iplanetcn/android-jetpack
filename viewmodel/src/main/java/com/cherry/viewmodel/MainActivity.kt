package com.cherry.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainViewModel : MainViewModel by viewModels()

        tv_message.text = mainViewModel.number.toString()

        btn_increase.setOnClickListener {
            mainViewModel.number++
            tv_message.text = mainViewModel.number.toString()
        }

        btn_decrease.setOnClickListener {
            mainViewModel.number--
            tv_message.text = mainViewModel.number.toString()
        }
    }
}
