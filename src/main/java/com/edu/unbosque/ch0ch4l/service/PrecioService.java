package com.edu.unbosque.ch0ch4l.service;

import com.edu.unbosque.ch0ch4l.model.Precio;
import com.edu.unbosque.ch0ch4l.repo.PrecioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrecioService {

    private final PrecioRepo precioRepo;

    @Autowired
    public PrecioService(PrecioRepo precioRepo) {
        this.precioRepo = precioRepo;
    }

    public List<Precio> getAllPrecios() {
        return precioRepo.findAll();
    }

    public Precio getPrecioById(Long id) {
        return precioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Precio no encontrado con id: " + id));
    }

    public Precio createPrecio(Precio precio) {
        return precioRepo.save(precio);
    }

    public Precio updatePrecio(Long id, Precio precio) {
        Precio existingPrecio = precioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Precio no encontrado con id: " + id));
        existingPrecio.setMesa(precio.getMesa());
        existingPrecio.setTipoReserva(precio.getTipoReserva());
        existingPrecio.setCosto(precio.getCosto());
        existingPrecio.setMoneda(precio.getMoneda());
        // Actualizar otros campos según sea necesario
        return precioRepo.save(existingPrecio);
    }

    public void deletePrecio(Long id) {
        precioRepo.deleteById(id);
    }
}
