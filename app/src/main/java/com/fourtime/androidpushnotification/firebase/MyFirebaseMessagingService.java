package com.fourtime.androidpushnotification.firebase;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;

import com.fourtime.androidpushnotification.Constants;
import com.fourtime.androidpushnotification.MainActivity;
import com.fourtime.androidpushnotification.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyFirebaseMessagingService extends FirebaseMessagingService {

    public void onMessageReceived(RemoteMessage remoteMessage) {

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(new Intent(this, MainActivity.class));

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(getApplicationContext(), Constants.NotificationChannel.DEFAULT.getId(this))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setColor(ContextCompat.getColor(this, R.color.colorAccent))
                .setContentTitle(remoteMessage.getData().get("title"))
                .setContentText(remoteMessage.getData().get("body"))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(remoteMessage.getData().get("body")))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND | Notification.FLAG_SHOW_LIGHTS)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (mNotificationManager != null) {
            mNotificationManager.notify(1, notification);
        }

    }
}
