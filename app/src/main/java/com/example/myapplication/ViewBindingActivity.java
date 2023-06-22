package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class ViewBindingActivity extends AppCompatActivity {
    Button btnLogin;
    private String username, password;
    SeekBar mSeekBar;
    TextView mTextViewSeekBar;
    private Boolean checkState;



    @Override
    protected void onPause() {

        super.onPause();
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("Log State", "Luu trang thai Start");
    }

    String usernameReturn;
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        usernameReturn = data.getExtras().getString("username");
                        Log.d("username", usernameReturn);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_binding);



        btnLogin = (Button)findViewById(R.id.button_login);


        EditText mEditUsername = findViewById(R.id.name);
        EditText mEditPassword = findViewById(R.id.password);



        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                username = mEditUsername.getText().toString();
                password = mEditPassword.getText().toString();

                if(username.equals("admin") && password.equals("123456")){

                    SharedPreferences sharedPreferences = getSharedPreferences("AccountPreference", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Username", username);
                    editor.putString("Password", password);
                    editor.commit();

                    Intent intent = new Intent(ViewBindingActivity.this, MainActivity.class);
                    startActivity(intent);



//                    Toast.makeText(ViewBindingActivity.this,"Login successfully",Toast.LENGTH_SHORT).show();
//                    Intent i = new Intent(ViewBindingActivity.this, Example.class);
//                    startActivity(i);


//                    Intent read1 = new Intent();
//                    read1.setAction(Intent.ACTION_VIEW);
//                    read1.setData(ContactsContract.Contacts.CONTENT_URI);
//                    startActivity(read1);

//                    Uri uri = Uri.parse("https://www.facebook.com/");
//                    Intent it = new Intent(Intent.ACTION_VIEW,uri);
//                    startActivity(it);

//                    Uri uri = Uri.parse("tel:0961449648");
//                    Intent it = new Intent(Intent.ACTION_DIAL, uri);
//                    startActivity(it);

                    //Pass data from Activity A to Activity B
//                    Intent intent = new Intent(ViewBindingActivity.this, Example.class);
//                    intent.putExtra("Key", "Hello");
//                    startActivity(intent);





//
//                    Intent intent = new Intent(ViewBindingActivity.this, Example.class);
//                    intent.setData(Uri.parse("https://www.google.com/"));
//                    intent.putExtra("username", username);
//                    intent.putExtra("password", password);
//                    ArrayList<Integer> test = new ArrayList<>();
//                    test.add(1);
//                    test.add(2);
//                    test.add(3);
//                    intent.putIntegerArrayListExtra("data", test);
//                    startActivity(intent);





                }
                else {
                    Toast.makeText(ViewBindingActivity.this,"Login failed",Toast.LENGTH_SHORT).show();
                }
            }






        });




        Button come = findViewById(R.id.comeback);
        come.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CheckboxActivity.class);
                someActivityResultLauncher.launch(i);
            }
        });

        mSeekBar = findViewById(R.id.seekBarBindingView);
        mTextViewSeekBar = findViewById(R.id.txtSeekBarBindingView);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;
                Toast.makeText(ViewBindingActivity.this, String.valueOf(progress), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mTextViewSeekBar.setText("Covered: " + progress + "/" + mSeekBar.getMax());
            }
        });

        CheckBox mjava = findViewById(R.id.checkBoxViewBindingJava);
        mjava.setOnClickListener(view -> {
            Toast.makeText(this, "Java", Toast.LENGTH_SHORT).show();
        });

        CheckBox mPython = findViewById(R.id.checkBoxViewBindingPython);
        mPython.setOnClickListener(view -> {
            Toast.makeText(this, "Python", Toast.LENGTH_SHORT).show();
        });

        CheckBox mAndroid = findViewById(R.id.checkBoxViewBindingAndroid);
        mAndroid.setOnClickListener(view -> {
            Toast.makeText(this, "Android", Toast.LENGTH_SHORT).show();
        });

        RadioGroup radioGroup = findViewById(R.id.radioGroupViewBinding);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton) findViewById(i);
                Toast.makeText(ViewBindingActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        Spinner mSpinner = findViewById(R.id.planets_spinner);
        List<String> categories = new ArrayList<String>();
        categories.add("Item1");
        categories.add("Item2");
        categories.add("Item3");
        categories.add("Item4");
        categories.add("Item5");
        categories.add("Item6");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

        mSpinner.setOnItemSelectedListener((new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(ViewBindingActivity.this, item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        }));

        ToggleButton mToggleButton = findViewById(R.id.ToggleState);

        mToggleButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                checkState = ((ToggleButton)view).isChecked();
                if(checkState){
                    mToggleButton.setText("Play on");
                }else{
                    mToggleButton.setText("Play Off");
                }
            }
        });


    }
}