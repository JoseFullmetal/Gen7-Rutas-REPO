package com.gradilla.app.rutas.repositories;

import java.sql.SQLException;
import java.util.List;

public interface IRepositoryCamion<S> {

    List<S> listar() throws SQLException;

    S getById(Long id) throws SQLException;

    void guardad (S t) throws SQLException;
    void eliminar (long id) throws SQLException;




}
