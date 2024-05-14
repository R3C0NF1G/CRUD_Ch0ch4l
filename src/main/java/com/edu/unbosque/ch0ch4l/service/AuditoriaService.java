package com.edu.unbosque.ch0ch4l.service;

import com.edu.unbosque.ch0ch4l.model.Auditoria;
import com.edu.unbosque.ch0ch4l.repo.AuditoriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriaService {

    private final AuditoriaRepo auditoriaRepo;

    @Autowired
    public AuditoriaService(AuditoriaRepo auditoriaRepo) {
        this.auditoriaRepo = auditoriaRepo;
    }

    public List<Auditoria> getAllAuditorias() {
        return auditoriaRepo.findAll();
    }

    public Auditoria getAuditoriaById(Long id) {
        return auditoriaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Auditoría no encontrada con id: " + id));
    }

    public Auditoria createAuditoria(Auditoria auditoria) {
        return auditoriaRepo.save(auditoria);
    }

    public Auditoria updateAuditoria(Long id, Auditoria auditoria) {
        Auditoria existingAuditoria = auditoriaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Auditoría no encontrada con id: " + id));
        // Actualizar los campos según sea necesario
        existingAuditoria.setIdDetalleReserva(auditoria.getIdDetalleReserva());
        existingAuditoria.setAccion(auditoria.getAccion());
        existingAuditoria.setTablaAfectada(auditoria.getTablaAfectada());
        existingAuditoria.setIdRegistro(auditoria.getIdRegistro());
        existingAuditoria.setDetalleAccion(auditoria.getDetalleAccion());
        existingAuditoria.setFecha(auditoria.getFecha());
        // Puedes agregar más campos aquí según tu modelo
        return auditoriaRepo.save(existingAuditoria);
    }

    public void deleteAuditoria(Long id) {
        auditoriaRepo.deleteById(id);
    }
}
