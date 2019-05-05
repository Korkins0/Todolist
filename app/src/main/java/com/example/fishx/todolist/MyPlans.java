package com.example.fishx.todolist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MyPlans extends AppCompatActivity {


    ListView listView;
    static List<plan> plans = new ArrayList<plan>();
    List<String> planadlari=new ArrayList<String>();
    planVeriKaynagi pvk= new planVeriKaynagi(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plans);
        listView=findViewById(R.id.listView);

        pvk.ac();
        plans=pvk.listele();


        if (true)
        {
        for (int i=0;i<=plans.size();i++){

            planadlari.add(plans.get(i).planadi);

        }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,planadlari);

            //CustomListAdapter customAdapter = new CustomListAdapter(this,R.layout.customlistitem, planadlari);

            listView.setAdapter(arrayAdapter);

        }




    }


}
