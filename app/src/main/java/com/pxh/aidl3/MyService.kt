package com.pxh.aidl3

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    val mBinder = object : IMyAidlInterface.Stub() {
        override fun add(a: Int, b: Int): Int {
            Log.e("MyService", "add:${a + b} ")
            return a + b
        }

        override fun basicTypes(
            anInt: Int,
            aLong: Long,
            aBoolean: Boolean,
            aFloat: Float,
            aDouble: Double,
            aString: String?
        ) {
            TODO("Not yet implemented")
        }
    }

    override fun onBind(intent: Intent): IBinder {
        Log.e("MyService", "onBind: ")
        return mBinder
    }

    override fun onCreate() {
        Log.e("MyService", "onCreate: ")
    }
}