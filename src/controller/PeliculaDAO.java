
package controller;

import bd.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Pelicula;


public class PeliculaDAO {
    
     private static final String SQL_LISTAR = 
        "SELECT p.id_pelicula, p.titulo, p.director, p.sinopsis, " 
        + "p.restriccion_edad, p.fecha_estreno, " 
        + "GROUP_CONCAT(g.nombre_genero SEPARATOR ',') AS generos " 
        + "FROM peliculas p " 
        + "LEFT JOIN peliculas_genero pg ON p.id_pelicula = pg.id_pelicula " 
        + "LEFT JOIN generos g ON pg.id_genero = g.id_genero " 
        + "GROUP BY p.id_pelicula, p.titulo, p.director, p.sinopsis, p.restriccion_edad, p.fecha_estreno";

    private static final String SQL_INSERT_PELICULA =
        "INSERT INTO peliculas (titulo, director, sinopsis, restriccion_edad, fecha_estreno) "
            + "VALUES (?, ?, ?, ?, ?)";
    
    private static final String SQL_INSERT_GENEROS =
        "INSERT INTO peliculas_genero (id_pelicula, id_genero) VALUES (?, ?)";

    private static final String SQL_UPDATE_PELICULA =
        "UPDATE peliculas SET titulo = ?, director = ?, sinopsis = ?, restriccion_edad = ?, "
            + "fecha_estreno = ? WHERE id_pelicula = ?";
    
    private static final String SQL_DELETE_GENEROS =
        "DELETE FROM peliculas_genero WHERE id_pelicula = ?";
    
    private static final String SQL_DELETE_PELICULA =
        "DELETE FROM peliculas WHERE id_pelicula = ?";
    
    private static final String SQL_ID = "SELECT MAX(id_pelicula) FROM peliculas" ;


    public List<Pelicula> listarPeliculas() {
        List<Pelicula> lista = new ArrayList<>();
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(SQL_LISTAR);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pelicula pelicula = new Pelicula.Builder()
                        .setIdPelicula(rs.getInt("id_pelicula"))
                        .setTitulo(rs.getString("titulo"))
                        .setDirector(rs.getString("director"))
                        .setSinopsis(rs.getString("sinopsis"))
                        .setRestriccionEdad(rs.getString("restriccion_edad"))
                        .setFechaEstreno(rs.getDate("fecha_estreno"))
                        .setGeneros(Arrays.asList(rs.getString("generos").split(",")))
                        .build();
                lista.add(pelicula);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean guardar(Pelicula pelicula) {
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(SQL_INSERT_PELICULA, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getDirector());
            ps.setString(3, pelicula.getSinopsis());
            ps.setString(4, pelicula.getRestriccionEdad());
            ps.setDate(5, new java.sql.Date(pelicula.getFechaEstreno().getTime()));

            int filas = ps.executeUpdate();
            if (filas == 0) return false;

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idGenerado = generatedKeys.getInt(1);

                    for (String genero : pelicula.getGeneros()) {
                        int idGenero = obtenerIdGeneroPorNombre(con, genero);
                        if (idGenero > 0) {
                            try (PreparedStatement psGenero = con.prepareStatement(SQL_INSERT_GENEROS)) {
                                psGenero.setInt(1, idGenerado);
                                psGenero.setInt(2, idGenero);
                                psGenero.executeUpdate();
                            }
                        }
                    }
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public boolean modificar(Pelicula pelicula) {
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(SQL_UPDATE_PELICULA)) {

            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getDirector());
            ps.setString(3, pelicula.getSinopsis());
            ps.setString(4, pelicula.getRestriccionEdad());
            ps.setDate(5, new java.sql.Date(pelicula.getFechaEstreno().getTime()));
            ps.setInt(6, pelicula.getIdPelicula());

            int filas = ps.executeUpdate();
            if (filas == 0) return false;

            try (PreparedStatement psDel = con.prepareStatement(SQL_DELETE_GENEROS)) {
                psDel.setInt(1, pelicula.getIdPelicula());
                psDel.executeUpdate();
            }

            for (String genero : pelicula.getGeneros()) {
                int idGenero = obtenerIdGeneroPorNombre(con, genero);
                if (idGenero > 0) {
                    try (PreparedStatement psGenero = con.prepareStatement(SQL_INSERT_GENEROS)) {
                        psGenero.setInt(1, pelicula.getIdPelicula());
                        psGenero.setInt(2, idGenero);
                        psGenero.executeUpdate();
                    }
                }
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminar(int id) {
        try (Connection con = ConnectionDB.getConnection()) {
            try (PreparedStatement psDel = con.prepareStatement(SQL_DELETE_GENEROS)) {
                psDel.setInt(1, id);
                psDel.executeUpdate();
            }

            try (PreparedStatement ps = con.prepareStatement(SQL_DELETE_PELICULA)) {
                ps.setInt(1, id);
                return ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private int obtenerIdGeneroPorNombre(Connection con, String nombreGenero) {
        try (PreparedStatement ps = con.prepareStatement("SELECT id_genero FROM generos WHERE nombre_genero = ?")) {
            ps.setString(1, nombreGenero.trim());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt("id_genero");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
