package com.ues.dao.impl;

import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.UsuariosDao;
import com.ues.exception.DAOException;
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
public class UsuariosDaoHibImpl extends CustomHibernateDaoSupport implements UsuariosDao {

    
    @Override
    public void crearUsuario(Usuario usuario) throws DAOException {
        usuario.setFechaCreacion(new Date());
        getHibernateTemplate().saveOrUpdate(usuario);
    }

    @Override
    public Usuario buscaUsuario(String nombreUsuario) throws DAOException {
        List list = getHibernateTemplate().find(" from Usuario WHERE nombreUsuario=?",nombreUsuario);
        return (Usuario) list.get(0);
    }

    @Override
    public List<Usuario> listaUsuarios() throws DAOException {
        List<Usuario> lista = getHibernateTemplate().find("from Usuario order by idUsuario");
        return lista;
    }

   /* public void modificarUsuario(Usuario usuario) throws DAOException {
        usuario.setFechaModificacion(new Date());
        getHibernateTemplate().update(usuario);*/

    @Override
    public void borrarUsuario(Usuario usuario) throws DAOException {
        getHibernateTemplate().delete(usuario);
    }

    @Override
    public List<Usuario> mostrarUsuarios() throws DAOException {
      Session session=null;
      List<Usuario> lista=null;
        try {
            session= getHibernateTemplate().getSessionFactory().openSession();
            Query query=session.createQuery("from Usuario");
            lista=(List<Usuario>) query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }finally{
        
        if(session!=null){
            session.close();
        }
        }
        return lista;
    }

    @Override
    public void insertarUsuario(Usuario usuario) throws DAOException {
        Session session=null;
      
        try {
            session=  getHibernateTemplate().getSessionFactory().openSession();
            session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
        
        if(session!=null){
            session.close();
        }
        }
       
    }

    @Override
    public void modificarUsuario(Usuario usuario) throws DAOException {
       Session session=null;
      
        try {
            session= getHibernateTemplate().getSessionFactory().openSession();
            session.beginTransaction();
            session.update(usuario);
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
        
        if(session!=null){
            session.close();
        }
        }
    }

    @Override
    public void eliminarUsuario(Usuario usuario) throws DAOException {
        Session session=null;
      
        try {
            session= getHibernateTemplate().getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(usuario);
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
        
        if(session!=null){
            session.close();
        }
        }
    }

    

}