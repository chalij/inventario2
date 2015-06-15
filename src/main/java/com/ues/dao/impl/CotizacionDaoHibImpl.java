package com.ues.dao.impl;

import com.ues.dao.CotizacionDao;
import com.ues.exception.DAOException;
import com.ues.model.Cotizacion;
import com.ues.model.CustomHibernateDaoSupport;
import com.ues.model.Pedido;
import com.ues.model.Proveedor;
import java.util.List;

/**
 *
 * @author Ibrahim
 */
public class CotizacionDaoHibImpl  extends CustomHibernateDaoSupport implements CotizacionDao{

    @Override
    public void crearCotizacion(Cotizacion creaCotiza) throws DAOException {
        getHibernateTemplate().saveOrUpdate(creaCotiza);
    }

    @Override
    public Cotizacion buscaCotizacion(Integer idCotiza) throws DAOException {
        List list = getHibernateTemplate().find(" from Cotizacion WHERE idCotizacion=?",idCotiza);
        return (Cotizacion) list.get(0);
    }

    @Override
    public List<Cotizacion> listaCotizaciones() throws DAOException {
        List<Cotizacion> lista = getHibernateTemplate().find("from Cotizacion c inner join fetch c.proveedor inner join fetch c.pedido order by c.idCotizacion");
        return lista;
    }

    @Override
    public void modificarCotizaciones(Cotizacion modificaCotiza) throws DAOException {
        getHibernateTemplate().update(modificaCotiza);
    }

    @Override
    public void borrarCotizacion(Cotizacion borraCotiza) throws DAOException {
        getHibernateTemplate().delete(borraCotiza);
    }

    @Override
    public List<Pedido> listaPedidos() throws DAOException {
        List<Pedido> lista = getHibernateTemplate().find("from Pedido p order by p.idPedido");     
         return lista;
    }

    @Override
    public List<Proveedor> listaProveedores() throws DAOException {
        List<Proveedor> lista = getHibernateTemplate().find("from Proveedor p order by p.idProveedor");        
        return lista;
    }    
}
