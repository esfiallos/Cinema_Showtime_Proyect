
package model;

/**
 * Representa un género cinematográfico dentro del sistema.
 * 
 * Cada género tiene un identificador único y un nombre asociado.
 */
public class Genero {
    
    private int id_genero;
    private String nombreGenero;
    
    public Genero() { };
    
    /**
    * Constructor que permite inicializar un objeto Genero con todos sus atributos.
    * 
    * @param id Identificador único del género.
    * @param genero Nombre del género.
    */
    public Genero(int id, String genero) {
        this.id_genero = id;
        this.nombreGenero = genero;
    }

    public int getId_genero() {  return id_genero;  }
    public String getNombreGenero() { return nombreGenero;   }
    
    
    public void setId_genero(int id_genero) { this.id_genero = id_genero;  }
    public void setNombreGenero(String nombreGenero) { this.nombreGenero = nombreGenero; }
    

    
}
