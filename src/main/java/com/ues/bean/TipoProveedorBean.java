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
    private TipoProveedorDao tipoproveedorDao;
    
    public TipoProveedorBean() {
    }

    public List<TipoProveedor> getMiLista() {
        try {
            miLista = tipoproveedorDao.listaTipoProveedor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miLista;
    }

    public TipoProveedorDao getTipoproveedorDao() {
        return tipoproveedorDao;
    }

    public void setMiLista(List<TipoProveedor> miLista) {
        this.miLista = miLista;
    }

    public void setTipoproveedorDao(TipoProveedorDao tipoproveedorDao) {
        this.tipoproveedorDao = tipoproveedorDao;
    }
    
}
