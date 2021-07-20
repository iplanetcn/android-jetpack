package com.cherry.workmanager

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.cherry.workmanager.databinding.ActivityMainBinding
import com.cherry.workmanager.workers.UploadWorker
import java.time.Duration

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupWork()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupWork() {
        val uploadWorkRequest: WorkRequest = OneTimeWorkRequestBuilder<UploadWorker>()
            .setInitialDelay(Duration.ofSeconds(10))
            .setConstraints(Constraints.Builder().setRequiresCharging(true).build())
            .addTag("tag_upload_images")
            .build()
        WorkManager.getInstance(this).enqueue(uploadWorkRequest)
    }
}