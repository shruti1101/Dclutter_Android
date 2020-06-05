package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SELL extends AppCompatActivity {

    Button books,others;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        books = (Button) findViewById(R.id.sell_books);
        others = (Button) findViewById(R.id.sell_others);
        sp = getSharedPreferences("mysharedpreference", MODE_PRIVATE);
        boolean flag = sp.getBoolean("status", false);
        if (flag) {
            Intent intent = new Intent(SELL.this, selection.class);
            startActivity(intent);
            finish();
        }
        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SELL.this, sell_books.class);
                startActivity(intent);
            }
        });
        others.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(SELL.this, sell_others.class);
                startActivity(intent);
            }
        });
    }}

