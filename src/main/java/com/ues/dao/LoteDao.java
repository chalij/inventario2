package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.Bodega;
import com.ues.model.Lote;
import com.ues.model.Producto;
import java.util.List;

/**
 *
 * @author Ibrahim
 */
public interface LoteDao {
    
   public void crearLote(Lote creaLote) throws DAOException;
   public Lote buscaLote(Integer buscaLote) throws DAOException;
   public List<Lote> listaLote() throws DAOException;
   public void modificarLote(Lote modificaLote) throws DAOException;
   public void borrarLote(Lote  borraLote) throws DAOException;
   public List<Producto> listaProductos() throws DAOException;
   public List<Bodega> listaBodegas() throws DAOException;
    
}
