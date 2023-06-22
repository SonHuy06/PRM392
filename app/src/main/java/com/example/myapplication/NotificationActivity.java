package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends AppCompatActivity {


    static String CHANNEL_ID = "Noti";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = getString(R.string.channel_name);
            String description = "Notification Tutorial";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        Button button = findViewById(R.id.btnNotification);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificationActivity.this, RecycleViewActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(NotificationActivity.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(NotificationActivity.this, CHANNEL_ID)
                        .setContentTitle("Xin chao")
                        .setContentText("Day la chuong trinh android studio")
                        .setSmallIcon(R.drawable.ic_action_airplane)
                        .setContentIntent(pendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(NotificationActivity.this);
                managerCompat.notify(1, mBuilder.build());
            }
        });

    }
}