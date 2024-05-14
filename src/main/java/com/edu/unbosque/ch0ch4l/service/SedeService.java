package com.edu.unbosque.ch0ch4l.service;

import com.edu.unbosque.ch0ch4l.model.Sede;
import com.edu.unbosque.ch0ch4l.repo.SedeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeService {

    private final SedeRepo sedeRepo;

    @Autowired
    public SedeService(SedeRepo sedeRepo) {
        this.sedeRepo = sedeRepo;
    }

    public List<Sede> getAllSedes() {
        return sedeRepo.findAll();
    }

    public Sede getSedeById(Long id) {
        return sedeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Sede no encontrada con id: " + id));
    }

    public Sede createSede(Sede sede) {
        return sedeRepo.save(sede);
    }

    public Sede updateSede(Long id, Sede sede) {
        Sede existingSede = sedeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Sede no encontrada con id: " + id));
        existingSede.setNombre(sede.getNombre());
        existingSede.setDireccion(sede.getDireccion());
        existingSede.setCiudad(sede.getCiudad());
        existingSede.setTelefono(sede.getTelefono());
        // Actualizar otros campos según sea necesario
        return sedeRepo.save(existingSede);
    }

    public void deleteSede(Long id) {
        sedeRepo.deleteById(id);
    }
}
