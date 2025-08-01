package service;

import controller.VentaDAO;
import controller.BoletoDAO;
import controller.AsientoDAO;
import java.util.List;
import java.util.ArrayList;
import model.Venta;

/**
 * Servicio que maneja la lógica relacionada con las ventas,
 * utilizando los DAOs correspondientes para acceso a datos.
 */
public class VentaService {
    private final VentaDAO ventaDAO;
    private final BoletoDAO boletoDAO;
    private final AsientoDAO asientoDAO;

    public VentaService() {
        this.ventaDAO = new VentaDAO();
        this.boletoDAO = new BoletoDAO();
        this.asientoDAO = new AsientoDAO();
    }
    
        /**
     * Elimina una venta según su id.
     * @param id Identificador de la venta a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean eliminar(int id) {
        return ventaDAO.eliminar(id);
    }

     /**
     * Registra una nueva venta en la base de datos.
     * @param venta Objeto Venta con los datos a registrar.
     * @return true si la inserción fue exitosa, false en caso contrario.
     */
    public boolean registrarVenta(Venta venta) {
        return ventaDAO.insertarVenta(venta);
    }

     /**
     * Obtiene la lista completa de ventas sin información adicional.
     * @return Lista de objetos Venta.
     */
    public List<Venta> obtenerVentas() {
        return ventaDAO.obtenerVentas();
    }
    
    /**
     * Obtiene la lista completa de ventas con información relacionada (JOIN).
     * @return Lista de objetos Venta con detalles extendidos.
     */
    public List<Venta> obtenerVentasInner() {
        return ventaDAO.obtenerVentasInner();
    }
    
    /**
    * Obtiene una lista de boletos en formato "id - tipoBoleto".
    * @return Lista de cadenas representando boletos.
    */
    public List<String> obtenerListaBoletos() {
        List<String> lista = new ArrayList<>();
        boletoDAO.obtenerBoletos().forEach(b -> {
            lista.add(b.getIdBoleto() + " - " + b.getTipoBoleto());
        });
        return lista;
    }
    
     /**
     * Obtiene una lista de asientos en formato "id - número".
     * @return Lista de cadenas representando asientos.
     */
    public List<String> obtenerListaAsientos() {
        List<String> lista = new ArrayList<>();
        asientoDAO.obtenerAsientos().forEach(a -> {
            lista.add(a.getIdAsiento() + " - " + a.getNumero());
        });
        return lista;
    }
}