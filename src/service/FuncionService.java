
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

public class FuncionService {

    private FuncionDAO funcionDAO = new FuncionDAO();

    public List<Funcion> obtenerFunciones() {
        return funcionDAO.obtenerTodas();
    }

    public boolean insertar(Funcion funcion) {
        return funcionDAO.insertar(funcion);
    }

    public boolean actualizar(Funcion funcion) {
        return funcionDAO.actualizar(funcion);
    }

    public boolean eliminar(int idFuncion) {
        return funcionDAO.eliminar(idFuncion);
    }
    
    public List<Funcion> obtenerTodasInner(){
        return funcionDAO.obtenerTodasInner();
    }

    public List<String> obtenerTiposProyeccion() {
            return funcionDAO.obtenerTiposProyeccion();
    }

}
