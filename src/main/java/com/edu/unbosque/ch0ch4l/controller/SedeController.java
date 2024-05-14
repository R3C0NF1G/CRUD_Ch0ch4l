package com.edu.unbosque.ch0ch4l.controller;

import com.edu.unbosque.ch0ch4l.model.Sede;
import com.edu.unbosque.ch0ch4l.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sedes")
public class SedeController {

    private final SedeService sedeService;

    @Autowired
    public SedeController(SedeService sedeService) {
        this.sedeService = sedeService;
    }

    @GetMapping
    public List<Sede> getAllSedes() {
        return sedeService.getAllSedes();
    }

    @GetMapping("/{id}")
    public Sede getSedeById(@PathVariable Long id) {
        return sedeService.getSedeById(id);
    }

    @PostMapping
    public Sede createSede(@RequestBody Sede sede) {
        return sedeService.createSede(sede);
    }

    @PutMapping("/{id}")
    public Sede updateSede(@PathVariable Long id, @RequestBody Sede sede) {
        return sedeService.updateSede(id, sede);
    }

    @DeleteMapping("/{id}")
    public void deleteSede(@PathVariable Long id) {
        sedeService.deleteSede(id);
    }
}
