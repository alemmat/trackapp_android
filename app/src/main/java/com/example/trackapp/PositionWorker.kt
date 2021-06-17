package com.example.test

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class PositionWorker(appContext: Context, workerParams: WorkerParameters): Worker(appContext, workerParams) {

    private val TAG = "MyActivity"

    override fun doWork(): Result {

        return try {

            Log.i(TAG, "index=")
            Result.success()
        }
        catch (throwable: Throwable) {

            Result.failure()
        }
    }
}