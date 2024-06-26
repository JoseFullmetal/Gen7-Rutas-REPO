package com.gradilla.app.rutas.services;
import java.util.List;
import java.util.Optional;
public interface IServiceCamion  <C> {

    List<C> listar();

    Optional<C> getById(Long id);

    void guardarCamion (C t);
    void eliminarCamion (Long id);


}
