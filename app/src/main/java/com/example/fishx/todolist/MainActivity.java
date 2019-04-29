package com.example.fishx.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void toAddPlan(View view){

        Intent intent = new Intent(this, AddPlan.class);
        startActivity(intent);
    }

    public void toMyPlans(View view){

        Intent intent = new Intent(this, MyPlans.class);
        startActivity(intent);
    }






}
