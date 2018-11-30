package com.phamngoclinh.loginfbfirebase.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.phamngoclinh.loginfbfirebase.R;

public class BillHolder extends RecyclerView.ViewHolder {
    public ImageView imgBill;
    public TextView tvtableBill,tvMon1,tvMon2,tvMon3,tvMon4,tvMon5;
    public BillHolder(View itemView) {
        super(itemView);
        imgBill = itemView.findViewById(R.id.imgBill);
        tvMon1 = itemView.findViewById(R.id.tvMon1);
        tvtableBill = itemView.findViewById(R.id.tvBilltable);
        tvMon2 = itemView.findViewById(R.id.tvMon2);
        tvMon3 = itemView.findViewById(R.id.tvMon3);
        tvMon4 = itemView.findViewById(R.id.tvMon4);
    }
}
