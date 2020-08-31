package com.example.trainingandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.trainingandroidapplication.broadcast.BroadcastActivity;
import com.example.trainingandroidapplication.fragments.FragmentActivity;
import com.example.trainingandroidapplication.layouts.ConstraintLayoutActivity;
import com.example.trainingandroidapplication.layouts.GridLayoutActivity;
import com.example.trainingandroidapplication.layouts.LinearLayoutActivity;
import com.example.trainingandroidapplication.layouts.RelativeLayoutActivity;
import com.example.trainingandroidapplication.lifecycle.LifecycleActivity;
import com.example.trainingandroidapplication.lists.ExpandableListActivity;
import com.example.trainingandroidapplication.lists.GridViewActivity;
import com.example.trainingandroidapplication.lists.ListViewActivity;
import com.example.trainingandroidapplication.lists.ListViewWithAdapterActivity;
import com.example.trainingandroidapplication.lists.SimpleAdapterActivity;
import com.example.trainingandroidapplication.notifications.NotificationsActivity;

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
            case R.id.button11:{
                Log.d(TAG, "onClick: FragmentActivity");
                Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button12:{
                Log.d(TAG, "onClick: ActionBarActivity");
                Intent intent = new Intent(MainActivity.this, ActionBarActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button13:{
                Log.d(TAG, "onClick: ExpandableListActivity");
                Intent intent = new Intent(MainActivity.this, ExpandableListActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button14:{
                Log.d(TAG, "onClick: SimpleAdapterActivity");
                Intent intent = new Intent(MainActivity.this, SimpleAdapterActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button15:{
                Log.d(TAG, "onClick: GridViewActivity");
                Intent intent = new Intent(MainActivity.this, GridViewActivity.class);
                startActivity(intent);
                break;
            }case R.id.button16:{
                Log.d(TAG, "onClick: PlayMusicServiceActivity");
                Intent intent = new Intent(MainActivity.this, PlayMusicServiceActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button17:{
                Log.d(TAG, "onClick: WriteAndReadFileActivity");
                Intent intent = new Intent(MainActivity.this, WriteAndReadFileActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button18:{
                Log.d(TAG, "onClick: LifecycleActivity");
                Intent intent = new Intent(MainActivity.this, LifecycleActivity.class);
                startActivity(intent);
                break;
            }case R.id.button19:{
                Log.d(TAG, "onClick: BroadcastActivity");
                Intent intent = new Intent(MainActivity.this, BroadcastActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
