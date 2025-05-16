
package com.cinerama.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PeliculaDAO {
    
private final String url = "jdbc:mysql://localhost:3306/cinerama";
    private final String usuario = "root";
    private final String clave = "258456"; // Reemplaza con tu clave real

    public List<Pelicula> obtenerPeliculas() {
        List<Pelicula> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, usuario, clave);
            String sql = "SELECT * FROM peliculas";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pelicula p = new Pelicula();
                p.setId(rs.getInt("id"));
                p.setTitulo(rs.getString("titulo"));
                p.setImagen(rs.getString("imagen"));
                p.setImagenPc(rs.getString("imagen_pc"));

                p.setDuracion(rs.getString("duracion"));
                p.setClasificacion(rs.getString("clasificacion"));
                lista.add(p);
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
