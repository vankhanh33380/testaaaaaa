package com.example.baove_duanmau;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class XeMayDao {
    private DbHelper dbHelper;

    public XeMayDao(Context context) {
        dbHelper = new DbHelper(context);
    }
    public ArrayList<XeMay> getXeMay(){
        ArrayList<XeMay> list = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        database.beginTransaction();
        try {
            Cursor cursor = database.rawQuery("select * from XeMay",null);
            if (cursor.getCount()>0){
                cursor.moveToFirst();
                do {
                    list.add(new XeMay(cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getInt(2),
                            cursor.getInt(3)));
                }while (cursor.moveToNext());
                database.setTransactionSuccessful();
            }
        } catch (Exception e){
            Log.e(TAG," getXeMay"+e);
        } finally {
            database.endTransaction();
        }
        return list;
    }
    public boolean addXeMay(XeMay xeMay){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenxe",xeMay.getTenxe());
        values.put("giaba",xeMay.getGiaban());
        values.put("trangthai",xeMay.getTrangthai());
        long check = database.insert("XeMay",null,values);
        return check != -1;
    }
}
