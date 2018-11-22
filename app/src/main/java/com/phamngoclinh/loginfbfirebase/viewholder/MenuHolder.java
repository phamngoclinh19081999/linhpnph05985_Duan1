package com.phamngoclinh.loginfbfirebase.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.phamngoclinh.loginfbfirebase.R;

public class MenuHolder extends RecyclerView.ViewHolder {
    public ImageView imgAnhmn;
    public TextView tvTen,tvGiaban;
    public MenuHolder(View itemView) {
        super(itemView);
        imgAnhmn = itemView.findViewById(R.id.imgAnhmn);
        tvTen = itemView.findViewById(R.id.tvTenmon);
        tvGiaban = itemView.findViewById(R.id.tvGia);
    }
}
