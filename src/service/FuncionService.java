
package service;

import bd.ConnectionDB;
import controller.FuncionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Funcion;

/**
 * Servicio que maneja la lógica de negocio para operaciones sobre funciones.
 * Se encarga de interactuar con el DAO correspondiente para CRUD y consultas específicas.
 */
public class FuncionService {

    private FuncionDAO funcionDAO = new FuncionDAO();

     /**
     * Obtiene la lista completa de funciones sin joins adicionales.
     * @return Lista de objetos {@link Funcion}.
     */
    public List<Funcion> obtenerFunciones() {
        return funcionDAO.obtenerTodas();
    }

    /**
     * Inserta una nueva función en la base de datos.
     * @param funcion Objeto {@link Funcion} con los datos a insertar.
     * @return true si la inserción fue exitosa, false en caso contrario.
     */
    public boolean insertar(Funcion funcion) {
        return funcionDAO.insertar(funcion);
    }

     /**
     * Actualiza una función existente en la base de datos.
     * @param funcion Objeto {@link Funcion} con los datos actualizados.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizar(Funcion funcion) {
        return funcionDAO.actualizar(funcion);
    }

        /**
     * Elimina una función por su identificador.
     * @param idFuncion Identificador único de la función a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean eliminar(int idFuncion) {
        return funcionDAO.eliminar(idFuncion);
    }
    
     /**
     * Obtiene la lista de funciones incluyendo el título de la película mediante JOIN.
     * @return Lista de objetos {@link Funcion} con información extendida.
     */
    public List<Funcion> obtenerTodasInner(){
        return funcionDAO.obtenerTodasInner();
    }

    /**
     * Obtiene la lista de tipos de proyección disponibles, sin duplicados.
     * @return Lista de strings con los distintos tipos de proyección.
     */
    public List<String> obtenerTiposProyeccion() {
            return funcionDAO.obtenerTiposProyeccion();
    }

}
