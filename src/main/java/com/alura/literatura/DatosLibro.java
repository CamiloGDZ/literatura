package com.alura.literatura;

public record DatosLibro(
    String title,
    String author,
    String language,
    Integer download_count
) {}
