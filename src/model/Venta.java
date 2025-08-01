package model;

import java.sql.Timestamp;
import java.util.List;

/**
 * Modelo que representa una venta realizada en el sistema.
 * Contiene información sobre el cliente, empleado, función, detalles y fecha de la venta.
 */
public class Venta {

    private int idVenta;
    private String dniCliente;
    private String dniEmpleado;
    private int idFuncion;
    private String tituloFuncion;  
    private Timestamp fechaVenta;
    
    private String tituloPelicula; 
    private List<DetalleVenta> detalles;

    public int getIdVenta() { return idVenta; }
    public void setIdVenta(int idVenta) { this.idVenta = idVenta; }

    public String getDniCliente() { return dniCliente; }
    public void setDniCliente(String dniCliente) { this.dniCliente = dniCliente; }

    public String getDniEmpleado() { return dniEmpleado; }
    public void setDniEmpleado(String dniEmpleado) { this.dniEmpleado = dniEmpleado; }

    public int getIdFuncion() { return idFuncion; }
    public void setIdFuncion(int idFuncion) { this.idFuncion = idFuncion; }

    public String getTituloFuncion() { return tituloFuncion; }           
    public void setTituloFuncion(String tituloFuncion) { this.tituloFuncion = tituloFuncion; }  

    public Timestamp getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(Timestamp fechaVenta) { this.fechaVenta = fechaVenta; }

    public String getTituloPelicula() { return tituloPelicula; }
    public void setTituloPelicula(String tituloPelicula) { this.tituloPelicula = tituloPelicula; }
    
    public List<DetalleVenta> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleVenta> detalles) { this.detalles = detalles; }

    /**
     * Builder para facilitar la construcción de objetos Venta.
     */
    public static class Builder {
        private final Venta venta;

        public Builder() {
            venta = new Venta();
        }

        public Builder setIdVenta(int idVenta) {
            venta.setIdVenta(idVenta);
            return this;
        }

        public Builder setDniCliente(String dniCliente) {
            venta.setDniCliente(dniCliente);
            return this;
        }

        public Builder setDniEmpleado(String dniEmpleado) {
            venta.setDniEmpleado(dniEmpleado);
            return this;
        }

        public Builder setIdFuncion(int idFuncion) {
            venta.setIdFuncion(idFuncion);
            return this;
        }

        public Builder setTituloFuncion(String tituloFuncion) {  
            venta.setTituloFuncion(tituloFuncion);
            return this;
        }

        public Builder setFechaVenta(Timestamp fechaVenta) {
            venta.setFechaVenta(fechaVenta);
            return this;
        }
        
        
        public Builder setTituloPelicula(String tituloPelicula) {
            venta.setTituloPelicula(tituloPelicula);
            return this;
        }

        public Builder setDetalles(List<DetalleVenta> detalles) {
            venta.setDetalles(detalles);
            return this;
        }

        public Venta build() {
            return venta;
        }
    }
}
