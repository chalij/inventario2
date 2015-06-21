package com.ues.bean;

import com.ues.dao.TipoMenuDao;
import com.ues.model.TipoMenu;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
/**
 *
 * @author Jocelyn
 */
    public class TipoMenuBean {

    private int idTipoMenuTM;
    private List<TipoMenu> miLista;
    private TipoMenuDao tipomenuDao;
    private TipoMenu tipomenu = new TipoMenu();
    
    //constructor
    public TipoMenuBean() {
        tipomenu = new TipoMenu();
    }

    /**
     * @return the miLista
     */
    public List<TipoMenu> getMiLista() {
        try
        {
            miLista=tipomenuDao.listaTipoMenus();
        }
        catch(Exception e)
        {
            System.out.println("Entra a Excepcion"+e.getMessage());
            miLista=new ArrayList<TipoMenu>();
        }
        tipomenu=new TipoMenu();
        return miLista;
    }
 
    /**
     * @param miLista the miLista to set
     */
    public void setMiLista(List<TipoMenu> miLista) {
        this.miLista = miLista;
    }

    
     public void addTipoMenu(ActionEvent actionEvent) {
        try {
            TipoMenu tm = new TipoMenu();
            
           tm.setIdTipoMenu(tipomenu.getIdTipoMenu());
            tm.setNombre(tipomenu.getNombre()); 
            tipomenuDao.crearTipoMenu(tm);
          
            addMessage("Insertado Id:!!" + tipomenu.getIdTipoMenu());
        } catch (Exception e) {
            addMessage("Error Id:!!" + tipomenu.getIdTipoMenu() + " " + e.getMessage());
            e.printStackTrace();
        }

    }
    
    
    public void updateTipoMenu(ActionEvent actionEvent) {
         try {
            TipoMenu tm = new TipoMenu();
            
           tm.setIdTipoMenu(tipomenu.getIdTipoMenu());
            tm.setNombre(tipomenu.getNombre()); 
            tipomenuDao.modificarTipoMenu(tm);
          
            addMessage("Modificado Id:!!" + tipomenu.getIdTipoMenu());
        } catch (Exception e) {
            addMessage("Error Id:!!" + tipomenu.getIdTipoMenu() + " " + e.getMessage());
            e.printStackTrace();
        }

    }
    
    public void eliminar(ActionEvent actionEvent) {
         try {
            TipoMenu tm = new TipoMenu();
            
           tm.setIdTipoMenu(tipomenu.getIdTipoMenu());
            tm.setNombre(tipomenu.getNombre()); 
            tipomenuDao.borrarTipoMenu(tm);
          
            addMessage("Eliminado Id:!!" + tipomenu.getIdTipoMenu());
        } catch (Exception e) {
            addMessage("Error Id:!!" + tipomenu.getIdTipoMenu() + " " + e.getMessage());
            e.printStackTrace();
        }

    }
    
    /**
     * @return the tipomenuDao
     */
    public TipoMenuDao getTipomenuDao() {
        return tipomenuDao;
    }

    /**
     * @param tipomenuDao the tipomenuDao to set
     */
    public void setTipomenuDao(TipoMenuDao tipomenuDao) {
        this.tipomenuDao = tipomenuDao;
    }

    /**
     * @return the tipomenu
     */
    public TipoMenu getTipomenu() {
        return tipomenu;
    }

    /**
     * @param tipomenu the tipomenu to set
     */
    public void setTipomenu(TipoMenu tipomenu) {
        this.tipomenu = tipomenu;
    }
   
     private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the idTipoMenuTM
     */
    public int getIdTipoMenuTM() {
        return idTipoMenuTM;
    }

    /**
     * @param idTipoMenuTM the idTipoMenuTM to set
     */
    public void setIdTipoMenuTM(int idTipoMenuTM) {
        this.idTipoMenuTM = idTipoMenuTM;
    }
    
    }