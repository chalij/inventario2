
package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.Persona;
import com.ues.model.Usuario;
import java.util.List;

/**
 *
 * @author Jocelyn
 */
public interface PersonasDao {
     public void crearPersona(Persona persona) throws DAOException;
   public Persona buscaPersona(Integer idPersona) throws DAOException;
   public List<Persona> listaPersonas() throws DAOException;
   public void modificarPersona(Persona persona) throws DAOException;
   public void borrarPersona(Persona persona) throws DAOException;
   public List<Usuario> listaUsuarios() throws DAOException;
    
}
