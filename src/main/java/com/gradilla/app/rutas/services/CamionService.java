package com.gradilla.app.rutas.services;
import com.gradilla.app.rutas.models.Camion;
import com.gradilla.app.rutas.models.Chofer;

import com.gradilla.app.rutas.repositories.CamionRepository;
import com.gradilla.app.rutas.repositories.ChoferesRepository;
import com.gradilla.app.rutas.repositories.IRepositoryCamion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
public class CamionService implements IServiceCamion<Camion> {


    private IRepositoryCamion<Camion> camionRepo;

    public CamionService(Connection conn){camionRepo = new CamionRepository(conn);}

    @Override
    public List<Camion> listar() {
        try {
            return camionRepo.listar();
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Camion> getById(Long id) {
        try {
            return Optional.ofNullable(camionRepo.getById(id));
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }

    }

    ///////////////////////////////////////////////////////////////
    @Override
    public void guardarCamion(Camion camion) {
        try {
            camionRepo.guardad(camion);
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }
///////////////////////////////////////////////////////////////////

    @Override
    public void eliminarCamion(Long id) {
        try {
            camionRepo.eliminarr(id);
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }

    }

}