package com.example.trainingandroidapplication.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.trainingandroidapplication.R;
import com.google.android.material.tabs.TabLayout;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        String[] ints = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ints);
        GridView gridView = findViewById(R.id.gridView);
        gridView.setNumColumns(3);
        gridView.setBackgroundColor(Color.GREEN);
        gridView.setGravity(TabLayout.GRAVITY_FILL);
        gridView.setAdapter(arrayAdapter);


    }
}
