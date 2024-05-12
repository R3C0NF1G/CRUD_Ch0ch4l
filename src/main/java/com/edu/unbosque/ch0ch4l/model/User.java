package com.edu.unbosque.ch0ch4l.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")

public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", nullable=false, length = 20)
    private String username;

    @Column(name = "pwd", nullable=false, length = 20)
    private String pwd;

    @Column(name = "empleado", nullable=false, length = 1)
    private boolean empleado;

    @Column(name = "admin", nullable=false, length = 1)
    private boolean admin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona" , referencedColumnName = "id")
    private Persona persona;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<DetalleReserva> detalleReservas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean isEmpleado() {
        return empleado;
    }

    public void setEmpleado(boolean empleado) {
        this.empleado = empleado;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<DetalleReserva> getDetalleReservas() {
        return detalleReservas;
    }

    public void setDetalleReservas(List<DetalleReserva> detalleReservas) {
        this.detalleReservas = detalleReservas;
    }

    
}
