package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.Devolucion;
import com.ues.model.Inventario;
import com.ues.model.OrdenDeCompra;
import com.ues.model.Requisicion;
import com.ues.model.TipoTransaccion;
import com.ues.model.Transaccion;
import java.util.List;

/**
 * @author Jocelyn
 */
public interface TransaccionDao {
     public void crearTransaccion(Transaccion transaccion) throws DAOException;
   public Transaccion buscaTransaccion(Integer idTransaccion) throws DAOException;
   public List<Transaccion> listaTransacciones() throws DAOException;
   public void modificarTransaccion(Transaccion transaccion) throws DAOException;
   public void borrarTransaccion(Transaccion transaccion) throws DAOException;
   public List<Inventario> listaInventarios() throws DAOException;
    public List<TipoTransaccion> listaTipoTransacciones() throws DAOException;
    public List<Devolucion> listaDevoluciones() throws DAOException;
    public List<Requisicion> listaRequisicion() throws DAOException;
     public List<OrdenDeCompra> listaOrdenesDeCompra() throws DAOException;
}