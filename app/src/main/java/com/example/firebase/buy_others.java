package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class buy_others extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference ref;
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_others);

        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("OTher");
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Model,ViewHolder>firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                        Model.class,
                        R.layout.row,
                        ViewHolder.class,
                        ref
                ){

                    @Override
                    protected void populateViewHolder(ViewHolder holder, Model member, int i) {
                        holder.setView(getApplicationContext(),member.getName(),member.getId() ,member.getItem() , member.getQuantity() , member.getHostel() ,member.getPrice());

                    }
                };

        recyclerView.setAdapter(firebaseRecyclerAdapter );
    }
}

