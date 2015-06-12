
package com.ues.dao.impl;

import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.TransaccionDao;
import com.ues.exception.DAOException;
import com.ues.model.Devolucion;
import com.ues.model.Inventario;
import com.ues.model.OrdenDeCompra;
import com.ues.model.Requisicion;
import com.ues.model.TipoTransaccion;
import com.ues.model.Transaccion;
import java.util.List;

/**
 *
 * @author Jocelyn
 */
public class TransaccionDaoHibImpl extends CustomHibernateDaoSupport implements TransaccionDao {
    
     public void crearTransaccion(Transaccion transaccion) throws DAOException {
        getHibernateTemplate().saveOrUpdate(transaccion);
    }

    public Transaccion buscaTransaccion(Integer idTransaccion) throws DAOException {
        List list = getHibernateTemplate().find(" from Transaccion WHERE idTransaccion=?",idTransaccion);
        return (Transaccion) list.get(0);
    }

    public List<Transaccion> listaTransacciones() throws DAOException {
        List<Transaccion> lista = getHibernateTemplate().find("from Transaccion t inner join fetch t.inventario inner joint fetch t.tipoTransaccion inner join fetch t.devolucion inner join fetch t.requisicion inner join fetch t.ordenDeCompra order by t.idTransaccion");
        return lista;
       
    }

    public void modificarTransaccion(Transaccion transaccion) throws DAOException {
        getHibernateTemplate().update(transaccion);
    }

    public void borrarTransaccion(Transaccion transaccion) throws DAOException {
        getHibernateTemplate().delete(transaccion);
    }

    
      @Override
    public List<Inventario> listaInventarios() throws DAOException{
        List<Inventario> lista = getHibernateTemplate().find("from Inventario i order by i.idInventario");
        
        
        return lista;}
    
      @Override
    public List<TipoTransaccion> listaTipoTransacciones() throws DAOException{
        List<TipoTransaccion> lista = getHibernateTemplate().find("from TipoTransaccion tt order by tt.idTipoTransaccion");
        
        
        return lista;}
    
    
      @Override
    public List<Devolucion> listaDevoluciones() throws DAOException{
        List<Devolucion> lista = getHibernateTemplate().find("from Devolucion d order by d.idDevolucion");
        
        
        return lista;}
    
    
      @Override
    public List<Requisicion> listaRequisicion() throws DAOException{
        List<Requisicion> lista = getHibernateTemplate().find("from Requisicion r order by r.idRequisicion");
        
        
        return lista;}
    
    
    
      @Override
    public List<OrdenDeCompra> listaOrdenesDeCompra() throws DAOException{
        List<OrdenDeCompra> lista = getHibernateTemplate().find("from OrdenDeCompra oc order by oc.idOrden");
        
        
        return lista;}
    
    
    
    
    
    
}// fin clase
