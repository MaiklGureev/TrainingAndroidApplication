package com.example.trainingandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.trainingandroidapplication.layouts.ConstraintLayoutActivity;
import com.example.trainingandroidapplication.layouts.GridLayoutActivity;
import com.example.trainingandroidapplication.layouts.LinearLayoutActivity;
import com.example.trainingandroidapplication.layouts.RelativeLayoutActivity;
import com.example.trainingandroidapplication.lists.ListViewActivity;
import com.example.trainingandroidapplication.lists.ListViewWithAdapterActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_ll:{
                Log.d(TAG, "onClick: LinearLayoutActivity");
                Intent intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button_gl:{
                Log.d(TAG, "onClick: GridLayoutActivity");
                Intent intent = new Intent(MainActivity.this, GridLayoutActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button_rl:{
                Log.d(TAG, "onClick: RelativeLayoutActivity");
                Intent intent = new Intent(MainActivity.this, RelativeLayoutActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button4:{
                Log.d(TAG, "onClick: ConstraintLayoutActivity");
                Intent intent = new Intent(MainActivity.this, ConstraintLayoutActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button5:{
                Log.d(TAG, "onClick: ControlElementsActivity");
                Intent intent = new Intent(MainActivity.this,ControlElementsActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button6:{
                Log.d(TAG, "onClick: ListViewActivity");
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button7:{
                Log.d(TAG, "onClick: ListViewWithAdapterActivity");
                Intent intent = new Intent(MainActivity.this, ListViewWithAdapterActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button8:{
                Log.d(TAG, "onClick: DataTransferSampleActivity");
                Intent intent = new Intent(MainActivity.this, DataTransferSampleActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button9:{
                Log.d(TAG, "onClick: DialogActivity");
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button10:{
                Log.d(TAG, "onClick: NotificationsActivity");
                Intent intent = new Intent(MainActivity.this, NotificationsActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
