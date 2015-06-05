package com.ues.bean;

import com.ues.dao.BodegaDao;
import com.ues.model.Bodega;
import java.util.List;

/**
 *
 * @author Ibrahim
 */
public class BodegaBean {
    private List<Bodega> miLista;
    private BodegaDao bodegaDao;
    
    public BodegaBean(){}
    
    public List<Bodega> getMiLista() {
        try {
            miLista = getBodegaDao().listaBodega();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miLista;
    }
    
    public void setMiLista(List<Bodega> miLista) {
        this.miLista = miLista;
    }
    

    /**
     * @return the bodegaDao
     */
    public BodegaDao getBodegaDao() {
        return bodegaDao;
    }

    /**
     * @param bodegaDao the bodegaDao to set
     */
    public void setBodegaDao(BodegaDao bodegaDao) {
        this.bodegaDao = bodegaDao;
    }
}
