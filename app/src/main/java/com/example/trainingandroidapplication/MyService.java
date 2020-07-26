package com.example.trainingandroidapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {

    private MediaPlayer mediaPlayer;
    private Thread thread;
    private MyBinder myBinder = new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "onCreate(): MediaPlayer.create", Toast.LENGTH_SHORT).show();
        mediaPlayer = MediaPlayer.create(MyService.this, R.raw.my_music);
        mediaPlayer.setLooping(false);

    }

    public String getPlayerStatus(){
        Log.d("MyService", "getPlayerStatus: work!");
        String info = mediaPlayer.getCurrentPosition() + " / " +mediaPlayer.getDuration();
        return info;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "onStartCommand(): MediaPlayer.start", Toast.LENGTH_SHORT).show();

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.start();
            }
        });
        thread.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy(): MediaPlayer.stop()", Toast.LENGTH_SHORT).show();
        mediaPlayer.stop();
    }

    @Override
    public boolean onUnbind(Intent intent) {

        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {

        super.onRebind(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public class MyBinder extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }

}
