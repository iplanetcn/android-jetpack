package com.cherry.viewmodel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.cherry.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mainViewModel: MainViewModel by viewModels()

        binding.tvMessage.text = mainViewModel.number.toString()

        binding.btnIncrease.setOnClickListener {
            mainViewModel.number++
            binding.tvMessage.text = mainViewModel.number.toString()
        }

        binding.btnDecrease.setOnClickListener {
            mainViewModel.number--
            binding.tvMessage.text = mainViewModel.number.toString()
        }
    }
}
