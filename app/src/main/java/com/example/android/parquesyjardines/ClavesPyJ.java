package com.example.android.parquesyjardines;

/**
 * Created by DamLocal on 15/01/2018.
 */

public enum ClavesPyJ {
    nombre, direccion, descripcion, horario, url, id, localizacion, categorias;

    public static String[] claves() {
        ClavesPyJ[] claves = ClavesPyJ.values();
        int numero = claves.length;
        String[] devolver = new String[numero];
        for (int i = 0; i < numero; i++) {
            devolver[i] = claves[i].toString();
        }
        return devolver;
    }
}
