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
        String createPlansql=" create table if not exists plann (id integer primary key autoincrement, planadi text, deadline text)";
        db.execSQL(createPlansql);
        String createAyrintisql="create table if not exists ayrinti (planadi text,planicerigi text,plandurumu boolean,deadline text ,id integer,foreign key(id) references plann(id))";
        db.execSQL(createAyrintisql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists plann");
    }
}
