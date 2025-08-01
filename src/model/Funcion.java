package model;

import java.sql.Timestamp;
import java.sql.Time;

/**
 * Representa una función o proyección de una película en el cine.
 * Contiene información sobre la película, fecha, hora, tipo de proyección
 * y datos adicionales obtenidos mediante JOIN (como título de la película y nombre de la sala).
 */
public class Funcion {
    private int idFuncion;
    private int idPelicula;
    private Timestamp fechaFuncion; // datetime = Timestamp en Java
    private Time horaInicio;
    private String tipoProyeccion;

    // Campos adicionales para JOIN
    private String tituloPelicula;
    private String nombreSala;

    //--------------------------------------------------------------------------

    public int getIdFuncion() { return idFuncion; }
    public int getIdPelicula() { return idPelicula; }
    public Timestamp getFechaFuncion() { return fechaFuncion; }
    public Time getHoraInicio() { return horaInicio; }
    public String getTipoProyeccion() { return tipoProyeccion; }
    
    public String getTituloPelicula() { return tituloPelicula; }
    public String getNombreSala() { return nombreSala; }

    //--------------------------------------------------------------------------

    public void setIdFuncion(int idFuncion) { this.idFuncion = idFuncion; }
    public void setIdPelicula(int idPelicula) { this.idPelicula = idPelicula; }
    public void setFechaFuncion(Timestamp fechaFuncion) { this.fechaFuncion = fechaFuncion; }
    public void setHoraInicio(Time horaInicio) { this.horaInicio = horaInicio; }
    public void setTipoProyeccion(String tipoProyeccion) { this.tipoProyeccion = tipoProyeccion; }

    public void setTituloPelicula(String tituloPelicula) { this.tituloPelicula = tituloPelicula; }
    public void setNombreSala(String nombreSala) { this.nombreSala = nombreSala; }

    //--------------------------------------------------------------------------

    /** 
    * Builder para construir instancias de {@link Funcion} de manera más legible y segura.
    */
    public static class Builder {
        private final Funcion funcion;

        public Builder() {
            funcion = new Funcion();
        }

        public Builder idFuncion(int id) {
            funcion.idFuncion = id;
            return this;
        }

        public Builder idPelicula(int id) {
            funcion.idPelicula = id;
            return this;
        }

        public Builder fechaFuncion(Timestamp fecha) {
            funcion.fechaFuncion = fecha;
            return this;
        }

        public Builder horaInicio(Time hora) {
            funcion.horaInicio = hora;
            return this;
        }

        public Builder tipoProyeccion(String tipo) {
            funcion.tipoProyeccion = tipo;
            return this;
        }

        public Builder tituloPelicula(String titulo) {
            funcion.tituloPelicula = titulo;
            return this;
        }

        public Builder nombreSala(String nombre) {
            funcion.nombreSala = nombre;
            return this;
        }

        /** 
        * Construye y retorna el objeto {@link Funcion} configurado.
        * @return Instancia de {@link Funcion} con los valores establecidos.
        */
        public Funcion build() {
            return funcion;
        }
    }
}
