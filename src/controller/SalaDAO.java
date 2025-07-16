
package controller;

import bd.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Sala;


public class SalaDAO {
    
    public List<Sala> obtenerTodasLasSalas() {
        List<Sala> lista = new ArrayList<>();
        String sql = "SELECT id_sala, id_cine, nombre_sala, capacidad FROM salas";

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Sala sala = new Sala();
                sala.setIdSala(rs.getInt("id_sala"));
                sala.setIdCine(rs.getInt("id_cine"));
                sala.setNombreSala(rs.getString("nombre_sala"));
                sala.setCapacidad(rs.getInt("capacidad"));
                lista.add(sala);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    
}
