package com.edu.unbosque.ch0ch4l.controller;

import com.edu.unbosque.ch0ch4l.model.DetalleReserva;
import com.edu.unbosque.ch0ch4l.service.DetalleReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-reservas")
public class DetalleReservaController {

    private final DetalleReservaService detalleReservaService;

    @Autowired
    public DetalleReservaController(DetalleReservaService detalleReservaService) {
        this.detalleReservaService = detalleReservaService;
    }

    @GetMapping
    public List<DetalleReserva> getAllDetalleReservas() {
        return detalleReservaService.getAllDetalleReservas();
    }

    @GetMapping("/{id}")
    public DetalleReserva getDetalleReservaById(@PathVariable Long id) {
        return detalleReservaService.getDetalleReservaById(id);
    }

    @PostMapping
    public DetalleReserva createDetalleReserva(@RequestBody DetalleReserva detalleReserva) {
        return detalleReservaService.createDetalleReserva(detalleReserva);
    }

    @PutMapping("/{id}")
    public DetalleReserva updateDetalleReserva(@PathVariable Long id, @RequestBody DetalleReserva detalleReserva) {
        return detalleReservaService.updateDetalleReserva(id, detalleReserva);
    }

    @DeleteMapping("/{id}")
    public void deleteDetalleReserva(@PathVariable Long id) {
        detalleReservaService.deleteDetalleReserva(id);
    }
}
