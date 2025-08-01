package controller;

import bd.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DetalleVenta;
import model.Venta;

/**
 * DAO que permite realizar el registro ventas a la base de datos 
 */
public class VentaDAO {

    /**
    * Inserta una nueva venta y sus respectivos detalles en la base de datos.
    * 
    * Este método utiliza una transacción para insertar primero la venta y luego 
    * los detalles relacionados. Si ocurre un error en cualquier parte, se revierte todo.
    *
    * @param venta Objeto Venta que contiene la información de la venta y sus detalles.
    * @return true si la operación fue exitosa; false en caso contrario.
    */
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
                psVenta.setTimestamp(4, venta.getFechaVenta());

                psVenta.executeUpdate();

                ResultSet generatedKeys = psVenta.getGeneratedKeys();
                int idVentaGenerado = -1;

                if (generatedKeys.next()) {
                    idVentaGenerado = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("No se pudo obtener el ID de la venta generada.");
                }

              
                for (DetalleVenta det : venta.getDetalles()) {
                    psDetalle.setInt(1, idVentaGenerado);
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

    /**
    * Recupera todas las ventas registradas en la base de datos.
    * 
    * Cada venta también incluye sus detalles correspondientes, obtenidos mediante
    * una consulta adicional.
    * 
    * @return Lista de objetos Venta con sus detalles completos.
    */
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
                    .setFechaVenta(rs.getTimestamp("fecha_venta"))
                    .setDetalles(obtenerDetallesVenta(rs.getInt("id_venta"), conn))
                    .build();

                ventas.add(venta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ventas;
    }
    
    /**
    * Recupera todas las ventas junto con el título de la película asociada.
    * 
    * Se utiliza una consulta con INNER JOIN para incluir el título de la película
    * vinculada a la función de la venta. También se cargan los detalles de cada venta.
    *
    * @return Lista de objetos Venta con el título de la película y sus detalles.
    */
    public List<Venta> obtenerVentasInner() {
       List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT v.id_venta, v.dni_cliente, v.dni_empleado, v.id_funcion, v.fecha_venta, p.titulo " +
                     "FROM ventas v " +
                     "JOIN funciones f ON v.id_funcion = f.id_funcion " +
                     "JOIN peliculas p ON f.id_pelicula = p.id_pelicula " +
                     "ORDER BY v.id_venta DESC";

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
                    .setFechaVenta(rs.getTimestamp("fecha_venta"))
                    .setTituloPelicula(rs.getString("titulo"))  
                    .setDetalles(obtenerDetallesVenta(rs.getInt("id_venta"), conn))
                    .build();

                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ventas;
    }


    
    private List<DetalleVenta> obtenerDetallesVenta(int idVenta, Connection conn) throws SQLException {
        List<DetalleVenta> detalles = new ArrayList<>();
        String sql = "SELECT * FROM detalles_venta WHERE id_venta = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idVenta);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DetalleVenta detalle = new DetalleVenta.Builder()
                        .setIdDetalleVenta(rs.getInt("id_detalle_venta"))
                        .setIdVenta(rs.getInt("id_venta"))
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
    
    /**
    * Elimina una venta específica de la base de datos según su ID.
    * 
    * @param idVenta El ID de la venta a eliminar.
    * @return true si se eliminó correctamente; false en caso contrario.
    */
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
    
    /**
    * Obtiene una lista de boletos disponibles en formato texto.
    * 
    * Cada boleto se representa como una cadena con su ID y tipo.
    * 
    * @return Lista de strings con la forma "ID - Tipo de boleto".
    */
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

    /**
    * Obtiene una lista de asientos disponibles en formato texto.
    * 
    * Cada asiento se representa como una cadena con su ID y número.
    * 
    * @return Lista de strings con la forma "ID - Número de asiento".
    */
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