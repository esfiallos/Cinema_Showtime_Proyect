package controller;

import bd.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DetalleVenta;
import model.Venta;
import controller.AsientoDAO;
import controller.BoletoDAO;

public class VentaDAO {

    public boolean insertarVenta(Venta venta) {
        String sqlVenta = "INSERT INTO ventas (dni_cliente, dni_empleado, id_funcion, fecha_venta) VALUES (?, ?, ?, ?)";
        String sqlDetalle = "INSERT INTO detalles_venta (id_venta, id_boleto, cantidad, id_asiento) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionDB.getConnection()) {
            conn.setAutoCommit(false);

            try (
                PreparedStatement psVenta = conn.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement psDetalle = conn.prepareStatement(sqlDetalle)
            ) {
             
                psVenta.setString(1, venta.getDniCliente());
                psVenta.setString(2, venta.getDniEmpleado());
                psVenta.setInt(3, venta.getIdFuncion());
                psVenta.setTimestamp(4, venta.getFechaCompra());

                psVenta.executeUpdate();

                ResultSet generatedKeys = psVenta.getGeneratedKeys();
                int idCompraGenerada = -1;

                if (generatedKeys.next()) {
                    idCompraGenerada = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("No se pudo obtener el ID de la venta generada.");
                }

              
                for (DetalleVenta det : venta.getDetalles()) {
                    psDetalle.setInt(1, idCompraGenerada);
                    psDetalle.setInt(2, det.getIdBoleto());
                    psDetalle.setInt(3, det.getCantidad());
                    psDetalle.setInt(4, det.getIdAsiento());
                    psDetalle.addBatch();
                }

                psDetalle.executeBatch();
                conn.commit();
                return true;

            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Venta> obtenerVentas() {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM ventas";

        try (
            Connection conn = ConnectionDB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Venta venta = new Venta.Builder()
                    .setIdVenta(rs.getInt("id_venta"))
                    .setDniCliente(rs.getString("dni_cliente"))
                    .setDniEmpleado(rs.getString("dni_empleado"))
                    .setIdFuncion(rs.getInt("id_funcion"))
                    .setFechaCompra(rs.getTimestamp("fecha_venta"))
                    .setDetalles(obtenerDetallesVenta(rs.getInt("id_venta"), conn))
                    .build();

                ventas.add(venta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ventas;
    }

    private List<DetalleVenta> obtenerDetallesVenta(int idCompra, Connection conn) throws SQLException {
        List<DetalleVenta> detalles = new ArrayList<>();
        String sql = "SELECT * FROM detalles_venta WHERE id_venta = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCompra);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DetalleVenta detalle = new DetalleVenta.Builder()
                        .setIdDetalleCompra(rs.getInt("id_detalle_venta"))
                        .setIdCompra(rs.getInt("id_venta"))
                        .setIdBoleto(rs.getInt("id_boleto"))
                        .setCantidad(rs.getInt("cantidad"))
                        .setIdAsiento(rs.getInt("id_asiento"))
                        .build();

                    detalles.add(detalle);
                }
            }
        }

        return detalles;
    }
    
    public boolean eliminar(int idVenta) {
        String sql = "DELETE FROM ventas WHERE id_venta = ?";
        try (Connection con = ConnectionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idVenta);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<String> obtenerListaBoletos() {
        List<String> lista = new ArrayList<>();
        BoletoDAO bol = new BoletoDAO();
        try {
            List<model.Boleto> boletos = bol.obtenerBoletos(); 
            for (model.Boleto b : boletos) {
                lista.add(b.getIdBoleto() + " - " + b.getTipoBoleto());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<String> obtenerListaAsientos() {
        List<String> lista = new ArrayList<>();
        AsientoDAO asi = new AsientoDAO();
        try {
            List<model.Asiento> asientos = asi.obtenerAsientos();
            for (model.Asiento a : asientos) {
                lista.add(a.getIdAsiento() + " - " + a.getNumero());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }


}