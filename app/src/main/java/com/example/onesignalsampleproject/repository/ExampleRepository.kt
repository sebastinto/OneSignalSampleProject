package com.example.onesignalsampleproject.repository

import androidx.work.*
import com.example.onesignalsampleproject.ui.EXAMPLE_COROUTINE_WORKER_TAG
import com.example.onesignalsampleproject.work.ExampleCoroutineWorker
import com.example.onesignalsampleproject.work.ExampleCoroutineWorker2
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ExampleRepository @Inject constructor(
    private val workManager: WorkManager
) {

    fun enqueueWork() {
        val exampleCoroutineWorker = OneTimeWorkRequestBuilder<ExampleCoroutineWorker>()
            .addTag(EXAMPLE_COROUTINE_WORKER_TAG)
            .setInputData(workDataOf("DATA_TAG" to "data"))
            .setBackoffCriteria(
                BackoffPolicy.LINEAR,
                WorkRequest.MIN_BACKOFF_MILLIS,
                TimeUnit.MILLISECONDS
            )
            .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
            .build()

        val exampleCoroutineWorker2 = OneTimeWorkRequestBuilder<ExampleCoroutineWorker2>()
            .addTag(EXAMPLE_COROUTINE_WORKER_TAG)
            .setInputData(workDataOf("DATA_TAG" to "data"))
            .setBackoffCriteria(
                BackoffPolicy.LINEAR,
                WorkRequest.MIN_BACKOFF_MILLIS,
                TimeUnit.MILLISECONDS
            )
            .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
            .build()

        val uniqueWorkName = "${System.currentTimeMillis()}_$EXAMPLE_COROUTINE_WORKER_TAG"

        workManager
            .beginUniqueWork(
                uniqueWorkName,
                ExistingWorkPolicy.APPEND_OR_REPLACE,
                exampleCoroutineWorker
            )
            .then(exampleCoroutineWorker2)
            .enqueue()
    }
}