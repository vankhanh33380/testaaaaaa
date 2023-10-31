package com.example.baove_duanmau;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;
    private ArrayList<XeMay> list;
    private XeMayDao xeMayDao;
    private  XemayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton = findViewById(R.id.addXM);
        recyclerView = findViewById(R.id.recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        xeMayDao = new XeMayDao(this);
        list = xeMayDao.getXeMay();
        adapter = new XemayAdapter(this,list,xeMayDao);
        recyclerView.setAdapter(adapter);
        
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDailogadd();
            }
        });
    
    }

    private void showDailogadd() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogadd, null);
        builder.setView(view);

        AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(true);
        alertDialog.show();

        TextInputEditText edtTen = view.findViewById(R.id.edtTenXM);
        TextInputEditText edtGia = view.findViewById(R.id.edtGiaXM);
        Button btnadd = view.findViewById(R.id.add);
        Button btnback = view.findViewById(R.id.back);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten;
                String gia;
                int trangthai=1;

                ten = edtTen.getText().toString().trim();
                gia = edtGia.getText().toString().trim();

                if (ten.isEmpty() || gia.isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    if (ten.isEmpty()){
                        Toast.makeText(MainActivity.this, "Không được bỏ trống tên", Toast.LENGTH_SHORT).show();
                    }
                    if (String.valueOf(gia).isEmpty()){
                        Toast.makeText(MainActivity.this, "Không được bỏ trống giá", Toast.LENGTH_SHORT).show();
                    }
                } else {
                   xeMayDao = new XeMayDao(MainActivity.this);
                   XeMay xeMay = new XeMay(ten,Integer.parseInt(gia),trangthai);
                   if (xeMayDao.addXeMay(xeMay)) {
                       adapter.addItem(xeMay);
                       adapter.notifyDataSetChanged();
                   }
                   Toast.makeText(MainActivity.this, "Thêm xe máy thành công", Toast.LENGTH_SHORT).show();
                    alertDialog.cancel();
               }
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
}