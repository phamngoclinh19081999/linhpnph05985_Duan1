package com.phamngoclinh.loginfbfirebase.adapter;

import android.support.annotation.NonNull;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.phamngoclinh.loginfbfirebase.R;
import com.phamngoclinh.loginfbfirebase.Tablefragment;
import com.phamngoclinh.loginfbfirebase.model.Table;
import com.phamngoclinh.loginfbfirebase.viewholder.TableHolder;

import java.util.ArrayList;

public class TableAdapter extends RecyclerView.Adapter<TableHolder> {
    private Tablefragment context;
    private ArrayList<Table> arrayList;
    DatabaseReference mData;
    final ArrayList<Table> dr = new ArrayList<>();

    public TableAdapter(Tablefragment context, ArrayList<Table> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public TableHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.cardview_table,parent,false);
        mData = FirebaseDatabase.getInstance().getReference();
        return new TableHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TableHolder holder, final int position) {
        final Table table = arrayList.get(position);
        holder.imgAnh.setImageResource(R.drawable.and);
        holder.tvSoban.setText("Số bàn: "+table.getSoban());
        holder.tvSotang.setText("Số tầng: "+table.getSotang());
        holder.cboOk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    context.activity(position);

                    dr.clear();
                    mData.child("Table").addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                                Log.e("ABC",dataSnapshot.getKey());
                                Table table1 = dataSnapshot.getValue(Table.class);
                                dr.add(table1);
                                abc(position);
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
            }
        });
        mData.child("Table").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    Table ta = dataSnapshot.getValue(Table.class);
                    dr.add(ta);
                    Log.e("RRROOO", "" + ta);
                    if (dr.size()>1) {
                        if (dr.get(position).getStatus().equals("1")) {
                            holder.tvSoban.setText("Số bàn: " + "Đã có người đặt !!!");
                            holder.cboOk.setClickable(false);
                        } else {
                            holder.tvSoban.setText("Số bàn: " + table.getSoban());
                        }
//                abcd(position,holder);
                    }
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
    public int getItemCount() {
        return arrayList.size();
    }
    public  void abc(int position){


        if (!dr.isEmpty()&& dr.size()==7){
            Table table2 = new Table();
            table2.setId(dr.get(position).getId());
            table2.setSoban(dr.get(position).getSoban());
            table2.setSotang(dr.get(position).getSotang());
            table2.setStatus("1");
            dr.set(position,table2);
            mData.child("Table").setValue(dr);
        }
    }
    public  void abcd(int position,TableHolder holder){

        if (!dr.isEmpty()&& dr.size()==7){
            Table table2 = new Table();
            table2.setId(dr.get(position).getId());
            table2.setSoban(dr.get(position).getSoban());
            table2.setSotang(dr.get(position).getSotang());
            table2.setStatus(dr.get(position).getStatus());
            if (table2.getStatus().equals("1")){

                holder.tvSoban.setText("Số bàn: "+"Đã có người đặt !!!");
                holder.cboOk.setClickable(false);
            }
            else {
                holder.tvSoban.setText("Số bàn: "+table2.getSoban());
            }
        }
    }
}
