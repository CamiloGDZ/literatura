package com.alura.literatura;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Principal {

    private static final Scanner scanner = new Scanner(System.in);
    private static final GutendexCliente cliente = new GutendexCliente();
    private static final List<DatosLibro> librosRegistrados = new ArrayList<>();

    public static void main(String[] args) {

        int opcion = -1;

        while (opcion != 0) {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Opción inválida.");
                continue;
            }

            switch (opcion) {
                case 1 ->
                    buscarLibroPorTitulo();
                case 2 ->
                    listarLibrosRegistrados();
                case 3 ->
                    listarAutoresRegistrados();
                case 4 ->
                    listarAutoresVivosEnAnio();
                case 5 ->
                    listarLibrosPorIdioma();
                case 0 ->
                    System.out.println("👋 Saliendo del programa...");
                default ->
                    System.out.println("⚠️ Opción no válida.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n------------");
        System.out.println("Elija la opción a través de su número:");
        System.out.println("1 - buscar libro por título");
        System.out.println("2 - listar libros registrados");
        System.out.println("3 - listar autores registrados");
        System.out.println("4 - listar autores vivos en un determinado año");
        System.out.println("5 - listar libros por idioma");
        System.out.println("0 - salir");
        System.out.print("👉 Opción: ");
    }

    private static void buscarLibroPorTitulo() {
        System.out.print("\n🔍 Ingresa el título del libro: ");
        String titulo = scanner.nextLine();

        DatosLibro datos = cliente.buscarLibroPorTitulo(titulo);

        if (datos == null) {
            System.out.println("❌ Libro no encontrado.");
        } else {
            librosRegistrados.add(datos);
            System.out.println("\n✅ Libro encontrado:");
            System.out.println("📖 Título: " + datos.title());
            System.out.println("✍️ Autor: " + datos.author());
            System.out.println("🌐 Idioma: " + datos.language());
            System.out.println("⬇️ Descargas: " + datos.download_count());
        }
    }

    private static void listarLibrosRegistrados() {
        if (librosRegistrados.isEmpty()) {
            System.out.println("📂 No hay libros registrados aún.");
        } else {
            System.out.println("\n📚 Libros registrados:");
            for (DatosLibro libro : librosRegistrados) {
                System.out.println("📖 " + libro.title() + " - Autor: " + libro.author());
            }
        }
    }

    private static void listarAutoresRegistrados() {
        Set<String> autores = new HashSet<>();
        for (DatosLibro libro : librosRegistrados) {
            autores.add(libro.author());
        }

        if (autores.isEmpty()) {
            System.out.println("📂 No hay autores registrados aún.");
        } else {
            System.out.println("\n✍️ Autores registrados:");
            for (String autor : autores) {
                System.out.println("🔸 " + autor);
            }
        }
    }

    private static void listarAutoresVivosEnAnio() {
        System.out.print("📅 Ingresa el año a consultar: ");
        int anio = Integer.parseInt(scanner.nextLine());

        System.out.println("\n Autores que posiblemente estaban vivos en " + anio + ":");
        for (DatosLibro libro : librosRegistrados) {
            if (libro.birthYear() != null && libro.deathYear() != null) {
                if (anio >= libro.birthYear() && anio <= libro.deathYear()) {
                    System.out.println("🔸 " + libro.author());
                }
            }
        }
    }

    private static void listarLibrosPorIdioma() {
        System.out.print("🌐 Ingresa el código del idioma (ej: 'en', 'es', 'fr'): ");
        String idioma = scanner.nextLine();

        System.out.println("\n📚 Libros en idioma " + idioma + ":");
        for (DatosLibro libro : librosRegistrados) {
            if (libro.language().equalsIgnoreCase(idioma)) {
                System.out.println("🔸 " + libro.title() + " - Autor: " + libro.author());
            }
        }
    }
}
