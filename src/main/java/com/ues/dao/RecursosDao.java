package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.Menu;
import com.ues.model.Recursos;
import com.ues.model.TipoUsuario;
import com.ues.model.Usuario;
import java.util.List;

/**
 *
 * @author Airy
 */
public interface RecursosDao {

    public void crearRecursos(Recursos recursos) throws DAOException;


    public List<Recursos> listaRecursos() throws DAOException;
    
    public List<TipoUsuario> listaTipoUsuarios() throws DAOException;

    public void borrarRecursos(Recursos recursos) throws DAOException;

    public void modificarRecursos(Recursos recursos) throws DAOException;
    
    public List<Menu> listaMenus() throws DAOException;

}
