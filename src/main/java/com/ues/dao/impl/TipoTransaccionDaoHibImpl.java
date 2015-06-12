package com.ues.dao.impl;

import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.TipoTransaccionDao;
import com.ues.exception.DAOException;
import com.ues.model.TipoTransaccion;
import java.util.List;

/**
 *
 * @author Jocelyn
 */
public class TipoTransaccionDaoHibImpl extends CustomHibernateDaoSupport implements TipoTransaccionDao {
    
     public void crearTipoTransaccion(TipoTransaccion tipotransaccion) throws DAOException {
        getHibernateTemplate().save(tipotransaccion);
    }

    public TipoTransaccion buscaTipoTransaccion(Integer idTipoTransaccion) throws DAOException {
        List list = getHibernateTemplate().find(" from TipoTransaccion WHERE idTipoTransaccion=?",idTipoTransaccion);
        return (TipoTransaccion) list.get(0);
    }

    public List<TipoTransaccion> listaTipoTransacciones() throws DAOException {
        List<TipoTransaccion> lista = getHibernateTemplate().find("from TipoTransaccion");
        return lista;
    }

    public void modificarTipoTransaccion(TipoTransaccion tipotransaccion) throws DAOException {
        getHibernateTemplate().update(tipotransaccion);
    }

    public void borrarTipoTransaccion(TipoTransaccion tipotransaccion) throws DAOException {
        getHibernateTemplate().delete(tipotransaccion);
    }

    
    
}
