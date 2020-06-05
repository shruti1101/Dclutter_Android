package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;

public class BUY extends AppCompatActivity {
    Button books;
    Button other;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        books=(Button)findViewById(R.id.buy_books);
        other=(Button)findViewById(R.id.buy_others);
        sp=getSharedPreferences("mysharedpreference",MODE_PRIVATE);
        boolean flag= sp.getBoolean("status",false);
        if(flag)
        {
            Intent intent=new Intent(BUY.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BUY.this,buy_books.class);
                startActivity(intent);
            }
        });
        other.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            { Intent intent=new Intent(BUY.this,buy_others.class);
                startActivity(intent);

            }});


    }



}




