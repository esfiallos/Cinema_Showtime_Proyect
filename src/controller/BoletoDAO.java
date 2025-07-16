package controller;

import bd.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Boleto;

public class BoletoDAO {

    public List<Boleto> obtenerBoletos() {
        List<Boleto> boletos = new ArrayList<>();
        String sql = "SELECT id_boleto, tipo_boleto FROM boletos";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Boleto boleto = new Boleto();
                boleto.setIdBoleto(rs.getInt("id_boleto"));
                boleto.setTipoBoleto(rs.getString("tipo_boleto"));
                boletos.add(boleto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boletos;
    }
}