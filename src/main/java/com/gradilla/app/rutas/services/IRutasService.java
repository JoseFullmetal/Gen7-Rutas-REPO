package com.gradilla.app.rutas.services;

import com.gradilla.app.rutas.models.Camion;
import com.gradilla.app.rutas.models.Chofer;
import com.gradilla.app.rutas.models.Ruta;

import java.util.List;

public interface IRutasService extends IService<Ruta>{

    List<Camion> listarCamiones();

    List<Chofer> ListarChoferes();

    Long guardarReturnId(Ruta ruta);
}
