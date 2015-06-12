package com.ues.bean;

import com.ues.dao.ProveedorDao;
import com.ues.model.Persona;
import com.ues.model.Proveedor;
import com.ues.model.TipoProveedor;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 *
 * @author Ibrahim
 */
public class ProveedorBean {
    
    private int idProveedorProv;
    private List<Proveedor> miLista;
    private List<Persona> miListaP;
    private List<TipoProveedor> miListaTipoP;
    private ProveedorDao proveedorDao;
    private Proveedor proveedor = new Proveedor();
    //Para las Foraneas
    private int idPersonaP;
    private int idTipoProveedorTP;
    private List<Persona> listaPer;
    private List<TipoProveedor> listaTP;
    
    private List<SelectItem> listaProveedor = new ArrayList<SelectItem>();
    private List<SelectItem> listaProveedor2 = new ArrayList<SelectItem>();

    public ProveedorBean() {
        proveedor = new Proveedor();
    }

    public int getIdProveedorProv() {
        return idProveedorProv;
    }

    public void setIdProveedorProv(int idProveedorProv) {
        this.idProveedorProv = idProveedorProv;
    }

    public List<Proveedor> getMiLista() {
        try {
            miLista = proveedorDao.listaProveedor();
        } catch (Exception e) {
            e.printStackTrace();
            miLista = new ArrayList<Proveedor>();
        }
        proveedor = new Proveedor();
        return miLista;
    }
    
    public void addProveedor(ActionEvent actionEvent) {
        try {
            Proveedor p = new Proveedor();
            Persona per = new Persona();
            TipoProveedor tp = new TipoProveedor();
            
            p.setIdProveedor(proveedor.getIdProveedor());
            per.setIdPersona(idPersonaP);
            tp.setIdTipoProveedor(idTipoProveedorTP);
            p.setNombre(proveedor.getNombre());
            p.setCorreo(proveedor.getCorreo());
            p.setNit(proveedor.getNit());
            p.setGiro(proveedor.getGiro());
            p.setNrc(proveedor.getNrc());
            p.setPersona(per);
            p.setTipoProveedor(tp);
            proveedorDao.crearProveedor(p);

            addMessage("Proveedor Ingresado:!!" + proveedor.getNombre());
        } catch (Exception e) {
            addMessage("Error Id:!!" + proveedor.getNombre() + " " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void updateProveedor(ActionEvent actionEvent) {
        try {
            Proveedor p = new Proveedor();
            Persona per = new Persona();
            TipoProveedor tp = new TipoProveedor();
            
            p.setIdProveedor(proveedor.getIdProveedor());
            per.setIdPersona(idPersonaP);
            tp.setIdTipoProveedor(idTipoProveedorTP);
            p.setNombre(proveedor.getNombre());
            p.setCorreo(proveedor.getCorreo());
            p.setNit(proveedor.getNit());
            p.setGiro(proveedor.getGiro());
            p.setNrc(proveedor.getNrc());
            p.setPersona(per);
            p.setTipoProveedor(tp);
            proveedorDao.modificarProveedor(p);

            addMessage("Proveedor Modificado:!!" + proveedor.getNombre());
        } catch (Exception e) {
            addMessage("Error Id:!!" + proveedor.getNombre() + " " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void eliminar() {
        try {
            Proveedor p = new Proveedor();
            Persona per = new Persona();
            TipoProveedor tp = new TipoProveedor();
            
            p.setIdProveedor(proveedor.getIdProveedor());
            per.setIdPersona(idPersonaP);
            tp.setIdTipoProveedor(idTipoProveedorTP);
            p.setNombre(proveedor.getNombre());
            p.setCorreo(proveedor.getCorreo());
            p.setNit(proveedor.getNit());
            p.setGiro(proveedor.getGiro());
            p.setNrc(proveedor.getNrc());
            p.setPersona(per);
            p.setTipoProveedor(tp);
            proveedorDao.borrarProveedor(p);

            addMessage("Proveedor Eliminado:!!" + proveedor.getNombre());
        } catch (Exception e) {
            addMessage("Error Id:!!" + proveedor.getNombre() + " " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void setMiLista(List<Proveedor> miLista) {
        this.miLista = miLista;
    }

    public List<Persona> getMiListaP() {
        return miListaP;
    }

    public void setMiListaP(List<Persona> miListaP) {
        this.miListaP = miListaP;
    }

    public List<TipoProveedor> getMiListaTipoP() {
        return miListaTipoP;
    }

    public void setMiListaTipoP(List<TipoProveedor> miListaTipoP) {
        this.miListaTipoP = miListaTipoP;
    }

    public ProveedorDao getProveedorDao() {
        return proveedorDao;
    }

    public void setProveedorDao(ProveedorDao proveedorDao) {
        this.proveedorDao = proveedorDao;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public int getIdPersonaP() {
        return idPersonaP;
    }

    public void setIdPersonaP(int idPersonaP) {
        this.idPersonaP = idPersonaP;
    }

    public int getIdTipoProveedorTP() {
        return idTipoProveedorTP;
    }

    public void setIdTipoProveedorTP(int idTipoProveedorTP) {
        this.idTipoProveedorTP = idTipoProveedorTP;
    }

    public List<Persona> getListaPer() {
        return listaPer;
    }

    public void setListaPer(List<Persona> listaPer) {
        this.listaPer = listaPer;
    }

    public List<TipoProveedor> getListaTP() {
        return listaTP;
    }

    public void setListaTP(List<TipoProveedor> listaTP) {
        this.listaTP = listaTP;
    }

    public List<SelectItem> getListaProveedor() {
        try {
            miListaP= proveedorDao.listaPersona();
            listaProveedor.clear();
            SelectItemGroup g2 = new SelectItemGroup("Personas");
            SelectItem[] asi = new SelectItem[miListaP.size()];
            for (int i = 0; i < miListaP.size(); i++) {
                Persona pAux = (Persona) miListaP.get(i);
                asi[i] = new SelectItem(pAux.getIdPersona(), pAux.getNombre());
            }
            g2.setSelectItems(asi);
            listaProveedor.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
           listaProveedor = new ArrayList<SelectItem>();
        }
        return listaProveedor;
    }

    public void setListaProveedor(List<SelectItem> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }

    public List<SelectItem> getListaProveedor2() {
        try {
            miListaTipoP= proveedorDao.listaTipoProveedor();
            listaProveedor2.clear();
            SelectItemGroup g2 = new SelectItemGroup("Bodegas");
            SelectItem[] asi = new SelectItem[miListaTipoP.size()];
            for (int i = 0; i < miListaTipoP.size(); i++) {
                TipoProveedor tpAux = (TipoProveedor) miListaTipoP.get(i);
                asi[i] = new SelectItem(tpAux.getIdTipoProveedor(), tpAux.getNombre());
            }
            g2.setSelectItems(asi);
            listaProveedor2.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
           listaProveedor2 = new ArrayList<SelectItem>();
        }
        return listaProveedor2;
    }

    public void setListaProveedor2(List<SelectItem> listaProveedor2) {
        this.listaProveedor2 = listaProveedor2;
    }
    
    
}
