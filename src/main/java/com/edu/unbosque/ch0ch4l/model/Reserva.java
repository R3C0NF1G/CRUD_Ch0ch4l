package com.edu.unbosque.ch0ch4l.model;

import java.sql.Date;
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
@Table(name = "reserva")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fecha", nullable=false)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_mesa", referencedColumnName = "id")
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "id_sede", referencedColumnName = "id")
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "id_tipo_reserva", referencedColumnName = "id")
    private TipoReserva tipoReserva;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<DetalleReserva> detalleReservas;

    @Column(name = "cant_personas_adic")
    private Integer cantPersonasAdic;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
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

    public Integer getCantPersonasAdic() {
        return cantPersonasAdic;
    }

    public void setCantPersonasAdic(Integer cantPersonasAdic) {
        this.cantPersonasAdic = cantPersonasAdic;
    }

    
}
