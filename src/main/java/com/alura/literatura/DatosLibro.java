package com.alura.literatura;

public class DatosLibro {
    private String title;
    private String author;
    private String language;
    private int download_count;
    private Integer birthYear;
    private Integer deathYear;

    // Constructor completo
    public DatosLibro(String title, String author, String language, int download_count, Integer birthYear, Integer deathYear) {
        this.title = title;
        this.author = author;
        this.language = language;
        this.download_count = download_count;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    // Constructor adicional para compatibilidad con código anterior (4 parámetros)
    public DatosLibro(String title, String author, String language, int download_count) {
        this(title, author, language, download_count, null, null);
    }

    public String title() {
        return title;
    }

    public String author() {
        return author;
    }

    public String language() {
        return language;
    }

    public int download_count() {
        return download_count;
    }

    public Integer birthYear() {
        return birthYear;
    }

    public Integer deathYear() {
        return deathYear;
    }
}
