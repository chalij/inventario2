package com.ues.dao.impl;

import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.TipoClienteDao;
import com.ues.exception.DAOException;
import com.ues.model.TipoCliente;
import java.util.List;

/**
 *
 * @author Jocelyn
 * 
 */
public class TipoClienteDaoHibImpl extends CustomHibernateDaoSupport implements TipoClienteDao {

        
    public void crearTipoCliente(TipoCliente tipocliente) throws DAOException {
        getHibernateTemplate().save(tipocliente);
    }

    public TipoCliente buscaTipoCliente(Integer idTipoCliente) throws DAOException {
        List list = getHibernateTemplate().find(" from TipoCliente WHERE idTipoCliente=?",idTipoCliente);
        return (TipoCliente) list.get(0);
    }

    public List<TipoCliente> listaTiposCliente() throws DAOException {
        List<TipoCliente> lista = getHibernateTemplate().find("from TipoCliente order by idTipoCliente");
        return lista;
    }

    public void modificarTipoCliente(TipoCliente tipocliente) throws DAOException {
        getHibernateTemplate().update(tipocliente);
    }

    public void borrarTipoCliente(TipoCliente tipocliente) throws DAOException {
        getHibernateTemplate().delete(tipocliente);
    }

    
}
