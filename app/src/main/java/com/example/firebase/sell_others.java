package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class sell_others extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;
    EditText id,name,hostel,item,quantity,price;
    int maxid = 0;
    Model member;
    Button submit;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_others);
        id=(EditText)findViewById(R.id.editText7);
        name=(EditText)findViewById(R.id.editText2);
        hostel=(EditText)findViewById(R.id.editText3);
        item=(EditText)findViewById(R.id.editText4);
        quantity=(EditText) findViewById(R.id.editText5);
        price=(EditText)findViewById(R.id.editText6);
        submit=(Button)findViewById(R.id.button);


        member = new Model();
        ref = database.getInstance().getReference().child("OTher");

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
                member.setId(id.getText().toString());
                member.setHostel(hostel.getText().toString());
                member.setItem(item.getText().toString());
                member.setQuantity(quantity.getText().toString());
                member.setPrice(price.getText().toString());


                ref.child(String.valueOf(maxid+1)).setValue(member);


            }

        });

    }

}
