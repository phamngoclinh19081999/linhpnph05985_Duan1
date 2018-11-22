package com.phamngoclinh.loginfbfirebase.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.phamngoclinh.loginfbfirebase.R;

public class TableHolder extends RecyclerView.ViewHolder {
    public ImageView imgAnh;
    public TextView tvSoban,tvSotang;
    public CheckBox cboOk;
    public TableHolder(View itemView) {
        super(itemView);

        imgAnh = itemView.findViewById(R.id.imgAnh);
        tvSoban = itemView.findViewById(R.id.tvSoban);
        tvSotang = itemView.findViewById(R.id.tvSotang);
        cboOk = itemView.findViewById(R.id.cboOK);
    }
}
