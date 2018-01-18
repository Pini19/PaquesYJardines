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

    TextView category;
    TextView description;
    TextView address;
    TextView schedule;
    TextView id;
    TextView loc;
    TextView name;
    TextView url;

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

        HashMap myMap = (HashMap) getIntent().getSerializableExtra("myObject");
        category.setText((Integer) myMap.get(category));
        description.setText((Integer) myMap.get(description));
        address.setText((Integer) myMap.get(address));
        schedule.setText((Integer) myMap.get(schedule));
        id.setText((Integer) myMap.get(id));
        loc.setText((Integer) myMap.get(loc));
        name.setText((Integer) myMap.get(name));
        url.setText((Integer) myMap.get(url));
    }
}

