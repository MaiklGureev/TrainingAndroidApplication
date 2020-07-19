package com.example.trainingandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SampleForNotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_for_notification);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            TextView textView = findViewById(R.id.textViewSampleMessageFromNotification);
            textView.setText(bundle.getString("value"));
        }
    }
}
