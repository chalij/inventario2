package com.ues.dao.impl;

import com.ues.dao.ProveedorDao;
import com.ues.exception.DAOException;
import com.ues.model.CustomHibernateDaoSupport;
import com.ues.model.Proveedor;
import com.ues.model.TipoProveedor;
import java.util.List;
/**
 *
 * @author Ibrahim
 */
public class ProveedorDaoHibImpl extends CustomHibernateDaoSupport implements ProveedorDao{

    @Override
    public void crearProveedor(Proveedor creaProveedor) throws DAOException {
        getHibernateTemplate().saveOrUpdate(creaProveedor);
    }

    @Override
    public Proveedor buscaProveedor(String buscaProveedor) throws DAOException {
        List list = getHibernateTemplate().find(" from Proveedor WHERE id_proveedor=?",buscaProveedor);
        return (Proveedor) list.get(0);
    }

    @Override
    public List<Proveedor> listaProveedor() throws DAOException {
        List<Proveedor> lista = getHibernateTemplate().find("from Proveedor");
        return lista;
    }

    @Override
    public void modificarProveedor(Proveedor modifiProveedor) throws DAOException {
        getHibernateTemplate().update(modifiProveedor);
    }

    @Override
    public void borrarProveedor(Proveedor borraProveedor) throws DAOException {
        getHibernateTemplate().delete(borraProveedor);
    }

    @Override
    public List<TipoProveedor> listaTipoProveedor() throws DAOException {
        List<TipoProveedor> lista = getHibernateTemplate().find("from Proveedor u  inner join fetch u.tipoUsuario order by u.idUsuario");
        return lista;
    } //arreglar el parametro sql de este metodo!!
    
}
