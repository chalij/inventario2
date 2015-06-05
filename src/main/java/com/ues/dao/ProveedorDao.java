package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.Proveedor;
import java.util.List;
/**
 *
 * @author Ibrahim
 */
public interface ProveedorDao {
    
   public void crearProveedor(Proveedor creaProveedor) throws DAOException;
   public Proveedor buscaProveedor(String buscaProveedor) throws DAOException;
   public List<Proveedor> listaProveedor() throws DAOException;
   public void modificarProveedor(Proveedor modifiProveedor) throws DAOException;
   public void borrarProveedor(Proveedor borraProveedor) throws DAOException;
    
}
