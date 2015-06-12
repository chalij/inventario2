package com.ues.bean;

import com.ues.dao.TipoDevolucionesDao;
import com.ues.dao.TipoProductosDao;
import com.ues.dao.TipoUsuariosDao;
import com.ues.dao.UsuariosDao;
import com.ues.dao.impl.UsuariosDaoHibImpl;
import com.ues.exception.DAOException;
import com.ues.model.TipoDevolucion;
import com.ues.model.TipoProducto;
import com.ues.model.TipoUsuario;
import com.ues.model.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 *
 * @author Airy
 */
public class TipoDevolucionesBean {

    private TipoDevolucion tipoDevolucion=new TipoDevolucion();
    private List<TipoDevolucion> tipoDevolucionLista = new ArrayList<TipoDevolucion>();
    private int idTipoDevolucionV;
    private TipoDevolucionesDao tipoDevolucionesDao;

    

    /**
     * @return the tipoUsuarioLista
     */
    
    
    public void addTipoDevolucion(ActionEvent actionEvent) {
        try {
            TipoDevolucion tdev = new TipoDevolucion();
            tdev.setIdTipoDevolucion(tipoDevolucion.getIdTipoDevolucion());
            tdev.setNombre(tipoDevolucion.getNombre());
            tdev.setDescripcion(tipoDevolucion.getDescripcion());
            tipoDevolucionesDao.insertarTipoDevolucion(tdev);
            tipoDevolucion = new TipoDevolucion();
            addMessage("Insertado Id:!!" + tdev.getIdTipoDevolucion());
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void updateTipoDevolucion(ActionEvent actionEvent) {
        try {
            TipoDevolucion tdev = new TipoDevolucion();
            tdev.setIdTipoDevolucion(tipoDevolucion.getIdTipoDevolucion());
            tdev.setNombre(tipoDevolucion.getNombre());
            tdev.setDescripcion(tipoDevolucion.getDescripcion());
            tipoDevolucionesDao.modificarTipoDevolucion(tdev);
            tipoDevolucion = new TipoDevolucion();
            addMessage("Modificado Id:!!" + tdev.getIdTipoDevolucion());
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void eliminar() {

        try {
            TipoDevolucion tdev = new TipoDevolucion();
            tdev.setIdTipoDevolucion(tipoDevolucion.getIdTipoDevolucion());
            tdev.setNombre(tipoDevolucion.getNombre());
            tdev.setDescripcion(tipoDevolucion.getDescripcion());
            tipoDevolucionesDao.eliminarTipoDevolucion(tdev);
            tipoDevolucion = new TipoDevolucion();
            addMessage("Eliminado Id:!!" + tdev.getIdTipoDevolucion());
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
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
     * @return the tipoDevolucion
     */
    public TipoDevolucion getTipoDevolucion() {
        return tipoDevolucion;
    }

    /**
     * @param tipoDevolucion the tipoDevolucion to set
     */
    public void setTipoDevolucion(TipoDevolucion tipoDevolucion) {
        this.tipoDevolucion = tipoDevolucion;
    }

    /**
     * @return the idTipoDevolucionV
     */
    public int getIdTipoDevolucionV() {
        return idTipoDevolucionV;
    }

    /**
     * @param idTipoDevolucionV the idTipoDevolucionV to set
     */
    public void setIdTipoDevolucionV(int idTipoDevolucionV) {
        this.idTipoDevolucionV = idTipoDevolucionV;
    }

    /**
     * @return the tipoDevolucionLista
     */
    public List<TipoDevolucion> getTipoDevolucionLista() {
        
        try {
            tipoDevolucionLista = tipoDevolucionesDao.mostrarTipoDevolucion();
        } catch (Exception e) {
            e.printStackTrace();
            tipoDevolucionLista = new ArrayList<TipoDevolucion>();
        }
        tipoDevolucion=new TipoDevolucion();
        return tipoDevolucionLista;
    }

    /**
     * @param tipoDevolucionLista the tipoDevolucionLista to set
     */
    public void setTipoDevolucionLista(List<TipoDevolucion> tipoDevolucionLista) {
        this.tipoDevolucionLista = tipoDevolucionLista;
    }

    /**
     * @return the tipoDevolucionesDao
     */
    public TipoDevolucionesDao getTipoDevolucionesDao() {
        return tipoDevolucionesDao;
    }

    /**
     * @param tipoDevolucionesDao the tipoDevolucionesDao to set
     */
    public void setTipoDevolucionesDao(TipoDevolucionesDao tipoDevolucionesDao) {
        this.tipoDevolucionesDao = tipoDevolucionesDao;
    }
}
