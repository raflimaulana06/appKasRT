package com.example.appkasrt

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class NotificationActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        createNotificationChannel()
        displayNotificationHistory()

    }


    private fun createNotificationChannel() {
        val name = getString(R.string.channel_name)
        val descriptionText = getString(R.string.channel_description)
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel("rt04", name, importance).apply {
            description = descriptionText
        }
        val notificationManager: NotificationManager =
            getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
private fun displayNotificationHistory() {
        val sharedPreferences =
            applicationContext.getSharedPreferences("NotificationHistory", Context.MODE_PRIVATE)
        val notifications = mutableListOf<NotificationItem>()
        val entries = sharedPreferences.all
        for ((_, value) in entries) {
            val notificationData = value.toString().split("|")
            if (notificationData.size == 3) {
                val title = notificationData[0]
                val content = notificationData[1]
                val timestamp = notificationData[2].toLong()
                notifications.add(NotificationItem(title, content, timestamp))
            }
        }
        notifications.sortByDescending { it.timestamp }
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NotificationHistoryAdapter(notifications)
    }
}



