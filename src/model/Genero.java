
package model;


public class Genero {
    
    private int id_genero;
    private String nombreGenero;
    
    public Genero() { };
    
    public Genero(int id, String genero) {
        this.id_genero = id;
        this.nombreGenero = genero;
    }

    public int getId_genero() {  return id_genero;  }
    public String getNombreGenero() { return nombreGenero;   }
    
    
    public void setId_genero(int id_genero) { this.id_genero = id_genero;  }
    public void setNombreGenero(String nombreGenero) { this.nombreGenero = nombreGenero; }
    

    
}
