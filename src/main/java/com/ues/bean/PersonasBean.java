package com.ues.bean;

import com.ues.dao.PersonasDao;
import com.ues.model.Persona;
import com.ues.model.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import com.ues.dao.impl.PersonasDaoHibImpl;
import com.ues.exception.DAOException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;


/**
 *
 * @author Jocelyn
 */
public class PersonasBean {

    private int idpersonaP; 
    private List<Persona> miLista;
    private PersonasDao personasDao;
    private int idusuarioU;
    public Date fecha=new Date();
    private Persona persona = new Persona();
    private List<Usuario> miListaU;
    
    //para llenar combobox de foráneas
     private List<SelectItem> miListaUsu = new ArrayList<SelectItem>();

    public PersonasBean() {
         persona = new Persona();
         fecha=new Date();
    }

    public List<Persona> getMiLista() {
        try {
            miLista = personasDao.listaPersonas();
            
          
        } catch (Exception e) {
            e.printStackTrace();
            miLista=new ArrayList<Persona>();
        }
        persona=new Persona();
        // Retorno otra lista que tambien necesitare para que la vista la pueda utilizar
        return miLista;
    }

    public void addPersona(ActionEvent actionEvent) {
        try {
            Persona per = new Persona();
            Usuario us = new Usuario();
            per.setIdPersona(persona.getIdPersona());
            us.setIdUsuario(idusuarioU);
            per.setNombre(persona.getNombre());
            per.setApellido(persona.getApellido());
            per.setGenero(persona.getGenero());
            per.setDui(persona.getDui());
            per.setNit(persona.getNit());
            per.setFechaNac(fecha);
            per.setDireccion(persona.getDireccion());
            per.setCorreo(persona.getCorreo());
            per.setUsuario(us);
            personasDao.crearPersona(per);
            addMessage("Insertado Id:!!" + persona.getIdPersona());
        } catch (Exception e) {
            addMessage("Error Id:!!" + persona.getIdPersona() + " " + e.getMessage());
            e.printStackTrace();
        }

    }
    
    
     public void updatePersona(ActionEvent actionEvent) {
        try {
            Persona per = new Persona();
            Usuario us = new Usuario();
            per.setIdPersona(persona.getIdPersona());
            us.setIdUsuario(idusuarioU);
            per.setNombre(persona.getNombre());
            per.setApellido(persona.getApellido());
            per.setGenero(persona.getGenero());
            per.setDui(persona.getDui());
            per.setNit(persona.getNit());
            per.setFechaNac(fecha);
            per.setDireccion(persona.getDireccion());
            per.setCorreo(persona.getCorreo());
            per.setUsuario(us);
            personasDao.modificarPersona(per);
            persona = new Persona();
            addMessage("Actualizado Id:!!" + per.getIdPersona());
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }

    }
     
     
     public void eliminar() {

        try {
            Persona per = new Persona();
            Usuario us = new Usuario();
            per.setIdPersona(persona.getIdPersona());
            us.setIdUsuario(idusuarioU);
            per.setNombre(persona.getNombre());
            per.setApellido(persona.getApellido());
            per.setGenero(persona.getGenero());
            per.setDui(persona.getDui());
            per.setNit(persona.getNit());
            per.setFechaNac(fecha);
            per.setDireccion(persona.getDireccion());
            per.setCorreo(persona.getCorreo());
            per.setUsuario(us);
            personasDao.borrarPersona(per);
            persona = new Persona();
            addMessage("Eliminado Id:!!");
        } catch (Exception e) {
            addMessage("Error Id:!!");
            e.printStackTrace();
        }
    }
     
     
 
    public void setMiLista(List<Persona> miLista) {
        this.miLista = miLista;
    }

    public PersonasDao getPersonasDao() {
        return personasDao;
    }

    public void setPersonasDao(PersonasDao personasDao) {
        this.personasDao = personasDao;
    }

    /**
     * @return the idusuarioU
     */
    public int getIdusuarioU() {
        return idusuarioU;
    }

    /**
     * @param idusuarioU the idusuarioU to set
     */
    public void setIdusuarioU(int idusuarioU) {
        this.idusuarioU = idusuarioU;
    }

    /**
     * @return the persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(Persona persona) {
        this.idusuarioU=persona.getUsuario().getIdUsuario();
        this.persona = persona;
    }

    private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    

    

    /**
     * @return the idpersonaP
     */
    public int getIdpersonaP() {
        return idpersonaP;
    }

    /**
     * @param idpersonaP the idpersonaP to set
     */
    public void setIdpersonaP(int idpersonaP) {
        this.idpersonaP = idpersonaP;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

   
    /**
     * @return the miListaUsu
     */
    public List<SelectItem> getMiListaUsu() {
        
         try {
            miListaU=personasDao.listaUsuarios();
            miListaUsu.clear();
            SelectItemGroup g2 = new SelectItemGroup("Usuario");
            SelectItem[] asi = new SelectItem[miListaU.size()];
            for (int i = 0; i < miListaU.size(); i++) {
                Usuario usAux = (Usuario) miListaU.get(i);
               asi[i] = new SelectItem(usAux.getIdUsuario(), usAux.getNombreUsuario());
            }
            g2.setSelectItems(asi);
            miListaUsu.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
            miListaUsu=new ArrayList<SelectItem>();
        }
    
        return miListaUsu;
    }

    /**
     * @param miListaUsu the miListaUsu to set
     */
    public void setMiListaUsu(List<SelectItem> miListaUsu) {
        this.miListaUsu = miListaUsu;
    }

    

    /**
     * @return the miListaU
     */
    public List<Usuario> getMiListaU() {
        return miListaU;
    }

    /**
     * @param miListaU the miListaU to set
     */
    public void setMiListaU(List<Usuario> miListaU) {
        this.miListaU = miListaU;
    }

}
