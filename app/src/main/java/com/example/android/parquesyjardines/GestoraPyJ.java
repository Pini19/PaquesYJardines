package com.example.android.parquesyjardines;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by DamLocal on 15/01/2018.
 */

public class GestoraPyJ extends ArrayList<PyJ>{

    /*
    * gestoraPyJ con datos del json
    * */


    public void ordenaTipo (){
        Collections.sort(this, new CompareTipo());
    }

    public void ordenAlfabetico(){
        Collections.sort(this, new CompareNombre());
    }

}
