package com.example.multimedia;

/**
 * Created by Luo_0412 on 2016/10/16.
 */

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MyService extends Service {

    private DownloadBinder mBinder = new DownloadBinder();

    class DownloadBinder extends Binder {

        public void startDownload() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // start downloading
                }
            }).start();
            Log.d("MyService", "startDownload executed");
        }

        public int getProgress() {
            Log.d("MyService", "getProgress executed");
            return 0;
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("MyService", "onBind executed");
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Notification notification = new Notification(R.mipmap.ic_launcher,
                "Notification comes", System.currentTimeMillis());
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);
//        notification.setLatestEventInfo(this, "This is title", "This is content",
//                pendingIntent);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                this);
        notification = builder.setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("This is content title").setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("This is content title")
                .setContentText("This is content text").build();

        startForeground(1, notification);
        Log.d("MyService", "onCreate executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService", "onStartCommand executed");
        new Thread(new Runnable() {
            @Override
            public void run() {
                // do something here
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService", "onDestroy executed");
    }

}
