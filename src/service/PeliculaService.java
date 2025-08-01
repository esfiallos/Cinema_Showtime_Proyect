
package service;

import controller.PeliculaDAO;
import java.util.List;
import model.Pelicula;

/**
 * Servicio que maneja la lógica de negocio relacionada con películas.
 * Actúa como intermediario entre el controlador y el DAO de películas.
 */
public class PeliculaService {
    
    private PeliculaDAO peliculaDAO;

    public PeliculaService() {
        this.peliculaDAO = new PeliculaDAO();
    }

     /**
     * Obtiene todas las películas disponibles.
     * @return Lista de objetos {@link Pelicula}.
     */
    public List<Pelicula> obtenerTodasLasPeliculas() {
        return peliculaDAO.listarPeliculas();
    }
    
     /**
     * Busca películas cuyo título coincida o contenga el texto dado.
     * @param titulo Texto a buscar en el título de las películas.
     * @return Lista de películas que cumplen el criterio.
     */
    public List<Pelicula> buscarPeliculas(String titulo) {
        return peliculaDAO.buscarPorTitulo(titulo);
    }

     /**
     * Guarda una nueva película en la base de datos.
     * @param pelicula Objeto {@link Pelicula} con los datos a guardar.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    public boolean guardar(Pelicula pelicula) {
        return peliculaDAO.guardar(pelicula);
    }

    
    /**
     * Actualiza una película existente.
     * @param pelicula Objeto {@link Pelicula} con los datos actualizados.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    public boolean actualizar(Pelicula pelicula) {
        return peliculaDAO.modificar(pelicula);
    }

     /**
     * Elimina una película por su identificador.
     * @param id Identificador único de la película a eliminar.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    public boolean eliminar(int id) {
        return peliculaDAO.eliminar(id);
    }
    
  
 
}
