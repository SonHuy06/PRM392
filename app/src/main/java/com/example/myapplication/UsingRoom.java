package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

public class UsingRoom extends AppCompatActivity {


    AppDatabase db;
    ProductDAO productDAO;
    private void initRoomDatabase(){
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "productDatabase").allowMainThreadQueries().build();
        productDAO = db.productDAO();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_room);
        db.productDAO().insertAll(new Product());

    }
}