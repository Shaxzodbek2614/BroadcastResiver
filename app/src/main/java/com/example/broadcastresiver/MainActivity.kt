package com.example.broadcastresiver

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var myReceiverBroadcast: MyReceiverBroadcast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myReceiverBroadcast = MyReceiverBroadcast()
        val intentFilter = IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
        registerReceiver(myReceiverBroadcast,intentFilter)
    }
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myReceiverBroadcast)
    }

}