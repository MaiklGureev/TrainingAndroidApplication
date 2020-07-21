package com.example.trainingandroidapplication.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.trainingandroidapplication.R;

public class FragmentActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private MyFirstFragment myFirstFragment;
    private MySecondFragment mySecondFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        fragmentManager = getSupportFragmentManager();
        myFirstFragment = new MyFirstFragment();
        mySecondFragment = new MySecondFragment();

    }

    public void onClick(View view) {
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (view.getId()){
            case R.id.buttonFragmentAdd:{
                if(fragmentManager.findFragmentByTag("first")==null){
                    fragmentTransaction.add(R.id.frameLayout,myFirstFragment,"first").commit();
                    Toast.makeText(this,"Add myFirstFragment",Toast.LENGTH_SHORT).show();
                }

                break;
            }
            case R.id.buttonFragmentRemove:{
                if(fragmentManager.findFragmentByTag("first")!=null){
                    fragmentTransaction.remove(myFirstFragment).commit();
                    Toast.makeText(this,"Remove myFirstFragment",Toast.LENGTH_SHORT).show();
                }else if(fragmentManager.findFragmentByTag("second")!=null){
                    fragmentTransaction.remove(mySecondFragment).commit();
                    Toast.makeText(this,"Remove mySecondFragment",Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.buttonFragmentReplace:{
                if(fragmentManager.findFragmentByTag("first")!=null){
                    fragmentTransaction.replace(R.id.frameLayout,mySecondFragment,"second").commit();
                    Toast.makeText(this,"Replace on mySecondFragment",Toast.LENGTH_SHORT).show();
                }else if(fragmentManager.findFragmentByTag("second")!=null){
                    fragmentTransaction.replace(R.id.frameLayout,myFirstFragment,"first").commit();
                    Toast.makeText(this,"Replace on myFirstFragment",Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.buttonFragmentHide:{
                if(fragmentManager.findFragmentByTag("first")!=null){
                    fragmentTransaction.hide(myFirstFragment).commit();
                    Toast.makeText(this,"Hide myFirstFragment",Toast.LENGTH_SHORT).show();
                }else if(fragmentManager.findFragmentByTag("second")!=null){
                    fragmentTransaction.hide(mySecondFragment).commit();
                    Toast.makeText(this,"Hide mySecondFragment",Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.buttonFragmentShow:{
                if(fragmentManager.findFragmentByTag("first")!=null){
                    fragmentTransaction.show(myFirstFragment).commit();
                    Toast.makeText(this,"Show myFirstFragment",Toast.LENGTH_SHORT).show();
                }else if(fragmentManager.findFragmentByTag("second")!=null){
                    fragmentTransaction.show(mySecondFragment).commit();
                    Toast.makeText(this,"Show mySecondFragment",Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}
