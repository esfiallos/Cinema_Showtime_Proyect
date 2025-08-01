package service;

import controller.ClienteDAO;
import model.Cliente;
import java.util.List;

/**
 * Servicio que maneja la lógica relacionada con los clientes,
 * delegando las operaciones de acceso a datos al ClienteDAO.
 */
public class ClienteService {

    private final ClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

   
     /**
     * Guarda un nuevo cliente en la base de datos.
     * @param cliente Objeto Cliente a insertar.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    public boolean guardar(Cliente cliente) {
        return clienteDAO.insertar(cliente);
    }


     /**
     * Modifica los datos de un cliente existente.
     * @param cliente Objeto Cliente con los datos actualizados.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean modificar(Cliente cliente) {
        return clienteDAO.actualizar(cliente);
    }

   
     /**
     * Elimina un cliente de la base de datos dado su DNI.
     * @param dniCliente Identificador único del cliente.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean eliminar(String dniCliente) {
        return clienteDAO.eliminar(dniCliente);
    }

  
    
    /**
     * Busca un cliente por su número de DNI.
     * @param dniCliente DNI del cliente a buscar.
     * @return El objeto Cliente correspondiente o null si no se encuentra.
     */
    public Cliente buscarClientePorDni(String dniCliente) {
        return clienteDAO.obtenerClientePorDni(dniCliente);
    }

     /**
     * Obtiene la lista completa de clientes registrados.
     * @return Lista de objetos Cliente.
     */
    public List<Cliente> obtenerClientes() {
        return clienteDAO.obtenerTodosClientes();
    }
    
        /**
     * Busca clientes cuyo nombre o apellido contenga el texto especificado.
     * @param texto Texto para filtrar clientes por nombre o apellido.
     * @return Lista de clientes que coinciden con el criterio.
     */
      public List<Cliente> buscarClientes(String texto) {
        return clienteDAO.buscarPorNombreOApellido(texto);
    }
}