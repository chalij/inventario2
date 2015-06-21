package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.Cliente;
import com.ues.model.Devolucion;
import com.ues.model.Empleado;
import com.ues.model.Requisicion;
import java.util.List;

/**
 *
 * @author Airy
 */
public interface DevolucionDao {

    public void crearDevolucion(Devolucion devolucion) throws DAOException;

    public List<Devolucion> listaDevolucion() throws DAOException;

    public List<Cliente> listaCliente() throws DAOException;

    public void borrarDevolucion(Devolucion devolucion) throws DAOException;

    public void modificarDevolucion(Devolucion devolucion) throws DAOException;

    public List<Empleado> listaEmpleado() throws DAOException;
    
    public int maxID(String table) throws DAOException;

}
