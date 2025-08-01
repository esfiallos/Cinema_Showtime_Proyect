
package model;

import java.sql.Date;
import java.util.List;

/**
 * Representa una película con sus detalles básicos, como título, director, duración,
 * sinopsis, restricción de edad, fecha de estreno y géneros asociados.
 * Utiliza el patrón Builder para facilitar la creación de objetos.
 */
public class Pelicula {
    
    private int idPelicula;
    private String titulo;
    private String director;
    private String sinopsis;
    private int duracion;
    private String restriccionEdad;
    private Date fechaEstreno;
    private List<String> generos;

    private Pelicula() {}

    public int getIdPelicula() { return idPelicula; }
    public String getTitulo() { return titulo; }
    public String getDirector() { return director; }
    public int getDuracion() { return duracion; }
    public String getSinopsis() { return sinopsis; }
    public String getRestriccionEdad() { return restriccionEdad; }
    public Date getFechaEstreno() { return fechaEstreno; }
    public List<String> getGeneros() { return generos; }
    
    public void setGeneros(List<String> generos) { this.generos = generos; }
    public void setIdPelicula(int idPelicula) { this.idPelicula = idPelicula; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDirector(String director) { this.director = director; }
    public void setRestriccionEdad(String restriccionEdad) { this.restriccionEdad = restriccionEdad; }
    public void setFechaEstreno(Date fechaEstreno) { this.fechaEstreno = fechaEstreno; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }
    public void setDuracion(int duracion) { this.duracion = duracion; }
    
    

    /**
     * Builder para construir objetos Pelicula de forma fluida y clara.
     */
    public static class Builder {
        private final Pelicula pelicula;

        public Builder() {
            pelicula = new Pelicula();
        }

        public Builder setIdPelicula(int idPelicula) {
            pelicula.setIdPelicula(idPelicula);
            return this;
        }

        public Builder setTitulo(String titulo) {
            pelicula.setTitulo(titulo);
            return this;
        }

        public Builder setDirector(String director) {
            pelicula.setDirector(director);
            return this;
        }
        
         public Builder setIDuracion(int duracion) {
            pelicula.setDuracion(duracion);
            return this;
        }


        public Builder setSinopsis(String sinopsis) {
            pelicula.setSinopsis(sinopsis);
            return this;
        }

        public Builder setRestriccionEdad(String restriccionEdad) {
            pelicula.setRestriccionEdad(restriccionEdad);
            return this;
        }

        public Builder setFechaEstreno(Date fechaEstreno) {
            pelicula.setFechaEstreno(fechaEstreno);
            return this;
        }

        public Builder setGeneros(List<String> generos) {
            pelicula.setGeneros(generos);
            return this;
        }

        /**
         * Construye y retorna la instancia de Pelicula.
         * @return objeto Pelicula construido.
         */
        public Pelicula build() {
            return pelicula;
        }
    }
}
