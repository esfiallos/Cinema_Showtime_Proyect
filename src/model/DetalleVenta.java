
package model;


public class DetalleVenta {
    
     private int idDetalleCompra;
    private int idCompra;
    private int idBoleto;
    private int cantidad;
    private int idAsiento;

    public int getIdDetalleCompra() { return idDetalleCompra; }
    public void setIdDetalleCompra(int idDetalleCompra) { this.idDetalleCompra = idDetalleCompra; }

    public int getIdCompra() { return idCompra; }
    public void setIdCompra(int idCompra) { this.idCompra = idCompra; }

    public int getIdBoleto() { return idBoleto; }
    public void setIdBoleto(int idBoleto) { this.idBoleto = idBoleto; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public int getIdAsiento() { return idAsiento; }
    public void setIdAsiento(int idAsiento) { this.idAsiento = idAsiento; }
    
    public static class Builder {
        private final DetalleVenta d;

        public Builder() {
            d = new DetalleVenta();
        }

        public Builder setIdDetalleCompra(int idDetalleCompra) {
            d.setIdDetalleCompra(idDetalleCompra);
            return this;
        }

        public Builder setIdCompra(int idCompra) {
            d.setIdCompra(idCompra);
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

        public DetalleVenta build() {
            return d;
        }
    }
    
}
