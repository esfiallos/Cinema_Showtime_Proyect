package service;

import controller.EmpleadoDAO;
import model.Empleado;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class EmpleadoService {

    private final EmpleadoDAO empleadoDAO;

    public EmpleadoService() {
        this.empleadoDAO = new EmpleadoDAO();
    }

    
    public List<Empleado> obtenerEmpleados() {
        return empleadoDAO.obtenerEmpleados();
    }

  
    public Empleado obtenerEmpleadoPorDni(String dni) {
        return empleadoDAO.obtenerEmpleadoPorDni(dni);
    }
    
    public Empleado login(String dni, String contrasena) {
        Empleado empleado = empleadoDAO.obtenerEmpleadoPorDni(dni);
        if (empleado != null && BCrypt.checkpw(contrasena, empleado.getContrasena())) {
            return empleado;
        }
        return null;
    }


  
    public boolean insertarEmpleado(Empleado empleado, String contraseñaPlain) {
        String hashed = hashPassword(contraseñaPlain);
        empleado.setContrasena(hashed);
        return empleadoDAO.insertarEmpleado(empleado);
    }

 
    public boolean actualizarEmpleado(Empleado empleado, String nuevaContraseñaPlain) {
        if (nuevaContraseñaPlain != null && !nuevaContraseñaPlain.isEmpty()) {
            String hashed = hashPassword(nuevaContraseñaPlain);
            empleado.setContrasena(hashed);
        } else {
          
        }
        return empleadoDAO.actualizarEmpleado(empleado);
    }


    public boolean eliminarEmpleado(String dni) {
        return empleadoDAO.eliminarEmpleado(dni);
    }

   
    public boolean verificarContraseña(String dni, String contraseñaPlain) {
        Empleado empleado = empleadoDAO.obtenerEmpleadoPorDni(dni);
        if (empleado == null) {
            return false;
        }
        return checkPassword(contraseñaPlain, empleado.getContrasena());
    }

   
    private String hashPassword(String plainPassword) {
      
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
    }

    private boolean checkPassword(String plainPassword, String hashedPassword) {
        if (hashedPassword == null || hashedPassword.isEmpty()) {
            return false;
        }
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
