package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.TipoTransaccion;
import java.util.List;

/**
 * @author Jocelyn
 */
public interface TipoTransaccionDao {
     public void crearTipoTransaccion(TipoTransaccion tipotransaccion) throws DAOException;
   public TipoTransaccion buscaTipoTransaccion(Integer idTransaccion) throws DAOException;
   public List<TipoTransaccion> listaTipoTransacciones() throws DAOException;
   public void modificarTipoTransaccion(TipoTransaccion tipotransaccion) throws DAOException;
   public void borrarTipoTransaccion(TipoTransaccion tipotransaccion) throws DAOException;
    
}