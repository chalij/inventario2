package com.ues.bean;

import com.ues.dao.UsuariosDao;
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

/**
 *
 * @author Airy
 */
public class UsuariosBean {

    private Usuario usuario = new Usuario();
    private int tipoUsuarioT;
    private List<Usuario> miLista;
    private UsuariosDao usuariosDao;
    private int eliminarU;

    public UsuariosBean() {
    }

    public List<Usuario> getMiLista() {
        try {
            miLista = usuariosDao.listaUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
            miLista = new ArrayList();
        }
        return miLista;
    }

    public void destroyWorld(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "System Error",  "Please try again later.");  
          
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
    public void addUsuario(ActionEvent actionEvent) {
        try {
            Usuario us = new Usuario();
            TipoUsuario tus = new TipoUsuario();
            tus.setIdTipoUsuario(tipoUsuarioT);
            us.setIdUsuario(usuario.getIdUsuario());
            us.setNombreUsuario(usuario.getNombreUsuario());
            us.setContrasena(usuario.getContrasena());
            us.setFechaCreacion(new Date());
            us.setTipoUsuario(tus);
            usuariosDao.crearUsuario(us);
            addMessage("Insertado Id:!!" + usuario.getIdUsuario());
        } catch (Exception e) {
            addMessage("Error Id:!!" + usuario.getIdUsuario()+" "+ e.getMessage());
            e.printStackTrace();
        }

    }
    public void eliminarUSI()
    {
        
        try {
           /* Usuario us = new Usuario();
            us.setIdUsuario(eliminarU);
            TipoUsuario tp=new TipoUsuario();
            us.setNombreUsuario("sdfs");
            us.setFechaCreacion(new Date());
            us.setContrasena("sdfsd");
            tp.setIdTipoUsuario(1);
            us.setTipoUsuario(tp);*/
            Usuario us = new Usuario();
            TipoUsuario tus = new TipoUsuario();
            tus.setIdTipoUsuario(usuario.getTipoUsuario().getIdTipoUsuario());
            us.setIdUsuario(usuario.getIdUsuario());
            us.setNombreUsuario(usuario.getNombreUsuario());
            us.setContrasena(usuario.getContrasena());
            us.setFechaCreacion(new Date());
            us.setTipoUsuario(tus);
            usuariosDao.borrarUsuario(us);
            addMessage("Eliminado Id:!!" + usuario.getIdUsuario());
        } catch (Exception e) {
            addMessage("Error Id:!!" + usuario.getIdUsuario()+" "+ e.getMessage());
            e.printStackTrace();
        }
    }
            

    public void setMiLista(List<Usuario> miLista) {
        this.miLista = miLista;
    }

    public UsuariosDao getUsuariosDao() {
        return usuariosDao;
    }

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

    private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the tipoUsuarioT
     */
    public int getTipoUsuarioT() {
        return tipoUsuarioT;
    }

    /**
     * @param tipoUsuarioT the tipoUsuarioT to set
     */
    public void setTipoUsuarioT(int tipoUsuarioT) {
        this.tipoUsuarioT = tipoUsuarioT;
    }

    /**
     * @return the eliminarU
     */
    public int getEliminarU() {
        return eliminarU;
    }

    /**
     * @param eliminarU the eliminarU to set
     */
    public void setEliminarU(int eliminarU) {
        this.eliminarU = eliminarU;
    }

}
