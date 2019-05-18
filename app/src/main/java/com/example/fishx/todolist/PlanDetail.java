package com.example.fishx.todolist;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PlanDetail extends AppCompatActivity {

    String m_Text;
    Context context = this;
    ArrayList<String> mTitle=new ArrayList<String>();
    int images[]={R.drawable.check,R.drawable.x};
    planVeriKaynagi db = new planVeriKaynagi(context);
    String planName;
    TextView textView;
    ListView listView;
    Button addDetail;
    ArrayList<detail> planDetails=new ArrayList<detail>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_detail);
        Intent intent=getIntent();
        addDetail=findViewById(R.id.button4);
        planName=intent.getStringExtra("name");
        textView=findViewById(R.id.textView2);
        listView=findViewById(R.id.detailList);
        textView.setText(planName+" Plan");


        db.ac();
        planDetails=db.listeleAyrinti(planName);


        for (int i=0;i<planDetails.size();i++){
            mTitle.add(planDetails.get(i).getIcerik());
        }




        MyAdapter adapter = new MyAdapter(this,mTitle,images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){

                }
                if (position==1){

                }
                if (position==2){

                }

            }
        });



        db.kapat();




    }


    public class MyAdapter extends ArrayAdapter<String> {

        //String name[];
        Context context;
        ArrayList<String> rTitle=new ArrayList<String>();
        int rImg[];

        MyAdapter(Context context,ArrayList<String> title,int imgs[]){
            super(context,R.layout.xdetailrow,R.id.baslik,title);
            this.context=context;
            this.rTitle=title;
            this.rImg=imgs;


        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.xdetailrow,parent,false);
            ImageView images=row.findViewById(R.id.image);
            TextView myTitle=row.findViewById(R.id.baslik);


            images.setImageResource(rImg[position%2]);
            myTitle.setText(rTitle.get(position));


            return row;
        }
    }



    public void addDetailButton(View view){


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Plan Detayı Ekle");

        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();

                if(m_Text!=null){
                    db.ac();
                    //plan=pvk.planOlustur(planAdi);
                    db.detayOlusturDb(m_Text,planName);
                    db.kapat();
                    Toast.makeText(context, "Plan Detayı Eklendi :(", Toast.LENGTH_SHORT).show();
                }

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();


    }




}
