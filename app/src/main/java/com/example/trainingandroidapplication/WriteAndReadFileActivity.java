package com.example.trainingandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class WriteAndReadFileActivity extends AppCompatActivity {

    private static final String FILE_NAME = "/myFile.txt";

    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_and_read_file);
        textView = findViewById(R.id.textViewForReadFile);
        editText = findViewById(R.id.editTextForWriteFile);

    }


    void writeFile(MyObject myObject) {
        try {
            File file = new File(Environment.getExternalStorageDirectory().toString() + FILE_NAME);
            file.createNewFile();
            textView.setText("Saved to: "+file.getPath());
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(myObject);
            fileOutputStream.close();
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    MyObject readFile() {
        try {
            MyObject myObject;
            File file = new File(Environment.getExternalStorageDirectory().toString() + FILE_NAME);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            myObject = (MyObject) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
            return myObject;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonWriteFile: {
                String text = editText.getText().toString();
                MyObject myObject = new MyObject(text);
                writeFile(myObject);
                Toast.makeText(this,"Text written to the file!",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.buttonReadFile: {
                MyObject myObject = readFile();
                if (myObject != null) {
                    String text = myObject.getText();
                    textView.setText(text);
                    Toast.makeText(this,"Read success!",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this,"Read error!",Toast.LENGTH_SHORT).show();
                }
                break;
            }

        }
    }


}
