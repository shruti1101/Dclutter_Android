package com.example.firebase;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.jar.Attributes;

public class ViewHolder extends RecyclerView.ViewHolder {

    View view;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        view = itemView;
    }

    public void setView(Context context ,String name,String Quantity,String hostel,String id, String item, String price){

        TextView namevh = view.findViewById(R.id.name_textview);
        TextView idvh = view.findViewById(R.id.Id_textview);
        TextView hostelvh = view.findViewById(R.id.hostel_textview);
        TextView itemvh = view.findViewById(R.id.item_textview);
        TextView quantityvh = view.findViewById(R.id.quantity_textview);
        TextView pricevh = view.findViewById(R.id.price_textview);

        namevh.setText(name);
        idvh.setText(id);
        hostelvh.setText(hostel);
        itemvh.setText(item);
        quantityvh.setText(Quantity);
        pricevh.setText(price);

    }
}
