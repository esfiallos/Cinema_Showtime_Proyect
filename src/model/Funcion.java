
package model;

import java.sql.Date;
import java.sql.Time;


public class Funcion {
    private int idFuncion;
    private int idPelicula;
    private int idSala;
    private Date fechaFuncion;
    private Time horaInicio;
    private String tipoProyeccion;
    
    private String tituloPelicula;
    private String nombreSala;

   //---------------------------------------------------------------------------
    
    public int getIdFuncion() { return idFuncion; }
    public int getIdPelicula() { return idPelicula; }
    public int getIdSala() { return idSala; }
    public Date getFechaFuncion() { return fechaFuncion; }
    public Time getHoraInicio() { return horaInicio; }
    public String getTipoProyeccion() { return tipoProyeccion; }
    public String getTituloPelicula() { return tituloPelicula; }
    public String getNombreSala() { return nombreSala; }

    
    //--------------------------------------------------------------------------
    
    public void setIdFuncion(int idFuncion) { this.idFuncion = idFuncion; }
    public void setIdPelicula(int idPelicula) { this.idPelicula = idPelicula; }
    public void setIdSala(int idSala) { this.idSala = idSala; }
    public void setFechaFuncion(Date fechaFuncion) { this.fechaFuncion = fechaFuncion; }
    public void setHoraInicio(Time horaInicio) { this.horaInicio = horaInicio; }
    public void setTipoProyeccion(String tipoProyeccion) { this.tipoProyeccion = tipoProyeccion; }
    
    //--------------------------------------------------------------------------

   
    public static class Builder {
        private Funcion funcion;

        public Builder() {
            funcion = new Funcion();
        }

        public Builder setIdFuncion(int id) {
            funcion.idFuncion = id;
            return this;
        }

        public Builder setIdPelicula(int id) {
            funcion.idPelicula = id;
            return this;
        }

        public Builder setIdSala(int id) {
            funcion.idSala = id;
            return this;
        }

        public Builder setFechaFuncion(Date fecha) {
            funcion.fechaFuncion = fecha;
            return this;
        }

        public Builder setHoraInicio(Time hora) {
            funcion.horaInicio = hora;
            return this;
        }

        public Builder setTipoProyeccion(String tipo) {
            funcion.tipoProyeccion = tipo;
            return this;
        }

        public Builder setTituloPelicula(String titulo) {
            funcion.tituloPelicula = titulo;
            return this;
        }

        public Builder setNombreSala(String nombre) {
            funcion.nombreSala = nombre;
            return this;
        }

        public Funcion build() {
            return funcion;
        }
    }
}