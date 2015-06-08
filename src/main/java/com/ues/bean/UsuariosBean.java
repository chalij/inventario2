package com.ues.bean;

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
public class UsuariosBean {

    private Usuario usuario = new Usuario();
    private int idUsuarioV;
    private int tipoUsuarioT;
    private List<Usuario> miLista;
    private List<TipoUsuario> listaTipoU;
    private UsuariosDao usuariosDao;
    private List<SelectItem> listaUsu = new ArrayList<SelectItem>();

    public UsuariosBean() {
        usuario = new Usuario();
    }

    public List<Usuario> getMiLista() {
        try {
            miLista = usuariosDao.listaUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
            miLista = new ArrayList<Usuario>();
        }
        usuario = new Usuario();
        return miLista;
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
            usuario = new Usuario();
            addMessage("Insertado Id:!!" + us.getIdUsuario());
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void updateUsuario(ActionEvent actionEvent) {
        try {
            Usuario us = new Usuario();
            TipoUsuario tus = new TipoUsuario();
            tus.setIdTipoUsuario(tipoUsuarioT);
            us.setIdUsuario(usuario.getIdUsuario());
            us.setNombreUsuario(usuario.getNombreUsuario());
            us.setContrasena(usuario.getContrasena());
            us.setFechaCreacion(usuario.getFechaCreacion());
            us.setFechaModificacion(new Date());
            us.setTipoUsuario(tus);
            usuariosDao.modificarUsuario(us);
            usuario = new Usuario();
            addMessage("Actualizado Id:!!" + us.getIdUsuario());
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void eliminar() {

        try {
            Usuario us = new Usuario();
            us.setIdUsuario(usuario.getIdUsuario());
            us.setNombreUsuario(usuario.getNombreUsuario());
            us.setContrasena(usuario.getContrasena());
            us.setFechaCreacion(usuario.getFechaCreacion());
            TipoUsuario tus = new TipoUsuario();
            tus.setIdTipoUsuario(usuario.getTipoUsuario().getIdTipoUsuario());
            us.setTipoUsuario(tus);
            usuariosDao.borrarUsuario(us);
            usuario = new Usuario();
            addMessage("Eliminado Id:!!");
        } catch (Exception e) {
            addMessage("Error Id:!!");
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
        this.tipoUsuarioT = usuario.getTipoUsuario().getIdTipoUsuario();
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
     * @return the idUsuarioV
     */
    public int getIdUsuarioV() {
        return idUsuarioV;
    }

    /**
     * @param idUsuarioV the idUsuarioV to set
     */
    public void setIdUsuarioV(int idUsuarioV) {
        this.idUsuarioV = idUsuarioV;
    }

    /**
     * @return the listaUsu
     */
    public List<SelectItem> getListaUsu() {

        try {
            listaTipoU = usuariosDao.listaTipoUsuarios();
            listaUsu.clear();
            SelectItemGroup g2 = new SelectItemGroup("Usarios");
            SelectItem[] asi = new SelectItem[listaTipoU.size()];
            for (int i = 0; i < listaTipoU.size(); i++) {
                TipoUsuario usAux = (TipoUsuario) listaTipoU.get(i);
                asi[i] = new SelectItem(usAux.getIdTipoUsuario(), usAux.getNombre());
            }
            g2.setSelectItems(asi);
            listaUsu.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
            listaUsu = new ArrayList<SelectItem>();
        }
        return listaUsu;
    }

    /**
     * @param listaUsu the listaUsu to set
     */
    public void setListaUsu(List<SelectItem> listaUsu) {
        this.listaUsu = listaUsu;
    }

}
