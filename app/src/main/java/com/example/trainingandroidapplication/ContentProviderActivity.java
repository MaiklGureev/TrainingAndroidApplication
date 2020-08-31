package com.example.trainingandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProvider;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class ContentProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
    }
}
