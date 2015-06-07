package com.ues.bean;

import com.ues.dao.ProveedorDao;
import com.ues.model.Proveedor;
import java.util.List;
/**
 *
 * @author Ibrahim
 */
public class ProveedorBean {
    
    private List<Proveedor> miLista;
    private ProveedorDao proveedorDao;
    
    public ProveedorBean() { }

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
