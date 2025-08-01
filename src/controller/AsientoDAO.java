package controller;

import bd.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Asiento;

/**
 * Clase DAO (Data Access Object) encargada de acceder a los datos
 * de la entidad {@link Asiento} desde la base de datos.
 * 
 * Proporciona métodos para recuperar información relacionada con
 * los asientos almacenados.
 */
public class AsientoDAO {

      /**
     * Recupera todos los asientos existentes en la base de datos.
     *
     * @return Una lista de objetos {@link Asiento} con los datos de cada asiento.
     */
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