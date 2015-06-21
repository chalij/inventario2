package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.Cliente;
import com.ues.model.Persona;
import com.ues.model.Producto;
import com.ues.model.Proveedor;
import com.ues.model.TipoCliente;
import com.ues.model.TipoProducto;
import com.ues.model.TipoUsuario;
import java.util.List;

/**
 *
 * @author Jocelyn
 */
public interface ProductoDao {

    public void crearProducto(Producto producto) throws DAOException;

    public Producto buscaProducto(Integer idProducto) throws DAOException;

    public List<Producto> listaProductos() throws DAOException;

    public void modificarProducto(Producto producto) throws DAOException;

    public void borrarProducto(Producto tipoProducto) throws DAOException;

    public List<Proveedor> listaProveedores() throws DAOException;

    public List<TipoProducto> listaTiposProducto() throws DAOException;

    public int maxId() throws DAOException;

}
