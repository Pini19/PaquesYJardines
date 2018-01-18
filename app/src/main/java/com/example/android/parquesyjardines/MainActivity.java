package com.example.android.parquesyjardines;


import android.content.Intent;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends AppCompatActivity {
    public static SimpleAdapter adapter;
    ArrayList<ParqueYJardin> data;
    private ListView list;
    private GestoraParquesYJardines gestora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) this.findViewById(R.id.listViewPrincipal);
        int[] to = {R.id.textViewNombre, R.id.textViewDireccion};
        String[] from = {"nombre", "direccion"};
        gestora = new GestoraParquesYJardines();
        adapter = new SimpleAdapter(this, gestora, R.layout.adapter_main_list, from, to);
        list.setAdapter(adapter);

        /*list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ParqueYJardin itemSelected = (ParqueYJardin) data.get(arg2);
                Log.v("ItemSelected",itemSelected.toString());
                Intent myintent = new Intent(MainActivity.this, InfoActivity.class);
                myintent.putExtra("myObject", itemSelected);
                startActivity(myintent);
            }

        });*/
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ordenNombre: {
                this.gestora.ordenAlfabetico();
                this.adapter.notifyDataSetChanged();
                break;
            }
            case R.id.ordenTipo: {
                this.gestora.ordenaTipo();
                this.adapter.notifyDataSetChanged();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
