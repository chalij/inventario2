package com.ues.bean;

import com.ues.dao.DevolucionDao;
import com.ues.model.Devolucion;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Airy
 */
public class DevolucionBean {

    private Devolucion devolucion;
    private List<Devolucion> listaDevolucion;
    private DevolucionDao devolucionDao;
    private int devIdV;

    /**
     * @return the devolucion
     */
    public Devolucion getDevolucion() {
        return devolucion;
    }

    /**
     * @param devolucion the devolucion to set
     */
    public void setDevolucion(Devolucion devolucion) {
        this.devolucion = devolucion;
    }

    /**
     * @return the listaDevolucion
     */
    public List<Devolucion> getListaDevolucion() {
        try
        {
            listaDevolucion=devolucionDao.listaDevolucion();
        }
        catch(Exception e)
        {
            listaDevolucion=new ArrayList<Devolucion>();
        }
        devolucion=new Devolucion();
        return listaDevolucion;
    }

    /**
     * @param listaDevolucion the listaDevolucion to set
     */
    public void setListaDevolucion(List<Devolucion> listaDevolucion) {
        this.listaDevolucion = listaDevolucion;
    }

    /**
     * @return the devolucionDao
     */
    public DevolucionDao getDevolucionDao() {
        return devolucionDao;
    }

    /**
     * @param devolucionDao the devolucionDao to set
     */
    public void setDevolucionDao(DevolucionDao devolucionDao) {
        this.devolucionDao = devolucionDao;
    }

    /**
     * @return the devIdV
     */
    public int getDevIdV() {
        return devIdV;
    }

    /**
     * @param devIdV the devIdV to set
     */
    public void setDevIdV(int devIdV) {
        this.devIdV = devIdV;
    }

}
