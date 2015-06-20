/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.bean;

import com.ues.dao.UsuariosDao;
import com.ues.model.CustomHibernateDaoSupport;
import com.ues.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Administrador
 */
public class LoggBean extends CustomHibernateDaoSupport {

    private String username;

    private String password;
    private Usuario usuario;
    private UsuariosDao usuariosDao;
    private List<Usuario> miLista;

    public void LoogBean() {
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
     * @return the miLista
     */
    public List<Usuario> getMiLista() {

        try {
            miLista = usuariosDao.listaUsuarios();
        } catch (Exception e) {
            miLista = new ArrayList<Usuario>();
        }
        System.out.println(miLista);
        return miLista;
    }

    public String login() {
        try {
            if (usuariosDao.controlLogg(username, password)) {

                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido!!", null);
                FacesContext.getCurrentInstance().addMessage(null, message);

                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("username", username);
                return "menu_principal.xhmtl?faces-redirect=true";
            } else {
                RequestContext.getCurrentInstance().update("growl");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!!", "Usuario o Pasword Invalido!"));
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * @param miLista the miLista to set
     */
    public void setMiLista(List<Usuario> miLista) {
        this.miLista = miLista;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
