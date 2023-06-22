package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        LinearLayout linear = new LinearLayout(this);
//        linear.setOrientation(LinearLayout.VERTICAL);
//
//        TextView mytext = new TextView(this);
//        mytext.setText("Mobile programming");
//
//
//        linear.addView(mytext);
//        setContentView(linear);
        SharedPreferences pref = getSharedPreferences("AccountPreference", MODE_PRIVATE);
        pref.getString("Username", null);
        pref.getString("Password", null);
        Button btnLogout = (Button) findViewById(R.id.myButton);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();
                editor.remove("Username");
                editor.remove("Password");
                editor.commit();

                //editor.clear()
                Intent intent = new Intent(MainActivity.this, ViewBindingActivity.class);
                startActivity(intent);
            }
        });
    }
}