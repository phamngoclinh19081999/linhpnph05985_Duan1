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
        arrayList.add(new Menu("1","SÚP HẢI SẢN ĐẬU PHỤ","Appetizer","58000",R.drawable.a1));
        arrayList.add(new Menu("2","SÚP GÀ NẤM","Appetizer","58000",R.drawable.a2));
        arrayList.add(new Menu("3","SÚP CUA, GÀ SỢI NGÔ NON","Appetizer","65000",R.drawable.a3));
        arrayList.add(new Menu("4","SÚP NẤM TÔM TƯƠI","Appetizer","58000",R.drawable.a4));
        arrayList.add(new Menu("5","GỎI SỨA TÔM THỊT","Appetizer","138000",R.drawable.a5));
        arrayList.add(new Menu("6","SALAD CỦ ĐẬU, DƯA LEO TRỘN DỪA TƯƠI","Appetizer","78000",R.drawable.a6));
        node_sachAdapter =new MenuAdapter(getActivity(),arrayList);
        Appetizer.setLayoutManager(linearLayoutManager);
        Appetizer.setHasFixedSize(true);
        Appetizer.setAdapter(node_sachAdapter);
        mData.child("Food").child("Appetizer").setValue(arrayList);
    }
    void addM(){
        arrayList = new ArrayList<>();
        arrayList.clear();
        arrayList.add(new Menu("1","BÒ NHÚNG DẤM CUỐN BÁNH TRÁNG","Maindishes","198000",R.drawable.m1));
        arrayList.add(new Menu("2","THỊT BA CHỈ RANG CHÁY CẠNH","Maindishes","78000",R.drawable.m2));
        arrayList.add(new Menu("3","THĂN HEO QUAY XÁ XÍU","Maindishes","118000",R.drawable.m3));
        arrayList.add(new Menu("4","THỊT HEO QUAY DA GIÒN","Maindishes","128000",R.drawable.m4));
        arrayList.add(new Menu("5","THỊT BA CHỈ TRỨNG CÚT KHO TỘ","Maindishes","98000",R.drawable.m5));
        arrayList.add(new Menu("6","NÕN ĐUÔI NƯỚNG","Maindishes","98000",R.drawable.m6));
        arrayList.add(new Menu("7","TÔM SÚ CHIÊN SẢ ỚT","Maindishes","215000",R.drawable.m7));
        arrayList.add(new Menu("8","TÔM CHAO MUỐI BỎ LÒ","Maindishes","248000",R.drawable.m8));
        arrayList.add(new Menu("9","CÁ LÓC CHIÊN GIÒN SỐT XÌ DẦU","Maindishes","268000",R.drawable.m9));
        arrayList.add(new Menu("10","CÁ DIÊU HỒNG HẤP XÌ DẦU KÈM BÚN","Maindishes","295000",R.drawable.m101));
        arrayList.add(new Menu("11","CÁ DIÊU HỒNG CHIÊN GIÒN","Maindishes","258000",R.drawable.m11));
        arrayList.add(new Menu("12","CÁ KHO TỘ","Maindishes","98000",R.drawable.m12));
        node_sachAdapter =new MenuAdapter(getActivity(),arrayList);
        Maindishes.setLayoutManager(abc);
        Maindishes.setHasFixedSize(true);
        Maindishes.setAdapter(node_sachAdapter);
        mData.child("Food").child("Maindishes").setValue(arrayList);
    }
    void addS(){
        arrayList = new ArrayList<>();
        arrayList.clear();
        arrayList.add(new Menu("1","RAU CỦ BỐN MÙA HẤP LỒNG CHẤM KHO QUẸT","Vegetables","78000",R.drawable.v1));
        arrayList.add(new Menu("2","NGỒNG TỎI XÀO","Vegetables","68000",R.drawable.v2));
        arrayList.add(new Menu("3","NGỒNG TỎI XÀO THỊT BÒ","Vegetables","128000",R.drawable.v3));
        arrayList.add(new Menu("4","NGỒNG TỎI XÀO NGAO","Vegetables","118000",R.drawable.v4));
        arrayList.add(new Menu("5","NGỒNG TỎI XÀO TÔM LỘT","Vegetables","115000",R.drawable.v5));
        arrayList.add(new Menu("6","BÔNG CẢI XANH THỊT BÒ XÀO NẤM","Vegetables","138000",R.drawable.v6));
        node_sachAdapter =new MenuAdapter(getActivity(),arrayList);
        Sup.setLayoutManager(abcd);
        Sup.setHasFixedSize(true);
        Sup.setAdapter(node_sachAdapter);
        mData.child("Food").child("Vegetables").setValue(arrayList);
    }
    void addD(){
        arrayList = new ArrayList<>();
        arrayList.clear();
        arrayList.add(new Menu("1","LẨU THÁI HẢI SẢN","Soup - Hot pot","438000",R.drawable.s1));
        arrayList.add(new Menu("2","LẨU RIÊU CUA SƯỜN SỤN BẮP BÒ","Soup - Hot pot","428000",R.drawable.s2));
        arrayList.add(new Menu("3","LẨU ẾCH MĂNG CAY","Soup - Hot pot","268000",R.drawable.s3));
        arrayList.add(new Menu("4","LẨU NẤM BỐN MÙA VỚI THỊT BÒ","Soup - Hot pot","458000",R.drawable.s4));
        arrayList.add(new Menu("5","LẨU CUA GIA VIÊN SÒ ĐIỆP","Soup - Hot pot","758000",R.drawable.s5));
        arrayList.add(new Menu("6","LẨU CUA GIA VIÊN CHUA CAY","Soup - Hot pot","758000",R.drawable.s6));
        node_sachAdapter =new MenuAdapter(getActivity(),arrayList);
        Desserts.setLayoutManager(abcde);
        Desserts.setHasFixedSize(true);
        Desserts.setAdapter(node_sachAdapter);
        mData.child("Food").child("Soup").setValue(arrayList);
    }
    void addDr(){
        arrayList = new ArrayList<>();
        arrayList.clear();
        arrayList.add(new Menu("1","TRÀ QUẤT NGÂM GỪNG MẬT ONG (CỐC)","Drinks","29000",R.drawable.d1));
        arrayList.add(new Menu("2","TRÀ HOA CÚC MẬT ONG (CỐC)","Drinks","29000",R.drawable.d2));
        arrayList.add(new Menu("3","TRÀ HOA HIBISCUS DỨA TƯƠI (CỐC)","Drinks","29000",R.drawable.d3));
        arrayList.add(new Menu("4","TRÀ CAM VỊ QUẾ (CỐC)","Drinks","29000",R.drawable.d4));
        arrayList.add(new Menu("5","TRÀ LONG NHÃN (CỐC)","Drinks","29000",R.drawable.d5));
        arrayList.add(new Menu("6","TRÀ HOA HIBISCUS DỨA TƯƠI (ẤM)","Drinks","55000",R.drawable.d6));
        node_sachAdapter =new MenuAdapter(getActivity(),arrayList);
        Drinks.setLayoutManager(abcdef);
        Drinks.setHasFixedSize(true);
        Drinks.setAdapter(node_sachAdapter);
        mData.child("Food").child("Drinks").setValue(arrayList);
    }
}
