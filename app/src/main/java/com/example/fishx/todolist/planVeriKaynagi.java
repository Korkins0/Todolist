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

    public void planSilDb(String planadi){

        String planname=planadi;
        db.delete("plann","planadi= '"+planname+"'" ,null);

    }
    public void detayGuncelleDb(String clickedName,Boolean clickedDurumu){

        if (clickedDurumu)
            db.execSQL("UPDATE ayrinti SET plandurumu=0 WHERE planicerigi='"+clickedName+"'");
        else
            db.execSQL("UPDATE ayrinti SET plandurumu=1 WHERE planicerigi='"+clickedName+"'");

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
    public void detayOlusturDb(String icerik,String planadi){
        detail detail=new detail();
        detail.setIcerik(icerik);
        detail.setPlanadi(planadi);
        detail.setDurum(false);
        //ac bunu sonra aqq kaanı tepeye de deadline al p.setDeadline(deadline);
        ContentValues val = new ContentValues();
        val.put("planadi",detail.getPlanadi());
        val.put("planicerigi",detail.getIcerik());
        val.put("plandurumu",detail.getDurum());
        //val.put("deadline",deadline);
        db.insert("ayrinti",null,val);
    }

    public List<String> listele(){


        String kolonlar[]={"id","planadi","deadline"};
        List<String> planadiList=new ArrayList<String>();
        Cursor cursor=db.query(false,"plann",kolonlar,null,null,null,null,null,null,null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            plan planim = new plan();
            int id=cursor.getInt(0);
            String planadi=cursor.getString(1);
            Date deadline = Calendar.getInstance().getTime();//buraya dön tarih şu an current date alıyor bunu seçilen tarihe çevir.
            /* System.out.println("Current time => " + deadline);
            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            String formattedDate = df.format(deadline);
        */
            planim.setPlanadi(planadi);
            planim.setDeadline(deadline);
            planadiList.add(planim.getPlanadi());
            cursor.moveToNext();
      //commit satırıı
        }
        return planadiList;
    }
       public ArrayList<detail> listeleAyrinti(String planadii){


        String kolonlar[]={"planadi","planicerigi","plandurumu","deadline","id"};
        ArrayList<detail> detailsList=new ArrayList<detail>();
        Cursor cursor=db.query(false,"ayrinti",kolonlar,null,null,null,null,null,null,null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            detail detayim = new detail();
            String planadi=cursor.getString(0);
            String planicerigi=cursor.getString(1);
            boolean plandurumu= cursor.getInt(2) > 0;
            Date deadline = Calendar.getInstance().getTime();//buraya dön tarih şu an current date alıyor bunu seçilen tarihe çevir.
            /* System.out.println("Current time => " + deadline);
            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            String formattedDate = df.format(deadline);
        */
            if (planadii.equals(planadi)){
            detayim.setPlanadi(planadi);
            detayim.setIcerik(planicerigi);
            detayim.setDurum(plandurumu);
            detailsList.add(detayim);}
            cursor.moveToNext();

        }
        return detailsList;
    }



    public List<plan> listeleplan(){

        plan planim = new plan();
        String kolonlar[]={"id","planadi","deadline"};
        List<plan> planList=new ArrayList<plan>();
        Cursor cursor=db.query(false,"plann",kolonlar,null,null,null,null,null,null,null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
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
      //commit satırıı
        }
        return planList;
    }

}
