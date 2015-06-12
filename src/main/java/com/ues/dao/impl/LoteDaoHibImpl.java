/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.dao.impl;

import com.ues.dao.LoteDao;
import com.ues.exception.DAOException;
import com.ues.model.Bodega;
import com.ues.model.CustomHibernateDaoSupport;
import com.ues.model.Lote;
import com.ues.model.Producto;
import java.util.List;

/**
 *
 * @author Ibrahim
 */
public class LoteDaoHibImpl extends CustomHibernateDaoSupport implements LoteDao{    

    @Override
    public void crearLote(Lote creaLote) throws DAOException {
        getHibernateTemplate().saveOrUpdate(creaLote);
    }

    @Override
    public Lote buscaLote(Integer buscaLote) throws DAOException {
        List list = getHibernateTemplate().find(" from Lote WHERE idLote=?",buscaLote);
        return (Lote) list.get(0);
    }

    @Override
    public List<Lote> listaLote() throws DAOException {
        List<Lote> lista = getHibernateTemplate().find("from Lote l inner join fetch l.producto inner join fetch l.bodega order by l.idLote");
        return lista;
    }

    @Override
    public void modificarLote(Lote modificaLote) throws DAOException {
        getHibernateTemplate().update(modificaLote);
    }

    @Override
    public void borrarLote(Lote borraLote) throws DAOException {
        getHibernateTemplate().delete(borraLote);
    }

    @Override
    public List<Producto> listaProductos() throws DAOException {
        List<Producto> lista = getHibernateTemplate().find("from Producto p order by p.idProducto");     
         return lista;
    }

    @Override
    public List<Bodega> listaBodegas() throws DAOException {
        List<Bodega> lista = getHibernateTemplate().find("from Bodega b order by b.idBodega");
        return lista;
    }
}
