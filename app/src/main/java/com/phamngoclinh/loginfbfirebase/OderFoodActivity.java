package com.phamngoclinh.loginfbfirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.phamngoclinh.loginfbfirebase.adapter.OrderAdapter;
import com.phamngoclinh.loginfbfirebase.model.Menu;

import java.util.ArrayList;

public class OderFoodActivity extends AppCompatActivity {
    private RecyclerView Appetizer;
    private LinearLayoutManager ab;
    private OrderAdapter bookAdapter;
    DatabaseReference mData;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oder_food);
        mData = FirebaseDatabase.getInstance().getReference();
        intent = getIntent();
        Log.e("BBCC",intent.getStringExtra("soban"));
        Toast.makeText(this, ""+intent.getStringExtra("soban"), Toast.LENGTH_SHORT).show();

        Appetizer = findViewById(R.id.recyclerA);

        mData = FirebaseDatabase.getInstance().getReference();
        ab=new LinearLayoutManager(OderFoodActivity.this,LinearLayoutManager.VERTICAL,false);

        addA();

    }
    public void addA(){
        final ArrayList<Menu> bookArrayList = new ArrayList<>();
        mData.child("Food").child("Appetizer").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Menu menu = dataSnapshot.getValue(Menu.class);
                bookArrayList.add(menu);
                bookAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        bookAdapter=new OrderAdapter(OderFoodActivity.this,bookArrayList);
        Appetizer.setLayoutManager(ab);
        Appetizer.setHasFixedSize(true);
        Appetizer.setAdapter(bookAdapter);

    }


    public void clA(View view) {
        Intent intent1 = new Intent(OderFoodActivity.this,MaindishesActivity.class);
        intent1.putExtra("soban",intent.getStringExtra("soban"));
        startActivity(intent1);
    }

    public void huyA(View view) {
        Toast.makeText(this, "Liên hệ với nhân viên phục vụ để hủy đặt bàn !!!", Toast.LENGTH_SHORT).show();
    }
}
