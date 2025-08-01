
package service;

import controller.ReporteDAO;
import java.util.ArrayList;
import java.util.List;
import model.Reporte;

/**
 * Servicio que maneja la lógica relacionada con la obtención de reportes.
 * Utiliza el DAO de Reporte para acceder a la información de la base de datos.
 */
public class ReporteService {
      private final ReporteDAO dao = new ReporteDAO();

     /**
     * Obtiene la lista de ventas agrupadas por días.
     * @return Lista de arreglos de objetos con los datos de ventas por día.
     *         Retorna lista vacía si ocurre algún error.
     */
    public List<Object[]> getVentasPorDias() {
        try {
            return dao.obtenerVentasPorDias();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

     /**
     * Obtiene la lista de películas más vistas.
     * @return Lista de arreglos de objetos con datos de las películas más vistas.
     *         Retorna lista vacía si ocurre algún error.
     */
    public List<Object[]> getPeliculasMasVistas() {
        try {
            return dao.obtenerPeliculasMasVistas();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    
    /**
     * Obtiene los ingresos totales agrupados según el criterio definido en el DAO.
     * @return Lista de arreglos de objetos con los ingresos totales.
     * 
     */
    public List<Object[]> getIngresosTotales() {
        try {
            return dao.obtenerIngresosTotales();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Obtiene la asistencia por película.
     * @return Lista de arreglos de objetos con datos de asistencia por película.
     *         Retorna lista vacía si ocurre algún error.
     */
    public List<Object[]> getAsistenciaPorPelicula() {
        try {
            return dao.obtenerAsistenciaPorPelicula();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
