package com.cinerama.modelo;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PeliculaDAO {

    public List<Pelicula> obtenerPeliculas() {
        List<Pelicula> lista = new ArrayList<>();
        String sql = "SELECT * FROM peliculas";

        try (
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
