
package service;

import controller.PeliculaDAO;
import java.util.List;
import model.Pelicula;


public class PeliculaService {
    
    private PeliculaDAO peliculaDAO;

    public PeliculaService() {
        this.peliculaDAO = new PeliculaDAO();
    }

    public List<Pelicula> obtenerTodasLasPeliculas() {
        return peliculaDAO.listarPeliculas();
    }
    
    public List<Pelicula> buscarPeliculas(String titulo) {
        return peliculaDAO.buscarPorTitulo(titulo);
    }

    public boolean guardar(Pelicula pelicula) {
        return peliculaDAO.guardar(pelicula);
    }

    public boolean actualizar(Pelicula pelicula) {
        return peliculaDAO.modificar(pelicula);
    }

    public boolean eliminar(int id) {
        return peliculaDAO.eliminar(id);
    }
    
  
 
}
