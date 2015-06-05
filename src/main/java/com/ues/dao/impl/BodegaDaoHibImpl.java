package com.ues.dao.impl;
import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.BodegaDao;
import com.ues.exception.DAOException;
import com.ues.model.Bodega;
import java.util.List;
/**
 *
 * @author Ibrahim
 */
public class BodegaDaoHibImpl extends CustomHibernateDaoSupport implements BodegaDao{

    @Override
    public void crearBodega(Bodega creabodega) throws DAOException {
        getHibernateTemplate().saveOrUpdate(creabodega);
    }

    @Override
    public Bodega buscaBodega(int buscabodega) throws DAOException {
        List list = getHibernateTemplate().find(" from Bodega WHERE id_bodega=?",buscabodega);
        return (Bodega) list.get(0);
    }

    @Override
    public List<Bodega> listaBodega() throws DAOException {
        List<Bodega> lista = getHibernateTemplate().find("from Bodega");
        return lista;
    }

    @Override
    public void modificarBodega(Bodega modifibodega) throws DAOException {
        getHibernateTemplate().update(modifibodega);
    }

    @Override
    public void borrarBodega(Bodega borrabodega) throws DAOException {
        getHibernateTemplate().delete(borrabodega);
    }
    
        
    
}
