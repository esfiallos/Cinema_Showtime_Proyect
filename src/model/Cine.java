package model;

public class Cine {
    private int idCine;
    private String nombreCine;
    private String direccion;
    private String codigoPostal;


    public int getIdCine() { return idCine; }
    public String getCodigoPostal() { return codigoPostal;}
    public String getNombreCine() {return nombreCine;}
    public String getDireccion() { return direccion; }
    
    
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public void setIdCine(int idCine) {
        this.idCine = idCine;
    }
    public void setNombreCine(String nombreCine) {
       this.nombreCine = nombreCine;
    }
    
    
    @Override
    public String toString() {
        return this.nombreCine; 
    }

}