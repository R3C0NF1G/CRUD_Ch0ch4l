package com.edu.unbosque.ch0ch4l.service;

import com.edu.unbosque.ch0ch4l.model.Reserva;
import com.edu.unbosque.ch0ch4l.repo.ReservaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepo reservaRepo;

    @Autowired
    public ReservaService(ReservaRepo reservaRepo) {
        this.reservaRepo = reservaRepo;
    }

    public List<Reserva> getAllReservas() {
        return reservaRepo.findAll();
    }

    public Reserva getReservaById(Long id) {
        return reservaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con id: " + id));
    }

    public Reserva createReserva(Reserva reserva) {
        return reservaRepo.save(reserva);
    }

    public Reserva updateReserva(Long id, Reserva reserva) {
        Reserva existingReserva = reservaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con id: " + id));
        // Actualizar los campos según sea necesario
        existingReserva.setFecha(reserva.getFecha());
        existingReserva.setMesa(reserva.getMesa());
        existingReserva.setSede(reserva.getSede());
        existingReserva.setTipoReserva(reserva.getTipoReserva());
        existingReserva.setCantPersonasAdic(reserva.getCantPersonasAdic());
        // Puedes agregar más campos aquí según tu modelo
        return reservaRepo.save(existingReserva);
    }

    public void deleteReserva(Long id) {
        reservaRepo.deleteById(id);
    }
}
