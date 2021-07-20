package com.cherry.databinding

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.cherry.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mainViewModel: MainViewModel by viewModels()
        binding.data = mainViewModel
        binding.lifecycleOwner = this

        getSharedPreferences("sp_settings", MODE_PRIVATE).edit {
            putInt("count", binding.data.number.value!!)
        }

        val count = getSharedPreferences("count", MODE_PRIVATE).getInt("count", 0)
    }
}
