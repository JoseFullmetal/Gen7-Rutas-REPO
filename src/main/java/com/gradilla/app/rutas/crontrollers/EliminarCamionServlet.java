package com.gradilla.app.rutas.crontrollers;

import com.gradilla.app.rutas.models.Camion;
import com.gradilla.app.rutas.models.Chofer;
import com.gradilla.app.rutas.services.CamionService;
import com.gradilla.app.rutas.services.ChoferesService;
import com.gradilla.app.rutas.services.IService;
import com.gradilla.app.rutas.services.IServiceCamion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/camiones/eliminar")
public class EliminarCamionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IServiceCamion<Camion> service = new CamionService(conn);
        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0l;
        }
        Chofer chofer;
        if(id > 0 ){
            Optional<Camion> o = service.getById(id);
            if(o.isPresent()){
                service.eliminarCamion(id);
                resp.sendRedirect(req.getContextPath()+ "/camiones/listar");
            }
            else
            {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el camion en la base de datos!");
            }
        }
        else{
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Errpr el id es null, se debe enviar como parametro en la url!");
        }
    }
}
