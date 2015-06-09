package com.ues.dao.impl;

import com.ues.dao.TipoUsuariosDao;
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
public class TipoUsuariosDaoHibImpl extends CustomHibernateDaoSupport implements TipoUsuariosDao {

    @Override
    public List<TipoUsuario> mostrarTipoUsuario() {
        List<TipoUsuario> lista = getHibernateTemplate().find("from TipoUsuario tp order by tp.idTipoUsuario");
        return lista;
    }

    @Override
    public void insertarTipoUsuario(TipoUsuario tipoUsuario) {
        getHibernateTemplate().save(tipoUsuario);
    }

    @Override
    public void modificarTipoUsuario(TipoUsuario tipoUsuario) {
        getHibernateTemplate().update(tipoUsuario);
    }

    @Override
    public void eliminarTipoUsuario(TipoUsuario tipoUsuario) {
        getHibernateTemplate().delete(tipoUsuario);
    }
}
