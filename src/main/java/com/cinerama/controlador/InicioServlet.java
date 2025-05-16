package com.cinerama.controlador;
import com.cinerama.modelo.Cine;
import com.cinerama.modelo.CineDAO;
import com.cinerama.modelo.Pelicula;
import com.cinerama.modelo.PeliculaDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "InicioServlet", urlPatterns = {"/InicioServlet"})
public class InicioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PeliculaDAO dao = new PeliculaDAO();
        List<Pelicula> todas = dao.obtenerPeliculas();

        // Películas para el carrusel (3 primeras)
   List<Pelicula> carrusel = todas.stream()
        .filter(p -> p.getImagen() != null && !p.getImagen().isEmpty())
        .limit(3)
        .collect(Collectors.toList());


CineDAO cineDAO = new CineDAO();
List<Cine> todosCines = cineDAO.obtenerCines();

request.setAttribute("peliculasDisponibles", todas);

request.setAttribute("cinesDisponibles", todosCines);


    // Películas destacadas para la cartelera (6 primeras)
    List<Pelicula> destacadas = todas.stream()
            .limit(6)
            .collect(Collectors.toList());

    // Enviar ambas listas al index.jsp
    request.setAttribute("carruselPeliculas", carrusel);
    request.setAttribute("listaPeliculas", destacadas);

    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    dispatcher.forward(request, response);
}
}
