package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Modify extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference ref;
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_books);

        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("User");
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Member,Holder>firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Member, Holder>(
                        Member.class,
                        R.layout.identify,
                        Holder.class,
                        ref
                ){

                    @Override
                    protected void populateViewHolder(Holder holder, Member member, int i) {
                        holder.setView(getApplicationContext(),member.getName(), member.getCourse() , member.getHostel() ,member.getPrice());

                    }
                };

        recyclerView.setAdapter(firebaseRecyclerAdapter );
    }

}
