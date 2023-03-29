package com.example.onesignalsampleproject.work

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import com.example.onesignalsampleproject.R
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import javax.inject.Inject

const val NOTIFICATION_ID = -1
const val CHANNEL_ID = "channel_id"


@HiltWorker
open class BaseWorker @AssistedInject constructor(
    @Assisted private val appContext: Context,
    @Assisted workerParams: WorkerParameters
) : CoroutineWorker(appContext, workerParams) {

    // todo: comment this field injection and use the declaration below
    @Inject lateinit var notificationManager: NotificationManager

    // private val notificationManager = appContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    override suspend fun doWork(): Result {
        return Result.success()
    }

    override suspend fun getForegroundInfo() = createForegroundInfo()

    fun createForegroundInfo(): ForegroundInfo {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel()
        }
        return ForegroundInfo(NOTIFICATION_ID, createNotification())
    }

    private fun createNotification(): Notification =

        NotificationCompat.Builder(applicationContext, CHANNEL_ID).apply {
            setSmallIcon(R.drawable.ic_launcher_foreground)
            setContentTitle("Work in progress")
            setContentText("Doing work...")
            setProgress(100, 0, true)
            priority = NotificationCompat.PRIORITY_DEFAULT
            setVibrate(null)
            setSound(null)
        }.build()


    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel() {
        val notifChannel = NotificationChannel(
            CHANNEL_ID,
            "channel_name",
            NotificationManager.IMPORTANCE_LOW
        ).also {
            it.description = "channel description"
            it.vibrationPattern = null
            it.enableVibration(false)
        }
        notificationManager.createNotificationChannel(notifChannel)
    }
}