package com.example.firebase;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.jar.Attributes;

public class Holder extends RecyclerView.ViewHolder {

    View view;
    public Holder(@NonNull View itemView) {
        super(itemView);

        view = itemView;
    }

    public void setView(Context context ,String name,String course,String hostel, String price){

        TextView nametv = view.findViewById(R.id.name_tv);
        TextView coursetv = view.findViewById(R.id.course_tv);
        TextView hosteltv = view.findViewById(R.id.hostel_tv);
        TextView pricetv = view.findViewById(R.id.price_tv);

        nametv.setText(name);
        coursetv.setText(course);
        hosteltv.setText(hostel);
        pricetv.setText(price);

    }
}
