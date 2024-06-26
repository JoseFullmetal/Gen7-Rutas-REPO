package com.gradilla.app.rutas.repositories;

import java.sql.SQLException;
import java.util.List;

public interface IRepository<T> {

    List<T> listar() throws SQLException;

    T getById(Long id) throws SQLException;

    void guardad (T t) throws SQLException;
    void eliminar (long id) throws SQLException;



}