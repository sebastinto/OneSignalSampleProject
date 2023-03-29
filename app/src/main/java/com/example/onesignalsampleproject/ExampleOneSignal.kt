package com.example.onesignalsampleproject

import android.content.Context
import com.onesignal.BuildConfig
import com.onesignal.OneSignal

const val ONESIGNAL_APP_ID = "" // todo: use your own key

class ExampleOneSignal {
    fun init(context: Context) {
        if (BuildConfig.DEBUG)
            OneSignal.setLogLevel(OneSignal.LOG_LEVEL.DEBUG, OneSignal.LOG_LEVEL.NONE)

        // OneSignal initialization
        OneSignal.initWithContext(context)
        OneSignal.setAppId(ONESIGNAL_APP_ID)

        // OneSignal options
        OneSignal.setLocationShared(false)
        OneSignal.provideUserConsent(true)
    }
}