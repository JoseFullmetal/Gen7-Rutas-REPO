package com.gradilla.app.rutas.models;

import java.time.LocalDate;

public class Chofer {

    private Long id;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String licencia;
    private String telefono;
    private LocalDate fechaNacimiento;
    private boolean Disponibilidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean getDisponibilidad()
    {
        return Disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {

        this.Disponibilidad = disponibilidad;
    }


}
