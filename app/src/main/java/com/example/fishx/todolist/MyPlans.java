package com.example.fishx.todolist;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyPlans extends AppCompatActivity {

    AlertDialog.Builder builder;
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

        builder = new AlertDialog.Builder(this);
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

                 final   Intent intent= new Intent(getApplicationContext(),PlanDetail.class);
                System.out.println(asilPlanlar.get(0).getPlanadi());

                for (int i=0;i<=position;i++) {
                    toDoName = plans.get(i);

                }

                builder.setMessage("What do you want to do to this plan ?")
                        .setCancelable(true)
                        .setPositiveButton("Go to Details", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                intent.putExtra("name",toDoName);
                                startActivityForResult(intent,1);

                            }
                        })
                        .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                pvk.planSilDb(toDoName);

                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("AlertDialogExample");
                alert.show();













            }
        });






    }


}
