package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.Cliente;
import com.ues.model.DetalleProducto;
import com.ues.model.DetalleRequisicion;
import com.ues.model.Empleado;
import com.ues.model.Producto;
import com.ues.model.Requisicion;
import java.util.List;

/**
 *
 * @author Airy
 */
public interface RequisicionDao {

    public void crearRequisicion(Requisicion requisicion,List<Producto> lprod) throws DAOException;

    public List<Requisicion> listaRequisicion() throws DAOException;

    public List<Cliente> listaCliente() throws DAOException;

    public void borrarRequisicion(Requisicion requisicion) throws DAOException;

    public void modificarRequisicion(Requisicion requisicion) throws DAOException;

    public List<Empleado> listaEmpleado() throws DAOException;
    
    public int maxID(String table,String id) throws DAOException;
    
    public Empleado listaBuscarEmp(int persona) throws DAOException;
    
    public void ingresoProceso(List<Producto> listP,Requisicion requiscion) throws DAOException;
    
    public List<Producto> listaProducto() throws DAOException;
    
    public List<DetalleRequisicion> listaDetalleRequisicion(int id) throws DAOException;
    
    public DetalleProducto listaDetalleProducto(int id) throws DAOException;

}
