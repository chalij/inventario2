package com.ues.dao.impl;

import com.ues.dao.ProveedorDao;
import com.ues.exception.DAOException;
import com.ues.model.CustomHibernateDaoSupport;
import com.ues.model.Persona;
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
    public Proveedor buscaProveedor(int buscaProveedor) throws DAOException {
        List list = getHibernateTemplate().find(" from Proveedor WHERE idProveedor=?",buscaProveedor);
        return (Proveedor) list.get(0);
    }
    
    @Override
    public List<Proveedor> listaProveedor() throws DAOException {
        List<Proveedor> lista = getHibernateTemplate().find("from Proveedor p inner join fetch p.tipoProveedor inner join fetch p.persona order by p.idProveedor");
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
    public List<Persona> listaPersona() throws DAOException {
        List<Persona> listaP = getHibernateTemplate().find("from Persona p  order by p.idPersona");
        return listaP;
    }    
    
    @Override
    public List<TipoProveedor> listaTipoProveedor() throws DAOException {
        List<TipoProveedor> listaTp = getHibernateTemplate().find("from TipoProveedor tp order by tp.idTipoProveedor");
        return listaTp;
    } //arreglar el parametro sql de este metodo!!

    @Override
    public int maxId() throws DAOException {
        List list = getHibernateTemplate().find("select max(p.idPersona) from Persona p");
        System.out.println(list);        
        return (Integer) list.get(0);
    }
}
