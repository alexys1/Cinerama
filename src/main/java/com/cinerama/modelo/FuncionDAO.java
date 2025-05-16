package com.cinerama.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionDAO {

    public List<Funcion> buscarFunciones(String idPelicula, String idCine, String fecha) {
        List<Funcion> lista = new ArrayList<>();

        String sql = "SELECT p.titulo, c.nombre, f.hora, f.precio "
                   + "FROM funciones f "
                   + "JOIN peliculas p ON f.id_pelicula = p.id "
                   + "JOIN cines c ON f.id_cine = c.id "
                   + "WHERE f.id_pelicula = ? AND f.id_cine = ? AND f.fecha = ?";

        try (
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, Integer.parseInt(idPelicula));
            ps.setInt(2, Integer.parseInt(idCine));
            ps.setString(3, fecha);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Funcion funcion = new Funcion();
                funcion.setTituloPelicula(rs.getString(1));
                funcion.setNombreCine(rs.getString(2));
                funcion.setHora(rs.getString(3));
                funcion.setPrecio(rs.getDouble(4));
                lista.add(funcion);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}

