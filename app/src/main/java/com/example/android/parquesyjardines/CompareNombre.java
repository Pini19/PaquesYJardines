package com.example.android.parquesyjardines;

import java.util.Comparator;

/**
 * Created by DamLocal on 15/01/2018.
 */
public class CompareNombre implements Comparator<PyJ> {

    @Override
    public int compare (PyJ pj1, PyJ pj2){
        return ((String)pj1.get(ClavesPyJ.nombre.toString())).compareTo((String)pj2.get(ClavesPyJ.nombre.toString()));    }
}
