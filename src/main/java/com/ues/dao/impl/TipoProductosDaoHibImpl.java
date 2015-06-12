package com.ues.dao.impl;

import com.ues.dao.TipoProductosDao;
import com.ues.dao.TipoUsuariosDao;
import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.UsuariosDao;
import com.ues.exception.DAOException;
import com.ues.model.TipoProducto;
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
public class TipoProductosDaoHibImpl extends CustomHibernateDaoSupport implements TipoProductosDao {

   

    @Override
    public List<TipoProducto> mostrarTipoProducto() {
        List<TipoProducto> lista = getHibernateTemplate().find("from TipoProducto tp order by tp.idTipoProducto");
        return lista;
    }

    @Override
    public void insertarTipoProducto(TipoProducto tipoProducto) {
        getHibernateTemplate().save(tipoProducto);
    }

    @Override
    public void modificarTipoProducto(TipoProducto tipoProducto) {
        getHibernateTemplate().update(tipoProducto);
    }

    @Override
    public void eliminarTipoProducto(TipoProducto tipoProducto) {
        getHibernateTemplate().delete(tipoProducto);
    }
}
