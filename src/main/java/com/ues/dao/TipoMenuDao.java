package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.TipoMenu;


import java.util.List;

/**
 *
 * @author Airy
 */
public interface TipoMenuDao {

    public void crearTipoMenu(TipoMenu tipomenu) throws DAOException;

    public TipoMenu buscaTipoMenu(Integer tipomenu) throws DAOException;
   
    public List<TipoMenu> listaTipoMenus() throws DAOException;

    public void borrarTipoMenu(TipoMenu tipomenu) throws DAOException;

    public void modificarTipoMenu(TipoMenu tipomenu) throws DAOException;
    
    public int maxID() throws DAOException;
      
}
