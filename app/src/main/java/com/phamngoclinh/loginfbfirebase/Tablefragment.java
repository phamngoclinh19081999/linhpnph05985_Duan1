package com.phamngoclinh.loginfbfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.phamngoclinh.loginfbfirebase.adapter.TableAdapter;
import com.phamngoclinh.loginfbfirebase.model.Table;

import java.util.ArrayList;

public class Tablefragment extends Fragment {
    private View layoutTable;
    private RecyclerView recyclerviewT;
    private LinearLayoutManager linearLayoutManager;
    private TableAdapter node_sachAdapter;
    private ArrayList<Table> arrayList;
    private DatabaseReference mData;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutTable = inflater.inflate(R.layout.fragment_table,container,false);
        mData = FirebaseDatabase.getInstance().getReference();
        AnhXa();
        return layoutTable;
    }

    void AnhXa(){
        recyclerviewT = layoutTable.findViewById(R.id.recyclerT);
        linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        arrayList=new ArrayList<>();
        arrayList.clear();
        arrayList.add(new Table("1","1","1","0"));
        arrayList.add(new Table("2","2","1","0"));
        arrayList.add(new Table("3","3","1","0"));
        arrayList.add(new Table("4","4","1","0"));
        arrayList.add(new Table("5","5","1","0"));
        arrayList.add(new Table("6","6","1","0"));
        arrayList.add(new Table("7","7","1","0"));
        node_sachAdapter =new TableAdapter(Tablefragment.this,arrayList);
        recyclerviewT.setLayoutManager(linearLayoutManager);
        recyclerviewT.setHasFixedSize(true);
        recyclerviewT.setAdapter(node_sachAdapter);
        mData.child("Table").setValue(arrayList);
    }
    public void activity(){
        Intent intent = new Intent(getActivity(),OderFoodActivity.class);
        startActivity(intent);
    }
}
