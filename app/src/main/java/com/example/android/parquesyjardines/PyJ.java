package com.example.android.parquesyjardines;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by DamLocal on 15/01/2018.
 */

public class PyJ extends HashMap<String, Object> implements Comparable<PyJ>{

    public PyJ (CharSequence nombre, CharSequence direccion, CharSequence descripcion, CharSequence horario,
                CharSequence url, int id, ArrayList<String> categorias){
        super();
        this.put(ClavesPyJ.nombre.toString(), nombre);
        this.put(ClavesPyJ.direccion.toString(), direccion);
        this.put(ClavesPyJ.descripcion.toString(), descripcion);
        this.put(ClavesPyJ.horario.toString(), horario);
        this.put(ClavesPyJ.url.toString(), url);
        this.put(ClavesPyJ.id.toString(), id);
        this.put(ClavesPyJ.categorias.toString(), categorias);

    }

    @Override
    public int compareTo(PyJ another) {
        Object[] PyJ1 = {(Boolean) this.get(ClavesPyJ.nombre.toString()), ((String) this.get(ClavesPyJ.direccion.toString())).toLowerCase(),
                ((String) this.get(ClavesPyJ.descripcion.toString())).toLowerCase(),((String) this.get(ClavesPyJ.horario.toString())).toLowerCase(),
                ((String) this.get(ClavesPyJ.url.toString())).toLowerCase(),(Integer) this.get(ClavesPyJ.id.toString()), (ArrayList) this.get(ClavesPyJ.id.toString())};

        Object[] PyJ2 = {(Boolean) another.get(ClavesPyJ.nombre.toString()), ((String) another.get(ClavesPyJ.direccion.toString())).toLowerCase(),
                ((String) another.get(ClavesPyJ.descripcion.toString())).toLowerCase(), ((String) another.get(ClavesPyJ.horario.toString())).toLowerCase(),
                ((String) another.get(ClavesPyJ.url.toString())).toLowerCase(), (Integer) another.get(ClavesPyJ.id.toString()), (ArrayList) another.get(ClavesPyJ.id.toString())};

        int campos = ClavesPyJ.values().length;
        for (int x = 0; x < campos; x++) {
            boolean iguales = PyJ1[x].equals(PyJ2[x]);
            if (!iguales) {
                return PyJ1[x].toString().compareTo(PyJ2[x].toString());
            }
        }
        return 0;
    }
    @Override
    public boolean equals(Object object){
        if (object instanceof PyJ) {
            PyJ otro=(PyJ) object;
            return this.compareTo(otro)==0?true:false;
        }
        return super.equals(object);
    }



}
