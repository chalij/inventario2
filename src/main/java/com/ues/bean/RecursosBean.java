package com.ues.bean;

import com.ues.dao.RecursosDao;
import com.ues.dao.UsuariosDao;
import com.ues.dao.impl.UsuariosDaoHibImpl;
import com.ues.exception.DAOException;
import com.ues.model.Recursos;
import com.ues.model.TipoUsuario;
import com.ues.model.Usuario;
import java.math.BigDecimal;
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
public class RecursosBean {

  //  private Usuario usuario = new Usuario();
    private Recursos recursos = new Recursos();
    private List<Recursos> miLista;
    private int tipoUsuarioT;
   // private int idUsuarioV;
    private int idRecursoV;
    private List<TipoUsuario> listaTipoU;
    //private UsuariosDao usuariosDao;
    private RecursosDao recursosDao;
    private List<SelectItem> listaUsu = new ArrayList<SelectItem>();

    public RecursosBean() {
        recursos = new Recursos();
    }

    public List<Recursos> getMiLista() {
        try {
            miLista = recursosDao.listaRecursos();
        } catch (Exception e) {
            e.printStackTrace();
            miLista = new ArrayList<Recursos>();
        }
        recursos=new Recursos();
        return miLista;
    }
    
    public void setMiLista(List<Recursos> miLista) {
        this.miLista = miLista;
    }


    public void addRecursos(ActionEvent actionEvent) {
        try {
            Recursos re = new Recursos();
            TipoUsuario tus = new TipoUsuario();
            tus.setIdTipoUsuario(tipoUsuarioT);
            re.setIdRecurso(recursos.getIdRecurso());
            re.setUrl(recursos.getUrl());
            re.setTipoUsuario(tus);
            recursosDao.crearRecursos(re);
            recursos = new Recursos();
            addMessage("Insertado Id:!!" + re.getIdRecurso());
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void updateRecursos(ActionEvent actionEvent) {
        try {
            Recursos re = new Recursos();
            TipoUsuario tus = new TipoUsuario();
            tus.setIdTipoUsuario(tipoUsuarioT);
            re.setIdRecurso(recursos.getIdRecurso());
            re.setUrl(recursos.getUrl());
            re.setTipoUsuario(tus);
            recursosDao.modificarRecursos(re);
            recursos = new Recursos();
            addMessage("Modificado Id:!!" + re.getIdRecurso());
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void eliminar() {

        try {
            Recursos re = new Recursos();
            TipoUsuario tus = new TipoUsuario();
            tus.setIdTipoUsuario(tipoUsuarioT);
            re.setIdRecurso(recursos.getIdRecurso());
            re.setUrl(recursos.getUrl());
            re.setTipoUsuario(tus);
            recursosDao.borrarRecursos(re);
            recursos = new Recursos();
            addMessage("Eliminar Id:!!" + re.getIdRecurso());
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }
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
     * @return the listaUsu
     */
    public List<SelectItem> getListaUsu() {

        try {
            listaTipoU = recursosDao.listaTipoUsuarios();
            listaUsu.clear();
            SelectItemGroup g2 = new SelectItemGroup("Tipo Usarios");
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

    /**
     * @return the recursos
     */
    public Recursos getRecursos() {
        return recursos;
    }

    /**
     * @param recursos the recursos to set
     */
    public void setRecursos(Recursos recursos) {
        
        this.tipoUsuarioT = recursos.getTipoUsuario().getIdTipoUsuario();
        this.recursos = recursos;
    }

    /**
     * @return the idRecursoV
     */
    public int getIdRecursoV() {
        return idRecursoV;
    }

    /**
     * @param idRecursoV the idRecursoV to set
     */
    public void setIdRecursoV(int idRecursoV) {
        this.idRecursoV = idRecursoV;
    }

    /**
     * @return the recursosDao
     */
    public RecursosDao getRecursosDao() {
        return recursosDao;
    }

    /**
     * @param recursosDao the recursosDao to set
     */
    public void setRecursosDao(RecursosDao recursosDao) {
        this.recursosDao = recursosDao;
    }
    
   

}
