
package service;

import controller.LoginDAO;
import model.Empleado;


public class LoginService {
    
     private final LoginDAO loginDAO = new LoginDAO();

    public Empleado login(String dni, String contrasena) {
        
        return loginDAO.login(dni, contrasena);
    }
    
}
