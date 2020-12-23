package com.example.quanylysinhvien.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Locale;

public class DBHeplper extends SQLiteOpenHelper {
    public DBHeplper(@Nullable Context context) {
        super(context, "QUANLYSINHVIENFPTDB.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE LOP(maLop TEXT PRIMARY KEY, tenLop TEXT)";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('LTAndroid','Lap Trinh Android')";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('LTPHP','Lap Trinh PHP')";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('LTC++','Lap Trinh C++')";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('LTUD','Lap Trinh Ứng dụng ')";
        db.execSQL(sql);

        sql = " CREATE TABLE SINHVIEN(maSv TEXT PRIMARY KEY, tenSV TEXT, email TEXT ,hinh TEXT, maLop TEXT REFERENCES LOP(maLop))";
        db.execSQL(sql);
        for (int i = 0; i < 100; i++) {
            sql = "INSERT INTO SINHVIEN VALUES ('00%d', 'Võ Văn Huy %d','ABC@gmail.com','avatarmacdinh','%s')";
            db.execSQL(String.format(Locale.getDefault(), sql, i, i, i % 2 == 0 ? "LTC++" : "LTAndroid"));
        }
        sql = "CREATE TABLE taiKhoan(tenTaiKhoan text primary key, matKhau text)";
        db.execSQL(sql);
        sql = "INSERT INTO taiKhoan VALUES('admin','admin')";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
