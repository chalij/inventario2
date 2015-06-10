package com.ues.bean;

import com.ues.dao.TelefonoDao;
import com.ues.model.Telefono;
import java.text.ParseException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import com.ues.dao.impl.TelefonoDaoHibImpl;
import com.ues.exception.DAOException;
import com.ues.model.Persona;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 *
 * @author Jocelyn
 */
public class TelefonoBean {
    
    private int idTelefonoT;
    private List<Telefono> miLista;

    private TelefonoDao telefonoDao;
    private Telefono telefono = new Telefono();
    
    //Para foránea
    private int idPersonaP;
    private List<Persona> miListaP;
    private List<SelectItem> listaitemP = new ArrayList<SelectItem>();
   
   
    public TelefonoBean() {
         telefono = new Telefono();
    }

    /**
     * @return the idTelefonoT
     */
    public int getIdTelefonoT() {
        return idTelefonoT;
    }

    /**
     * @param idTelefonoT the idTelefonoT to set
     */
    public void setIdTelefonoT(int idTelefonoT) {
        this.idTelefonoT = idTelefonoT;
    }

    /**
     * @return the miLista
     */
    public List<Telefono> getMiLista() {
        
         try {
            miLista = telefonoDao.listaTelefonos();
        } catch (Exception e) {
            e.printStackTrace();
            miLista = new ArrayList<Telefono>();
        }
       telefono = new Telefono();
         
        return miLista;
    }
    
     public void addTelefono(ActionEvent actionEvent) {
        try {
            
            Telefono t = new Telefono();
            Persona p= new Persona ();
            t.setIdTelefono(telefono.getIdTelefono());
            t.setNumTelefono(telefono.getNumTelefono());
            p.setIdPersona(idPersonaP);
            t.setPersona(p);
            telefonoDao.crearTelefono(t);
           
            addMessage("Insertado Id:!!" + telefono.getIdTelefono());
        } catch (Exception e) {
            addMessage("Error Id:!!" + telefono.getIdTelefono() + " " + e.getMessage());
            e.printStackTrace();
        }
    
     }
    
    
     public void updateTelefono(ActionEvent actionEvent) {
       try {
            
            Telefono t = new Telefono();
            Persona p= new Persona ();
            t.setIdTelefono(telefono.getIdTelefono());
            t.setNumTelefono(telefono.getNumTelefono());
            p.setIdPersona(idPersonaP);
            t.setPersona(p);
            telefonoDao.modificarTelefono(t);
           
            addMessage("Insertado Id:!!" + telefono.getIdTelefono());
        } catch (Exception e) {
            addMessage("Error Id:!!" + telefono.getIdTelefono() + " " + e.getMessage());
            e.printStackTrace();
        }
           
    }
     
     public void eliminar() {

       try {
            
            Telefono t = new Telefono();
            Persona p= new Persona ();
            t.setIdTelefono(telefono.getIdTelefono());
            t.setNumTelefono(telefono.getNumTelefono());
            p.setIdPersona(idPersonaP);
            t.setPersona(p);
            telefonoDao.borrarTelefono(t);
            telefono=new Telefono();
           
            addMessage("Eliminado Id:!!" + telefono.getIdTelefono());
        } catch (Exception e) {
            addMessage("Error Id:!!" + telefono.getIdTelefono() + " " + e.getMessage());
            e.printStackTrace();
        }
    }
 
    /**
     * @param miLista the miLista to set
     */
    public void setMiLista(List<Telefono> miLista) {
        this.miLista = miLista;
    }
    
     private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the miListaP
     */
    public List<Persona> getMiListaP() {
        return miListaP;
    }

    /**
     * @param miListaP the miListaP to set
     */
    public void setMiListaP(List<Persona> miListaP) {
        this.miListaP = miListaP;
    }

    /**
     * @return the telefonoDao
     */
    public TelefonoDao getTelefonoDao() {
        return telefonoDao;
    }

    /**
     * @param telefonoDao the telefonoDao to set
     */
    public void setTelefonoDao(TelefonoDao telefonoDao) {
        this.telefonoDao = telefonoDao;
    }

    /**
     * @return the telefono
     */
    public Telefono getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the idPersonaP
     */
    public int getIdPersonaP() {
        return idPersonaP;
    }

    /**
     * @param idPersonaP the idPersonaP to set
     */
    public void setIdPersonaP(int idPersonaP) {
        this.idPersonaP = idPersonaP;
    }

    /**
     * @return the listaitemP
     */
    public List<SelectItem> getListaitemP() {
        
        try {
            miListaP=telefonoDao.listaPersonas();
            listaitemP.clear();
            
            SelectItemGroup g2 = new SelectItemGroup("Persona");
            SelectItem[] asi = new SelectItem[miListaP.size()];
            for (int i = 0; i < miListaP.size(); i++) {
                Persona pAux = (Persona) miListaP.get(i);
                asi[i] = new SelectItem(pAux.getIdPersona(), pAux.getNombre()+" "+pAux.getApellido());
            }
            g2.setSelectItems(asi);
            listaitemP.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
           listaitemP = new ArrayList<SelectItem>();
        }
      
        return listaitemP;
    }

    /**
     * @param listaitemP the listaitemP to set
     */
    public void setListaitemP(List<SelectItem> listaitemP) {
        this.listaitemP = listaitemP;
    }

    
    
   
}//fin clase

