package com.example.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Example extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        if(getIntent() != null){
            String data = getIntent().getStringExtra("Key");
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        }

        Bundle extra = getIntent().getExtras();
        String username = extra.getString("username","");
        String password = extra.getString("password", "");
        ArrayList<Integer> test = extra.getIntegerArrayList("data");
        Uri uri = getIntent().getData();
        Log.d("TAG", username);
        Log.d("TAG1", password);
        Log.d("ListAge", test.get(2).toString());
        Log.d("data", uri.toString());


    }


}
