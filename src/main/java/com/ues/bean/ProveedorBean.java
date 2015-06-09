package com.ues.bean;

import com.ues.dao.ProveedorDao;
import com.ues.model.Proveedor;
import com.ues.model.TipoProveedor;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
/**
 *
 * @author Ibrahim
 */
public class ProveedorBean {
    
    private Proveedor proveedor = new Proveedor();
    private int idProveedorV;
    private int tipoProveedorT;
    private List<Proveedor> miLista;
    private List<TipoProveedor> listaTipoP;
    private ProveedorDao proveedorDao;
    private List<SelectItem> listaProv = new ArrayList<SelectItem>();
    
    public ProveedorBean() { 
        proveedor = new Proveedor();
    }

    public int getIdProveedorV() {
        return idProveedorV;
    }

    public void setIdProveedorV(int idProveedorV) {
        this.idProveedorV = idProveedorV;
    }

    public int getTipoProveedorT() {
        return tipoProveedorT;
    }

    public void setTipoProveedorT(int tipoProveedorT) {
        this.tipoProveedorT = tipoProveedorT;
    }

    public List<TipoProveedor> getListaTipoP() {
        return listaTipoP;
    }

    public void setListaTipoP(List<TipoProveedor> listaTipoP) {
        this.listaTipoP = listaTipoP;
    }

    public List<SelectItem> getListaProv() {
        return listaProv;
    }

    public void setListaProv(List<SelectItem> listaProv) {
        this.listaProv = listaProv;
    }
    
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    public List<Proveedor> getMiLista() {
        try {
            miLista = proveedorDao.listaProveedor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miLista;
    }

    public ProveedorDao getProveedorDao() {
        return proveedorDao;
    }

    public void setMiLista(List<Proveedor> miLista) {
        this.miLista = miLista;
    }

    public void setProveedorDao(ProveedorDao proveedorDao) {
        this.proveedorDao = proveedorDao;
    }
    
}
