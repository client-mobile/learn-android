package com.example.multimedia;

/**
 * Created by Luo_0412 on 2016/10/15.
 */

import java.io.File;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NotificationTestActivity extends Activity implements OnClickListener {

    private Button sendNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_test_layout);
        sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new Notification(
                        R.mipmap.ic_launcher, "This is ticker text",
                        System.currentTimeMillis());
                Uri soundUri = Uri.fromFile(new File("/system/media/audio/ringtones/Basic_tone.ogg"));
                notification.sound = soundUri;
                long[] vibrates = {0, 1000, 1000, 1000};
                notification.vibrate = vibrates;
                notification.ledARGB = Color.GREEN;
                notification.ledOnMS = 1000;
                notification.ledOffMS = 1000;
                notification.flags = Notification.FLAG_SHOW_LIGHTS;
//			notification.defaults = Notification.DEFAULT_ALL;
                Intent intent = new Intent(this, NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this, 0, intent,
                        PendingIntent.FLAG_CANCEL_CURRENT);

//                notification.setLatestEventInfo(this, "This is content title",
//                        "This is content text", pi);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        this);
                notification = builder.setContentIntent(pi)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setTicker("This is content title").setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setContentTitle("This is content title")
                        .setContentText("This is content text").build();

                manager.notify(1, notification);
                break;
            default:
                break;
        }
    }

}
