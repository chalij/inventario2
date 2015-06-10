package com.ues.dao.impl;

import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.TelefonoDao;
import com.ues.exception.DAOException;
import com.ues.model.Persona;
import com.ues.model.Telefono;
import java.util.List;

/**
 *
 * @author Jocelyn
 */
public class TelefonoDaoHibImpl extends CustomHibernateDaoSupport implements TelefonoDao {
    
     public void crearTelefono(Telefono telefono) throws DAOException {
        getHibernateTemplate().saveOrUpdate(telefono);
    }

    public Telefono buscaTelefono(Integer idTelefono) throws DAOException {
        List list = getHibernateTemplate().find(" from Telefono WHERE idTelefono=?",idTelefono);
        return (Telefono) list.get(0);
    }

    public List<Telefono> listaTelefonos() throws DAOException {
        List<Telefono> lista = getHibernateTemplate().find("from Telefono t inner join fetch t.persona order by t.idTelefono");
        return lista;
    }

    public void modificarTelefono(Telefono telefono) throws DAOException {
        getHibernateTemplate().update(telefono);
    }

    public void borrarTelefono(Telefono telefono) throws DAOException {
        getHibernateTemplate().delete(telefono);
    }

     @Override
    public List<Persona> listaPersonas() throws DAOException{
        List<Persona> lista = getHibernateTemplate().find("from Persona p order by p.idPersona");
     
         return lista;}
        
    
    
}
