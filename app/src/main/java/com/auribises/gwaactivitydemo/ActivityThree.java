package com.auribises.gwaactivitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityThree extends AppCompatActivity implements View.OnClickListener{

    EditText eTxtName, eTxtPhone;
    Button btnBack;

    void initViews(){ // Any Name
        eTxtName = (EditText)findViewById(R.id.editTextName);
        eTxtPhone = (EditText)findViewById(R.id.editTextPhone);
        btnBack = (Button)findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        initViews();
    }

    @Override
    public void onClick(View view) {
        String name = eTxtName.getText().toString().trim();
        String phone = eTxtPhone.getText().toString().trim();

        Intent john = new Intent(); // Empty Intent. Created to store data
        john.putExtra("keyName",name);
        john.putExtra("keyPhone",phone);

        setResult(201,john); // 201 can be any number. its is resultCode
        finish(); // to destroy the activity
    }
}
