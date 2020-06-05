package com.example.firebase;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;



import org.w3c.dom.Text;

import java.security.KeyStore;
import java.security.PrivateKey;

public class login extends AppCompatActivity {
    Button log, reg;
    TextView smart, pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        smart = (EditText) findViewById(R.id.sid);
        pw = (EditText) findViewById(R.id.pid);
        log = (Button) findViewById(R.id.login_btn);
        reg = (Button) findViewById(R.id.register_btn);
        reg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(login.this, MainActivity.class);
                startActivity(i);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_smart=smart.getText().toString();
                String txt_pw=pw.getText().toString();

                if(txt_smart.isEmpty() || txt_pw.isEmpty())
                {
                    Toast.makeText(login.this,"Please fill the Field",Toast.LENGTH_SHORT).show();
                }
                else if(txt_smart.equals("admin") && txt_pw.equals("teacher"))
                {
                    Intent i = new Intent(login.this, Modify.class);
                    startActivity(i);
                }
                else
                {
                            Intent i = new Intent(login.this, selection.class);
                            startActivity(i);
                }

            }
        });
    }

}

