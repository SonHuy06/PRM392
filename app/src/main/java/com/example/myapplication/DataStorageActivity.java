package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class DataStorageActivity extends AppCompatActivity {

    EditText mEditText;
    AppDatabase db;

    private static final int READ_BLOCK_SIZE = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);

        Button btn= (Button) findViewById(R.id.dataStorageBtn);
        mEditText = findViewById(R.id.dataStorageEditText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    FileOutputStream fileOut = openFileOutput("myTextFile.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileOut);
                    outputWriter.write(mEditText.getText().toString());
                    outputWriter.close();

                } catch (Exception e) {
                    Log.d("Error", e.toString());
                }



            }
        });

        Button readBtn = (Button) findViewById(R.id.dataStorageReadBtn);
        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{

                    FileInputStream fileIn = openFileInput("myTextFile.txt");
                    char[] inBuffer = new char[READ_BLOCK_SIZE];
                    InputStreamReader inputStreamReader = new InputStreamReader(fileIn);
                    int charRead;
                    String s = "";
                    while((charRead = inputStreamReader.read(inBuffer)) > 0){
                        String readString  = String.copyValueOf(inBuffer, 0, charRead);
                        s += readString;
                    };
                    inputStreamReader.close();
                    TextView txtView = (TextView) findViewById(R.id.dataStorageTextView);
                    txtView.setText(s);

                }catch (Exception e){
                    e.printStackTrace();
                }



            }
        });

    }
}