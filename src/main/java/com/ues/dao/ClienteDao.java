package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.Cliente;
import com.ues.model.Persona;
import com.ues.model.TipoCliente;
import com.ues.model.TipoUsuario;
import java.util.List;

/**
 *
 * @author Jocelyn
 */
public interface ClienteDao {
     public void crearCliente(Cliente cliente) throws DAOException;
   public Cliente buscaCliente(Integer idCliente) throws DAOException;
   public List<Cliente> listaClientes() throws DAOException;
   public void modificarCliente(Cliente cliente) throws DAOException;
   public void borrarCliente(Cliente tipocliente) throws DAOException;
   public List<Persona> listaPersonas() throws DAOException;
   public List<TipoCliente> listaTiposCliente() throws DAOException;
   public int maxId() throws DAOException;
    
}