package service;

import controller.ClienteDAO;
import model.Cliente;
import java.util.List;

public class ClienteService {

    private final ClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

   
    public boolean guardar(Cliente cliente) {
        return clienteDAO.insertar(cliente);
    }


    public boolean modificar(Cliente cliente) {
        return clienteDAO.actualizar(cliente);
    }

   
    public boolean eliminar(String dniCliente) {
        return clienteDAO.eliminar(dniCliente);
    }

  
    public Cliente buscarClientePorDni(String dniCliente) {
        return clienteDAO.obtenerClientePorDni(dniCliente);
    }

    
    public List<Cliente> obtenerClientes() {
        return clienteDAO.obtenerTodosClientes();
    }
}