package controller;

import bd.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Genero;

public class GeneroDAO {

    private static final String SQL = "Select * from generos";

    public List<Genero> ListarGeneros() {
        List<Genero> lista = new ArrayList<>();

        try (Connection con = ConnectionDB.getConnection();
                PreparedStatement ps = con.prepareStatement(SQL);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Genero genero = new Genero();

                genero.setId_genero(rs.getInt("id_genero"));
                genero.setNombreGenero(rs.getString("nombre_genero"));

                lista.add(genero);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    public String[] obtenerListaGeneros() {
        List<Genero> lista = ListarGeneros();

        String[] soloGeneros = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            soloGeneros[i] = lista.get(i).getNombreGenero();
        }

        return soloGeneros;
    }
}