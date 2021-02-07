package com.cherry.livedata

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModelWithLiveData: ViewModelWithLiveData by viewModels()
        viewModelWithLiveData.likedNumber.observe(this, {
            tv_message.text = it.toString()
        })

        ibtn_thumb_up.setOnClickListener{
            viewModelWithLiveData.addLikeNumber(1)
        }

        ibtn_thumb_down.setOnClickListener {
            viewModelWithLiveData.addLikeNumber(-1)
        }
    }
}
