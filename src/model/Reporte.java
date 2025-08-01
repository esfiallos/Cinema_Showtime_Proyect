
package model;

import java.sql.Date;
import java.sql.Time;

/**
 * Modelo que representa un reporte de una función de película.
 * Contiene datos como la función, película asociada, fecha y hora, 
 * total de boletos vendidos y monto recaudado.
 */
public class Reporte {
    
    private int idFuncion;
    private String pelicula;
    private Date fechaFuncion;
    private Time horaInicio;
    private int totalBoletos;
    private double totalRecaudado;

    // Getters y Setters
    public int getIdFuncion() { return idFuncion; }
    public void setIdFuncion(int idFuncion) { this.idFuncion = idFuncion; }

    public String getPelicula() { return pelicula; }
    public void setPelicula(String pelicula) { this.pelicula = pelicula; }

    public Date getFechaFuncion() { return fechaFuncion; }
    public void setFechaFuncion(Date fechaFuncion) { this.fechaFuncion = fechaFuncion; }

    public Time getHoraInicio() { return horaInicio; }
    public void setHoraInicio(Time horaInicio) { this.horaInicio = horaInicio; }

    public int getTotalBoletos() { return totalBoletos; }
    public void setTotalBoletos(int totalBoletos) { this.totalBoletos = totalBoletos; }

    public double getTotalRecaudado() { return totalRecaudado; }
    public void setTotalRecaudado(double totalRecaudado) { this.totalRecaudado = totalRecaudado; }
    
}
