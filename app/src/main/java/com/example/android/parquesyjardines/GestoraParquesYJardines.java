package com.example.android.parquesyjardines;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.JsonToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by
 * daniel on 11/01/2018.
 */

public class GestoraParquesYJardines extends ArrayList<ParqueYJardin> {
    public GestoraParquesYJardines() {
        CargadoraJSON tarea = new CargadoraJSON(this);
        tarea.execute("http://datos.gijon.es/doc/turismo/parques-jardines.json");
    }

    public void ordenaTipo() {
        Collections.sort(this, new CompareTipo());
    }

    public void ordenAlfabetico() {
        Collections.sort(this, new CompareNombre());
    }

    class CargadoraJSON extends AsyncTask<String, Integer, Boolean> {
        private GestoraParquesYJardines gestora;

        public CargadoraJSON(GestoraParquesYJardines gestora) {
            this.gestora = gestora;
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {
                // leemos el archivo y definimos la gestora
                URL urlValue = new URL(params[0]);
                try (InputStream lector = urlValue.openStream()) {

                    JsonReader reader = new JsonReader(new InputStreamReader(lector, "UTF-8"));

                    reader.beginObject();

                    String name = reader.nextName();

                    reader.beginObject();

                    name = reader.nextName();
                    gestora.addAll(leerParquesYJardines(reader));
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(GestoraParquesYJardines.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return false;
            }

            return true;
        }

        protected void onPostExecute(Boolean result) {
            if (result) {
                if (gestora.size() > 0 && MainActivity.adapter != null) {
                    MainActivity.adapter.notifyDataSetChanged();
                }
            }

        }

        public List<ParqueYJardin> leerParquesYJardines(JsonReader reader) throws IOException {
            List<ParqueYJardin> parquesYJardines = new ArrayList<ParqueYJardin>();
            reader.beginArray();
            while (reader.hasNext()) {
                parquesYJardines.add(leerParqueYJardin(reader));
            }
            reader.endArray();
            return parquesYJardines;

        }

        public ParqueYJardin leerParqueYJardin(JsonReader reader) throws IOException {
            ParqueYJardin uno = new ParqueYJardin(null, null, null, null, null, null, null, null);
            reader.beginObject();
            while (reader.hasNext()) {
                String name = reader.nextName();
                if (name.equals("categorias")) {
                    List<String> categorias = new ArrayList<String>();
                    reader.beginObject();
                    reader.nextName();
                    if (reader.peek() == JsonToken.BEGIN_ARRAY) {
                        reader.beginArray();
                        while (reader.hasNext()) {

                            categorias.add(obtenerContent(reader));
                        }
                        reader.endArray();
                        reader.endObject();
                    } else {
                        reader.beginObject();
                        while (reader.hasNext()) {

                            categorias.add(obtenerContent(reader));
                        }
                        reader.endObject();

                    }

                    uno.put("categorias", categorias);
                } else if (name.equals("descripcion")) {
                    uno.put("descripcion", obtenerContent(reader));
                } else if (name.equals("horario")) {
                    if (reader.peek() != JsonToken.BEGIN_OBJECT) {
                        uno.put("horario", reader.nextString());
                    } else {
                        reader.skipValue();
                        uno.put("horario", "No dispone de horario");
                    }
                } else if (name.equals("identificador")) {
                    uno.put("identificador", reader.nextInt());
                } else if (name.equals("localizacion")) {
                    uno.put("localizacion", obtenerContent(reader));
                } else if (name.equals("nombre")) {
                    uno.put("nombre", obtenerContent(reader));
                } else if (name.equals("url")) {
                    uno.put("url", reader.nextString());
                } else if (name.equals("direccion")) {
                    reader.beginArray();
                    uno.put("direccion", reader.nextString());
                    reader.skipValue();
                    reader.endArray();
                } else {
                    reader.skipValue();
                }
            }
            reader.endObject();
            return uno;
        }

        public String obtenerContent(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.BEGIN_OBJECT) {
                reader.beginObject();
            }
            String dato = null;

            while (reader.hasNext()) {
                String name = reader.nextName();
                if (name.equals("content")) {
                    dato = reader.nextString();
                } else {
                    reader.skipValue();
                }
            }
            if (reader.peek() == JsonToken.END_OBJECT) {
                reader.endObject();
            }
            return dato;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
    }
}
