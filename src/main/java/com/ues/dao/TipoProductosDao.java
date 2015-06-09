/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.dao;

import com.ues.model.TipoProducto;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface TipoProductosDao {
    public List<TipoProducto> mostrarTipoProducto();
    public void insertarTipoProducto(TipoProducto tipoProducto);
    public void modificarTipoProducto(TipoProducto tipoProducto);
    public void eliminarTipoProducto(TipoProducto tipoProducto);
}
