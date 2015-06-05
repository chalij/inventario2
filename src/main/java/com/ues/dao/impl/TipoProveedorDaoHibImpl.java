package com.ues.dao.impl;
/**
 *
 * @author Ibrahim
 */
import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.TipoProveedorDao;
import com.ues.exception.DAOException;
import com.ues.model.TipoProveedor;
import java.util.List;

public class TipoProveedorDaoHibImpl extends CustomHibernateDaoSupport implements TipoProveedorDao{
    
    public void crearTipoProveedor(TipoProveedor tipoP) throws DAOException {
        getHibernateTemplate().saveOrUpdate(tipoP);
    }

    public TipoProveedor buscaTipoProveedor(String tipoPbusq) throws DAOException {
        List list = getHibernateTemplate().find(" from TipoProveedor WHERE id_tipo_provedor=?",tipoPbusq);
        return (TipoProveedor) list.get(0);
    }
    
    public List<TipoProveedor> listaTipoProveedor() throws DAOException {
        List<TipoProveedor> lista = getHibernateTemplate().find("from TipoProveedor");
        return lista;
    }

    public void modificarTipoProveedor(TipoProveedor tipoPmodif) throws DAOException {
        getHibernateTemplate().update(tipoPmodif);
    }

    public void borrarTipoProveedor(TipoProveedor tipoPborra) throws DAOException {
        getHibernateTemplate().delete(tipoPborra);
    }
    
}
