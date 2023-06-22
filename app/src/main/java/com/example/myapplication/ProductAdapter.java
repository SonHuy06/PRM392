package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<ProductRecycle> mProduct;
    private Context mContext;

    public ProductAdapter(List<ProductRecycle> mProduct, Context mContext)
    {
        this.mProduct=mProduct;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View productView = inflater.inflate(R.layout.product_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(productView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductRecycle product = mProduct.get(position);
        holder.productName.setText(product.getmName());
        holder.quantity.setText(String.valueOf(product.getQuantity()));
        holder.price.setText(String.valueOf(product.getPrice()));

        Picasso.get()
                .load("https://en.kepoper.com/wp-content/uploads/2020/11/g-dragon-comeback-4-e1604306039472.jpg")
                .into(holder.imageView);



        }





    @Override
    public int getItemCount() {
        return mProduct.size();
    }




}
