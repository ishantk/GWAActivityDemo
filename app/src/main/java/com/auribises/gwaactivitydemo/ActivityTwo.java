package com.auribises.gwaactivitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTwo extends AppCompatActivity {

    TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        txtData = (TextView)findViewById(R.id.textViewData);

        Intent rcv = getIntent();

        /*String name = rcv.getStringExtra("keyName");
        String phone = rcv.getStringExtra("keyPhone");
        int age = rcv.getIntExtra("keyAge",0);*/

        /*Bundle rcvBundle = rcv.getBundleExtra("keyBundle");
        String name = rcvBundle.getString("keyName");
        String phone = rcvBundle.getString("keyPhone");
        int age = rcvBundle.getInt("keyAge");*/

        Person rcvPerson = (Person)rcv.getSerializableExtra("keyPerson");
        txtData.setText(rcvPerson.getName()+"\n"+rcvPerson.getPhone()+"\n"+rcvPerson.getAge());
        //txtData.setText(name+"\n"+phone+"\n"+age);

    }

    public void goBackHandler(View view){

        // Destroying the activity
        finish();

    }
}
