package com.alura.literatura;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ConvierteDatos {

    public List<DatosLibro> obtenerDatos(String json) {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray resultados = jsonObject.getJSONArray("results");
        List<DatosLibro> libros = new ArrayList<>();

        for (int i = 0; i < resultados.length(); i++) {
            JSONObject libroJson = resultados.getJSONObject(i);

            String titulo = libroJson.optString("title", "Título no disponible");

            // Autor: tomamos el primer autor si hay
            String autor = "Autor desconocido";
            JSONArray autores = libroJson.optJSONArray("authors");
            if (autores != null && autores.length() > 0) {
                JSONObject autorObj = autores.getJSONObject(0);
                autor = autorObj.optString("name", "Autor desconocido");
            }

            String idioma = libroJson.optString("language", "N/A");
            int descargas = libroJson.optInt("download_count", 0);

            DatosLibro libro = new DatosLibro(titulo, autor, idioma, descargas);
            libros.add(libro);
        }

        return libros;
    }
}
