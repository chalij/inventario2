package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.Cotizacion;
import com.ues.model.Pedido;
import com.ues.model.Proveedor;
import java.util.List;

/**
 *
 * @author Ibrahim
 */
public interface CotizacionDao {

    public void crearCotizacion(Cotizacion creaCotiza) throws DAOException;

    public Cotizacion buscaCotizacion(Integer idCotiza) throws DAOException;

    public List<Cotizacion> listaCotizaciones() throws DAOException;

    public void modificarCotizaciones(Cotizacion modificaCotiza) throws DAOException;

    public void borrarCotizacion(Cotizacion borraCotiza) throws DAOException;

    public List<Pedido> listaPedidos() throws DAOException;

    public List<Proveedor> listaProveedores() throws DAOException;

}
