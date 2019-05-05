package com.example.fishx.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class planVeriKaynagi {

    SQLiteDatabase db;
    sqliteKatmani bdb;

    public planVeriKaynagi(Context context){
        bdb = new sqliteKatmani(context);
    }

    public void ac(){
        db=bdb.getWritableDatabase();
    }

    public void kapat(){
        bdb.close();
    }

    public plan planOlustur(String planadi){
        plan p=new plan();
        p.setPlanadi(planadi);
        // ac bunu sonra aqq kaanı tepeye de deadline al p.setDeadline(deadline);
        return p;
    }
    public void planOlusturDb(String planadi){
        plan p=new plan();
        p.setPlanadi(planadi);
        Date deadline = Calendar.getInstance().getTime();//bunu sil sonraaa yieen
        //ac bunu sonra aqq kaanı tepeye de deadline al p.setDeadline(deadline);
        ContentValues val = new ContentValues();
        val.put("planadi",p.getPlanadi());
        //val.put("deadline",deadline);
        db.insert("plann",null,val);

    }

    public List<plan> listele(){

        plan planim = new plan();
        String kolonlar[]={"id","planadi","deadline"};
        List<plan> planList=new ArrayList<plan>();
        Cursor cursor=db.query(false,"plann",kolonlar,null,null,null,null,null,null,null);
        cursor.moveToFirst();

        while (!cursor.isLast()){
            int id=cursor.getInt(0);
            String planadi=cursor.getString(1);
            Date deadline = Calendar.getInstance().getTime();//buraya dön tarih şu an current date alıyor bunu seçilen tarihe çevir.
            /* System.out.println("Current time => " + deadline);
            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            String formattedDate = df.format(deadline);
        */
            planim.setPlanadi(planadi);
            planim.setDeadline(deadline);
            planList.add(planim);
            cursor.moveToNext();
        }
        return planList;
    }

}
