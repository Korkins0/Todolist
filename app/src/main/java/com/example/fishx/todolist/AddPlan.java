 package com.example.fishx.todolist;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

 public class AddPlan extends AppCompatActivity {

    EditText planName;
    EditText date;
    String planAdi;
    Date deadLine;
    final planVeriKaynagi pvk= new planVeriKaynagi(this);
    Calendar c;
    private  DatePickerDialog.OnDateSetListener mDateSetListener;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);

        planName=findViewById(R.id.editText3);
        date=findViewById(R.id.editText6);


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=Calendar.getInstance();
                int day= c.get(Calendar.DAY_OF_MONTH);
                int month=c.get(Calendar.MONTH);
                int year=c.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog(AddPlan.this,android.R.style.Theme_Holo_Light_Dialog,mDateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date.setText(dayOfMonth+"/"+month+"/"+year);
            }
        };

    }


    public void addPlantoDbButton(View view){

         planAdi=planName.getText().toString();

        plan plan=new plan();

        if(planName!=null){
            pvk.ac();
            //plan=pvk.planOlustur(planAdi);
            pvk.planOlusturDb(planAdi);
            pvk.kapat();
        }





    }




}
