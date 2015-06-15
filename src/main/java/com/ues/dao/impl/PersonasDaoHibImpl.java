
package com.ues.dao.impl;

import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.PersonasDao;
import com.ues.exception.DAOException;
import com.ues.model.Persona;
import com.ues.model.Usuario;
import java.util.List;

/**
 *
 * @author Jocelyn
 * 
 */
public class PersonasDaoHibImpl extends CustomHibernateDaoSupport implements PersonasDao {

      
    @Override  
    public void crearPersona(Persona persona) throws DAOException {
        getHibernateTemplate().saveOrUpdate(persona);
    }

    @Override
    public Persona buscaPersona(Integer idPersona) throws DAOException {
        List list = getHibernateTemplate().find(" from Persona WHERE idPersona=?",idPersona);
        return (Persona) list.get(0);
    }

    @Override
    public List<Persona> listaPersonas() throws DAOException {
        List<Persona> lista = getHibernateTemplate().find("from Persona p order by p.idPersona");
        return lista;
       
    }

    @Override
    public void modificarPersona(Persona persona) throws DAOException {
        getHibernateTemplate().update(persona);
    }

    @Override
    public void borrarPersona(Persona persona) throws DAOException {
        getHibernateTemplate().delete(persona);
    }

    @Override
    public List<Usuario> listaUsuarios() throws DAOException{
        List<Usuario> lista = getHibernateTemplate().find("from Usuario u order by u.idUsuario");
     
         return lista;}
}
