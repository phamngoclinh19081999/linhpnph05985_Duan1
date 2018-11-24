package com.phamngoclinh.loginfbfirebase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.phamngoclinh.loginfbfirebase.adapter.OrderAdapter;
import com.phamngoclinh.loginfbfirebase.model.Menu;

import java.util.ArrayList;

public class FragmentDesserts extends Fragment {
    private RecyclerView recyclerviewBook;
    private LinearLayoutManager linearLayoutManager;
    private OrderAdapter bookAdapter;
    private ArrayList<Menu> bookArrayList;
    DatabaseReference mData;
    private View layoutHome;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutHome = inflater.inflate(R.layout.fragment_deserts,container,false);
        mData = FirebaseDatabase.getInstance().getReference();
        recycler();
        return layoutHome;
    }

    public void recycler(){
        recyclerviewBook = layoutHome.findViewById(R.id.recycleOrderD);
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        bookArrayList = new ArrayList<>();
        mData.child("Food").child("Soup").addChildEventListener(new ChildEventListener() {
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



        bookAdapter=new OrderAdapter(getActivity(),bookArrayList);
        recyclerviewBook.setLayoutManager(linearLayoutManager);
        recyclerviewBook.setHasFixedSize(true);
        recyclerviewBook.setAdapter(bookAdapter);

    }
}
