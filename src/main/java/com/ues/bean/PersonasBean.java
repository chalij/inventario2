package com.ues.bean;

import com.ues.dao.PersonasDao;
import com.ues.dao.UsuariosDao;
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
import com.ues.dao.impl.UsuariosDaoHibImpl;
import com.ues.exception.DAOException;
import com.ues.model.TipoUsuario;
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
    private PersonasDao personasDao=new PersonasDaoHibImpl();
    private UsuariosDao usuariosDao;
    private int idusuarioU;
    public Date fecha = new Date();
    private Persona persona = new Persona();
    private Usuario usuario=new Usuario();
    private List<Usuario> miListaU;

    //para llenar combobox de foráneas
    private List<SelectItem> miListaUsu = new ArrayList<SelectItem>();

    public PersonasBean() {
        persona = new Persona();
        fecha = new Date();
        usuario=new Usuario();
    }

    public List<Persona> getMiLista() {
        try {
            miLista = personasDao.listaPersonas();

        } catch (Exception e) {
            e.printStackTrace();
            miLista = new ArrayList<Persona>();
        }
        persona = new Persona();
        usuario=new Usuario();
        // Retorno otra lista que tambien necesitare para que la vista la pueda utilizar
        return miLista;
    }

    public void addPersona(ActionEvent actionEvent) {
        try {
            Persona per = new Persona();
           // Usuario us = new Usuario();
            per.setIdPersona(persona.getIdPersona());
            //us.setIdUsuario(idusuarioU);
            per.setNombre(persona.getNombre());
            per.setApellido(persona.getApellido());
            per.setGenero(persona.getGenero());
            per.setDui(persona.getDui());
            per.setNit(persona.getNit());
            per.setFechaNac(fecha);
            per.setDireccion(persona.getDireccion());
            per.setCorreo(persona.getCorreo());
            personasDao.crearPersona(per);
            
            Usuario uaux = new Usuario();
            uaux.setNombreUsuario(usuario.getNombreUsuario());
            uaux.setContrasena(usuario.getContrasena());
            TipoUsuario tus = new TipoUsuario();
            tus.setIdTipoUsuario(1);
            uaux.setTipoUsuario(tus);
            uaux.setFechaCreacion(new Date());
           // uaux.setPersona(per);
            usuariosDao.crearUsuario(uaux);
            addMessage("Insertado Id:!!"+per.getNombre()+" "+per.getApellido());
        } catch (Exception e) {
            addMessage("Error Id:!!"  + e.getMessage());
            e.printStackTrace();
        }
        

    }

    public void updatePersona(ActionEvent actionEvent) {
        try {
            Persona per = new Persona();
            Usuario us = new Usuario();
            per.setIdPersona(persona.getIdPersona());
            //us.setIdUsuario(idusuarioU);
            per.setNombre(persona.getNombre());
            per.setApellido(persona.getApellido());
            per.setGenero(persona.getGenero());
            per.setDui(persona.getDui());
            per.setNit(persona.getNit());
            per.setFechaNac(fecha);
            per.setDireccion(persona.getDireccion());
            per.setCorreo(persona.getCorreo());
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
            miListaU = personasDao.listaUsuarios();
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
            miListaUsu = new ArrayList<SelectItem>();
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

    /**
     * @return the usuariosDao
     */
    public UsuariosDao getUsuariosDao() {
        return usuariosDao;
    }

    /**
     * @param usuariosDao the usuariosDao to set
     */
    public void setUsuariosDao(UsuariosDao usuariosDao) {
        this.usuariosDao = usuariosDao;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the usuarioDao
     */
  
}
