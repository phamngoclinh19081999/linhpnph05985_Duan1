package com.phamngoclinh.loginfbfirebase.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.phamngoclinh.loginfbfirebase.OderFoodActivity;
import com.phamngoclinh.loginfbfirebase.R;
import com.phamngoclinh.loginfbfirebase.model.Bill;
import com.phamngoclinh.loginfbfirebase.model.Food;
import com.phamngoclinh.loginfbfirebase.model.Menu;
import com.phamngoclinh.loginfbfirebase.viewholder.MenuHolder;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<MenuHolder> {
    private Context context;
    private ArrayList<Menu> arrayList;
    Menu table;
    ArrayList<Food> food;
    DatabaseReference mData;
    public OrderAdapter(Context context, ArrayList<Menu> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.cardview_menu,parent,false);
        mData = FirebaseDatabase.getInstance().getReference();
        return new MenuHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MenuHolder holder, final int position) {
        table= arrayList.get(position);
        holder.imgAnhmn.setImageResource(table.getAnh());
        holder.tvTen.setText(table.getTenmon());
        holder.tvGiaban.setText(table.getGiatien()+" VND");
        holder.tvSoluong.setText("0");
        holder.imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int soluong = Integer.parseInt(holder.tvSoluong.getText().toString()) + 1;
                    holder.tvSoluong.setText("" + soluong);
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
                if (!holder.checkBox.isChecked()){
                    holder.tvSoluong.setText("0");
                }
            }
        });
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (holder.checkBox.isChecked()){
                    food = new ArrayList<>();
                    food.clear();
                    food.add(new Food(arrayList.get(position).getTenmon(),arrayList.get(position).getGiatien(),holder.tvSoluong.getText().toString()));
                    mData.child("Order").push().setValue(food);
                    Toast.makeText(context, ""+position+arrayList.get(position).getTenmon()+arrayList.get(position).getGiatien(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "Ban da huy chon mon an !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}

