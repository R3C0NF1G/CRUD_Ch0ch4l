package com.edu.unbosque.ch0ch4l.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "dni", nullable=false)
    private int dni;

    @Column(name = "nombres", nullable=false, length = 20)
    private String nombres;

    @Column(name = "apellidos", nullable=false, length = 20)
    private String apellidos;

    @Column(name = "fecha_nac", nullable=false)
    private Date fechaNac;

    @Column(name = "telefono", nullable=false, length = 10)
    private String telefono;

    @Column(name = "email", nullable=false, length = 40)
    private String email;

    @Column(name = "direccion", nullable=false, length = 30)
    private String direccion;

    @Column(name = "tipo_persona", nullable=false, length = 20)
    private String tipoPersona;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Sede> sedes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Sede> getSedes() {
        return sedes;
    }

    public void setSedes(List<Sede> sedes) {
        this.sedes = sedes;
    }

    
}
