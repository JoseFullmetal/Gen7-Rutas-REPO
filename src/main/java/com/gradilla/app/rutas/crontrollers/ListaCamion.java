package com.gradilla.app.rutas.crontrollers;

import com.gradilla.app.rutas.models.Chofer;
import com.gradilla.app.rutas.models.enums.Camion;
import com.gradilla.app.rutas.services.CamionService;
import com.gradilla.app.rutas.services.ChoferesService;
import com.gradilla.app.rutas.services.IService;
import com.gradilla.app.rutas.services.IServiceCamion;
import jakarta.jws.WebService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.List;
@WebServlet("/camiones/listar")//controler principal proq ue tiene la url
public class ListaCamion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");

        IServiceCamion<Camion> service = new CamionService(conn);
        List<Camion> camions= service.listar();
    }
}
