package com.example.android.parquesyjardines;

import java.util.Comparator;

/**
 * Created by DamLocal on 15/01/2018.
 */

public class CompareTipo implements Comparator<ParqueYJardin> {

    @Override
    public int compare (ParqueYJardin pj1, ParqueYJardin pj2 ){
        return ((String)pj1.get(ClavesPyJ.categorias.toString())).compareTo((String)pj2.get(ClavesPyJ.categorias.toString()));
    }

}
