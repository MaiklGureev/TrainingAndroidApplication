package com.example.trainingandroidapplication.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.trainingandroidapplication.R;

public class LinearLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ll);


        //установка фото
        LinearLayout linearLayout = findViewById(R.id.linear_layout);
        ImageView imageView = new ImageView(LinearLayoutActivity.this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setImageResource(R.drawable.cat_and_popug);
        imageView.setLayoutParams(layoutParams);
        linearLayout.addView(imageView);


    }
}
