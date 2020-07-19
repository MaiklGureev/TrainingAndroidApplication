package com.example.trainingandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.function.ToLongBiFunction;

public class EditTitleAndAuthorActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewValue;
    EditText editTextValue;
    Button buttonOkey;
    int resultCode;
    String oldValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_title_and_author);

        textViewValue = findViewById(R.id.textViewValue);
        editTextValue = findViewById(R.id.editTextValue);
        buttonOkey = findViewById(R.id.buttonOkey);

        Bundle bundle = getIntent().getExtras();
        oldValue = bundle.getString(Tools.RESULT_VALUE);
        resultCode = bundle.getInt(Tools.RESULT_KEY_CODE);
        if (resultCode == Tools.RESULT_CODE_TITLE) {
            textViewValue.setText("Title:");
        } else if (resultCode == Tools.RESULT_CODE_AUTHOR) {
            textViewValue.setText("Author:");
        }
        editTextValue.setText(oldValue);

    }

    public void onClick(View view) {
        if (resultCode == Tools.RESULT_CODE_TITLE) {
            Intent intent = new Intent();
            String res = editTextValue.getText().toString();
            intent.putExtra(Tools.RESULT_VALUE, res);
            setResult(Tools.RESULT_CODE_TITLE, intent);
            finish();
        } else if (resultCode == Tools.RESULT_CODE_AUTHOR) {
            Intent intent = new Intent();
            String res = editTextValue.getText().toString();
            intent.putExtra(Tools.RESULT_VALUE, res);
            setResult(Tools.RESULT_CODE_AUTHOR, intent);
            finish();

        }
    }
}
