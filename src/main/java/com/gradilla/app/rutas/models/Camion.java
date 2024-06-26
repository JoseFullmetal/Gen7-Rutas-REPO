package com.gradilla.app.rutas.models.enums;

public class Camion {


    private Long id;

    private String matricula;

    private Tipos tipoCamion;

    private Integer modelo;

    private Marcas marca;

    private Integer capacidad;

    private Double Kilometraje;

    private Boolean disponibilidad;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getmatricula() {
        return matricula;
    }

    public void setmatricula(String matricula) {
        this.matricula = matricula;
    }

    public Tipos gettipo_camion() {
        return tipoCamion;
    }

    public void settipo_camion(Tipos tipoCamion) {
        this.tipoCamion = tipoCamion;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public Marcas getMarca() {
        return marca;
    }

    public void setMarca(Marcas marca) {
        this.marca = marca;
    }

    public Integer getCapasidad() {
        return capacidad;
    }

    public void setCapasidad(Integer capasidad) {
        this.capacidad = capasidad;
    }

    public Double getKilometraje() {
        return Kilometraje;
    }

    public void setKilometraje(Double kilometraje) {
        Kilometraje = kilometraje;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }


}
