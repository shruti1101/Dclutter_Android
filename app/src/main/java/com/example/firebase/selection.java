package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.content.SharedPreferences;
import android.os.Bundle;

public class selection extends AppCompatActivity {
    Button buy,sell;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        buy=(Button)findViewById(R.id.btn_buy);
        sell=(Button)findViewById(R.id.btn_sell);
        sp=getSharedPreferences("mysharedpreference",MODE_PRIVATE);
        boolean flag= sp.getBoolean("status",false);
        if(flag)
        {
            Intent intent=new Intent(selection.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(selection.this,BUY.class);
                startActivity(intent);
            }
        });
        sell.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            { Intent intent=new Intent(selection.this, SELL.class);
                startActivity(intent);

            }});


    }

}

