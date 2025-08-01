
package model;

/**
 * Representa un ítem simplificado de cliente con DNI y nombre.
 * Útil para listas desplegables o selecciones donde solo se necesita
 * mostrar información básica del cliente.
 */
public class ItemCliente {
    private String dni;
    private String nombre;

    public ItemCliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

     /**
     * Representación en texto del objeto, que muestra DNI y nombre concatenados.
     *
     * @return Una cadena con el formato "dni - nombre".
     */
    @Override
    public String toString() {
        return dni + " - " + nombre;
    }
}
