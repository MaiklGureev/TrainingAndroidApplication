package com.example.trainingandroidapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;

public class NotificationsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "NotificationsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
    }



    @Override
    public void onClick(final View v) {

        final NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        final Notification.Builder builder = new Notification.Builder(NotificationsActivity.this);
        Notification notification;

        switch (v.getId()) {
            case R.id.buttonSimpleNotification: {
                builder.setSmallIcon(R.mipmap.ic_launcher_round)
                        .setColor(Color.GREEN)
                        .setTicker("My notification 01")
                        .setSubText("SubText from my notification 01")
                        .setContentText("My text")
                        .setContentTitle("My notification 01")
                        .setWhen(System.currentTimeMillis())
                        .setPriority(Notification.PRIORITY_MAX)
                        .setAutoCancel(true);

                notification = builder.build();
                notification.defaults = Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE;
                notification.flags = notification.flags | Notification.FLAG_SHOW_LIGHTS;
                notificationManager.notify(111, notification);
                break;
            }
            case R.id.buttonSimpleNotificationCancel: {
                notificationManager.cancel(111);
                break;
            }
            case R.id.buttonNotificationWithProgress: {
                builder.setSmallIcon(R.mipmap.ic_launcher_round)
                        .setTicker("My notification 02")
                        .setContentText("My text")
                        .setContentTitle("My notification 02")
                        .setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setProgress(100, 75, false);
                notification = builder.build();
                notificationManager.notify(222, notification);

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            for (int a = 0; a <= 100; a++) {
                                Thread.sleep(100);
                                if (a == 100) {
                                    builder.setContentText("Progress is over!")
                                            .setProgress(0, 0, false)
                                            .setDefaults(Notification.DEFAULT_SOUND);
                                    notificationManager.notify(222, builder.build());
                                } else {
                                    builder.setContentText("Progress is " + a + "%")
                                            .setProgress(100, a, false);
                                    notificationManager.notify(222, builder.build());
                                }
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.run();
                break;
            }
            case R.id.buttonNotificationWithProgressCancel: {
                notificationManager.cancel(222);
                break;
            }
            case R.id.buttonNotificationWithButton: {

                Intent notificationIntent = new Intent(NotificationsActivity.this, SampleForNotificationActivity.class);
                notificationIntent.putExtra("value","Message from my notification 03!");

                PendingIntent pendingIntent = PendingIntent.getActivity(NotificationsActivity.this,
                        0, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

                builder.setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("My notification 03")
                        .setContentText("Click on me!")
                        .setPriority(Notification.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent)
                        .addAction(R.mipmap.ic_launcher, "Open", pendingIntent)
                        .setAutoCancel(true);


                notificationManager.notify(333, builder.build());

                break;
            }
            case R.id.buttonNotificationWithButtonCancel: {
                notificationManager.cancel(333);
                break;
            }
        }

    }
}
