package com.example.broadcastresiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.SystemClock
import android.util.Log
import android.widget.Toast
import com.example.broadcastresiver.utils.MyData

private const val TAG = "MyReceiverBroadcast"
class MyReceiverBroadcast : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val connect = MyData.isNetworkConnected(context)
        Toast.makeText(context, "Vaqt bo'ldi", Toast.LENGTH_SHORT).show()
        val alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
        val ringtone = RingtoneManager.getRingtone(context, alarmSound)
        ringtone.play()
    }
}