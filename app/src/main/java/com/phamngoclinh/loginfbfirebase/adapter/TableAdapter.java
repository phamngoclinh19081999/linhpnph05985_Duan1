package com.phamngoclinh.loginfbfirebase.adapter;

import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.phamngoclinh.loginfbfirebase.R;
import com.phamngoclinh.loginfbfirebase.Tablefragment;
import com.phamngoclinh.loginfbfirebase.model.Table;
import com.phamngoclinh.loginfbfirebase.viewholder.TableHolder;

import java.util.ArrayList;

public class TableAdapter extends RecyclerView.Adapter<TableHolder> {
    private Tablefragment context;
    private ArrayList<Table> arrayList;

    public TableAdapter(Tablefragment context, ArrayList<Table> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public TableHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.cardview_table,parent,false);
        return new TableHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TableHolder holder, int position) {
        Table table = arrayList.get(position);
        holder.imgAnh.setImageResource(R.drawable.and);
        holder.tvSoban.setText("Số bàn: "+table.getSoban());
        holder.tvSotang.setText("Số tầng: "+table.getSotang());
        holder.cboOk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    context.activity();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
