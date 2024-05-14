package com.edu.unbosque.ch0ch4l.controller;

import com.edu.unbosque.ch0ch4l.model.TipoReserva;
import com.edu.unbosque.ch0ch4l.service.TipoReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-reservas")
public class TipoReservaController {

    private final TipoReservaService tipoReservaService;

    @Autowired
    public TipoReservaController(TipoReservaService tipoReservaService) {
        this.tipoReservaService = tipoReservaService;
    }

    @GetMapping
    public List<TipoReserva> getAllTipoReservas() {
        return tipoReservaService.getAllTipoReservas();
    }

    @GetMapping("/{id}")
    public TipoReserva getTipoReservaById(@PathVariable Long id) {
        return tipoReservaService.getTipoReservaById(id);
    }

    @PostMapping
    public TipoReserva createTipoReserva(@RequestBody TipoReserva tipoReserva) {
        return tipoReservaService.createTipoReserva(tipoReserva);
    }

    @PutMapping("/{id}")
    public TipoReserva updateTipoReserva(@PathVariable Long id, @RequestBody TipoReserva tipoReserva) {
        return tipoReservaService.updateTipoReserva(id, tipoReserva);
    }

    @DeleteMapping("/{id}")
    public void deleteTipoReserva(@PathVariable Long id) {
        tipoReservaService.deleteTipoReserva(id);
    }
}

