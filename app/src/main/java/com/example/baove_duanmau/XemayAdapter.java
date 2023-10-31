package com.example.baove_duanmau;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class XemayAdapter extends RecyclerView.Adapter<XemayAdapter.ViewHolder> {
    private Context context;
    private ArrayList<XeMay> list;
    private XeMayDao xeMayDao;

    public XemayAdapter(Context context, ArrayList<XeMay> list, XeMayDao xeMayDao) {
        this.context = context;
        this.list = list;
        this.xeMayDao = xeMayDao;
    }

    @NonNull
    @Override
    public XemayAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_xemay,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull XemayAdapter.ViewHolder holder, int position) {
        int trangthai = list.get(position).getTrangthai();
        if (trangthai==1){
            holder.txtma.setText("XM"+list.get(position).getId());
            holder.txtten.setText(list.get(position).getTenxe());
            holder.txtgia.setText(String.valueOf(list.get(position).getGiaban()));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void addItem(XeMay xeMay) {
        list.clear();
        list.addAll(xeMayDao.getXeMay());
        notifyItemInserted(list.size() - 1);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtma, txtten,txtgia;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtma = itemView.findViewById(R.id.maxm);
            txtten = itemView.findViewById(R.id.tenxm);
            txtgia = itemView.findViewById(R.id.giaban);
        }
    }
}
