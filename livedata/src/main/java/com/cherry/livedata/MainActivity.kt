package com.cherry.livedata

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.cherry.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModelWithLiveData: ViewModelWithLiveData by viewModels()
        viewModelWithLiveData.likedNumber.observe(this, {
            binding.tvMessage.text = it.toString()
        })

        binding.ibtnThumbUp.setOnClickListener {
            viewModelWithLiveData.addLikeNumber(1)
        }

        binding.ibtnThumbDown.setOnClickListener {
            viewModelWithLiveData.addLikeNumber(-1)
        }
    }
}
