
package model;

/**
 * Representa el detalle de una venta en el sistema de cine.
 * 
 * Cada detalle está vinculado a una venta específica e incluye información
 * sobre el boleto comprado, la cantidad adquirida y el asiento asignado.
 */
public class DetalleVenta {
    
    private int idDetalleVenta;  // Antes: idDetalleCompra
    private int idVenta;    
    private int idBoleto;
    private int cantidad;
    private int idAsiento;

    public int getIdDetalleVenta() { return idDetalleVenta; }
    public void setIdDetalleVenta(int idDetalleVenta) { this.idDetalleVenta = idDetalleVenta; }

    public int getIdVenta() { return idVenta; }
    public void setIdVenta(int idVenta) { this.idVenta = idVenta; }

    public int getIdBoleto() { return idBoleto; }
    public void setIdBoleto(int idBoleto) { this.idBoleto = idBoleto; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public int getIdAsiento() { return idAsiento; }
    public void setIdAsiento(int idAsiento) { this.idAsiento = idAsiento; }
    
    /**
    * Clase Builder para construir objetos {@link DetalleVenta} de forma flexible.
    * 
    * Utiliza el patrón Builder para permitir una creación fluida y ordenada del objeto.
    */
    public static class Builder {
        private final DetalleVenta d;

        public Builder() {
            d = new DetalleVenta();
        }

        public Builder setIdDetalleVenta(int idDetalleVenta) {
            d.setIdDetalleVenta(idDetalleVenta);
            return this;
        }

        public Builder setIdVenta(int idVenta) {
            d.setIdVenta(idVenta);
            return this;
        }

        public Builder setIdBoleto(int idBoleto) {
            d.setIdBoleto(idBoleto);
            return this;
        }

        public Builder setCantidad(int cantidad) {
            d.setCantidad(cantidad);
            return this;
        }

        public Builder setIdAsiento(int idAsiento) {
            d.setIdAsiento(idAsiento);
            return this;
        }

        /**
        * Construye y retorna el objeto {@link DetalleVenta} configurado.
        * 
        * @return Instancia final de DetalleVenta con los datos establecidos.
        */
        public DetalleVenta build() {
            return d;
        }
    }
    
}
