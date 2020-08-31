package com.example.trainingandroidapplication.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Action: "+intent.getAction());
        stringBuilder.append("\nMessage: " + intent.getStringExtra(BroadcastActivity.MY_ACTION));

        Toast.makeText(context, stringBuilder, Toast.LENGTH_LONG).show();
    }
}
