package service;

import controller.VentaDAO;
import controller.BoletoDAO;
import controller.AsientoDAO;
import java.util.List;
import java.util.ArrayList;
import model.Venta;

public class VentaService {
    private final VentaDAO ventaDAO;
    private final BoletoDAO boletoDAO;
    private final AsientoDAO asientoDAO;

    public VentaService() {
        this.ventaDAO = new VentaDAO();
        this.boletoDAO = new BoletoDAO();
        this.asientoDAO = new AsientoDAO();
    }
    
    public boolean eliminar(int id) {
        return ventaDAO.eliminar(id);
    }

    public boolean registrarVenta(Venta venta) {
        return ventaDAO.insertarVenta(venta);
    }

    public List<Venta> obtenerVentas() {
        return ventaDAO.obtenerVentas();
    }
    
    // Aquí los métodos nuevos para obtener listas con formato "id - descripción"
    public List<String> obtenerListaBoletos() {
        List<String> lista = new ArrayList<>();
        boletoDAO.obtenerBoletos().forEach(b -> {
            lista.add(b.getIdBoleto() + " - " + b.getTipoBoleto());
        });
        return lista;
    }
    
    public List<String> obtenerListaAsientos() {
        List<String> lista = new ArrayList<>();
        asientoDAO.obtenerAsientos().forEach(a -> {
            lista.add(a.getIdAsiento() + " - " + a.getNumero());
        });
        return lista;
    }
}