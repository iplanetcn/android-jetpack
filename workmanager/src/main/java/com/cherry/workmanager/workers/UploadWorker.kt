package com.cherry.workmanager.workers

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * UploadWorker
 *
 * @author john
 * @since 2021-03-16
 */
class UploadWorker(appContext: Context, workerParameters: WorkerParameters) :
    Worker(appContext, workerParameters) {
    override fun doWork(): Result {
        // Do the work here--in this case, upload the images;
        uploadImages()

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }

    private fun uploadImages(){
        Log.d("UploadWorker","upload images")
    }
}