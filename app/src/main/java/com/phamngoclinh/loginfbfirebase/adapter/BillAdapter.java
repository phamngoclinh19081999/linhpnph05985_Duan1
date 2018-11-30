package com.phamngoclinh.loginfbfirebase.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.phamngoclinh.loginfbfirebase.R;
import com.phamngoclinh.loginfbfirebase.model.Bill;
import com.phamngoclinh.loginfbfirebase.model.Food;
import com.phamngoclinh.loginfbfirebase.viewholder.BillHolder;

import java.util.ArrayList;

public class BillAdapter extends RecyclerView.Adapter<BillHolder> {
    private Context context;
    private ArrayList<Food> listBill;

    public BillAdapter(Context context, ArrayList<Food> listBill) {
        this.context = context;
        this.listBill = listBill;
    }

    @NonNull
    @Override
    public BillHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.card_bill,parent,false);
        return new BillHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BillHolder holder, int position) {
        Food bill = listBill.get(position);
        holder.imgBill.setImageResource(R.drawable.bill);
        holder.tvMon1.setText("Tên món: "+bill.getFood());
        holder.tvMon2.setText("Giá bán: "+bill.getGia()+" VND");
        holder.tvMon3.setText("Số lượng: "+bill.getSo());
        holder.tvMon4.setText("Tổng tiền: "+Integer.parseInt(bill.getSo())*Integer.parseInt(bill.getGia())+" VND");

    }

    @Override
    public int getItemCount() {
        return listBill.size();
    }
}
