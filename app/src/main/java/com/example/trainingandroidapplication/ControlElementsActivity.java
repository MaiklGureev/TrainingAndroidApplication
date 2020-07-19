package com.example.trainingandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ControlElementsActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    EditText editText;
    ToggleButton toggleButton;
    CheckBox checkBox;
    Switch aSwitch;
    Spinner spinner;
    String[] books = new String[]{"book1","book2","book3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_elements);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        toggleButton = findViewById(R.id.toggleButton);
        checkBox = findViewById(R.id.checkBox);
        aSwitch = findViewById(R.id.switch1);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,books);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String msg = String.format("Selected %s in spinner!",books[position]);
                textView.setText(msg);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button: {
                String msg = String.format("Click on button!");
                textView.setText(msg);
                break;
            }
            case R.id.toggleButton: {
                boolean toggle = toggleButton.isChecked();
                String msg = String.format("Toggle button is %b!", toggle);
                textView.setText(msg);
                break;
            }
            case R.id.checkBox: {
                boolean check = checkBox.isChecked();
                String msg = String.format("Check box is %b!", check);
                textView.setText(msg);
                break;
            }
            case R.id.radioButton1: {

                String msg = String.format("Selected radioButton1!");
                textView.setText(msg);
                break;
            }
            case R.id.radioButton2: {
                String msg = String.format("Selected radioButton2!");
                textView.setText(msg);
                break;
            }
            case R.id.radioButton3: {
                String msg = String.format("Selected radioButton3!");
                textView.setText(msg);
                break;
            }
            case R.id.switch1: {
                boolean switcher = aSwitch.isChecked();
                String msg = String.format("Switch is %b!", switcher);
                textView.setText(msg);
                break;
            }
        }
    }


}
