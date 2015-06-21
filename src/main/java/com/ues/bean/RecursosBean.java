package com.ues.bean;

import com.ues.dao.MenusDao;
import com.ues.dao.RecursosDao;
import com.ues.dao.UsuariosDao;
import com.ues.dao.impl.UsuariosDaoHibImpl;
import com.ues.exception.DAOException;
import com.ues.model.Menu;
import com.ues.model.Recursos;
import com.ues.model.TipoMenu;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Airy
 */
public class RecursosBean {

    //  private Usuario usuario = new Usuario();
    private Recursos recursos = new Recursos();
    private Menu menu = new Menu();
    private List<Menu> miLista;
    private int tipoUsuarioT;
    private int tipoMenuT;
    // private int idUsuarioV;
    private int idRecursoV;
    private List<TipoUsuario> listaTipoU;
    private List<TipoMenu> listaTipoM;
    //private UsuariosDao usuariosDao;
    private RecursosDao recursosDao;
    private MenusDao menusDao;
    private List<SelectItem> listaUsu = new ArrayList<SelectItem>();
    private List<SelectItem> listaUsu2 = new ArrayList<SelectItem>();

    public RecursosBean() {
        recursos = new Recursos();
        menu = new Menu();
    }

    public List<Menu> getMiLista() {
        try {
            miLista = recursosDao.listaRecursos();

        } catch (Exception e) {
            e.printStackTrace();
            miLista = new ArrayList<Menu>();
        }
        recursos = new Recursos();
        menu = new Menu();
        return miLista;
    }

    public void setMiLista(List<Menu> miLista) {
        this.miLista = miLista;
    }

    public void addRecursos(ActionEvent actionEvent) {
        try {
            Recursos re = new Recursos();
            TipoUsuario tus = new TipoUsuario();
            tus.setIdTipoUsuario(tipoUsuarioT);
            // re.setIdRecursos(recursos.getIdRecursos());
            re.setUrl(recursos.getUrl());
            re.setTipoUsuario(tus);
            recursosDao.crearRecursos(re);
            System.out.println(recursosDao.maxID());
            Recursos rea = new Recursos();
            rea.setIdRecursos(recursosDao.maxID());
            Menu me = new Menu();
            me.setNombre(menu.getNombre());
            TipoMenu tm = new TipoMenu();
            tm.setIdTipoMenu(tipoMenuT);
            me.setTipoMenu(tm);
            me.setRecursos(rea);
            menusDao.crearMenu(me);
            recursos = new Recursos();
            menu = new Menu();
            addMessage("Insertado!!");
        } catch (Exception e) {
            addMessage("Error!!" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void updateRecursos(ActionEvent actionEvent) {
        try {
            
            Recursos re = new Recursos();
            re.setIdRecursos(recursos.getIdRecursos());
            TipoUsuario tus = new TipoUsuario();
            tus.setIdTipoUsuario(tipoUsuarioT);
            re.setUrl(recursos.getUrl());
            re.setTipoUsuario(tus);
            recursosDao.modificarRecursos(re);
            System.out.println("++++++++++++claves++++++++++++++");
            System.out.println(re.getIdRecursos());
            System.out.println(menu.getIdMenu());
          //  System.out.println(recursosDao.maxID());
            Recursos rea = new Recursos();
            rea.setIdRecursos(recursos.getIdRecursos());
            Menu me = new Menu();
            me.setIdMenu(menu.getIdMenu());
            me.setNombre(menu.getNombre());
            TipoMenu tm = new TipoMenu();
            tm.setIdTipoMenu(tipoMenuT);
            me.setTipoMenu(tm);
            me.setRecursos(rea);
            menusDao.modificarMenu(me);
            recursos = new Recursos();
            menu = new Menu();
            addMessage("Modificado!!");
        } catch (Exception e) {
            addMessage("Error!!" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void eliminar() {

        try {
            
            Recursos rea = new Recursos();
            rea.setIdRecursos(recursos.getIdRecursos());
            Menu me = new Menu();
            me.setIdMenu(menu.getIdMenu());
            me.setNombre(menu.getNombre());
            TipoMenu tm = new TipoMenu();
            tm.setIdTipoMenu(tipoMenuT);
            me.setTipoMenu(tm);
            me.setRecursos(rea);
            menusDao.borrarMenu(me);
            
            
            Recursos re = new Recursos();
            re.setIdRecursos(recursos.getIdRecursos());
            TipoUsuario tus = new TipoUsuario();
            tus.setIdTipoUsuario(tipoUsuarioT);
            re.setUrl(recursos.getUrl());
            re.setTipoUsuario(tus);
            recursosDao.borrarRecursos(re);
            System.out.println("++++++++++++claves++++++++++++++");
            System.out.println(re.getIdRecursos());
            System.out.println(menu.getIdMenu());
            recursos = new Recursos();
            menu = new Menu();
          //  System.out.println(recursosDao.maxID());
            addMessage("Eliminar!!");
        } catch (Exception e) {
            addMessage("Error!!" + e.getMessage());
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

    /**
     * @return the menusDao
     */
    public MenusDao getMenusDao() {
        return menusDao;
    }

    /**
     * @param menusDao the menusDao to set
     */
    public void setMenusDao(MenusDao menusDao) {
        this.menusDao = menusDao;
    }

    /**
     * @return the listaUsu2
     */
    public List<SelectItem> getListaUsu2() {
        try {
            listaTipoM = menusDao.listaTipoMenus();
            listaUsu2.clear();
            SelectItemGroup g2 = new SelectItemGroup("Tipo Menus");
            SelectItem[] asi = new SelectItem[listaTipoM.size()];
            for (int i = 0; i < listaTipoM.size(); i++) {
                TipoMenu usAux = (TipoMenu) listaTipoM.get(i);
                asi[i] = new SelectItem(usAux.getIdTipoMenu(), usAux.getNombre());
            }
            g2.setSelectItems(asi);
            listaUsu2.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
            listaUsu2 = new ArrayList<SelectItem>();
        }
        return listaUsu2;
    }

    /**
     * @param listaUsu2 the listaUsu2 to set
     */
    public void setListaUsu2(List<SelectItem> listaUsu2) {
        this.listaUsu2 = listaUsu2;
    }

    /**
     * @return the listaTipoM
     */
    public List<TipoMenu> getListaTipoM() {
        return listaTipoM;
    }

    /**
     * @param listaTipoM the listaTipoM to set
     */
    public void setListaTipoM(List<TipoMenu> listaTipoM) {
        this.listaTipoM = listaTipoM;
    }

    /**
     * @return the tipoMenuT
     */
    public int getTipoMenuT() {
        return tipoMenuT;
    }

    /**
     * @param tipoMenuT the tipoMenuT to set
     */
    public void setTipoMenuT(int tipoMenuT) {
        this.tipoMenuT = tipoMenuT;
    }

    /**
     * @return the menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(Menu menu) {
        this.recursos=menu.getRecursos();
        this.tipoUsuarioT = menu.getRecursos().getTipoUsuario().getIdTipoUsuario();
        this.menu = menu;
    }

}
