package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.Persona;
import com.ues.model.Proveedor;
import com.ues.model.TipoProveedor;
import java.util.List;

/**
 *
 * @author Ibrahim
 */
public interface ProveedorDao {

    public void crearProveedor(Proveedor creaProveedor) throws DAOException;

    public Proveedor buscaProveedor(int buscaProveedor) throws DAOException;

    public List<Proveedor> listaProveedor() throws DAOException;

    public List<TipoProveedor> listaTipoProveedor() throws DAOException;

    public List<Persona> listaPersona() throws DAOException;

    public void modificarProveedor(Proveedor modifiProveedor) throws DAOException;

    public void borrarProveedor(Proveedor borraProveedor) throws DAOException;

    public int maxId() throws DAOException;

}
