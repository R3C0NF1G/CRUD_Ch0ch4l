package com.edu.unbosque.ch0ch4l.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "auditoria")
public class Auditoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_detalle_reserva", nullable=false)
    private int idDetalleReserva;

    @Column(name = "accion", nullable=false, length = 20)
    private String accion;

    @Column(name = "tabla_afectada", nullable=false, length = 20)
    private String tablaAfectada;

    @Column(name = "id_registro", nullable=false)
    private int idRegistro;

    @Column(name = "detalle_accion", nullable=false, length = 200)
    private String detalleAccion;

    @Column(name = "fecha", nullable=false)
    private Timestamp fecha;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIdDetalleReserva() {
        return idDetalleReserva;
    }

    public void setIdDetalleReserva(int idDetalleReserva) {
        this.idDetalleReserva = idDetalleReserva;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getTablaAfectada() {
        return tablaAfectada;
    }

    public void setTablaAfectada(String tablaAfectada) {
        this.tablaAfectada = tablaAfectada;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getDetalleAccion() {
        return detalleAccion;
    }

    public void setDetalleAccion(String detalleAccion) {
        this.detalleAccion = detalleAccion;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    
}
