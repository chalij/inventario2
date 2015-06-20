package com.ues.dao.impl;

import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.UsuariosDao;
import com.ues.exception.DAOException;
import com.ues.model.Persona;
import com.ues.model.TipoUsuario;
import com.ues.model.Usuario;
import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
    public List<TipoUsuario> listaTipoUsuarios() throws DAOException {
        List<TipoUsuario> lista = getHibernateTemplate().find("from TipoUsuario tp order by tp.idTipoUsuario");

        return lista;
    }

    @Override
    public List<Usuario> listaUsuarios() throws DAOException {
        List<Usuario> lista = getHibernateTemplate().find("from Usuario u  inner join fetch u.tipoUsuario inner join fetch u.persona order by u.idUsuario");

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

    @Override
    public int maxID() throws DAOException {
        List list = getHibernateTemplate().find("select max(p.idPersona) from Persona p");
        System.out.println(list.get(0));
        return (Integer) list.get(0);
    }

    @Override
    public boolean controlLogg(String nombreUsuario, String contrasena) throws DAOException {
        List<Usuario> list = getHibernateTemplate().find(" from Usuario u inner join fetch u.tipoUsuario WHERE u.nombreUsuario=? and u.contrasena=?", nombreUsuario, contrasena);
        if (list.size() == 0) {
            return false;
                    
        } else {
                Usuario us=list.get(0);
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("tipoUsuario", us.getTipoUsuario().getIdTipoUsuario());
            return true;
    
        }
    }
}
