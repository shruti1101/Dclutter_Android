package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.view.View;
import android.text.TextUtils;
import android.util.Patterns;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText id,name,hostel,password;
    Button register;
    SharedPreferences sp;
    String edname;
    FirebaseDatabase database;
    DatabaseReference reff;
     Member men;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id=(EditText)findViewById(R.id.register_id);
        name=(EditText)findViewById(R.id.register_name);
        hostel=(EditText)findViewById(R.id.register_hostel);
        password=(EditText)findViewById(R.id.register_pass);
        register=(Button)findViewById(R.id.regis);
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        reff= database.getReference();
        men=new Member();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_id= id.getText().toString();
                String txt_pass = password.getText().toString();
                if(TextUtils.isEmpty(txt_id )||(TextUtils .isEmpty(txt_pass)))
                    Toast.makeText(MainActivity.this,"Fields are empty",Toast.LENGTH_SHORT).show();
                else if(txt_pass.length()<8)
                    Toast.makeText(MainActivity.this,"Password too short",Toast.LENGTH_SHORT).show();
                else
                registeredUser(txt_id,txt_pass);
            }
        });

    }
   private void registeredUser(String id, String password)
    {
        auth.createUserWithEmailAndPassword(id,password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this , "registering user successful" ,Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "registeration failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


