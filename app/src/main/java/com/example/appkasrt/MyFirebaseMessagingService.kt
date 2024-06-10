package com.example.appkasrt

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlin.random.Random

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        if (message.notification != null) {
            startNotification(message.notification?.title, message.notification?.body)
        }
    }

    private fun startNotification(title: String?, message: String?) {
        val intent = Intent(this, NotificationActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE)
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.bg_card_laporan)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(Random.nextInt(), builder.build())
        // Simpan notifikasi ke penyimpanan lokal
        saveNotificationToLocal(title, message)
    }

    private fun saveNotificationToLocal(title: String?, message: String?) {
        val sharedPreferences = applicationContext.getSharedPreferences("NotificationHistory", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val timestamp = System.currentTimeMillis()
        editor.putString(timestamp.toString(), "$title|$message|$timestamp")
        editor.apply()
    }

    companion object {
        private const val CHANNEL_ID = "rt04"
    }
    override fun onNewToken(token: String) {
        // Mengirim token baru ke server backend atau melakukan tindakan lain sesuai kebutuhan aplikasi
        // Misalnya:
        sendTokenToServer(token)
    }

    private fun sendTokenToServer(token: String) {
        // Implementasi pengiriman token ke server backend di sini
        // Misalnya, mengirim token melalui HTTP POST request
        println("Token baru: $token")
    }

}