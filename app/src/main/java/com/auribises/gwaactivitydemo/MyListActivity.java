package com.auribises.gwaactivitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    ArrayAdapter<String> adapter;

    void initList(){
        listView = (ListView)findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adapter.add("AajTak"); //0
        adapter.add("Zee News");
        adapter.add("CNN");
        adapter.add("BBC");
        adapter.add("IndiaToday");
        adapter.add("IndianExpress");
        adapter.add("Tribune"); //n-1

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        initList();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
        String newsName = adapter.getItem(pos);
        Toast.makeText(this,"You Selected: "+newsName,Toast.LENGTH_LONG).show();

        switch (pos){
            case 0:
                Intent intent = new Intent(MyListActivity.this,NewsActivity.class);
                startActivity(intent);
                break;

            case 1:

                break;
        }
    }
}
