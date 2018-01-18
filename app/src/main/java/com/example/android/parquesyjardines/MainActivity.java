package com.example.android.parquesyjardines;

import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ArrayList<Object> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();
        data.add("a");
        data.add("b");
        ListView list = findViewById(R.id.list);
        list.setAdapter(new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1, data));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                HashMap itemSelected = (HashMap) data.get(arg2);
                Intent myintent = new Intent(MainActivity.this, InfoActivity.class);
                myintent.putExtra("myObject", itemSelected);
                startActivity(myintent);
            }

        });
    }
}
