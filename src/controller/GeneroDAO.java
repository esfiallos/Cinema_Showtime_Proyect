package controller;

import bd.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Genero;

/**
 * Clase DAO que gestiona el acceso a los datos de los géneros de películas.
 * Utiliza JDBC para conectarse a la base de datos y recuperar información de la tabla 'generos'.
 */
public class GeneroDAO {

    private static final String SQL = "Select * from generos";

     /**
     * Consulta todos los géneros disponibles en la base de datos.
     *
     * @return Una lista de objetos {@link Genero} con los datos recuperados.
     */
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

    /**
     * Obtiene una lista de nombres de géneros en formato de arreglo de cadenas.
     * Esta función es útil para mostrar los géneros en interfaces gráficas (combo box, listas, etc.).
     *
     * @return Arreglo de Strings con los nombres de todos los géneros disponibles.
     */
    public String[] obtenerListaGeneros() {
        List<Genero> lista = ListarGeneros();

        String[] soloGeneros = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            soloGeneros[i] = lista.get(i).getNombreGenero();
        }

        return soloGeneros;
    }
}