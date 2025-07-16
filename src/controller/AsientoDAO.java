package controller;

import bd.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Asiento;

public class AsientoDAO {

    public List<Asiento> obtenerAsientos() {
        List<Asiento> asientos = new ArrayList<>();
        String sql = "SELECT id_asiento, numero FROM asientos";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Asiento asiento = new Asiento();
                asiento.setIdAsiento(rs.getInt("id_asiento"));
                asiento.setNumero(rs.getString("numero"));
                asientos.add(asiento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asientos;
    }
}