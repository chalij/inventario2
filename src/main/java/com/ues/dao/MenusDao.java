package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.Menu;
import com.ues.model.TipoMenu;
import com.ues.model.TipoUsuario;
import com.ues.model.Usuario;
import java.util.List;

/**
 *
 * @author Airy
 */
public interface MenusDao {

    public void crearMenu(Menu menu) throws DAOException;


    public List<Menu> listaMenus() throws DAOException;
    
    public List<TipoMenu> listaTipoMenus() throws DAOException;

    public void borrarMenu(Menu menu) throws DAOException;

    public void modificarMenu(Menu menu) throws DAOException;
    
    public int maxID() throws DAOException;
    

}
