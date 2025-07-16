package controller;

import bd.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cine;

public class CineDAO {

    private Cine mapearCine(ResultSet rs) throws SQLException {
        Cine cine = new Cine();
        cine.setIdCine(rs.getInt("id_cine"));
        cine.setNombreCine(rs.getString("nombre_cine"));
        cine.setDireccion(rs.getString("direccion"));
        cine.setCodigoPostal(rs.getString("codigo_postal"));
        return cine;
    }

    public List<Cine> obtenerTodosLosCines() {
        List<Cine> lista = new ArrayList<>();
        String sql = "SELECT * FROM cines";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearCine(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    public Cine obtenerCinePorId(int idCine) {
        String sql = "SELECT * FROM cines WHERE id_cine = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCine);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapearCine(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean insertarCine(Cine cine) {
        String sql = "INSERT INTO cines (nombre_cine, direccion, codigo_postal) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cine.getNombreCine());
            ps.setString(2, cine.getDireccion());
            ps.setString(3, cine.getCodigoPostal());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean actualizarCine(Cine cine) {
        String sql = "UPDATE cines SET nombre_cine = ?, direccion = ?, codigo_postal = ? WHERE id_cine = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cine.getNombreCine());
            ps.setString(2, cine.getDireccion());
            ps.setString(3, cine.getCodigoPostal());
            ps.setInt(4, cine.getIdCine());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean eliminarCine(int idCine) {
        String sql = "DELETE FROM cines WHERE id_cine = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCine);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}