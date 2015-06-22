/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.bean;

import com.ues.dao.ProductoDao;
import com.ues.dao.TipoProductosDao;
import com.ues.model.Producto;
import com.ues.model.Proveedor;
import com.ues.model.TipoProducto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 *
 * @author Administrador
 */
public class ProductoBean {

    private Producto producto=new Producto();
    private List<Producto> miLista=new ArrayList<Producto>();
    private int prodIdV;
    private int proveeTdV;
    private int tipoProdIdV;
    private ProductoDao productoDao;
    private List<SelectItem> listaUsu = new ArrayList<SelectItem>();
    private List<SelectItem> listaUsu2 = new ArrayList<SelectItem>();
    private List<TipoProducto> listaTipoP=new ArrayList<TipoProducto>();
    private List<Proveedor> listaProveedorP=new ArrayList<Proveedor>();
    
    
    
    /**
     * @return the listaUsu
     */
    public List<SelectItem> getListaUsu() {

        try {
            listaTipoP = productoDao.listaTiposProducto();
            listaUsu.clear();
            SelectItemGroup g2 = new SelectItemGroup("Tipo Productos");
            SelectItem[] asi = new SelectItem[listaTipoP.size()];
            for (int i = 0; i < listaTipoP.size(); i++) {
                TipoProducto usAux = (TipoProducto) listaTipoP.get(i);
                asi[i] = new SelectItem(usAux.getIdTipoProducto(), usAux.getNombre());
            }
            g2.setSelectItems(asi);
            listaUsu.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
            listaUsu = new ArrayList<SelectItem>();
        }
        return listaUsu;
    }

    /**
     * @param listaUsu the listaUsu to set
     */
    public void setListaUsu(List<SelectItem> listaUsu) {
        this.listaUsu = listaUsu;
    }
    
    /**
     * @return the listaUsu2
     */
    public List<SelectItem> getListaUsu2() {
        try {
            listaProveedorP = productoDao.listaProveedores();
            listaUsu2.clear();
            SelectItemGroup g2 = new SelectItemGroup("Tipo Provvedor");
            SelectItem[] asi = new SelectItem[listaProveedorP.size()];
            for (int i = 0; i < listaProveedorP.size(); i++) {
                Proveedor usAux = (Proveedor) listaProveedorP.get(i);
                asi[i] = new SelectItem(usAux.getIdProveedor(), usAux.getNombre());
            }
            g2.setSelectItems(asi);
            listaUsu2.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
            listaUsu2 = new ArrayList<SelectItem>();
        }
        return listaUsu2;
    }

    /**
     * @param listaUsu2 the listaUsu2 to set
     */
    public void setListaUsu2(List<SelectItem> listaUsu2) {
        this.listaUsu2 = listaUsu2;
    }

    /**
     * @return the tipoUsuarioLista
     */
    public void addTipoProducto() {
        try {
            Producto pro = new Producto();
            pro.setNombre4(producto.getNombre4());
            Proveedor prov=new Proveedor();
            prov.setIdProveedor(proveeTdV);
            TipoProducto tp=new TipoProducto();
            tp.setIdTipoProducto(tipoProdIdV);
            pro.setTipoProducto(tp);
            pro.setProveedor(prov);
            pro.setCosto(producto.getCosto());
            pro.setDescripcion(producto.getDescripcion());
            pro.setCodigoProducto(producto.getCodigoProducto());
            pro.setExistencias(0);
            productoDao.crearProducto(pro);
            producto = new Producto();
            addMessage("Insertado!!");
        } catch (Exception e) {
            addMessage("Error!!" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void updateTipoProducto() {
    
        try {
            Producto pro = new Producto();
            pro.setIdProducto(producto.getIdProducto());
            pro.setNombre4(producto.getNombre4());
            Proveedor prov=new Proveedor();
            prov.setIdProveedor(proveeTdV);
            TipoProducto tp=new TipoProducto();
            tp.setIdTipoProducto(tipoProdIdV);
            pro.setTipoProducto(tp);
            pro.setProveedor(prov);
            pro.setCosto(producto.getCosto());
            pro.setDescripcion(producto.getDescripcion());
            pro.setCodigoProducto(producto.getCodigoProducto());
            pro.setExistencias(0);
            productoDao.modificarProducto(pro);
            producto = new Producto();
            addMessage("Insertado!!");
        } catch (Exception e) {
            addMessage("Error!!" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void eliminar() {

        try {
            Producto pro = new Producto();
            pro.setIdProducto(producto.getIdProducto());
            pro.setNombre4(producto.getNombre4());
            Proveedor prov=new Proveedor();
            prov.setIdProveedor(proveeTdV);
            TipoProducto tp=new TipoProducto();
            tp.setIdTipoProducto(tipoProdIdV);
            pro.setTipoProducto(tp);
            pro.setProveedor(prov);
            pro.setCosto(producto.getCosto());
            pro.setDescripcion(producto.getDescripcion());
            pro.setCodigoProducto(producto.getCodigoProducto());
            pro.setExistencias(0);
            productoDao.borrarProducto(pro);
            producto = new Producto();
            addMessage("Insertado!!");
        } catch (Exception e) {
            addMessage("Error!!" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * @return the tipoUsuarioLista
     */
    private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }




    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the miLista
     */
    public List<Producto> getMiLista() {
        
        try {
            miLista = productoDao.listaProductos();
        } catch (Exception e) {
            e.printStackTrace();
            miLista = new ArrayList<Producto>();
        }
        producto = new Producto();
        return miLista;
    }

    /**
     * @param miLista the miLista to set
     */
    public void setMiLista(List<Producto> miLista) {
        this.miLista = miLista;
    }
    
    
    /**
     * @return the prodIdV
     */
    public int getProdIdV() {
        return prodIdV;
    }

    /**
     * @param prodIdV the prodIdV to set
     */
    public void setProdIdV(int prodIdV) {
        this.prodIdV = prodIdV;
    }

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

    /**
     * @return the listaTipoP
     */
    public List<TipoProducto> getListaTipoP() {
        return listaTipoP;
    }

    /**
     * @param listaTipoP the listaTipoP to set
     */
    public void setListaTipoP(List<TipoProducto> listaTipoP) {
        this.listaTipoP = listaTipoP;
    }

    /**
     * @return the listaProveedorP
     */
    public List<Proveedor> getListaProveedorP() {
        return listaProveedorP;
    }

    /**
     * @param listaProveedorP the listaProveedorP to set
     */
    public void setListaProveedorP(List<Proveedor> listaProveedorP) {
        this.listaProveedorP = listaProveedorP;
    }

    /**
     * @return the proveeTdV
     */
    public int getProveeTdV() {
        return proveeTdV;
    }

    /**
     * @param proveeTdV the proveeTdV to set
     */
    public void setProveeTdV(int proveeTdV) {
        this.proveeTdV = proveeTdV;
    }

    /**
     * @return the tipoProdIdV
     */
    public int getTipoProdIdV() {
        return tipoProdIdV;
    }

    /**
     * @param tipoProdIdV the tipoProdIdV to set
     */
    public void setTipoProdIdV(int tipoProdIdV) {
        this.tipoProdIdV = tipoProdIdV;
    }

}
