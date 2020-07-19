package com.example.trainingandroidapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }


    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Вопрос!")
                .setMessage("Котик Компотик хороший котик?")
                .setPositiveButton("ДА, хороший!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"Котик Компотик хороший котик!",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Очень хороший!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"Котик Компотик ОЧЕНЬ хороший котик!",Toast.LENGTH_LONG).show();
                    }
                })
                .setCancelable(false)
                .create()
                .show();
    }
}
