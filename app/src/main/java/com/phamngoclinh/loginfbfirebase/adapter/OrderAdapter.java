package com.phamngoclinh.loginfbfirebase.adapter;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.phamngoclinh.loginfbfirebase.R;
import com.phamngoclinh.loginfbfirebase.model.Menu;
import com.phamngoclinh.loginfbfirebase.viewholder.MenuHolder;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<MenuHolder> {
    private Context context;
    private ArrayList<Menu> arrayList;
    Menu table;
    public OrderAdapter(Context context, ArrayList<Menu> arrayList) {
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
    public void onBindViewHolder(@NonNull final MenuHolder holder, int position) {
        table= arrayList.get(position);
        holder.imgAnhmn.setImageResource(table.getAnh());
        holder.tvTen.setText(table.getTenmon());
        holder.tvGiaban.setText(table.getGiatien()+" VND");
        holder.tvSoluong.setText("0");
        holder.imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.checkBox.isChecked()) {
                    int soluong = Integer.parseInt(holder.tvSoluong.getText().toString()) + 1;
                    holder.tvSoluong.setText("" + soluong);
                }
                else {
                    Toast.makeText(context, "Bạn chưa chọn món ăn này !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soluong = Integer.parseInt(holder.tvSoluong.getText().toString())-1;
                if (soluong<0){
                    Toast.makeText(context, "Số lượng món ăn là 0 !!!", Toast.LENGTH_SHORT).show();
                }else {
                    holder.tvSoluong.setText(""+soluong);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}

