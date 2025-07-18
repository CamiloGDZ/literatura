package com.alura.literatura;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibroController {

    @GetMapping("/buscar")
    public DatosLibro buscarLibro(@RequestParam String titulo) {
        GutendexCliente cliente = new GutendexCliente();
        return cliente.buscarLibroPorTitulo(titulo);
    }
}
