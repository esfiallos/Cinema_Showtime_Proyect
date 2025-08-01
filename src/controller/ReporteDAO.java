
package controller;

import bd.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Reporte;
import java.util.ArrayList;

/**
 * DAO que permite generar distintos reportes basados en las ventas y asistencia de películas.
 */
public class ReporteDAO {

    /**
     * Obtiene el total de ventas agrupadas por día.
     * 
     * @return Lista de objetos con fecha y total de ventas.
     * @throws SQLException si ocurre un error en la consulta.
     */
    public List<Object[]> obtenerVentasPorDias() throws SQLException {
    String sql = "SELECT " +
             "DATE(v.fecha_venta) AS fecha_venta, " +
             "SUM(b.precio_base * d.cantidad) AS total_ventas " +
             "FROM ventas v " +
             "JOIN detalles_venta d ON v.id_venta = d.id_venta " +
             "JOIN boletos b ON d.id_boleto = b.id_boleto " +
             "GROUP BY DATE(v.fecha_venta) " +
             "ORDER BY fecha_venta";


        return ejecutarConsulta(sql);
    }

    /**
     * Obtiene la cantidad de ventas realizadas por día (mal nombrado).
     * 
     * @return Lista de objetos con fecha y total de ventas.
     * @throws SQLException si ocurre un error en la consulta.
     */
    public List<Object[]> obtenerPeliculasMasVistas() throws SQLException {
        String sql = "SELECT v.fecha_venta, SUM(b.precio_base * dv.cantidad) AS total_ventas " 
             + "FROM ventas v " 
             + "JOIN detalles_venta dv ON v.id_venta = dv.id_venta " 
             + "JOIN boletos b ON dv.id_boleto = b.id_boleto " 
             + "GROUP BY v.fecha_venta " 
             + "ORDER BY v.fecha_venta";

        return ejecutarConsulta(sql);
    }

    /**
     * Obtiene el total de ingresos generados por cada película.
     * 
     * @return Lista de objetos con título de película e ingresos totales.
     * @throws SQLException si ocurre un error en la consulta.
     */
    public List<Object[]> obtenerIngresosTotales() throws SQLException {
        String sql = "SELECT p.titulo AS pelicula, "
           + "SUM(b.precio_base * dv.cantidad) AS total_ingresos "
           + "FROM ventas v "
           + "JOIN detalles_venta dv ON v.id_venta = dv.id_venta "
           + "JOIN boletos b ON dv.id_boleto = b.id_boleto "
           + "JOIN funciones f ON v.id_funcion = f.id_funcion "
           + "JOIN peliculas p ON f.id_pelicula = p.id_pelicula "
           + "GROUP BY p.titulo "
           + "ORDER BY total_ingresos DESC";

        return ejecutarConsulta(sql);
    }

    /**
     * Obtiene la cantidad total de asistentes por película.
     * 
     * @return Lista de objetos con título de película y cantidad de asistentes.
     * @throws SQLException si ocurre un error en la consulta.
     */
    public List<Object[]> obtenerAsistenciaPorPelicula() throws SQLException {
        String sql = "SELECT p.titulo AS pelicula, COUNT(*) AS cantidad_asistentes "
           + "FROM ventas v "
           + "JOIN funciones f ON v.id_funcion = f.id_funcion "
           + "JOIN peliculas p ON f.id_pelicula = p.id_pelicula "
           + "GROUP BY p.titulo "
           + "ORDER BY cantidad_asistentes DESC";

        return ejecutarConsulta(sql);
    }

    /**
     * Ejecuta una consulta SQL genérica y devuelve los resultados en una lista de objetos.
     * 
     * @param sql Consulta SQL a ejecutar.
     * @return Lista de filas, donde cada fila es un arreglo de objetos.
     * @throws SQLException si ocurre un error durante la ejecución.
     */
    private List<Object[]> ejecutarConsulta(String sql) throws SQLException {
        List<Object[]> datos = new ArrayList<>();
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            int columnas = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                datos.add(fila);
            }
        }
        return datos;
    }
    
}
