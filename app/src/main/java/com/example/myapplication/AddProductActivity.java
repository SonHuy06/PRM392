package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class AddProductActivity extends AppCompatActivity {

    EditText eName, ePrice, eQuantity;
    Button btnAdd, btnList;
    String name;
    int quantity;
    double price;

    AppDatabase db;
    ProductDAO productDAO;
    private void initRoomDatabase(){
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();
        productDAO = db.productDAO();
    }

    ArrayList<ProductRecycle> productRecycles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        btnList = (Button) findViewById(R.id.AddProductActivityListBtn);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddProductActivity.this, RecycleViewActivity.class);
                startActivity(i);
            }
        });

        btnAdd = (Button) findViewById(R.id.AddProductActivityAddBtn);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eName = findViewById(R.id.AddProductActivityTextPName);
                ePrice = findViewById(R.id.AddProductActivityTextPPrice);
                eQuantity = findViewById(R.id.AddProductActivityTextPQuantity);

                name = eName.getText().toString();
                price = Double.parseDouble(ePrice.getText().toString());
                quantity = Integer.parseInt(eQuantity.getText().toString());
                initRoomDatabase();
                Product p = new Product();
                p.name = name;
                p.quantity = quantity;
                p.price = price;
                productDAO.insertAll(p);
            }
        });



    }
}