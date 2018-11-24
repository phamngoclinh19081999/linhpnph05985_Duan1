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

import com.phamngoclinh.loginfbfirebase.R;
import com.phamngoclinh.loginfbfirebase.model.Menu;
import com.phamngoclinh.loginfbfirebase.viewholder.MenuHolder;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<MenuHolder> {
    private Context context;
    private ArrayList<Menu> arrayList;
    private ImageView imageView;
    private EditText editText;
    private TextView textView,textView1;
     Menu table;
    String soluong;
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
    public void onBindViewHolder(@NonNull MenuHolder holder, int position) {
        table= arrayList.get(position);
        holder.imgAnhmn.setImageResource(table.getAnh());
        holder.tvTen.setText(table.getTenmon());
        holder.tvGiaban.setText(table.getGiatien()+" VND");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_order);
                imageView = dialog.findViewById(R.id.imgAnhmonan);
                textView = dialog.findViewById(R.id.tvTenmonan);
                textView1 = dialog.findViewById(R.id.tvGiamonan);
                editText = dialog.findViewById(R.id.edtSoluong);

                imageView.setImageResource(table.getAnh());
                textView.setText(table.getTenmon());
                soluong = editText.getText().toString().trim();
                Runnabelq runnabelq = new Runnabelq(context,1);
                new Thread(runnabelq).start();



                dialog.findViewById(R.id.btnOrder).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

                dialog.findViewById(R.id.btnHuy).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();


            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Runnabelq implements Runnable{
        Context context;
        int second;

        public Runnabelq(Context context, int second) {
            this.context = context;
            this.second = second;
        }

        @Override
        public void run() {

            for (int i = 0;i<=1;i++){
                final Handler handler = new Handler(Looper.getMainLooper());
                final int a = i;
                handler.post(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void run() {
                        if (a==1){
                            Toast.makeText(context, ""+soluong, Toast.LENGTH_SHORT).show();
                            if (!soluong.equals("")){

                                textView1.setText(Integer.parseInt(soluong)*Integer.parseInt(table.getGiatien()));
                            }
                            Runnabelq runnabelq = new Runnabelq(context,1);
                            new Thread(runnabelq).start();
                        }

                    }
                });
                try {
                    Thread.sleep(500);
                }catch (Exception e){

                }
            }

        }
    }
}

