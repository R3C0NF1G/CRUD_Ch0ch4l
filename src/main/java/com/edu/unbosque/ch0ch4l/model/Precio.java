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
@Table(name = "precio")
public class Precio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_mesa", referencedColumnName = "id")
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "id_tipo_reserva", referencedColumnName = "id")
    private TipoReserva tipoReserva;

    @OneToMany(mappedBy = "precio", cascade = CascadeType.ALL)
    private List<DetalleReserva> detalleReservas;

    @Column(name = "costo", nullable=false)
    private int costo;

    @Column(name = "moneda", length = 10)
    private String moneda;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public List<DetalleReserva> getDetalleReservas() {
        return detalleReservas;
    }

    public void setDetalleReservas(List<DetalleReserva> detalleReservas) {
        this.detalleReservas = detalleReservas;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    
}
