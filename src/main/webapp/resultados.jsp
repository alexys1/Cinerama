<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cinerama.modelo.Funcion" %>

<!DOCTYPE html>
<html>
<head>
    <title>Resultados de Búsqueda</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>
        body {
            background-color: #0d0d0d;
            color: #ffffff;
            font-family: Arial, sans-serif;
            padding: 20px;
        }

        .funcion {
            border: 1px solid #333;
            border-radius: 8px;
            padding: 15px;
            margin-bottom: 15px;
            background-color: #1a1a1a;
        }
    </style>
</head>
<body>

<h2>🎬 Resultados para el <%= request.getAttribute("fecha") %></h2>

<%
    List<Funcion> resultados = (List<Funcion>) request.getAttribute("resultados");

    if (resultados != null && !resultados.isEmpty()) {
        for (Funcion f : resultados) {
%>
            <div class="funcion">
                <p><strong>Película:</strong> <%= f.getTituloPelicula() %></p>
                <p><strong>Cine:</strong> <%= f.getNombreCine() %></p>
                <p><strong>Hora:</strong> <%= f.getHora() %></p>
            </div>
<%
        }
    } else {
%>
        <p>No hay funciones disponibles para esa búsqueda.</p>
<%
    }
%>

</body>
</html>
