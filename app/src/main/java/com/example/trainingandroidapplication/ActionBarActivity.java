package com.example.trainingandroidapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.ClipData;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;

public class ActionBarActivity extends AppCompatActivity {

    TextView textView;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My title");
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setSubtitle("It's subtitle");
        textView = findViewById(R.id.textViewActionBarInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);

        MenuItem menuItem = menu.findItem(R.id.item_app_bar_search);
        searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                textView.setText("onQueryTextSubmit: " + query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                textView.setText("onQueryTextChange: " + newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
            case R.id.itemSimpleButton1: {
                textView.setText("Click on: " + item.getTitle());
                return true;
            }
            case R.id.itemSimpleButton2: {
                textView.setText("Click on: " + item.getTitle());
                return true;
            }
            case R.id.itemCheckButton1: {
                switchItem(item);
                return true;
            }
            case R.id.itemCheckButton2: {
                switchItem(item);
                return true;
            }
            case R.id.itemRadioButton1: {
                switchItem(item);
                return true;
            }
            case R.id.itemRadioButton2: {
                switchItem(item);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }


    void switchItem(MenuItem item){
        if(item.isChecked()){
            item.setChecked(false);
        }
        else{
            item.setChecked(true);
        }
        textView.setText("Click on and switch: " + item.getTitle());
    }

}
