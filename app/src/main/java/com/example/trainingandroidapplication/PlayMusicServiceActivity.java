package com.example.trainingandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

public class PlayMusicServiceActivity extends AppCompatActivity {

    private MyService myService;
    private Intent intent;
    private ServiceConnection serviceConnection;
    private boolean bound;
    private TextView textViewStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music_service);
        intent = new Intent(this, MyService.class);
        textViewStatus = findViewById(R.id.textViewInfo);
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                myService = ((MyService.MyBinder) service).getService();
                bound = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                if (bound) {
                    unbindService(serviceConnection);
                    bound = false;
                }
            }
        };

    }


    @Override
    protected void onStart() {
        super.onStart();
        bindService(intent, serviceConnection, 0);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bound) {
            unbindService(serviceConnection);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonPlayMusic: {
                startService(intent);
                textViewStatus.setText("Play!");
                break;
            }
            case R.id.buttonStopMusic: {
                textViewStatus.setText("Stop!");
                stopService(intent);
                break;
            }
        }
    }

}
