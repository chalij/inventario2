package com.ues.dao.impl;

import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.UsuariosDao;
import com.ues.exception.DAOException;
import com.ues.model.TipoUsuario;
import com.ues.model.Usuario;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Airy
 */
public class UsuariosDaoHibImpl extends CustomHibernateDaoSupport implements UsuariosDao {

    @Override
    public void crearUsuario(Usuario usuario) throws DAOException {
        usuario.setFechaCreacion(new Date());
        getHibernateTemplate().save(usuario);
    }

    @Override
    public Usuario buscaUsuario(String nombreUsuario) throws DAOException {
        List list = getHibernateTemplate().find(" from Usuario WHERE nombreUsuario=?", nombreUsuario);
        return (Usuario) list.get(0);
    }

    
    
            
    @Override
    public List<TipoUsuario> listaTipoUsuarios() throws DAOException{
        List<TipoUsuario> lista = getHibernateTemplate().find("from TipoUsuario tp order by tp.idTipoUsuario");
        
        return lista;
    }
            
            
            
            
    @Override
    public List<Usuario> listaUsuarios() throws DAOException {
        List<Usuario> lista = getHibernateTemplate().find("from Usuario u  inner join fetch u.tipoUsuario order by u.idUsuario");
        
        return lista;
    }

    @Override
    public void modificarUsuario(Usuario usuario) throws DAOException {
        usuario.setFechaModificacion(new Date());
        getHibernateTemplate().update(usuario);
    }

    @Override
    public void borrarUsuario(Usuario usuario) throws DAOException {
        getHibernateTemplate().delete(usuario);
    }
}
