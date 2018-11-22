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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.phamngoclinh.loginfbfirebase.adapter.MenuAdapter;
import com.phamngoclinh.loginfbfirebase.model.Menu;

import java.util.ArrayList;

public class Menufragment extends Fragment {
    private View layoutMenu;
    private RecyclerView Appetizer,Maindishes,Sup,Desserts,Drinks;
    private LinearLayoutManager linearLayoutManager,abc,abcd,abcde,abcdef;
    private MenuAdapter node_sachAdapter;
    private ArrayList<Menu> arrayList;
    private DatabaseReference mData;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutMenu = inflater.inflate(R.layout.fragment_menu,container,false);
        Appetizer = layoutMenu.findViewById(R.id.recyclerA);
        Maindishes = layoutMenu.findViewById(R.id.recyclerM);
        Sup = layoutMenu.findViewById(R.id.recyclerS);
        Desserts = layoutMenu.findViewById(R.id.recyclerD);
        Drinks = layoutMenu.findViewById(R.id.recyclerDr);
        mData = FirebaseDatabase.getInstance().getReference();
        linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        abc=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        abcd=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        abcde=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        abcdef=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        addA();
        addM();
        addS();
        addD();
        addDr();
        return layoutMenu;
    }

    void addA(){
        arrayList = new ArrayList<>();
        arrayList.clear();
        arrayList.add(new Menu("1","Gỏi cóc non tai heo","Appetizer","100k",R.drawable.photo));
        arrayList.add(new Menu("2","Gỏi ngheu bắp chuối","Appetizer","100k",R.drawable.a2));
        arrayList.add(new Menu("3","Salat sốt chanh leo","Appetizer","100k",R.drawable.a3));
        arrayList.add(new Menu("4","Gỏi cóc non tai heo","Appetizer","100k",R.drawable.a4));
        node_sachAdapter =new MenuAdapter(getActivity(),arrayList);
        Appetizer.setLayoutManager(linearLayoutManager);
        Appetizer.setHasFixedSize(true);
        Appetizer.setAdapter(node_sachAdapter);
        mData.child("Food").setValue(arrayList);
    }
    void addM(){
        arrayList = new ArrayList<>();
        arrayList.clear();
        arrayList.add(new Menu("1","Gỏi cóc non tai heo","Appetizer","100k",R.drawable.photo));
        arrayList.add(new Menu("2","Gỏi ngheu bắp chuối","Appetizer","100k",R.drawable.a2));
        arrayList.add(new Menu("3","Salat sốt chanh leo","Appetizer","100k",R.drawable.a3));
        arrayList.add(new Menu("4","Gỏi cóc non tai heo","Appetizer","100k",R.drawable.a4));
        node_sachAdapter =new MenuAdapter(getActivity(),arrayList);
        Maindishes.setLayoutManager(abc);
        Maindishes.setHasFixedSize(true);
        Maindishes.setAdapter(node_sachAdapter);
    }
    void addS(){
        arrayList = new ArrayList<>();
        arrayList.clear();
        arrayList.add(new Menu("1","Gỏi cóc non tai heo","Appetizer","100k",R.drawable.photo));
        arrayList.add(new Menu("2","Gỏi ngheu bắp chuối","Appetizer","100k",R.drawable.a2));
        arrayList.add(new Menu("3","Salat sốt chanh leo","Appetizer","100k",R.drawable.a3));
        arrayList.add(new Menu("4","Gỏi cóc non tai heo","Appetizer","100k",R.drawable.a4));
        node_sachAdapter =new MenuAdapter(getActivity(),arrayList);
        Sup.setLayoutManager(abcd);
        Sup.setHasFixedSize(true);
        Sup.setAdapter(node_sachAdapter);
    }
    void addD(){
        arrayList = new ArrayList<>();
        arrayList.clear();
        arrayList.add(new Menu("1","Gỏi cóc non tai heo","Appetizer","100k",R.drawable.photo));
        arrayList.add(new Menu("2","Gỏi ngheu bắp chuối","Appetizer","100k",R.drawable.a2));
        arrayList.add(new Menu("3","Salat sốt chanh leo","Appetizer","100k",R.drawable.a3));
        arrayList.add(new Menu("4","Gỏi cóc non tai heo","Appetizer","100k",R.drawable.a4));
        node_sachAdapter =new MenuAdapter(getActivity(),arrayList);
        Desserts.setLayoutManager(abcde);
        Desserts.setHasFixedSize(true);
        Desserts.setAdapter(node_sachAdapter);
    }
    void addDr(){
        arrayList = new ArrayList<>();
        arrayList.clear();
        arrayList.add(new Menu("1","Gỏi cóc non tai heo","Appetizer","100k",R.drawable.photo));
        arrayList.add(new Menu("2","Gỏi ngheu bắp chuối","Appetizer","100k",R.drawable.a2));
        arrayList.add(new Menu("3","Salat sốt chanh leo","Appetizer","100k",R.drawable.a3));
        arrayList.add(new Menu("4","Gỏi cóc non tai heo","Appetizer","100k",R.drawable.a4));
        node_sachAdapter =new MenuAdapter(getActivity(),arrayList);
        Drinks.setLayoutManager(abcdef);
        Drinks.setHasFixedSize(true);
        Drinks.setAdapter(node_sachAdapter);
    }
}
