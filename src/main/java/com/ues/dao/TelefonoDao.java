package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.Persona;
import com.ues.model.Telefono;
import java.util.List;

/**
 * @author Jocelyn
 */
public interface TelefonoDao {
     public void crearTelefono(Telefono telefono) throws DAOException;
   public Telefono buscaTelefono(Integer idTelefono) throws DAOException;
   public List<Telefono> listaTelefonos() throws DAOException;
   public void modificarTelefono(Telefono telefono) throws DAOException;
   public void borrarTelefono(Telefono telefono) throws DAOException;
   public List<Persona> listaPersonas() throws DAOException;
    
}