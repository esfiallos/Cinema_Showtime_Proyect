
package model;

import java.sql.Timestamp;
import java.util.List;

public class Venta {

    private int idVenta;
    private String dniCliente;
    private String dniEmpleado;
    private int idFuncion;
    private Timestamp fechaVenta;
    private List<DetalleVenta> detalles;

  
    public int getIdVenta() { return idVenta; }
    public void setIdVenta(int idVenta) { this.idVenta = idVenta; }

    public String getDniCliente() { return dniCliente; }
    public void setDniCliente(String dniCliente) { this.dniCliente = dniCliente; }

    public String getDniEmpleado() { return dniEmpleado; }
    public void setDniEmpleado(String dniEmpleado) { this.dniEmpleado = dniEmpleado; }

    public int getIdFuncion() { return idFuncion; }
    public void setIdFuncion(int idFuncion) { this.idFuncion = idFuncion; }

    public Timestamp getFechaCompra() { return fechaVenta; }
    public void setFechaCompra(Timestamp fechaCompra) { this.fechaVenta = fechaCompra; }

    public List<DetalleVenta> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleVenta> detalles) { this.detalles = detalles; }

    
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

        public Builder setFechaCompra(Timestamp fechaCompra) {
            venta.setFechaCompra(fechaCompra);
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
