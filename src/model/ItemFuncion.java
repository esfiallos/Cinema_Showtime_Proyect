
package model;

public class ItemFuncion {
    private int idFuncion;
    private String nombreSala;

    public ItemFuncion(int idFuncion, String nombreSala) {
        this.idFuncion = idFuncion;
        this.nombreSala = nombreSala;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    @Override
    public String toString() {
        return idFuncion + " - " + nombreSala;
    }
}
