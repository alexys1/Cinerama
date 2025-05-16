
package com.cinerama.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CineDAO {

    public List<Cine> obtenerCines() {
        List<Cine> lista = new ArrayList<>();
        String sql = "SELECT id, nombre FROM cines";

        try (
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Cine c = new Cine();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
