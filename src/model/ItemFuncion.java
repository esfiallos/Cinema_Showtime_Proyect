
package model;

/**
 * Representa un ítem simplificado de una función, con su ID y nombre de sala.
 * Útil para mostrar opciones básicas de funciones en interfaces de usuario.
 */
public class ItemFuncion {
    private int idFuncion;
    private String nombreSala;

    /**
     * Constructor que inicializa un objeto ItemFuncion con su ID y nombre de sala.
     *
     * @param idFuncion  Identificador único de la función.
     * @param nombreSala Nombre de la sala donde se realiza la función.
     */
    public ItemFuncion(int idFuncion, String nombreSala) {
        this.idFuncion = idFuncion;
        this.nombreSala = nombreSala;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    /**
     * Representación en texto del objeto, que muestra ID y nombre de sala concatenados.
     *
     * @return Una cadena con el formato "idFuncion - nombreSala".
     */
    @Override
    public String toString() {
        return idFuncion + " - " + nombreSala;
    }
}
