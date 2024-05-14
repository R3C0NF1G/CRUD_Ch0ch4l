package com.edu.unbosque.ch0ch4l.service;

import com.edu.unbosque.ch0ch4l.model.Persona;
import com.edu.unbosque.ch0ch4l.repo.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    private final PersonaRepo personaRepo;

    @Autowired
    public PersonaService(PersonaRepo personaRepo) {
        this.personaRepo = personaRepo;
    }

    public List<Persona> getAllPersonas() {
        return personaRepo.findAll();
    }

    public Persona getPersonaById(Long id) {
        return personaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con id: " + id));
    }

    public Persona createPersona(Persona persona) {
        return personaRepo.save(persona);
    }

    public Persona updatePersona(Long id, Persona persona) {
        Persona existingPersona = personaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con id: " + id));
        existingPersona.setDni(persona.getDni());
        existingPersona.setNombres(persona.getNombres());
        existingPersona.setApellidos(persona.getApellidos());
        existingPersona.setFechaNac(persona.getFechaNac());
        existingPersona.setTelefono(persona.getTelefono());
        existingPersona.setEmail(persona.getEmail());
        existingPersona.setDireccion(persona.getDireccion());
        existingPersona.setTipoPersona(persona.getTipoPersona());
        // Actualizar otros campos según sea necesario
        return personaRepo.save(existingPersona);
    }

    public void deletePersona(Long id) {
        personaRepo.deleteById(id);
    }
}
