package com.ues.dao.impl;

import com.ues.dao.MenusDao;
import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.UsuariosDao;
import com.ues.exception.DAOException;
import com.ues.model.Menu;
import com.ues.model.Persona;
import com.ues.model.TipoMenu;
import com.ues.model.TipoUsuario;
import com.ues.model.Usuario;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Airy
 */
public class MenusDaoHibImpl extends CustomHibernateDaoSupport implements MenusDao {






    @Override
    public int maxID() throws DAOException {
        List list = getHibernateTemplate().find("select max(p.idRecursos) from Recursos p");
        System.out.println(list.get(0));
        return (Integer) list.get(0);
    }
    
    

    @Override
    public void crearMenu(Menu menu) throws DAOException {
        getHibernateTemplate().save(menu);
    }
    
    
    

    @Override
    public List<Menu> listaMenus() throws DAOException {
        List<Menu> lista = getHibernateTemplate().find("from Menu m order by m.idMenu");

        return lista;
    }
    
    

    @Override
    public List<TipoMenu> listaTipoMenus() throws DAOException {
        List<TipoMenu> lista = getHibernateTemplate().find("from TipoMenu tp order by tp.idTipoMenu");

        return lista;
    }

   

    @Override
    public void borrarMenu(Menu menu) throws DAOException {
        getHibernateTemplate().delete(menu);
    }

    @Override
    public void modificarMenu(Menu menu) throws DAOException {
        getHibernateTemplate().update(menu);
    }


}
