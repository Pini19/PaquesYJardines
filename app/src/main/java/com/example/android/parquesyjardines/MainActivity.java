package com.example.android.parquesyjardines;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class MainActivity extends AppCompatActivity {
    private ListView list;
    public static SimpleAdapter adapter;
    private GestoraParquesYJardines gestora;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        gestora = new GestoraParquesYJardines();
        list = (ListView) this.findViewById(R.id.listViewPrincipal);
        int [] to = {R.id.textViewNombre, R.id.textViewDireccion};
        String[] from = {"nombre", "direccion"};
        adapter = new SimpleAdapter(this, gestora , R.layout.adapter_main_list, from , to);
        list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.ordenNombre:{
                this.gestora.ordenAlfabetico();
                this.adapter.notifyDataSetChanged();
                break;
            }
            case R.id.ordenTipo:{
                this.gestora.ordenaTipo();
                this.adapter.notifyDataSetChanged();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
