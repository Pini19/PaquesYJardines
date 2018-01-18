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
import java.util.List;

/**
 * Created by miguel on 18/01/2018.
 */

public class InfoActivity extends AppCompatActivity {

    TextView category;
    TextView description;
    TextView address;
    TextView schedule;
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
        loc = this.findViewById(R.id.enlaceLoc);
        name = this.findViewById(R.id.textoNombre);
        url = this.findViewById(R.id.enlaceUrl);

        HashMap myMap = (HashMap) getIntent().getSerializableExtra("myObject");

        List<String> categorias = (List<String>) myMap.get(ClavesPyJ.categorias.toString());
        String categoria = "";
        for (int i = 0; i < categorias.size(); i++) {
            categoria += categorias.get(i) + ", ";
        }
        category.setText(categoria.substring(0, categoria.length() - 2));

        if (myMap.get(ClavesPyJ.descripcion.toString()) != null) {
            description.setText(myMap.get(ClavesPyJ.descripcion.toString()).toString());
        } else {
            description.setText(getString(R.string.dato_no_existe));
        }

        address.setText(myMap.get(ClavesPyJ.direccion.toString()).toString());
        schedule.setText(myMap.get(ClavesPyJ.horario.toString()).toString());

        if (myMap.get(ClavesPyJ.localizacion.toString()) != null) {
            loc.setText(myMap.get(ClavesPyJ.localizacion.toString()).toString());
        } else {
            loc.setText(getString(R.string.dato_no_existe));
        }

        name.setText(myMap.get(ClavesPyJ.nombre.toString()).toString());
        url.setText(myMap.get(ClavesPyJ.url.toString()).toString());
    }
}

