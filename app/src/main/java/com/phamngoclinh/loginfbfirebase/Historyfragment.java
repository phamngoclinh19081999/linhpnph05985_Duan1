package com.phamngoclinh.loginfbfirebase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.phamngoclinh.loginfbfirebase.adapter.BillAdapter;
import com.phamngoclinh.loginfbfirebase.adapter.OrderAdapter;
import com.phamngoclinh.loginfbfirebase.adapter.TableAdapter;
import com.phamngoclinh.loginfbfirebase.model.Bill;
import com.phamngoclinh.loginfbfirebase.model.Food;
import com.phamngoclinh.loginfbfirebase.model.Table;

import java.util.ArrayList;

public class Historyfragment extends Fragment {
    private View layoutHistory;
    private RecyclerView recyclerBill;
    private LinearLayoutManager abcdef;
    private BillAdapter bill;
    DatabaseReference mData;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutHistory = inflater.inflate(R.layout.fragment_history,container,false);
        mData = FirebaseDatabase.getInstance().getReference();
        recyclerBill = layoutHistory.findViewById(R.id.recyclerBill);
        abcdef=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        AnhXa();
        return layoutHistory;
    }

    void AnhXa(){

        final ArrayList<Food> billArrayList = new ArrayList<>();
        mData.child("Bill").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                mData.child("Bill").child("1").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        Food hd = dataSnapshot.getValue(Food.class);
                        billArrayList.add(hd);
                        bill.notifyDataSetChanged();
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
        bill =new BillAdapter(getActivity(),billArrayList);
        recyclerBill.setLayoutManager(abcdef);
        recyclerBill.setHasFixedSize(true);
        recyclerBill.setAdapter(bill);

//        mData.child("Table").setValue(arrayList);
    }
}
