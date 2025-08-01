package service;

import controller.EmpleadoDAO;
import model.Empleado;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

/**
 * Servicio encargado de manejar la lógica de negocio relacionada con los empleados.
 * Incluye autenticación, gestión de contraseñas y operaciones CRUD básicas.
 */
public class EmpleadoService {

    private final EmpleadoDAO empleadoDAO;

    public EmpleadoService() {
        this.empleadoDAO = new EmpleadoDAO();
    }

     /**
     * Recupera todos los empleados activos en el sistema.
     *
     * @return Lista de empleados.
     */
    public List<Empleado> obtenerEmpleados() {
        return empleadoDAO.obtenerEmpleados();
    }

  
     /**
     * Busca un empleado por su número de DNI.
     *
     * @param dni El número de documento del empleado.
     * @return El objeto {@link Empleado} si existe, o null si no se encuentra.
     */
    public Empleado obtenerEmpleadoPorDni(String dni) {
        return empleadoDAO.obtenerEmpleadoPorDni(dni);
    }
    
      /**
     * Verifica las credenciales de inicio de sesión de un empleado.
     *
     * @param dni        DNI del empleado.
     * @param contrasena Contraseña en texto plano.
     * @return El objeto {@link Empleado} autenticado si las credenciales son correctas; null en caso contrario.
     */
    public Empleado login(String dni, String contrasena) {
        Empleado empleado = empleadoDAO.obtenerEmpleadoPorDni(dni);
        if (empleado != null && BCrypt.checkpw(contrasena, empleado.getContrasena())) {
            return empleado;
        }
        return null;
    }


  
     /**
     * Inserta un nuevo empleado en la base de datos, cifrando su contraseña.
     *
     * @param empleado         Objeto con los datos del empleado.
     * @param contraseñaPlain  Contraseña en texto plano.
     * @return true si la inserción fue exitosa, false en caso contrario.
     */
    public boolean insertarEmpleado(Empleado empleado, String contraseñaPlain) {
        String hashed = hashPassword(contraseñaPlain);
        empleado.setContrasena(hashed);
        return empleadoDAO.insertarEmpleado(empleado);
    }

 
      /**
     * Actualiza los datos de un empleado. Si se provee una nueva contraseña, también la actualiza.
     *
     * @param empleado              Objeto con los datos actualizados.
     * @param nuevaContraseñaPlain  Nueva contraseña en texto plano (opcional).
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizarEmpleado(Empleado empleado, String nuevaContraseñaPlain) {
        if (nuevaContraseñaPlain != null && !nuevaContraseñaPlain.isEmpty()) {
            String hashed = hashPassword(nuevaContraseñaPlain);
            empleado.setContrasena(hashed);
        } else {
          
        }
        return empleadoDAO.actualizarEmpleado(empleado);
    }


     /**
     * Desactiva un empleado lógicamente, por medio de su DNI.
     *
     * @param dni DNI del empleado a desactivar.
     * @return true si se desactivó correctamente, false en caso contrario.
     */
    public boolean desactivarEmpleado(String dni) {
        return empleadoDAO.desactivarEmpleado(dni);
    }


    /**
     * Verifica si una contraseña ingresada es válida para el empleado con el DNI dado.
     *
     * @param dni               DNI del empleado.
     * @param contraseñaPlain   Contraseña en texto plano.
     * @return true si la contraseña coincide, false en caso contrario.
     */
    public boolean verificarContraseña(String dni, String contraseñaPlain) {
        Empleado empleado = empleadoDAO.obtenerEmpleadoPorDni(dni);
        if (empleado == null) {
            return false;
        }
        return checkPassword(contraseñaPlain, empleado.getContrasena());
    }

   
    /**
     * Cifra una contraseña utilizando el algoritmo BCrypt.
     *
     * @param plainPassword Contraseña en texto plano.
     * @return Contraseña cifrada.
     */
    private String hashPassword(String plainPassword) {
      
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
    }

     /**
     * Compara una contraseña en texto plano con una contraseña cifrada.
     *
     * @param plainPassword  Contraseña en texto plano.
     * @param hashedPassword Contraseña cifrada.
     * @return true si coinciden, false en caso contrario.
     */
    private boolean checkPassword(String plainPassword, String hashedPassword) {
        if (hashedPassword == null || hashedPassword.isEmpty()) {
            return false;
        }
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
