
package service;

import controller.ReporteDAO;
import java.util.ArrayList;
import java.util.List;
import model.Reporte;


public class ReporteService {
      private final ReporteDAO dao = new ReporteDAO();

    public List<Object[]> getVentasPorDias() {
        try {
            return dao.obtenerVentasPorDias();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Object[]> getPeliculasMasVistas() {
        try {
            return dao.obtenerPeliculasMasVistas();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Object[]> getIngresosTotales() {
        try {
            return dao.obtenerIngresosTotales();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Object[]> getAsistenciaPorPelicula() {
        try {
            return dao.obtenerAsistenciaPorPelicula();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
