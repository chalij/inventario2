package com.ues.bean;

import com.ues.dao.TipoProveedorDao;
import com.ues.model.TipoProveedor;
import java.util.List;

/**
 *
 * @author Ibrahim
 */
public class TipoProveedorBean {

    private List<TipoProveedor> miLista;
    private TipoProveedorDao tipoProveedorDao;
    
    public TipoProveedorBean() {        
    }

    public List<TipoProveedor> getMiLista() {
        try {
            miLista = getTipoProveedorDao().listaTipoProveedor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miLista;
    }

    public TipoProveedorDao getTipoProveedorDao() {
        return tipoProveedorDao;
    }

    public void setMiLista(List<TipoProveedor> miLista) {
        this.miLista = miLista;
    }

    public void setTipoProveedorDao(TipoProveedorDao tipoProveedorDao) {
        this.tipoProveedorDao = tipoProveedorDao;
    }
}
