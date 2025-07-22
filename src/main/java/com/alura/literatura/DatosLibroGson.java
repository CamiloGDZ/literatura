package com.alura.literatura;

public class DatosLibroGson {
    private String title;
    private String[] languages;
    private Integer download_count;
    private Autor[] authors;

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        // Devolver el primer idioma si hay varios
        if (languages != null && languages.length > 0) {
            return languages[0];
        }
        return "Desconocido";
    }

    public Integer getDownload_count() {
        return download_count;
    }

    public Autor getAutor() {
        if (authors != null && authors.length > 0) {
            return authors[0];
        }
        return null;
    }
}
