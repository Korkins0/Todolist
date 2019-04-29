package com.example.fishx.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MyPlans extends AppCompatActivity {

    ListView listView;
    ArrayList<String> plans = new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plans);
        listView=findViewById(R.id.listView);

        plans.add("planA");
        plans.add("planB");
        plans.add("planC");

        CustomListAdapter customAdapter = new CustomListAdapter(this,R.layout.customlistitem, plans);

        listView.setAdapter(customAdapter);

    }
}
