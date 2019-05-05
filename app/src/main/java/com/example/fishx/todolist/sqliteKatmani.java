package com.example.fishx.todolist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqliteKatmani extends SQLiteOpenHelper {

    public sqliteKatmani(Context c){
        super(c,"plann",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql=" create table plann (id integer primary key autoincrement, planadi text, deadline date)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists plann");
    }
}
