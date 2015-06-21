/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.bean;

import com.ues.dao.ProductoDao;

/**
 *
 * @author Administrador
 */
public class ProductoBean {
    private ProductoDao productoDao;

    /**
     * @return the productoDao
     */
    public ProductoDao getProductoDao() {
        return productoDao;
    }

    /**
     * @param productoDao the productoDao to set
     */
    public void setProductoDao(ProductoDao productoDao) {
        this.productoDao = productoDao;
    }
}
