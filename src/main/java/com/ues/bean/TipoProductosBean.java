package com.ues.bean;

import com.ues.dao.TipoProductosDao;
import com.ues.dao.TipoUsuariosDao;
import com.ues.dao.UsuariosDao;
import com.ues.dao.impl.UsuariosDaoHibImpl;
import com.ues.exception.DAOException;
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
public class TipoProductosBean {

    private TipoProducto tipoProducto=new TipoProducto();
    private List<TipoProducto> tipoProductoLista = new ArrayList<TipoProducto>();
    private int idTipoProductoV;
    private TipoProductosDao tipoProductosDao;

    

    /**
     * @return the tipoUsuarioLista
     */
    
    
    public void addTipoProducto(ActionEvent actionEvent) {
        try {
            TipoProducto tus = new TipoProducto();
            tus.setIdTipoProducto(tipoProducto.getIdTipoProducto());
            tus.setNombre(tipoProducto.getNombre());
            tus.setDescripcion(tipoProducto.getDescripcion());
            tipoProductosDao.insertarTipoProducto(tus);
            tipoProducto = new TipoProducto();
            addMessage("Insertado Id:!!" + tus.getIdTipoProducto());
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void updateTipoProducto(ActionEvent actionEvent) {
        try {
            TipoProducto tus = new TipoProducto();
            tus.setIdTipoProducto(tipoProducto.getIdTipoProducto());
            tus.setNombre(tipoProducto.getNombre());
            tus.setDescripcion(tipoProducto.getDescripcion());
            tipoProductosDao.modificarTipoProducto(tus);
            tipoProducto = new TipoProducto();
            addMessage("Modificado Id:!!" + tus.getIdTipoProducto());
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void eliminar() {

        try {
            TipoProducto tus = new TipoProducto();
            tus.setIdTipoProducto(tipoProducto.getIdTipoProducto());
            tus.setNombre(tipoProducto.getNombre());
            tus.setDescripcion(tipoProducto.getDescripcion());
            tipoProductosDao.eliminarTipoProducto(tus);
            tipoProducto = new TipoProducto();
            addMessage("Eliminado Id:!!" + tus.getIdTipoProducto());
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
     * @return the tipoProducto
     */
    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    /**
     * @param tipoProducto the tipoProducto to set
     */
    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    /**
     * @return the tipoProductoLista
     */
    public List<TipoProducto> getTipoProductoLista() {
        
        try {
            tipoProductoLista = tipoProductosDao.mostrarTipoProducto();
        } catch (Exception e) {
            e.printStackTrace();
            tipoProductoLista = new ArrayList<TipoProducto>();
        }
        tipoProducto=new TipoProducto();
        return tipoProductoLista;
    }

    /**
     * @param tipoProductoLista the tipoProductoLista to set
     */
    public void setTipoProductoLista(List<TipoProducto> tipoProductoLista) {
        this.tipoProductoLista = tipoProductoLista;
    }

    /**
     * @return the idTipoProductoV
     */
    public int getIdTipoProductoV() {
        return idTipoProductoV;
    }

    /**
     * @param idTipoProductoV the idTipoProductoV to set
     */
    public void setIdTipoProductoV(int idTipoProductoV) {
        this.idTipoProductoV = idTipoProductoV;
    }

    /**
     * @return the tipoProductosDao
     */
    public TipoProductosDao getTipoProductosDao() {
        return tipoProductosDao;
    }

    /**
     * @param tipoProductosDao the tipoProductosDao to set
     */
    public void setTipoProductosDao(TipoProductosDao tipoProductosDao) {
        this.tipoProductosDao = tipoProductosDao;
    }
}
