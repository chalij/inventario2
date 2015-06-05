package com.ues.dao;
import com.ues.exception.DAOException;
import com.ues.model.TipoProveedor;
import java.util.List;
/**
 *
 * @author Ibrahim
 */
public interface TipoProveedorDao {
    
   public void crearTipoProveedor(TipoProveedor tipoP) throws DAOException;
   public TipoProveedor buscaTipoProveedor(String tipoPbusq) throws DAOException;
   public List<TipoProveedor> listaTipoProveedor() throws DAOException;
   public void modificarTipoProveedor(TipoProveedor tipoPmodif) throws DAOException;
   public void borrarTipoProveedor(TipoProveedor tipoPborra) throws DAOException;
    
}
