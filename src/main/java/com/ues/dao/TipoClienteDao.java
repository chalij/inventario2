package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.TipoCliente;
import java.util.List;

/**
 *
 * @author Jocelyn
 */
public interface TipoClienteDao {
     public void crearTipoCliente(TipoCliente tipocliente) throws DAOException;
   public TipoCliente buscaTipoCliente(Integer idTipoCliente) throws DAOException;
   public List<TipoCliente> listaTiposCliente() throws DAOException;
   public void modificarTipoCliente(TipoCliente tipocliente) throws DAOException;
   public void borrarTipoCliente(TipoCliente tipocliente) throws DAOException;
    
}
