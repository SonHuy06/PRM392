package com.example.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView productName;
    public TextView quantity, price, oldPrice, desciption;

    public Button detail_button;
    public ImageView imageView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.viewRecycleImage);
        productName = itemView.findViewById(R.id.viewRecycleProductName);
        quantity = itemView.findViewById(R.id.viewRecycleProductQuantity);
        price = itemView.findViewById(R.id.viewRecycleProductPrice);
        detail_button = itemView.findViewById(R.id.btnRecycleIdDetail);
        detail_button.setId(getAdapterPosition());

        detail_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "vi tri" + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
