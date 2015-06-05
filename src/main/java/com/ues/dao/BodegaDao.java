package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.Bodega;
import java.util.List;

/**
 *
 * @author Ibrahim
 */
public interface BodegaDao {
    
   public void crearBodega(Bodega creabodega) throws DAOException;
   public Bodega buscaBodega(int buscabodega) throws DAOException;
   public List<Bodega> listaBodega() throws DAOException;
   public void modificarBodega(Bodega modifibodega) throws DAOException;
   public void borrarBodega(Bodega borrabodega) throws DAOException;
    
}
