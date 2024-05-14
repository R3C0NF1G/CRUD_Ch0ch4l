package com.edu.unbosque.ch0ch4l.controller;

import com.edu.unbosque.ch0ch4l.model.Mesa;
import com.edu.unbosque.ch0ch4l.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    private final MesaService mesaService;

    @Autowired
    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping
    public List<Mesa> getAllMesas() {
        return mesaService.getAllMesas();
    }

    @GetMapping("/{id}")
    public Mesa getMesaById(@PathVariable Long id) {
        return mesaService.getMesaById(id);
    }

    @PostMapping
    public Mesa createMesa(@RequestBody Mesa mesa) {
        return mesaService.createMesa(mesa);
    }

    @PutMapping("/{id}")
    public Mesa updateMesa(@PathVariable Long id, @RequestBody Mesa mesa) {
        return mesaService.updateMesa(id, mesa);
    }

    @DeleteMapping("/{id}")
    public void deleteMesa(@PathVariable Long id) {
        mesaService.deleteMesa(id);
    }
    
}
