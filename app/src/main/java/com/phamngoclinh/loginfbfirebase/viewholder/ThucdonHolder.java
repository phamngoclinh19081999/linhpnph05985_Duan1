package com.phamngoclinh.loginfbfirebase.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.phamngoclinh.loginfbfirebase.R;

public class ThucdonHolder extends RecyclerView.ViewHolder {
    public ImageView imgAnhmn;
    public TextView tvTen,tvGiaban;
    public ThucdonHolder(View itemView) {
        super(itemView);
        imgAnhmn = itemView.findViewById(R.id.imgAnhmns);
        tvTen = itemView.findViewById(R.id.tvTenmons);
        tvGiaban = itemView.findViewById(R.id.tvGias);
    }
}

