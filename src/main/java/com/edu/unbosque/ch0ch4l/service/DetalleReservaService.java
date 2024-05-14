package com.edu.unbosque.ch0ch4l.service;

import com.edu.unbosque.ch0ch4l.model.DetalleReserva;
import com.edu.unbosque.ch0ch4l.repo.DetalleReservaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleReservaService {

    private final DetalleReservaRepo detalleReservaRepo;

    @Autowired
    public DetalleReservaService(DetalleReservaRepo detalleReservaRepo) {
        this.detalleReservaRepo = detalleReservaRepo;
    }

    public List<DetalleReserva> getAllDetalleReservas() {
        return detalleReservaRepo.findAll();
    }

    public DetalleReserva getDetalleReservaById(Long id) {
        return detalleReservaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de reserva no encontrado con id: " + id));
    }

    public DetalleReserva createDetalleReserva(DetalleReserva detalleReserva) {
        return detalleReservaRepo.save(detalleReserva);
    }

    public DetalleReserva updateDetalleReserva(Long id, DetalleReserva detalleReserva) {
        DetalleReserva existingDetalleReserva = detalleReservaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de reserva no encontrado con id: " + id));
        // Actualizar los campos según sea necesario
        existingDetalleReserva.setReserva(detalleReserva.getReserva());
        existingDetalleReserva.setUsuario(detalleReserva.getUsuario());
        existingDetalleReserva.setPrecio(detalleReserva.getPrecio());
        existingDetalleReserva.setEstado(detalleReserva.getEstado());
        existingDetalleReserva.setPrecioTotal(detalleReserva.getPrecioTotal());
        // Puedes agregar más campos aquí según tu modelo
        return detalleReservaRepo.save(existingDetalleReserva);
    }

    public void deleteDetalleReserva(Long id) {
        detalleReservaRepo.deleteById(id);
    }
}
