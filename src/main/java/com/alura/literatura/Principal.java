package com.alura.literatura;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GutendexCliente cliente = new GutendexCliente();

        System.out.println("📚 Bienvenido al Buscador de Libros de Gutendex!");

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n🔸 MENÚ 🔸");
            System.out.println("1. Buscar un libro");
            System.out.println("2. Salir");
            System.out.print("👉 Elige una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("\n🔍 Ingresa el título del libro: ");
                    String titulo = scanner.nextLine();

                    DatosLibro datos = cliente.buscarLibroPorTitulo(titulo);

                    if (datos == null) {
                        System.out.println("❌ Libro no encontrado. Intenta con otro título.");
                    } else {
                        System.out.println("\n✅ Libro encontrado:");
                        System.out.println("📖 Título: " + datos.title());
                        System.out.println("✍️ Autor: " + datos.author());
                        System.out.println("🌐 Idioma: " + datos.language());
                        System.out.println("⬇️ Descargas: " + datos.download_count());
                    }
                    break;

                case "2":
                    continuar = false;
                    System.out.println("👋 ¡Gracias por usar el programa!");
                    break;

                default:
                    System.out.println("⚠️ Opción no válida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}
