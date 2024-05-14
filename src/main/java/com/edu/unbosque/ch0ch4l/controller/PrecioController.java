package com.edu.unbosque.ch0ch4l.controller;

import com.edu.unbosque.ch0ch4l.model.Precio;
import com.edu.unbosque.ch0ch4l.service.PrecioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/precios")
public class PrecioController {

    private final PrecioService precioService;

    @Autowired
    public PrecioController(PrecioService precioService) {
        this.precioService = precioService;
    }

    @GetMapping
    public List<Precio> getAllPrecios() {
        return precioService.getAllPrecios();
    }

    @GetMapping("/{id}")
    public Precio getPrecioById(@PathVariable Long id) {
        return precioService.getPrecioById(id);
    }

    @PostMapping
    public Precio createPrecio(@RequestBody Precio precio) {
        return precioService.createPrecio(precio);
    }

    @PutMapping("/{id}")
    public Precio updatePrecio(@PathVariable Long id, @RequestBody Precio precio) {
        return precioService.updatePrecio(id, precio);
    }

    @DeleteMapping("/{id}")
    public void deletePrecio(@PathVariable Long id) {
        precioService.deletePrecio(id);
    }
}
