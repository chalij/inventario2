package com.ues.bean;

import com.ues.dao.TipoClienteDao;
import com.ues.model.TipoCliente;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import com.ues.dao.impl.TipoClienteDaoHibImpl;
import com.ues.exception.DAOException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 *
 * @author Jocelyn
 */
public class TipoClienteBean {
    
    private int idTipoClienteTC;
    private List<TipoCliente> miLista;
    private TipoClienteDao tipoclienteDao;
    private TipoCliente tipocliente = new TipoCliente();
    
    
   

    public TipoClienteBean() {
         tipocliente = new TipoCliente();
    }

    public List<TipoCliente> getMiLista() {
        try {
            miLista = getTipoclienteDao().listaTiposCliente();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miLista;
    }

    public void addTipoCliente(ActionEvent actionEvent) {
        try {
            TipoCliente tc = new TipoCliente();
         
            tc.setIdTipoCliente(tipocliente.getIdTipoCliente());
            tc.setNombre(tipocliente.getNombre());
            tc.setDescripcion(tipocliente.getDescripcion());
            
            tipoclienteDao.crearTipoCliente(tc);
           
            addMessage("Insertado Id:!!" + tipocliente.getIdTipoCliente());
        } catch (Exception e) {
            addMessage("Error Id:!!" + tipocliente.getIdTipoCliente() + " " + e.getMessage());
            e.printStackTrace();
        }

    }
         public void updateTipoCliente(ActionEvent actionEvent) {
        try {
            TipoCliente tc = new TipoCliente();
         
            tc.setIdTipoCliente(tipocliente.getIdTipoCliente());
            tc.setNombre(tipocliente.getNombre());
            tc.setDescripcion(tipocliente.getDescripcion());
            
            tipoclienteDao.modificarTipoCliente(tc);
           
            addMessage("Modificado Id:!!" + tipocliente.getIdTipoCliente());
        } catch (Exception e) {
            addMessage("Error Id:!!" + tipocliente.getIdTipoCliente() + " " + e.getMessage());
            e.printStackTrace();
        }
    }
     
     public void eliminar() {

        try {
            TipoCliente tc= new TipoCliente();
            tc.setIdTipoCliente(tipocliente.getIdTipoCliente());
            tc.setNombre(tipocliente.getNombre());
            tc.setDescripcion(tipocliente.getDescripcion());
            tipoclienteDao.borrarTipoCliente(tc);
            tipocliente=new TipoCliente();
            
            addMessage("Eliminado Id:!!");
        } catch (Exception e) {
            addMessage("Error Id:!!");
            e.printStackTrace();
        }
    }
 
    public void setMiLista(List<TipoCliente> miLista) {
        this.miLista = miLista;
    }

    private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the tipoclienteDao
     */
    public TipoClienteDao getTipoclienteDao() {
        return tipoclienteDao;
    }

    /**
     * @param tipoclienteDao the tipoclienteDao to set
     */
    public void setTipoclienteDao(TipoClienteDao tipoclienteDao) {
        this.tipoclienteDao = tipoclienteDao;
    }

    /**
     * @return the tipocliente
     */
    public TipoCliente getTipocliente() {
        return tipocliente;
    }

    /**
     * @param tipocliente the tipocliente to set
     */
    public void setTipocliente(TipoCliente tipocliente) {
        this.tipocliente = tipocliente;
    }

    /**
     * @return the idTipoClienteTC
     */
    public int getIdTipoClienteTC() {
        return idTipoClienteTC;
    }

    /**
     * @param idTipoClienteTC the idTipoClienteTC to set
     */
    public void setIdTipoClienteTC(int idTipoClienteTC) {
        this.idTipoClienteTC = idTipoClienteTC;
    }

    
}
