package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.TipoUsuario;
import com.ues.model.Usuario;
import java.util.List;

/**
 *
 * @author Airy
 */
public interface UsuariosDao {

    public void crearUsuario(Usuario usuario) throws DAOException;

    public Usuario buscaUsuario(int username) throws DAOException;

    public List<Usuario> listaUsuarios() throws DAOException;
    
    public List<TipoUsuario> listaTipoUsuarios() throws DAOException;

    public void borrarUsuario(Usuario usuario) throws DAOException;

    public void modificarUsuario(Usuario usuario) throws DAOException;
    
    public int maxID() throws DAOException;
    
    
    public boolean controlLogg(String nombreUsuario, String contrasena) throws DAOException;

}
