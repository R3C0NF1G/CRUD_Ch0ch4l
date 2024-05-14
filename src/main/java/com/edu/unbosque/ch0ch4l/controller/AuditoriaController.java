package com.edu.unbosque.ch0ch4l.controller;

import com.edu.unbosque.ch0ch4l.model.Auditoria;
import com.edu.unbosque.ch0ch4l.service.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auditorias")
public class AuditoriaController {

    private final AuditoriaService auditoriaService;

    @Autowired
    public AuditoriaController(AuditoriaService auditoriaService) {
        this.auditoriaService = auditoriaService;
    }

    @GetMapping
    public List<Auditoria> getAllAuditorias() {
        return auditoriaService.getAllAuditorias();
    }

    @GetMapping("/{id}")
    public Auditoria getAuditoriaById(@PathVariable Long id) {
        return auditoriaService.getAuditoriaById(id);
    }

    @PostMapping
    public Auditoria createAuditoria(@RequestBody Auditoria auditoria) {
        return auditoriaService.createAuditoria(auditoria);
    }

    @PutMapping("/{id}")
    public Auditoria updateAuditoria(@PathVariable Long id, @RequestBody Auditoria auditoria) {
        return auditoriaService.updateAuditoria(id, auditoria);
    }

    @DeleteMapping("/{id}")
    public void deleteAuditoria(@PathVariable Long id) {
        auditoriaService.deleteAuditoria(id);
    }
}
