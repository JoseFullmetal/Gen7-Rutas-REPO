package com.gradilla.app.rutas.repositories;
import com.gradilla.app.rutas.models.enums.Camion;
import com.gradilla.app.rutas.models.enums.Marcas;
import com.gradilla.app.rutas.models.enums.Tipos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CamionRepository implements IRepositoryCamion<Camion> {


    private Connection conn;

    public CamionRepository(Connection conn) {
        this.conn = conn;
    }


    @Override
    public List<Camion> listar() throws SQLException {
        List<Camion> camions = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM CAMIONES")) {
            while (rs.next()) {
                Camion a = this.getCamion(rs);
                camions.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return camions;
    }

    @Override
    public Camion getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void guardad(Camion camion) throws SQLException {
        String sql = "";
        if (camion.getId() != null && camion.getId() > 0) {
            sql = "upodate camiones set MATRICULA=?, TIPO_CAMION=?," +
                    "MODELO=?, MARCA=?, CAPACIDAD=?, " +
                    "KILOMETRAJE=?, DISPONIBILIDAD=? " +
                    " where ID_CAMION=?";
        } else {
            sql = "insert into camiones(ID_CAMION, MATRICULA," +
                    "TIPO_CAMION, MODELO, MARCA, CAPACIDAD," +
                    "KILOMETRAJE, DISPONIBILIDAD) " +
                    "values (-1,?,?,?,?,?,?,?)";
        }
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (camion.getId() != null && camion.getId() > 0) {
                stmt.setString(1, camion.getmatricula());
                stmt.setString(2, camion.gettipo_camion().name());
                stmt.setString(3, String.valueOf(camion.getModelo()));
                stmt.setString(4, camion.getMarca().name());
                stmt.setString(5, String.valueOf(camion.getCapasidad()));
                stmt.setString(6, String.valueOf(camion.getKilometraje()));
                stmt.setInt(   7, camion.getDisponibilidad() ? 1 : 0);
                stmt.setLong(  8, camion.getId());
            } else {
                stmt.setString(1, camion.getmatricula());
                stmt.setString(2, String.valueOf(camion.gettipo_camion()));
                stmt.setString(3, String.valueOf(camion.getModelo()));
                stmt.setString(4, String.valueOf(camion.getMarca()));
                stmt.setString(5, String.valueOf(camion.getCapasidad()));
                stmt.setString(6, String.valueOf(camion.getKilometraje()));
                //Operador ternario
                stmt.setInt(7, camion.getDisponibilidad() ? 1 : 0);
            }
            stmt.executeUpdate();
        }
    }

        @Override
        public void eliminar(long id) throws SQLException {

        }
    private Camion getCamion(ResultSet rs) throws SQLException {
        Camion a = new Camion();
        a.setId(rs.getLong("ID_CAMION"));
        a.setmatricula(rs.getString("MATRICULA"));
        a.settipo_camion(Tipos.valueOf(rs.getString("TIPO_CAMION")));
        a.setModelo(Integer.valueOf(rs.getString("MODELO")));
        a.setMarca(Marcas.valueOf(rs.getString("MARCA")));
        a.setCapasidad(Integer.valueOf(rs.getString("CAPACIDAD")));
        a.setKilometraje(Double.valueOf(rs.getString("KILOMETRAJE")));
        a.setDisponibilidad(rs.getBoolean("DIPONIBILIDAD"));
        return a;
        }

    }



