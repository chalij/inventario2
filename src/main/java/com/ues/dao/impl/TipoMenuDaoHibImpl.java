package com.ues.dao.impl;

import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.TipoMenuDao;
import com.ues.exception.DAOException;
import com.ues.model.TipoMenu;
import java.util.List;

/**
 *
 * @author Jocelyn
 */
public class TipoMenuDaoHibImpl extends CustomHibernateDaoSupport implements TipoMenuDao {
    
     public void crearTipoMenu(TipoMenu tipomenu) throws DAOException {
        getHibernateTemplate().save(tipomenu);
    }

    public TipoMenu buscaTipoMenu(Integer idTipoMenu) throws DAOException {
        List list = getHibernateTemplate().find(" from TipoMenu WHERE idTipoMenu=?",idTipoMenu);
        return (TipoMenu) list.get(0);
    }

    public List<TipoMenu> listaTipoMenus() throws DAOException {
        List<TipoMenu> lista = getHibernateTemplate().find("from TipoMenu");
        //System.out.println(lista.get(0));
        return lista;
    }

    public void modificarTipoMenu(TipoMenu tipomenu) throws DAOException {
        getHibernateTemplate().update(tipomenu);
    }

    public void borrarTipoMenu(TipoMenu tipomenu) throws DAOException {
        getHibernateTemplate().delete(tipomenu);   }
    
        
         
    public int maxID() throws DAOException {
        
         List list=  getHibernateTemplate().find("select max(p.idTipoMenu) from TipoMenu p");
      System.out.println(list.get(0));
         
        return (Integer)list.get(0);
 
    }

    
    
}
