package com.gradilla.app.rutas.crontrollers;
import com.gradilla.app.rutas.models.Chofer;
import com.gradilla.app.rutas.services.ChoferesService;
import com.gradilla.app.rutas.services.IService;
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

@WebServlet("/choferes/listar")//controler principal proq ue tiene la url
public class ListaChoferesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");

        IService<Chofer> service = new ChoferesService(conn);
        List<Chofer> choferes= service.listar();
        /*for (Chofer c: chofers){
            resp.getWriter().println("<1>"+ c.getId()+ "->"
            +c.getNombre()+ "->"+c.getApMaterno()+"</h1>");

       */
        //vista
        req.setAttribute("choferes", choferes);
        getServletContext().getRequestDispatcher("/listaChoferes.jsp").forward(req,resp);

        }
    }

