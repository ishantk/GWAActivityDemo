package com.auribises.gwaactivitydemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    Context context;

    @Override
    public void onReceive(Context context, Intent intent) {

        this.context = context;

        String action = intent.getAction();

        if(action.equals("a.b.c.d")){
            showNotification("This is Received by User");
            Toast.makeText(context,"This is Received by User",Toast.LENGTH_LONG).show();

            //Intent intent1 = new Intent(context,ActivityOne.class);
            //context.startActivity(intent1);
        }

        if(action.equals("android.intent.action.BATTERY_LOW")){
            showNotification("Batter is LOW");
        }

    }

    void showNotification(String message){

        NotificationManager notificationManager = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("Receiver");
        builder.setContentText(message);
        builder.setSmallIcon(R.drawable.music);
        builder.setDefaults(Notification.DEFAULT_ALL); // VIBRATE permission in manifest

        Notification notification = builder.build();

        notificationManager.notify(101,notification);

    }
}
