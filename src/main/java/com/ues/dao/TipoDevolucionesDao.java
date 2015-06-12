/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.dao;

import com.ues.model.TipoDevolucion;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface TipoDevolucionesDao {
    public List<TipoDevolucion> mostrarTipoDevolucion();
    public void insertarTipoDevolucion(TipoDevolucion tipoDevolucion);
    public void modificarTipoDevolucion(TipoDevolucion tipoDevolucion);
    public void eliminarTipoDevolucion(TipoDevolucion tipoDevolucion);
}
