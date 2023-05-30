package com.tapac1k.bootcounter

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BootReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context, p1: Intent?) {
        when(p1?.action) {
            Intent.ACTION_BOOT_COMPLETED -> {
                Log.d("boot","bootcompleted")
                p0.startService(
                    Intent(p0, MainService::class.java).apply {
                        putExtra("time", System.currentTimeMillis())
                    }
                )
            }
        }
    }
}