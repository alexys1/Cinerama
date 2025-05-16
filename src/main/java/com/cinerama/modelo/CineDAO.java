package com.cinerama.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CineDAO {
    private final String url = "jdbc:mysql://localhost:3306/cinerama";
    private final String usuario = "root";
    private final String clave = "258456";

    public List<Cine> obtenerCines() {
        List<Cine> lista = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(url, usuario, clave);
            String sql = "SELECT id, nombre FROM cines";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cine c = new Cine();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                lista.add(c);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
