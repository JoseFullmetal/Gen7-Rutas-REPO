package com.gradilla.app.rutas.repositories;
import com.gradilla.app.rutas.models.Ruta;

import java.sql.*;
import java.util.List;

public class RutasRepository implements IRutasRepository{

    private Connection conn;

    public RutasRepository (Connection conn){
        this.conn = conn;
    }

    @Override
    public Long guardarReturnId(Ruta ruta) throws SQLException {
        String sql = "";
        Long resultado = -1l;
        sql = "insert into ruta (ID_RUTA, camion_id, chofer_id, "+
                "dirreccion_origen_id, dirreccion_destino_id, distancia, "+
                "fecha_salida, "+
                "fecha_llegada_estimada, fecha_llegada_real, a_tiempo) "+
                "values (SEQUECE4.NEXTVAL,?,?,?,?,?,?,?,?,?)";
        try(PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"ID_RUTA"})) {
            stmt.setLong(1,ruta.getCamionId());
            stmt.setLong(2,ruta.getChoferId());
            stmt.setLong(3,ruta.getDireccionOrigenId());
            stmt.setLong(4,ruta.getDireccionDestino());
            stmt.setFloat(5,ruta.getDistanca());
            stmt.setDate(6, Date.valueOf(ruta.getFechaSalidad()));
            stmt.setDate(7,Date.valueOf(ruta.getFechaLlegadaEstimada()));
            stmt.setDate(8,Date.valueOf(ruta.getFechaLlegadaEstimada()));
            stmt.setInt(9,ruta.getaTiempo());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                resultado = rs.getLong(1);
            }
        }
        return  resultado;
    }

    @Override
    public List<Ruta> listar() throws SQLException {
        return List.of();
    }

    @Override
    public Ruta getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void guardar(Ruta ruta) throws SQLException {

    }

    @Override
    public void eliminar(long id) throws SQLException {

    }


}
