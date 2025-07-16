
package controller;

import model.Funcion;
import bd.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionDAO {
    public List<Funcion> obtenerTodas() {
        List<Funcion> lista = new ArrayList<>();
        String sql = "SELECT * FROM funciones";

        try (Connection conn = ConnectionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Funcion funcion = new Funcion.Builder()
                    .setIdFuncion(rs.getInt("id_funcion"))
                    .setIdPelicula(rs.getInt("id_pelicula"))
                    .setIdSala(rs.getInt("id_sala"))
                    .setFechaFuncion(rs.getDate("fecha_funcion"))
                    .setHoraInicio(rs.getTime("hora_inicio"))
                    .setTipoProyeccion(rs.getString("tipo_proyeccion"))
                    .build();
                
                lista.add(funcion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean insertar(Funcion f) {
        String sql = "INSERT INTO funciones (id_pelicula, id_sala, fecha_funcion, hora_inicio, tipo_proyeccion) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, f.getIdPelicula());
            ps.setInt(2, f.getIdSala());
            ps.setDate(3, f.getFechaFuncion());
            ps.setTime(4, f.getHoraInicio());
            ps.setString(5, f.getTipoProyeccion());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean actualizar(Funcion f) {
        String sql = "UPDATE funciones SET id_pelicula = ?, id_sala = ?, fecha_funcion = ?, hora_inicio = ?, tipo_proyeccion = ? WHERE id_funcion = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, f.getIdPelicula());
            ps.setInt(2, f.getIdSala());
            ps.setDate(3, f.getFechaFuncion());
            ps.setTime(4, f.getHoraInicio());
            ps.setString(5, f.getTipoProyeccion());
            ps.setInt(6, f.getIdFuncion());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

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
    
    
    public List<Funcion> obtenerFuncionesINNER() {
    List<Funcion> lista = new ArrayList<>();

        String sql = "SELECT f.id_funcion, f.id_pelicula, f.id_sala, "
                + "f.fecha_funcion, f.hora_inicio, f.tipo_proyeccion, "
                + "p.titulo AS titulo_pelicula, "
                + " s.nombre_sala AS nombre_sala "
            + " FROM funciones f "
            + " JOIN peliculas p ON f.id_pelicula = p.id_pelicula "
            + " JOIN salas s ON f.id_sala = s.id_sala "
            + " ORDER BY f.fecha_funcion, f.hora_inicio";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcion funcion = new Funcion.Builder()
                    .setIdFuncion(rs.getInt("id_funcion"))
                    .setIdPelicula(rs.getInt("id_pelicula"))
                    .setIdSala(rs.getInt("id_sala"))
                    .setFechaFuncion(rs.getDate("fecha_funcion"))
                    .setHoraInicio(rs.getTime("hora_inicio"))
                    .setTipoProyeccion(rs.getString("tipo_proyeccion"))
                    .setTituloPelicula(rs.getString("titulo_pelicula"))
                    .setNombreSala(rs.getString("nombre_sala"))
                    .build();

                lista.add(funcion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}
