package model;

/**
 * Representa un asiento dentro de una sala de cine o teatro.
 * Contiene información como el número de asiento, fila, tipo y la sala a la que pertenece.
 */
public class Asiento {
    private int idAsiento;
    private int idSala;   
    private String numero;
    private String fila;
    private String tipoAsiento;

    public Asiento() {}

     /**
     * Constructor completo para inicializar todos los atributos del asiento.
     *
     * @param idAsiento     ID único del asiento.
     * @param idSala        ID de la sala a la que pertenece el asiento.
     * @param numero        Número del asiento.
     * @param fila          Fila del asiento.
     * @param tipoAsiento   Tipo de asiento (VIP, estándar, etc.).
     */
    public Asiento(int idAsiento, int idSala, String numero, String fila, String tipoAsiento) {
        this.idAsiento = idAsiento;
        this.idSala = idSala;
        this.numero = numero;
        this.fila = fila;
        this.tipoAsiento = tipoAsiento;
    }

    public int getIdAsiento() {
        return idAsiento;
    }

    
    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    /**
     * Representación en texto del objeto Asiento.
     * Útil para mostrar en interfaces gráficas o logs.
     *
     * @return una cadena con el ID, número y fila del asiento.
     */
    @Override
    public String toString() {
        return idAsiento + " - " + numero + " (" + fila + ")";
    }
}