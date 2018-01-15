package com.example.android.parquesyjardines;

        import java.util.HashMap;
        import java.util.List;

/**
 * Created by daniel on 11/01/2018.
 */

public class ParqueYJardin extends HashMap<String, Object>{
    public ParqueYJardin(List<String> categorias, String descripcion, String direccion, String horario, String identificador, String localizacion, String nombre, String url) {
        this.put("categorias", categorias );
        this.put("descripcion", descripcion);
        this.put("direccion", direccion);
        this.put("horario", horario);
        this.put("identificador", identificador);
        this.put("localizacion", localizacion);
        this.put("nombre", nombre);
        this.put("url", url);
    }

    public static String[] getClaves() {
        String[] claves = { "categorias", "descripcion", "direccion", "horario", "identificador", "localizacion", "nombre", "url"};
        return claves;
    }
}
