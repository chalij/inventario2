package com.ues.bean;

import com.ues.dao.TipoUsuariosDao;
import com.ues.dao.UsuariosDao;
import com.ues.dao.impl.UsuariosDaoHibImpl;
import com.ues.exception.DAOException;
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
public class TipoUsuariosBean {

    private TipoUsuario tipoUsuario = new TipoUsuario();
    private List<TipoUsuario> tipoUsuarioLista = new ArrayList<TipoUsuario>();
    private int idTipoUsuarioV;
    private TipoUsuariosDao tipoUsuariosDao;

    /**
     * @return the tipoUsuario
     */
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * @param tipoUsuario the tipoUsuario to set
     */
    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * @return the tipoUsuarioLista
     */
    public List<TipoUsuario> getTipoUsuarioLista() {
        
        try {
            tipoUsuarioLista = getTipoUsuariosDao().mostrarTipoUsuario();
        } catch (Exception e) {
            e.printStackTrace();
            tipoUsuarioLista = new ArrayList<TipoUsuario>();
        }
        tipoUsuario=new TipoUsuario();
        return tipoUsuarioLista;
    }
    
    
    public void addTipoUsuario(ActionEvent actionEvent) {
        try {
            TipoUsuario tus = new TipoUsuario();
            tus.setIdTipoUsuario(tipoUsuario.getIdTipoUsuario());
            tus.setNombre(tipoUsuario.getNombre());
            tus.setDescripcion(tipoUsuario.getDescripcion());
            tipoUsuariosDao.insertarTipoUsuario(tus);
            tipoUsuario = new TipoUsuario();
            addMessage("Insertado Id:!!" + tus.getIdTipoUsuario());
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void updateTipoUsuario(ActionEvent actionEvent) {
            
        try {
            TipoUsuario tus = new TipoUsuario();
            tus.setIdTipoUsuario(tipoUsuario.getIdTipoUsuario());
            tus.setNombre(tipoUsuario.getNombre());
            tus.setDescripcion(tipoUsuario.getDescripcion());
            tipoUsuariosDao.modificarTipoUsuario(tus);
            tipoUsuario = new TipoUsuario();
            addMessage("Insertado Id:!!" + tus.getIdTipoUsuario());
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void eliminar() {

        try {
            TipoUsuario tus = new TipoUsuario();
            tus.setIdTipoUsuario(tipoUsuario.getIdTipoUsuario());
            tus.setNombre(tipoUsuario.getNombre());
            tus.setDescripcion(tipoUsuario.getDescripcion());
            tipoUsuariosDao.eliminarTipoUsuario(tus);
            tipoUsuario = new TipoUsuario();
            addMessage("Insertado Id:!!" + tus.getIdTipoUsuario());
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * @param tipoUsuarioLista the tipoUsuarioLista to set
     */
    public void setTipoUsuarioLista(List<TipoUsuario> tipoUsuarioLista) {
        this.tipoUsuarioLista = tipoUsuarioLista;
    }

    /**
     * @return the tipoUsuariosDao
     */
    public TipoUsuariosDao getTipoUsuariosDao() {
        return tipoUsuariosDao;
    }

    /**
     * @param tipoUsuariosDao the tipoUsuariosDao to set
     */
    public void setTipoUsuariosDao(TipoUsuariosDao tipoUsuariosDao) {
        this.tipoUsuariosDao = tipoUsuariosDao;
    }

    /**
     * @return the idTipoUsuarioV
     */
    public int getIdTipoUsuarioV() {
        return idTipoUsuarioV;
    }

    /**
     * @param idTipoUsuarioV the idTipoUsuarioV to set
     */
    public void setIdTipoUsuarioV(int idTipoUsuarioV) {
        this.idTipoUsuarioV = idTipoUsuarioV;
    }

    /**
     * @return the tipoUsuarioLista
     */
   
    private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
