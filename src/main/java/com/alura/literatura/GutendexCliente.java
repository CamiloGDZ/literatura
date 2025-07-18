package com.alura.literatura;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class GutendexCliente {

    private static final String URL_BASE = "https://gutendex.com/books/";

    public DatosLibro buscarLibroPorTitulo(String titulo) {
        RestTemplate restTemplate = new RestTemplate();

        String url = UriComponentsBuilder
                .fromHttpUrl(URL_BASE)
                .queryParam("search", titulo)
                .toUriString();

        String respuesta = restTemplate.getForObject(url, String.class);

        JSONObject json = new JSONObject(respuesta);
        JSONArray resultados = json.getJSONArray("results");

        if (resultados.isEmpty()) {
            return null;
        }

        JSONObject libro = resultados.getJSONObject(0);
        String title = libro.getString("title");
        String language = libro.getJSONArray("languages").getString(0);
        int downloads = libro.getInt("download_count");

        JSONArray autores = libro.getJSONArray("authors");
        String autor = "Desconocido";

        if (!autores.isEmpty()) {
            JSONObject autorObj = autores.getJSONObject(0);
            autor = autorObj.getString("name");
        }

        return new DatosLibro(title, autor, language, downloads);
    }
}
