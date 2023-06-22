package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {
    @PrimaryKey(autoGenerate = true)
    public int pid;

    @ColumnInfo(name = "Name")
    public String name;

    @ColumnInfo(name = "Quantity")
    public int quantity;

    @ColumnInfo(name = "Price")
    public double price;
}
