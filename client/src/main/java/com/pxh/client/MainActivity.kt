package com.pxh.client




import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import com.pxh.aidl3.IMyAidlInterface


class MainActivity : AppCompatActivity() {

    private val serviceConnection = object :ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.e("MainActivity", "onServiceConnected: $name")
            Log.e("MainActivity", "onServiceConnected: ${IMyAidlInterface.Stub.asInterface(service).add(1,2)}")
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            TODO("Not yet implemented")
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent()
        intent.component = ComponentName("com.pxh.aidl3","com.pxh.aidl3.MyService")
        Log.e("MainActivity", "onCreate: ")
        startService(intent)
        bindService(intent,serviceConnection, BIND_AUTO_CREATE)
        findViewById<Button>(R.id.button).setOnClickListener {

        }
    }
}