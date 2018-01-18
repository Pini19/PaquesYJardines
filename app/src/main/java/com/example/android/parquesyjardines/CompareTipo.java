package com.example.android.parquesyjardines;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by DamLocal on 15/01/2018.
 */

public class CompareTipo implements Comparator<ParqueYJardin> {

    @Override
    public int compare (ParqueYJardin pj1, ParqueYJardin pj2 ){
        String pj1S = "";
        String pj2S = "";
        ArrayList<String> pj1A = (ArrayList<String>)pj1.get(ClavesPyJ.categorias.toString());
        ArrayList<String> pj2A = (ArrayList<String>)pj2.get(ClavesPyJ.categorias.toString());
        for(String categoria:pj1A) {
            pj1S += categoria;
        }
        for(String categoria:pj2A) {
            pj2S += categoria;
        }
        return pj1S.compareTo(pj2S);
    }

}
