package com.auribises.gwaactivitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class ViewsActivity extends AppCompatActivity implements View.OnClickListener,CompoundButton.OnCheckedChangeListener{

    // References for the Objects
    CheckBox cbCpp, cbJava, cbPy;
    RadioButton rbMale, rbFemale;
    Button btnSubmit;

    RatingBar ratingBar;

    Spinner spCity;
    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapter,autoAdapter;

    float f;

    // Any MethodName of your choice
    void initViews(){
        cbCpp = (CheckBox)findViewById(R.id.checkBoxCpp);
        cbJava = (CheckBox)findViewById(R.id.checkBoxJava);
        cbPy = (CheckBox)findViewById(R.id.checkBoxPython);

        rbFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        rbMale = (RadioButton)findViewById(R.id.radioButtonMale);

        btnSubmit = (Button)findViewById(R.id.buttonSubmit);

        ratingBar = (RatingBar)findViewById(R.id.ratingBar);



        //btnSubmit.setOnClickListener(this);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        cbCpp.setOnCheckedChangeListener(this);
        cbJava.setOnCheckedChangeListener(this);
        cbPy.setOnCheckedChangeListener(this);
        rbFemale.setOnCheckedChangeListener(this);
        rbMale.setOnCheckedChangeListener(this);


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(ViewsActivity.this,"You gave: "+v+" rating",Toast.LENGTH_LONG).show();
                f = v;
            }
        });



    }

    // Any MethodName of your choice
    void initSpinner(){
        spCity = (Spinner)findViewById(R.id.spinnerCity);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);
        adapter.add("--Select City--"); //0
        adapter.add("Ludhiana");
        adapter.add("Chandigarh");
        adapter.add("Delhi");
        adapter.add("Bengaluru");
        adapter.add("California"); // n-1

        spCity.setAdapter(adapter);

        spCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String city = adapter.getItem(i);

                if(i!=0)
                    Toast.makeText(ViewsActivity.this,"You Selected: "+city,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    void initAutoComplete(){
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoComplete);

        autoAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);
        autoAdapter.add("Handkerchiefs"); //0
        autoAdapter.add("HandBags");
        autoAdapter.add("Shoes");
        autoAdapter.add("Shades");
        autoAdapter.add("Sharpner");
        autoAdapter.add("Scale"); // n-1

        autoCompleteTextView.setAdapter(autoAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);
        initViews();
        initSpinner();
        initAutoComplete();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.buttonSubmit){
            String str = autoCompleteTextView.getText().toString().trim();
            Toast.makeText(this,"You Clicked Button: "+str,Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        int id = compoundButton.getId();

        switch (id){
            case R.id.checkBoxCpp:
                if(b)
                    Toast.makeText(this,"You Checked CPP",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this,"You UnChecked CPP",Toast.LENGTH_LONG).show();
                break;

            case R.id.checkBoxJava:
                Toast.makeText(this,"You Checked Java: "+cbJava.isChecked(),Toast.LENGTH_LONG).show();
                break;

            case R.id.checkBoxPython:

                break;

            case R.id.radioButtonMale:
                Toast.makeText(this,"You Checked Male: "+rbMale.isChecked(),Toast.LENGTH_LONG).show();
                break;

            case R.id.radioButtonFemale:

                break;
        }
    }
}
