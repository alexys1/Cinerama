package com.cinerama.controlador;

import com.cinerama.modelo.Funcion;
import com.cinerama.modelo.FuncionDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BuscarServlet", urlPatterns = {"/BuscarServlet"})
public class BuscarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idPelicula = request.getParameter("pelicula");
        String idCine = request.getParameter("cine");
        String fecha = request.getParameter("fecha");

        // Conexión a la base de datos
        FuncionDAO dao = new FuncionDAO();
        List<Funcion> resultados = dao.buscarFunciones(idPelicula, idCine, fecha);

        request.setAttribute("resultados", resultados);
        request.setAttribute("fecha", fecha);

        RequestDispatcher dispatcher = request.getRequestDispatcher("resultados.jsp");
        dispatcher.forward(request, response);
    }
}
