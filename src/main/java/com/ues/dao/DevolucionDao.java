package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.Cliente;
import com.ues.model.Devolucion;
import com.ues.model.Empleado;
import com.ues.model.OrdenDeCompra;
import com.ues.model.Proveedor;
import com.ues.model.Requisicion;
import com.ues.model.TipoDevolucion;
import java.util.List;

/**
 *
 * @author Airy
 */
public interface DevolucionDao {

    public void crearDevolucion(Devolucion devolucion) throws DAOException;

    public List<Devolucion> listaDevolucion() throws DAOException;


    public void borrarDevolucion(Devolucion devolucion) throws DAOException;

    public void modificarDevolucion(Devolucion devolucion) throws DAOException;

    
    public int maxID(String table) throws DAOException;
    
    public List<Requisicion> listaRequisicion() throws DAOException;
    
    public List<Cliente> listaCliente() throws DAOException;
    
    public List<Proveedor> listaProveedor() throws DAOException;
    
    public List<OrdenDeCompra> listaOrden() throws DAOException;
    
    public List<TipoDevolucion> listaTipoDevolucion() throws DAOException;

}
