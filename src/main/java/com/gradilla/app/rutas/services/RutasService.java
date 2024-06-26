package com.gradilla.app.rutas.services;
import com.gradilla.app.rutas.models.Camion;
import com.gradilla.app.rutas.models.Chofer;
import com.gradilla.app.rutas.models.Ruta;
import com.gradilla.app.rutas.repositories.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RutasService implements  IRutasService{

    private IRepository<Chofer> choferesRepo;
    private  IRepositoryCamion<Camion> camionesRepo;
    private IRutasRepository rustasRepository;

    public RutasService(Connection conn){
        this.choferesRepo = new ChoferesRepository(conn);
        this.camionesRepo = new CamionRepository(conn);
        this.rustasRepository = new RutasRepository(conn);
    }

    @Override
    public List<Camion> listarCamiones() {
        try {
            return camionesRepo.listar();
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }



    @Override
    public List<Chofer> ListarChoferes() {
        try {
            return choferesRepo.listar();
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Long guardarReturnId(Ruta ruta) {
        try {
            return rustasRepository.guardarReturnId(ruta);
        }catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Ruta> listar() {
        return List.of();
    }

    @Override
    public Optional<Ruta> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void guardar(Ruta ruta) {

    }

    @Override
    public void eliminar(Long id) {

    }
}