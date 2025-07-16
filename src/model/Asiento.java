package model;

public class Asiento {
    private int idAsiento;
    private int idSala;   
    private String numero;
    private String fila;
    private String tipoAsiento;

    public Asiento() {}

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

    @Override
    public String toString() {
        return idAsiento + " - " + numero + " (" + fila + ")";
    }
}