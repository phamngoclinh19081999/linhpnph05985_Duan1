package com.phamngoclinh.loginfbfirebase.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.phamngoclinh.loginfbfirebase.R;
import com.phamngoclinh.loginfbfirebase.model.Menu;
import com.phamngoclinh.loginfbfirebase.viewholder.MenuHolder;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuHolder> {
    private Context context;
    private ArrayList<Menu> arrayList;

    public MenuAdapter(Context context, ArrayList<Menu> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.cardview_menu,parent,false);
        return new MenuHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder holder, int position) {

        Menu table = arrayList.get(position);
        holder.imgAnhmn.setImageResource(table.getAnh());
        holder.tvTen.setText("Tên món : "+table.getTenmon());
        holder.tvGiaban.setText("Giá tiền : "+table.getGiatien());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
