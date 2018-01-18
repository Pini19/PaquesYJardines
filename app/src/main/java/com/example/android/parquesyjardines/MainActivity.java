package com.example.android.parquesyjardines;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.SimpleAdapter;

public class MainActivity extends AppCompatActivity {

    private GestoraPyJ gestora;
    private SimpleAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onOptionItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.ordenNombre:{
                this.gestora.ordenAlfabetico();
                this.adaptador.notifyDataSetChanged();
            }
            case R.id.ordenTipo:{
                this.gestora.ordenaTipo();
                this.adaptador.notifyDataSetChanged();
            }
        }
        return true;
    }
}
