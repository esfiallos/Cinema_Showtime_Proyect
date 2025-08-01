package controller;

import bd.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Cliente;
import java.util.List;

/**
 * Clase DAO que gestiona las operaciones CRUD sobre la tabla de clientes en la base de datos.
 */
public class ClienteDAO {

     /**
     * Inserta un nuevo cliente en la base de datos.
     *
     * @param cliente Objeto Cliente que contiene los datos a insertar.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    public boolean insertar(Cliente cliente) {
        String sql = "INSERT INTO clientes (dni_cliente, primer_nombre, segundo_nombre, "
                + "primer_apellido, segundo_apellido, genero, correo_cliente, telefono_cliente) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getDniCliente());
            ps.setString(2, cliente.getPrimerNombre());
            ps.setString(3, cliente.getSegundoNombre());
            ps.setString(4, cliente.getPrimerApellido());
            ps.setString(5, cliente.getSegundoApellido());
            ps.setString(6, cliente.getGenero());
            ps.setString(7, cliente.getCorreoCliente());
            ps.setString(8, cliente.getTelefonoCliente());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

     /**
     * Actualiza los datos de un cliente existente.
     *
     * @param cliente Objeto Cliente con los nuevos datos.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizar(Cliente cliente) {
        String sql = "UPDATE clientes SET primer_nombre = ?, segundo_nombre = ?, "
                + "primer_apellido = ?, segundo_apellido = ?, genero = ?, correo_cliente = ?, "
                + "telefono_cliente = ? WHERE dni_cliente = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getPrimerNombre());
            ps.setString(2, cliente.getSegundoNombre());
            ps.setString(3, cliente.getPrimerApellido());
            ps.setString(4, cliente.getSegundoApellido());
            ps.setString(5, cliente.getGenero());
            ps.setString(6, cliente.getCorreoCliente());
            ps.setString(7, cliente.getTelefonoCliente());
            ps.setString(8, cliente.getDniCliente());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina un cliente de la base de datos usando su DNI.
     *
     * @param dni DNI del cliente a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean eliminar(String dni) {
        String sql = "DELETE FROM clientes WHERE dni_cliente = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dni);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

     /**
     * Obtiene un cliente de la base de datos mediante su DNI.
     *
     * @param dni DNI del cliente a buscar.
     * @return Objeto Cliente si se encuentra, null en caso contrario.
     */
    public Cliente obtenerClientePorDni(String dni) {
        String sql = "SELECT * FROM clientes WHERE dni_cliente = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapearCliente(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
     /**
     * Busca clientes por coincidencia parcial en nombres o apellidos.
     *
     * @param texto Texto a buscar en los campos de nombre y apellido.
     * @return Lista de clientes que coinciden con el texto de búsqueda.
     */
    public List<Cliente> buscarPorNombreOApellido(String texto) {
        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM clientes WHERE "
                   + "primer_nombre LIKE ? OR "
                   + "segundo_nombre LIKE ? OR "
                   + "primer_apellido LIKE ? OR "
                   + "segundo_apellido LIKE ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String parametro = "%" + texto + "%";
            ps.setString(1, parametro);
            ps.setString(2, parametro);
            ps.setString(3, parametro);
            ps.setString(4, parametro);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    clientes.add(mapearCliente(rs));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }


    
    public List<Cliente> obtenerTodosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection conn = ConnectionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                clientes.add(mapearCliente(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

     /**
     * Mapea los datos de un ResultSet a un objeto Cliente utilizando el patrón Builder.
     *
     * @param rs ResultSet con los datos del cliente.
     * @return Objeto Cliente con los datos mapeados.
     * @throws SQLException Si ocurre un error al acceder a los datos del ResultSet.
     */
    private Cliente mapearCliente(ResultSet rs) throws SQLException {
        return new Cliente.Builder()
                .setDniCliente(rs.getString("dni_cliente"))
                .setPrimerNombre(rs.getString("primer_nombre"))
                .setSegundoNombre(rs.getString("segundo_nombre"))
                .setPrimerApellido(rs.getString("primer_apellido"))
                .setSegundoApellido(rs.getString("segundo_apellido"))
                .setGenero(rs.getString("genero"))
                .setCorreoCliente(rs.getString("correo_cliente"))
                .setTelefonoCliente(rs.getString("telefono_cliente"))
                .build();
    }
}
