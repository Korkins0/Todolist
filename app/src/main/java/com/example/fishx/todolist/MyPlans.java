package com.example.fishx.todolist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MyPlans extends AppCompatActivity {

    String toDoName=null;
    ListView listView;
    static List<String> plans = new ArrayList<String>();
    List<plan> asilPlanlar=new ArrayList<plan>();
    planVeriKaynagi pvk= new planVeriKaynagi(this);





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plans);
        listView=findViewById(R.id.listView);

        pvk.ac();
        plans=pvk.listele();
        asilPlanlar=pvk.listeleplan();

        if (!plans.isEmpty())
        {




            //ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,plans);

            //listView.setAdapter(arrayAdapter);

            CustomListAdapter customAdapter = new CustomListAdapter(this,R.layout.customlistitem, plans);

            listView.setAdapter(customAdapter);



        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(getApplicationContext(),PlanDetail.class);


                System.out.println(asilPlanlar.get(0).getPlanadi());

                for (int i=0;i<=position;i++) {
                  toDoName = plans.get(i);

                }

                intent.putExtra("name",toDoName);
                startActivityForResult(intent,1);

            }
        });




    }


}
