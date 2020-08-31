package com.example.trainingandroidapplication.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.trainingandroidapplication.R;

public class BroadcastActivity extends AppCompatActivity {

    public static final String MY_ACTION = "mikhailGureev.action.myAction";
    public static final String MY_MESSAGE = "My message from broadcast!";
    private int COUNTER = 1;
    private BroadcastReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        myReceiver = new MyReceiver();
    }

    public void sendMessage(View view) {



        Intent intent = new Intent();
        intent.setAction(MY_ACTION);
        intent.putExtra(MY_ACTION,MY_MESSAGE+" ("+COUNTER+")");
        sendBroadcast(intent);
        COUNTER++;
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MY_ACTION);
        registerReceiver(myReceiver,intentFilter);
        Toast.makeText(this, "registerReceiver success!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);
        Toast.makeText(this, "unregisterReceiver success!", Toast.LENGTH_SHORT).show();
    }
}
