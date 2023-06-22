package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDAO {

    @Query("SELECT * FROM Product")
    List<Product> getALL();

    @Insert
    void insertAll(Product... products);

    @Query("SELECT * FROM Product WHERE name = :first")
    Product findName(String first);

    @Delete
    void Delete(Product product);


}
