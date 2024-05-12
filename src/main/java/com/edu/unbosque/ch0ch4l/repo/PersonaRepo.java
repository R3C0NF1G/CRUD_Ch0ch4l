package com.edu.unbosque.ch0ch4l.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.unbosque.ch0ch4l.model.Persona;

public interface PersonaRepo extends JpaRepository<Persona, Long> {


}
