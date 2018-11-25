package com.phamngoclinh.loginfbfirebase.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.phamngoclinh.loginfbfirebase.R;

public class MenuHolder extends RecyclerView.ViewHolder {
    public ImageView imgAnhmn,imgPlus,imgMinus;
    public TextView tvTen,tvGiaban,tvSoluong;
    public CheckBox checkBox;
    public MenuHolder(View itemView) {
        super(itemView);
        imgAnhmn = itemView.findViewById(R.id.imgAnhmn);
        tvTen = itemView.findViewById(R.id.tvTenmon);
        tvGiaban = itemView.findViewById(R.id.tvGia);
        imgPlus = itemView.findViewById(R.id.imgPlus);
        imgMinus = itemView.findViewById(R.id.imgMinus);
        checkBox = itemView.findViewById(R.id.cboOrder);
        tvSoluong = itemView.findViewById(R.id.tvSoluong);
    }
}
