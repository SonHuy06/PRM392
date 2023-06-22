package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity {

    ArrayList<ProductRecycle> productRecycles;
    RecyclerView recyclerView;
    ProductAdapter productAdapter;

    AppDatabase db;
    ProductDAO productDAO;
    private void initRoomDatabase(){
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();
                productDAO = db.productDAO();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        recyclerView = findViewById(R.id.viewRecyclerProductList);
        initRoomDatabase();
        productRecycles = new ArrayList<ProductRecycle>();
        Product product = new Product();
        product.name = "Sony";
        product.quantity = 10;
        product.price = 105.1;
        productDAO.insertAll(product);
        List<Product> products = productDAO.getALL();
        Log.d("Kick thuoc " , String.valueOf(products.size()));
        for (Product product1 : products) {
            Log.d("name", product1.name);
            Log.d("quantity", String.valueOf(product1.quantity));
            Log.d("price", String.valueOf(product1.price));
            productRecycles.add(new ProductRecycle(product1.name, (double) product1.quantity, (int) product1.price));
        }


//        for (int i = 1; i <= 15; i++) {
//            productRecycles.add(new ProductRecycle("Product Name" + i, 1, 100 + i));
//        }
        productAdapter = new ProductAdapter(productRecycles, RecycleViewActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        TextView article_text = findViewById(R.id.article);
        registerForContextMenu(article_text);
    }



//    @Override
//    public boolean onContextItemSelected(@NonNull)

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        switch(item.getItemId()){
//            case R.id.option_setting:
//                showSettings();
//                return true;
//            case R.id.option_favorites:;
//                showFavorites();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    public void showSettings(){

    }

    public void showFavorites(){

    }
}