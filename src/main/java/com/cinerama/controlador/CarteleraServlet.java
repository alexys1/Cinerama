package com.cinerama.controlador;

import com.cinerama.modelo.Pelicula;
import com.cinerama.modelo.PeliculaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CarteleraServlet", urlPatterns = {"/CarteleraServlet"})
public class CarteleraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener películas desde la base de datos
        PeliculaDAO dao = new PeliculaDAO();
        List<Pelicula> listaPeliculas = dao.obtenerPeliculas();

        // Enviar la lista al JSP
        request.setAttribute("listaPeliculas", listaPeliculas);

        // Redirigir a la vista
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}

