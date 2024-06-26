package com.gradilla.app.rutas.crontrollers;
import com.gradilla.app.rutas.models.Chofer;
import com.gradilla.app.rutas.models.enums.Camion;
import com.gradilla.app.rutas.models.enums.Marcas;
import com.gradilla.app.rutas.models.enums.Tipos;
import com.gradilla.app.rutas.services.ChoferesService;
import com.gradilla.app.rutas.services.IService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
@WebServlet("/camion/alta")
public class AltaCamionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/altaCamion.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Chofer> service = new ChoferesService(conn);
        String matricula = req.getParameter("matricula");
        String tipocamion = req.getParameter("tipocamion");
        String modelo = req.getParameter("modelo");
        String marca = req.getParameter("marca");
        String capacidad = req.getParameter("capacidad");
        String kilometraje = req.getParameter("kilometraje");
        String disponibilidad = req.getParameter("disponibilidad");


        String checkbox[]; // []
        checkbox = req.getParameterValues("disponibilidad");
        Boolean habilitar;
        if (checkbox != null){
            habilitar =true;
        }else {
            habilitar = false;
        }
        Map<String, String> errores = new HashMap<>();
        if (matricula == null || matricula.isBlank()){
            errores.put("matricula", "la matricula es requerida");
        }
        if (tipocamion == null || tipocamion.isBlank()){
            errores.put("tipo_camion", "tipo de camion requerido");
        }
        if (modelo == null || modelo.isBlank()){
            errores.put("modelo", "el apellido materno es requerido");
        }
        if (marca == null || marca.isBlank()){
            errores.put("marca", "la marca es requerida");
        }
        if (capacidad == null || capacidad.isBlank()){
            errores.put("capacidad", "la capacidad es requerida");
        }
        if (kilometraje == null || kilometraje.isBlank()){
            errores.put("kilometraje", "el kilometraje es requerido");
        }
        if (errores.isEmpty()){
            Camion camion = new Camion();
            camion.setId(0L);
            camion.setmatricula(matricula);
            camion.settipo_camion(Tipos.valueOf(tipocamion));
            camion.setModelo(Integer.valueOf(modelo));
            camion.setMarca(Marcas.valueOf(marca));
            camion.setCapasidad(Integer.valueOf(capacidad));
            camion.setKilometraje(Double.valueOf(kilometraje));
            camion.setDisponibilidad(habilitar);
            // service.guardar();
            resp.sendRedirect(req.getContextPath()+ "/camion/listar");
        }else{
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/altaCamion.jsp").forward(req, resp);
        }
    }
}
