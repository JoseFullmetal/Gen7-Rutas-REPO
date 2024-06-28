package com.gradilla.app.rutas.models;

import java.time.LocalDate;

public class Ruta {

    private Long id;

    private Long camionId;

    private Long choferId;

    private Long direccionOrigenId;

    private Long direccionDestino;

    private Float distanca;

    private LocalDate fechaSalidad;

    private LocalDate fechaLlegadaEstimada;

    private LocalDate fechaLlgadaReal;

    private Integer aTiempo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCamionId() {
        return camionId;
    }

    public void setCamionId(Long camionId) {
        this.camionId = camionId;
    }

    public Long getChoferId() {
        return choferId;
    }

    public void setChoferId(Long choferId) {
        this.choferId = choferId;
    }

    public Long getDireccionOrigenId() {
        return direccionOrigenId;
    }

    public void setDireccionOrigenId(Long direccionOrigenId) {
        this.direccionOrigenId = direccionOrigenId;
    }

    public Long getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(Long direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public Float getDistanca() {
        return distanca;
    }

    public void setDistanca(Float distanca) {
        this.distanca = distanca;
    }

    public LocalDate getFechaSalidad() {
        return fechaSalidad;
    }

    public void setFechaSalidad(LocalDate fechaSalidad) {
        this.fechaSalidad = fechaSalidad;
    }

    public LocalDate getFechaLlegadaEstimada() {
        return fechaLlegadaEstimada;
    }

    public void setFechaLlegadaEstimada(LocalDate fechaLlegadaEstimada) {
        this.fechaLlegadaEstimada = fechaLlegadaEstimada;
    }

    public LocalDate getFechaLlgadaReal() {
        return fechaLlgadaReal;
    }

    public void setFechaLlgadaReal(LocalDate fechaLlgadaReal) {
        this.fechaLlgadaReal = fechaLlgadaReal;
    }

    public Integer getaTiempo() {
        return aTiempo;
    }

    public void setaTiempo(Integer aTiempo) {
        this.aTiempo = aTiempo;
    }
}
