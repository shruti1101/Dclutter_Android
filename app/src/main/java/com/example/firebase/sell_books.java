package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class sell_books extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;
    EditText id,name,hostel,course,year,price;
    int maxid = 0;
    Member member;
    Button submit;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_books);
        id=(EditText)findViewById(R.id.sell_t);
        name=(EditText)findViewById(R.id.sell_name);
        hostel=(EditText)findViewById(R.id.sell_hostel);
        course=(EditText)findViewById(R.id.sell_course);
        price=(EditText)findViewById(R.id.sell_price);
        submit=(Button)findViewById(R.id.sell_sub);


        member = new Member();
        ref = database.getInstance().getReference().child("User");

        ref.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    maxid = (int) dataSnapshot.getChildrenCount();
                }else{
                    ///
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databseError) {

            }
        });
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){


                    member.setName(name.getText().toString());
                    member.setType(id.getText().toString());
                    member.setHostel(hostel.getText().toString());
                    member.setCourse(course.getText().toString());
                    member.setPrice(price.getText().toString());


                    ref.child(String.valueOf(maxid+1)).setValue(member);


                }

        });

    }
}