package com.example.trainingandroidapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.method.CharacterPickerDialog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    Handler h;
    ProgressDialog progressDialog;
    Calendar calendar = Calendar.getInstance();
    int year;
    int month;
    int day;
    int hour;
    int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonShowSimpleDialog: {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Вопрос!")
                        .setMessage("Котик Компотик хороший котик?")
                        .setPositiveButton("ДА, хороший!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogActivity.this, "Котик Компотик хороший котик!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Очень хороший!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogActivity.this, "Котик Компотик ОЧЕНЬ хороший котик!", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setCancelable(false)
                        .create()
                        .show();
                break;
            }
            case R.id.buttonShowProgressDialog: {
                progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("My title");
                progressDialog.setMessage("Message");
                progressDialog.setCancelable(true);
                progressDialog.setCanceledOnTouchOutside(true);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.incrementProgressBy(40);
                progressDialog.incrementSecondaryProgressBy(50);
                progressDialog.setMax(100);

                progressDialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        progressDialog.dismiss();
                    }
                });

                progressDialog.show();
                break;
            }
            case R.id.buttonShowCharacterPickerDialog: {
                Editable editable = new SpannableStringBuilder();
                editable.append("a");
                final CharacterPickerDialog characterPickerDialog =
                        new CharacterPickerDialog(this, v, editable, "abcd", false) {
                            @Override
                            public void onClick(View v) {
                                Button button = (Button) v;
                                Toast.makeText(v.getContext(), "Selected <<" + button.getText() + ">>!",
                                        Toast.LENGTH_SHORT).show();
                                dismiss();
                            }

                        };
                characterPickerDialog.show();
                break;
            }
            case R.id.buttonShowDatePickerDialog: {

                DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        Toast.makeText(DialogActivity.this, calendar.getTime().toString(), Toast.LENGTH_LONG).show();
                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(this, onDateSetListener, year, month, day);
                datePickerDialog.show();
                break;
            }
            case R.id.buttonShowTimePickerDialog: {
                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);

                        Toast.makeText(DialogActivity.this, calendar.getTime().toString(), Toast.LENGTH_LONG).show();
                    }
                };

                TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hour, minute, true);
                timePickerDialog.show();
                break;
            }
            case R.id.buttonShowCustomDialog: {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DialogActivity.this);
                View customView = getLayoutInflater().inflate(R.layout.custom_dialog, null);
                final EditText editText = customView.findViewById(R.id.editTextCustomDialogName);

                alertDialog.setView(customView);
                alertDialog.setPositiveButton("Okey", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String message = String.format("Name is %s!", editText.getText());
                        Toast.makeText(DialogActivity.this, message, Toast.LENGTH_LONG).show();
                    }
                });

                alertDialog.setNegativeButton("Cancel", null);
                alertDialog.show();
                break;
            }
        }


    }
}
