package com.example.onesignalsampleproject.work

import android.app.NotificationManager
import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.delay


@HiltWorker
class ExampleCoroutineWorker @AssistedInject constructor(
    @Assisted private val appContext: Context,
    @Assisted workerParams: WorkerParameters
) : BaseWorker(appContext, workerParams) {


    override suspend fun doWork(): Result {
        setForeground(createForegroundInfo())
        delay(5_000)
        return Result.success()
    }

    override suspend fun getForegroundInfo() = createForegroundInfo()
}