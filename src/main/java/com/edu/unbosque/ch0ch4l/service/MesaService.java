package com.edu.unbosque.ch0ch4l.service;

import com.edu.unbosque.ch0ch4l.model.Mesa;
import com.edu.unbosque.ch0ch4l.repo.MesaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {

    private final MesaRepo mesaRepo;

    @Autowired
    public MesaService(MesaRepo mesaRepo) {
        this.mesaRepo = mesaRepo;
    }

    public List<Mesa> getAllMesas() {
        return mesaRepo.findAll();
    }

    public Mesa getMesaById(Long id) {
        return mesaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada con id: " + id));
    }

    public Mesa createMesa(Mesa mesa) {
        return mesaRepo.save(mesa);
    }

    public Mesa updateMesa(Long id, Mesa mesa) {
        Mesa existingMesa = mesaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada con id: " + id));
        existingMesa.setCantidadPersonas(mesa.getCantidadPersonas());
        existingMesa.setNoMesa(mesa.getNoMesa());
        // Actualizar otros campos según sea necesario
        return mesaRepo.save(existingMesa);
    }

    public void deleteMesa(Long id) {
        mesaRepo.deleteById(id);
    }
}
