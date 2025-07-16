
package model;

/**
 *
 * @author Eme
 */
public class Sala {
      private int idSala;
    private int idCine;
    private String nombreSala;
    private int capacidad;

    
    public int getIdSala() { return idSala; }
    public int getIdCine() { return idCine; }
    public String getNombreSala() { return nombreSala; }
    public int getCapacidad() { return capacidad; }
    
    
    public void setIdSala(int idSala) { this.idSala = idSala; }
    public void setIdCine(int idCine) { this.idCine = idCine; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    public void setNombreSala(String nombreSala) { this.nombreSala = nombreSala; }

}
