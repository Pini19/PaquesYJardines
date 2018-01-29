package com.example.android.parquesyjardines;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
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
    private ListView list;
    private static final int NOTIF_ALERTA_ID =99;
    private GestoraParquesYJardines gestora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) this.findViewById(R.id.listViewPrincipal);
        int[] to = {R.id.textViewNombre, R.id.textViewDireccion};
        String[] from = {"nombre", "direccion"};
        gestora = new GestoraParquesYJardines(this);
        adapter = new SimpleAdapter(this, gestora, R.layout.adapter_main_list, from, to);
        list.setAdapter(adapter);



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ParqueYJardin itemSelected = (ParqueYJardin) gestora.get(arg2);
                Intent myintent = new Intent(MainActivity.this, InfoActivity.class);
                myintent.putExtra("myObject", itemSelected);
                startActivity(myintent);
            }

        });

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

    public void mostrarNotificacion(int cantidadPYJ) {

        String ns = this.NOTIFICATION_SERVICE;
        NotificationManager notManager = (NotificationManager) getSystemService(ns);

        int icono = android.R.drawable.stat_notify_chat;
        CharSequence textoTitulo = "Parques y jardines";
        CharSequence textoPrincipal="Numero de parques y jardines: " + cantidadPYJ;
        long hora = System.currentTimeMillis();
        Notification.Builder caracteristicas = new Notification.Builder(this)
                .setSmallIcon(icono)
                .setWhen(hora)
                .setContentTitle(textoTitulo)
                .setContentText(textoPrincipal);
        Context contexto = getApplicationContext();
        Intent lanzar = new Intent(contexto,
                this.getClass());

        PendingIntent contIntent = PendingIntent.getActivity(contexto, NOTIF_ALERTA_ID, lanzar, PendingIntent.FLAG_UPDATE_CURRENT);

        caracteristicas.setContentIntent(contIntent);

        Notification notificacion=caracteristicas.build();

        //AutoCancel: cuando se pulsa la notificaión ésta desaparece
        notificacion.flags |= Notification.FLAG_AUTO_CANCEL;

        //Añadir sonido, vibración y luces
        notificacion.defaults |= Notification.DEFAULT_SOUND;
        notificacion.defaults |= Notification.DEFAULT_VIBRATE;
        notificacion.defaults |= Notification.DEFAULT_LIGHTS;

        notificacion.defaults |= Notification.DEFAULT_ALL;

        notManager.notify(NOTIF_ALERTA_ID, notificacion);
    }
}

