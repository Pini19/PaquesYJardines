package com.example.android.parquesyjardines;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by miguel on 18/01/2018.
 */

public class InfoActivity extends AppCompatActivity {

    ListView list;
    TextView category;
    TextView description;
    TextView address;
    TextView schedule;
    TextView id;
    TextView loc;
    TextView name;
    TextView url;
    ArrayList<TextView> objetos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_informacion);

        category = this.findViewById(R.id.textoCat);
        description = this.findViewById(R.id.textoDesc);
        address = this.findViewById(R.id.textoDir);
        schedule = this.findViewById(R.id.textoHorario);
        id = this.findViewById(R.id.textoId);
        loc = this.findViewById(R.id.enlaceLoc);
        name = this.findViewById(R.id.textoNombre);
        url = this.findViewById(R.id.enlaceUrl);

        objetos = new ArrayList<>();
        objetos.add(category);
        objetos.add(description);
        objetos.add(address);
        objetos.add(schedule);
        objetos.add(id);
        objetos.add(loc);
        objetos.add(name);
        objetos.add(url);

        int i = 0;
        String s = (String) getIntent().getSerializableExtra("myObject");
        /*HashMap myMap = (HashMap) getIntent().getSerializableExtra("myObject");
        Iterator myVeryOwnIterator = myMap.keySet().iterator();
        while (myVeryOwnIterator.hasNext()) {
            String key = (String) myVeryOwnIterator.next();
            String value = (String) myMap.get(key);
            objetos.get(i).setText(value);*/
        category.setText(s);
        i++;
    }
}

