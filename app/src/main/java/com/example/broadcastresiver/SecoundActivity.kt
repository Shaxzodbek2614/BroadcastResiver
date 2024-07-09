package com.example.broadcastresiver

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.properties.Delegates

private const val TAG = "SecoundActivity"
class SecoundActivity : AppCompatActivity() {
    var cuurentTime by Delegates.notNull<Long>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secound)
        cuurentTime = SystemClock.elapsedRealtime()
        setTime()
    }

    @SuppressLint("ScheduleExactAlarm")
    private fun setTime(){
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, MyReceiverBroadcast::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_IMMUTABLE)
        alarmManager.setExact(AlarmManager.ELAPSED_REALTIME, cuurentTime + 10000, pendingIntent)
    }
}