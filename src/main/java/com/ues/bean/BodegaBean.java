package com.ues.bean;

import com.ues.dao.BodegaDao;
import com.ues.model.Bodega;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Ibrahim
 */
public class BodegaBean {
    private Bodega bodega = new Bodega();
    private List<Bodega> bodegaLista = new ArrayList<Bodega>();
    private int idBodegaB;
    private BodegaDao bodegaDao;
    
    public BodegaBean(){
        bodega = new Bodega();
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public List<Bodega> getBodegaLista() {
        try {
            bodegaLista = bodegaDao.listaBodega();
        } catch (Exception e) {
            e.printStackTrace();
            bodegaLista = new ArrayList<Bodega>();
        }
        bodega = new Bodega();
        return bodegaLista;
    }

    public void setBodegaLista(List<Bodega> bodegaLista) {
        this.bodegaLista = bodegaLista;
    }

    public int getIdBodegaB() {
        return idBodegaB;
    }

    public void setIdBodegaB(int idBodegaB) {
        this.idBodegaB = idBodegaB;
    }

    public BodegaDao getBodegaDao() {
        return bodegaDao;
    }

    public void setBodegaDao(BodegaDao bodegaDao) {
        this.bodegaDao = bodegaDao;
    }
    
    public void eliminar() {

        try {
            Bodega bod = new Bodega();
            bod.setIdBodega(bodega.getIdBodega());
            bod.setCantidadPasillos(bodega.getCantidadPasillos());
            bod.setEstantesPorPasillo(bodega.getEstantesPorPasillo());
            bod.setNombre2(bodega.getNombre2());
            bod.setCatidadEstante(bodega.getCatidadEstante());
            bod.setProductoPorEstante(bodega.getProductoPorEstante());
            bod.setUbicacion(bodega.getUbicacion());
            bodegaDao.borrarBodega(bodega);
            bodega = new Bodega();            
            addMessage("Eliminado Id:!!");
        } catch (Exception e) {
            addMessage("Error Id:!!");
            e.printStackTrace();
        }
    }
    
    public void updateBodega(ActionEvent actionEvent) {
        try {
            Bodega bod = new Bodega();
            bod.setIdBodega(bodega.getIdBodega());
            bod.setCantidadPasillos(bodega.getCantidadPasillos());
            bod.setEstantesPorPasillo(bodega.getEstantesPorPasillo());
            bod.setNombre2(bodega.getNombre2());
            bod.setCatidadEstante(bodega.getCatidadEstante());
            bod.setProductoPorEstante(bodega.getProductoPorEstante());
            bod.setUbicacion(bodega.getUbicacion());
            bodegaDao.modificarBodega(bod);
            bodega = new Bodega();
            addMessage("Actualizada: " + bod.getNombre2());
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void addBodega(ActionEvent actionEvent) {
        try {
            Bodega bod = new Bodega();
            bod.setIdBodega(bodega.getIdBodega());
            bod.setCantidadPasillos(bodega.getCantidadPasillos());
            bod.setEstantesPorPasillo(bodega.getEstantesPorPasillo());
            bod.setNombre2(bodega.getNombre2());
            bod.setCatidadEstante(bodega.getCatidadEstante());
            bod.setProductoPorEstante(bodega.getProductoPorEstante());
            bod.setUbicacion(bodega.getUbicacion());
            bodegaDao.crearBodega(bod);
            bodega = new Bodega();
            addMessage("Insertado: " + bod.getNombre2());
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }

    }
    
    private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
