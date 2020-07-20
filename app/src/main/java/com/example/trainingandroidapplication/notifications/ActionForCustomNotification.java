package com.example.trainingandroidapplication.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ActionForCustomNotification extends BroadcastReceiver {
    private static final String TAG = "ActionForCustomNotification";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: is work!");

        String message  = intent.getStringExtra("message");
        Toast.makeText(context, "Button is click!", Toast.LENGTH_SHORT).show();

        Intent newIntent = new Intent(context, SampleForNotificationActivity.class);
        newIntent.putExtra("value", message);
        context.startActivity(newIntent);
    }
}
