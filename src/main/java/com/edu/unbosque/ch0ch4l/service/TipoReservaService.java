package com.edu.unbosque.ch0ch4l.service;

import com.edu.unbosque.ch0ch4l.model.TipoReserva;
import com.edu.unbosque.ch0ch4l.repo.TipoReservaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoReservaService {

    private final TipoReservaRepo tipoReservaRepo;

    @Autowired
    public TipoReservaService(TipoReservaRepo tipoReservaRepo) {
        this.tipoReservaRepo = tipoReservaRepo;
    }

    public List<TipoReserva> getAllTipoReservas() {
        return tipoReservaRepo.findAll();
    }

    public TipoReserva getTipoReservaById(Long id) {
        return tipoReservaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de reserva no encontrado con id: " + id));
    }

    public TipoReserva createTipoReserva(TipoReserva tipoReserva) {
        return tipoReservaRepo.save(tipoReserva);
    }

    public TipoReserva updateTipoReserva(Long id, TipoReserva tipoReserva) {
        TipoReserva existingTipoReserva = tipoReservaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de reserva no encontrado con id: " + id));
        existingTipoReserva.setTipo(tipoReserva.getTipo());
        existingTipoReserva.setDescripcion(tipoReserva.getDescripcion());
        // Actualizar otros campos según sea necesario
        return tipoReservaRepo.save(existingTipoReserva);
    }

    public void deleteTipoReserva(Long id) {
        tipoReservaRepo.deleteById(id);
    }
}
