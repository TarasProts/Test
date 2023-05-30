package com.tapac1k.bootcounter

import android.app.AlarmManager
import android.app.Application
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.SystemClock
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApp: Application() {
    val delay =  15*60 *1000L
    val pi = PendingIntent.getBroadcast(this, 0, Intent(this, AlarmReceiver::class.java), PendingIntent.FLAG_IMMUTABLE)

    override fun onCreate() {
        super.onCreate()
        setupAlarm()
    }
    fun setupAlarm() {
        val am = (getSystemService(Service.ALARM_SERVICE) as AlarmManager)
        am.cancel(pi)
        am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + delay, delay, pi)
    }
}