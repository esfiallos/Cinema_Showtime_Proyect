package controller;

import model.Funcion;
import bd.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para manejar operaciones CRUD relacionadas con funciones de películas.
 * Proporciona métodos para insertar, actualizar, eliminar y consultar funciones.
 */

public class FuncionDAO {

        /**
        * Obtiene todas las funciones sin hacer joins con otras tablas.
        *
        * @return Lista de objetos {@link model.Funcion} obtenidos desde la tabla funciones.
        */
        public List<Funcion> obtenerTodas() {
            List<Funcion> lista = new ArrayList<>();
            String sql = "SELECT * FROM funciones";

            try (Connection conn = ConnectionDB.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Funcion funcion = new Funcion.Builder()
                        .idFuncion(rs.getInt("id_funcion"))
                        .idPelicula(rs.getInt("id_pelicula"))
                        .fechaFuncion(rs.getTimestamp("fecha_funcion"))
                        .horaInicio(rs.getTime("hora_inicio"))
                        .tipoProyeccion(rs.getString("tipo_proyeccion"))
                        .build();

                    lista.add(funcion);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return lista;
        }

        /**
        * Obtiene todas las funciones, incluyendo el título de la película asociada mediante JOIN.
        *
        * @return Lista de objetos {@link model.Funcion} con información adicional del título de la película.
        */
        public List<Funcion> obtenerTodasInner() {
            List<Funcion> lista = new ArrayList<>();

            String sql = "SELECT f.id_funcion, f.id_pelicula, f.fecha_funcion, f.hora_inicio, f.tipo_proyeccion, " +
                         "p.titulo AS titulo_pelicula " +
                         "FROM funciones f " +
                         "JOIN peliculas p ON f.id_pelicula = p.id_pelicula " +
                         "ORDER BY f.fecha_funcion, f.hora_inicio";

            try (Connection conn = ConnectionDB.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Funcion funcion = new Funcion.Builder()
                        .idFuncion(rs.getInt("id_funcion"))
                        .idPelicula(rs.getInt("id_pelicula"))
                        .fechaFuncion(rs.getTimestamp("fecha_funcion"))
                        .horaInicio(rs.getTime("hora_inicio"))
                        .tipoProyeccion(rs.getString("tipo_proyeccion"))
                        // Supongamos que agregas estos atributos a tu modelo Funcion
                        .tituloPelicula(rs.getString("titulo_pelicula"))
                        .build();

                    lista.add(funcion);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return lista;
        }

        /**
        * Inserta una nueva función en la base de datos.
        *
        * @param f Objeto {@link model.Funcion} que contiene los datos a insertar.
        * @return true si la operación fue exitosa; false en caso contrario.
        */
        public boolean insertar(Funcion f) {
            String sql = "INSERT INTO funciones (id_pelicula, fecha_funcion, hora_inicio, tipo_proyeccion) VALUES (?, ?, ?, ?)";

            try (Connection conn = ConnectionDB.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, f.getIdPelicula());
                ps.setTimestamp(2, f.getFechaFuncion());
                ps.setTime(3, f.getHoraInicio());
                ps.setString(4, f.getTipoProyeccion());

                return ps.executeUpdate() > 0;

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false;
        }

        /**
        * Actualiza una función existente en la base de datos.
        *
        * @param f Objeto {@link model.Funcion} con los datos actualizados.
        * @return true si la operación fue exitosa; false en caso contrario.
        */

        public boolean actualizar(Funcion f) {
            String sql = "UPDATE funciones SET id_pelicula = ?, fecha_funcion = ?, hora_inicio = ?, tipo_proyeccion = ? WHERE id_funcion = ?";

            try (Connection conn = ConnectionDB.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, f.getIdPelicula());
                ps.setTimestamp(2, f.getFechaFuncion());
                ps.setTime(3, f.getHoraInicio());
                ps.setString(4, f.getTipoProyeccion());
                ps.setInt(5, f.getIdFuncion());

                return ps.executeUpdate() > 0;

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false;
        }

        /**
        * Elimina una función de la base de datos según su ID.
        *
        * @param idFuncion Identificador único de la función a eliminar.
        * @return true si la operación fue exitosa; false en caso contrario.
        */
        public boolean eliminar(int idFuncion) {
            String sql = "DELETE FROM funciones WHERE id_funcion = ?";

            try (Connection conn = ConnectionDB.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, idFuncion);
                return ps.executeUpdate() > 0;

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false;
        }

    /**
    * Obtiene todos los tipos de proyección distintos disponibles en las funciones.
    *
    * @return Lista de cadenas con los tipos de proyección únicos registrados.
    */
    public List<String> obtenerTiposProyeccion() {
             List<String> tipos = new ArrayList<>();
        String sql = "SELECT DISTINCT tipo_proyeccion FROM funciones";

        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                tipos.add(rs.getString("tipo_proyeccion"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tipos;
    }
}
