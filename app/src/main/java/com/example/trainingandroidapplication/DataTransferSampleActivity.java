package com.example.trainingandroidapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class DataTransferSampleActivity extends AppCompatActivity {

    private static final String TAG = "DataTransferActivity";
    TextView textViewTitle;
    TextView textViewAuthor;
    Button buttonEditTitle;
    Button buttonEditAuthor;

    String title = "Руководство по андройду";
    String author = "Василий Пупкин";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_transfer_sample);

        textViewTitle = findViewById(R.id.textViewEmptyTitle);
        textViewAuthor = findViewById(R.id.textViewEmptyAuthor);

        buttonEditTitle = findViewById(R.id.buttonEditTitle);
        buttonEditAuthor = findViewById(R.id.buttonEditAuthor);

        buttonEditTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataTransferSampleActivity.this, EditTitleAndAuthorActivity.class);
                intent.putExtra(Tools.RESULT_VALUE, title);
                intent.putExtra(Tools.RESULT_KEY_CODE,Tools.RESULT_CODE_TITLE);
                startActivityForResult(intent, Tools.RESULT_CODE_TITLE);
            }
        });

        buttonEditAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataTransferSampleActivity.this, EditTitleAndAuthorActivity.class);
                intent.putExtra(Tools.RESULT_VALUE, author);
                intent.putExtra(Tools.RESULT_KEY_CODE,Tools.RESULT_CODE_AUTHOR);
                startActivityForResult(intent, Tools.RESULT_CODE_AUTHOR);
            }
        });
        updateTextViews();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == Tools.RESULT_CODE_TITLE) {
            title = data.getStringExtra(Tools.RESULT_VALUE);
        } else if (resultCode == Tools.RESULT_CODE_AUTHOR) {
            author = data.getStringExtra(Tools.RESULT_VALUE);
        }
        updateTextViews();

    }

    void updateTextViews() {
        textViewAuthor.setText("Author: " + author);
        textViewTitle.setText("Title: " + title);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
