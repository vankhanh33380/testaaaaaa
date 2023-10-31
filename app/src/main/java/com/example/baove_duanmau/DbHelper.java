package com.example.baove_duanmau;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "PS33380_Test", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qXemay = "create table XeMay(" +
                "id integer primary key autoincrement," +
                "tenxe text," +
                "giaba integer," +
                "trangthai integer)";
        sqLiteDatabase.execSQL(qXemay);
        String data = "insert into XeMay values(" +
                "1,'Xe a',1000000,1)," +
                "(2,'Xe b',2000000,1)," +
                "(3,'Xe c',100000,1)," +
                "(4,'Xe d',300000,0)," +
                "(5,'Xe e',500000,1)";
        sqLiteDatabase.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
