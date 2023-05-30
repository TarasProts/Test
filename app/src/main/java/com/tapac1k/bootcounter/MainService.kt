package com.tapac1k.bootcounter

import android.app.Service
import android.content.Intent
import android.os.IBinder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainService: Service() {
    @Inject
    lateinit var databaseRepository: DatabaseRepository
    private val serviceScope = CoroutineScope(Dispatchers.IO + Job())
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        serviceScope.launch {
            val time = intent?.getLongExtra("time", -1L) ?: -1L
            if (time != -1L) databaseRepository.addBoot(time)
        }
        return super.onStartCommand(intent, flags, startId)
    }


}