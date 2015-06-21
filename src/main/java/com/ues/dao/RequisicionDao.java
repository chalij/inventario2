package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.Cliente;
import com.ues.model.Empleado;
import com.ues.model.Requisicion;
import java.util.List;

/**
 *
 * @author Airy
 */
public interface RequisicionDao {

    public void crearRequisicion(Requisicion requisicion) throws DAOException;

    public List<Requisicion> listaRequisicion() throws DAOException;

    public List<Cliente> listaCliente() throws DAOException;

    public void borrarRequisicion(Requisicion requisicion) throws DAOException;

    public void modificarRequisicion(Requisicion requisicion) throws DAOException;

    public List<Empleado> listaEmpleado() throws DAOException;
    
    public int maxID(String table) throws DAOException;

}
