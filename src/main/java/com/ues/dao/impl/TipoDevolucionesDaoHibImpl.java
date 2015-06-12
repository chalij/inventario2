package com.ues.dao.impl;

import com.ues.dao.TipoDevolucionesDao;
import com.ues.dao.TipoProductosDao;
import com.ues.dao.TipoUsuariosDao;
import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.UsuariosDao;
import com.ues.exception.DAOException;
import com.ues.model.TipoDevolucion;
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
public class TipoDevolucionesDaoHibImpl extends CustomHibernateDaoSupport implements TipoDevolucionesDao {

   

    @Override
    public List<TipoDevolucion> mostrarTipoDevolucion() {
        List<TipoDevolucion> lista = getHibernateTemplate().find("from TipoDevolucion tp order by tp.idTipoDevolucion");
        return lista;
    }

    @Override
    public void insertarTipoDevolucion(TipoDevolucion tipoDevolucion) {
        getHibernateTemplate().save(tipoDevolucion);
    }

    @Override
    public void modificarTipoDevolucion(TipoDevolucion tipoDevolucion) {
        getHibernateTemplate().update(tipoDevolucion);
    }

    @Override
    public void eliminarTipoDevolucion(TipoDevolucion tipoDevolucion) {
        getHibernateTemplate().delete(tipoDevolucion);
    }
}
