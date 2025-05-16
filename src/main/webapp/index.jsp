<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List"%>
<%@ page import="com.cinerama.modelo.Pelicula" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <title>Cinerama</title>
  <link rel="stylesheet" href="css/estilo.css">
</head>
<header class="header-cinerama">
    <div class="contenedor-header">
      <!-- Logo que redirige al inicio -->
      <a href="InicioServlet"><img src="img-logos/logo.png" alt="Cinerama Logo" class="logo"></a>
      
      <!-- Menú de navegación -->
      <nav>
        <ul class="nav-menu">
          <li><a href="#">Películas</a></li>
          <li><a href="#">Cines</a></li>
          <li><a href="#">Próximos Estrenos</a></li>
        </ul>
      </nav>

      <!-- Íconos: búsqueda, ayuda, login -->
      <div class="iconos-menu">
         
        <a href="#"><img src="img-logos/icono_buscar.PNG" alt="Buscar" class="icono"></a>
        <a href="#"><img src="img-logos/icono_ayuda.PNG" alt="Ayuda" class="icono"></a>
        <a href="#"><img src="img-logos/icono_usuario.PNG" alt="Login" class="icono"></a>
      </div>
    </div>
  </header>
<body>
  
  <!-- Banner de fondo visible detrás del header -->
  <section class="carrusel">
  <div class="slides">
    <%
      List<Pelicula> carrusel = (List<Pelicula>) request.getAttribute("carruselPeliculas");
      if (carrusel != null && !carrusel.isEmpty()) {
        for (Pelicula p : carrusel) {
    %>
     <img src="<%= p.getImagenPc() %>" alt="<%= p.getTitulo() %>">

    <%
        }
      } else {
    %>
        <img src="img/banner1.jpg" alt="Banner por defecto">
    <%
      }
    %>
  </div>
</section>
<section class="buscador-peliculas">
  <form class="formulario-buscador" method="post" action="BuscarServlet">
    
    <div class="campo">
      <label for="pelicula">Película</label>
      <select name="pelicula" id="pelicula" required>
        <option value="" disabled selected>Selecciona una película</option>
        <%
          List<com.cinerama.modelo.Pelicula> peliculas = (List<com.cinerama.modelo.Pelicula>) request.getAttribute("peliculasDisponibles");
          if (peliculas != null) {
            for (com.cinerama.modelo.Pelicula p : peliculas) {
        %>
          <option value="<%= p.getId() %>"><%= p.getTitulo() %></option>
        <%
            }
          }
        %>
      </select>
    </div>

    <div class="campo">
      <label for="cine">Cine</label>
      <select name="cine" id="cine" required>
        <option value="" disabled selected>Selecciona un cine</option>
        <%
          List<com.cinerama.modelo.Cine> cines = (List<com.cinerama.modelo.Cine>) request.getAttribute("cinesDisponibles");
          if (cines != null) {
            for (com.cinerama.modelo.Cine c : cines) {
        %>
          <option value="<%= c.getId() %>"><%= c.getNombre() %></option>
        <%
            }
          }
        %>
      </select>
    </div>

    <div class="campo">
      <label for="fecha">Fecha</label>
      <input type="date" name="fecha" id="fecha" required>
    </div>

    <div class="campo-boton">
      <button type="submit">🔍 Buscar</button>
    </div>
  </form>
</section>

<section class="cartelera">
  <h2 class="titulo-cartelera">🎬 Películas en emisión</h2>
  <div class="lista-cartelera">
    <%
      List<Pelicula> cartelerapeliculas = (List<Pelicula>) request.getAttribute("listaPeliculas");
      if (peliculas != null && !peliculas.isEmpty()) {
        for (Pelicula p : peliculas) {
    %>
        <div class="pelicula">
          <img src="<%= p.getImagen() %>" alt="<%= p.getTitulo() %>" style="width:200px;"><br>
          <h3><%= p.getTitulo() %></h3>
          <p><strong>Duración:</strong> <%= p.getDuracion() %></p>
          <p><strong>Clasificación:</strong> <%= p.getClasificacion() %></p>
        </div>
    <%
        }
      } else {
    %>
      <p>No hay películas disponibles</p>
    <%
      }
    %>
  </div>
 

<div class="contenedor-boton">
  <a href="CarteleraServlet" class="boton-ver-mas">
    🎟️ Ver cartelera completa
  </a>
</div>


</section>
   
</body>
<footer class="footer-cinerama">
  <div class="footer-contenedor">
    <div class="footer-col">
      <h4>Nosotros</h4>
      <ul>
        <li><a href="#">Quiénes somos</a></li>
        <li><a href="#">Trabaja con nosotros</a></li>
        <li><a href="#">Cines y locales</a></li>
      </ul>
    </div>

    <div class="footer-col">
      <h4>Atención al cliente</h4>
      <ul>
        <li><a href="#">Contáctanos</a></li>
        <li><a href="#">Libro de Reclamaciones</a></li>
        <li><a href="#">Consultas frecuentes</a></li>
      </ul>
    </div>

    <div class="footer-col">
      <h4>Políticas</h4>
      <ul>
        <li><a href="#">Privacidad</a></li>
        <li><a href="#">Términos y condiciones</a></li>
        <li><a href="#">Seguridad</a></li>
      </ul>
    </div>

    <div class="footer-col redes">
      <h4>Síguenos</h4>
      <div class="social-icons">
        <a href="#"><img src="img-logos/fb.png" alt="Facebook"></a>
        <a href="#"><img src="img-logos/ig.png" alt="Instagram"></a>
        <a href="#"><img src="img-logos/yt.png" alt="YouTube"></a>
      </div>
    </div>
  </div>

  <div class="footer-creditos">
    © 2025 Cinerama. Todos los derechos reservados.
  </div>
</footer>



</html>

