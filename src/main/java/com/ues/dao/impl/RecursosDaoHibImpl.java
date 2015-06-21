package com.ues.dao.impl;

import com.ues.dao.RecursosDao;
import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.UsuariosDao;
import com.ues.exception.DAOException;
import com.ues.model.Menu;
import com.ues.model.Recursos;
import com.ues.model.TipoUsuario;
import com.ues.model.Usuario;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Airy
 */
public class RecursosDaoHibImpl extends CustomHibernateDaoSupport implements RecursosDao {


    
    
            
    @Override
    public List<TipoUsuario> listaTipoUsuarios() throws DAOException{
        List<TipoUsuario> lista = getHibernateTemplate().find("from TipoUsuario tp order by tp.idTipoUsuario");
        
        return lista;
    }
            
        



    @Override
    public void crearRecursos(Recursos recursos) throws DAOException {
        getHibernateTemplate().save(recursos);
    }

    @Override
    public List<Menu> listaRecursos() throws DAOException {
        List<Menu> lista = getHibernateTemplate().find("from Menu m  inner join fetch  m.recursos inner join fetch m.tipoMenu inner join fetch m.recursos.tipoUsuario order by m.recursos.idRecursos");
        
        return lista;
    }
    
    
    @Override
    public List<Menu> listaMenus(int tipoMenu) throws DAOException {
        List<Menu> lista = getHibernateTemplate().find("from Menu m  inner join fetch  m.recursos inner join fetch m.tipoMenu inner join fetch m.recursos.tipoUsuario where m.recursos.tipoUsuario.idTipoUsuario="+tipoMenu);
        
        return lista;
    }
    
    

    @Override
    public void borrarRecursos(Recursos recursos) throws DAOException {
        getHibernateTemplate().delete(recursos);
    }

    @Override
    public void modificarRecursos(Recursos recursos) throws DAOException {
        getHibernateTemplate().update(recursos);
    }
    
    
    @Override
    public int maxID() throws DAOException {
        List list = getHibernateTemplate().find("select max(p.idRecursos) from Recursos p");
        System.out.println(list.get(0));
        return (Integer) list.get(0);
    }
}
