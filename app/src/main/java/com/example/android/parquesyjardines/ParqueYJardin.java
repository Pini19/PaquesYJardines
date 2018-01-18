package com.example.android.parquesyjardines;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by daniel on 11/01/2018.
 */

public class ParqueYJardin extends HashMap<String, Object> implements Comparable<ParqueYJardin> {
    public ParqueYJardin(List<String> categorias, String descripcion, String direccion, String horario, String identificador, String localizacion, String nombre, String url) {
        this.put(ClavesPyJ.nombre.toString(), nombre);
        this.put(ClavesPyJ.direccion.toString(), direccion);
        this.put(ClavesPyJ.descripcion.toString(), descripcion);
        this.put(ClavesPyJ.horario.toString(), horario);
        this.put(ClavesPyJ.url.toString(), url);
        this.put(ClavesPyJ.id.toString(), identificador);
        this.put(ClavesPyJ.categorias.toString(), categorias);
    }

    public static String[] getClaves() {
        String[] claves = {"categorias", "descripcion", "direccion", "horario", "identificador", "localizacion", "nombre", "url"};
        return claves;
    }

    @Override
    public int compareTo(ParqueYJardin another) {
        Object[] PyJ1 = {(Boolean) this.get(ClavesPyJ.nombre.toString()), ((String) this.get(ClavesPyJ.direccion.toString())).toLowerCase(),
                ((String) this.get(ClavesPyJ.descripcion.toString())).toLowerCase(), ((String) this.get(ClavesPyJ.horario.toString())).toLowerCase(),
                ((String) this.get(ClavesPyJ.url.toString())).toLowerCase(), (Integer) this.get(ClavesPyJ.id.toString()), (ArrayList) this.get(ClavesPyJ.id.toString())};

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
    public boolean equals(Object object) {
        if (object instanceof ParqueYJardin) {
            ParqueYJardin otro = (ParqueYJardin) object;
            return this.compareTo(otro) == 0 ? true : false;
        }
        return super.equals(object);
    }
}
