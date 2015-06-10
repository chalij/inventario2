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

    private Proveedor proveedor = new Proveedor();
    private int idProveedorV;
    private int idPersonaP;
    private int tipoProveedorT;
    private List<Proveedor> miLista;
    private List<TipoProveedor> listaTipoP;
    private List<Persona> listaPersona;
    private ProveedorDao proveedorDao;
    private List<SelectItem> listaProv = new ArrayList<SelectItem>();
    private List<SelectItem> listaPer = new ArrayList<SelectItem>();

    public ProveedorBean() {
        proveedor = new Proveedor();
    }

    public List<SelectItem> getListaPer() {
        try {
            listaPersona = proveedorDao.listaPersona();
            listaPer.clear();
            SelectItemGroup g2 = new SelectItemGroup("Tipos de Persona");
            SelectItem[] asi = new SelectItem[listaPersona.size()];
            for(int i=0; i<listaPersona.size(); i++){
                Persona perAux = (Persona) listaPersona.get(i);
                asi[i] = new SelectItem(perAux.getIdPersona(), perAux.getNombre());
            }
            g2.setSelectItems(asi);
            listaPer.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
            listaPer = new ArrayList<SelectItem>();
        }
        return listaPer;
    }

    public void setListaPer(List<SelectItem> listaPer) {
        this.listaPer = listaPer;
    }
    
    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }
    
    public int getIdPersonaP() {
        return idPersonaP;
    }

    public void setIdPersonaP(int idPersonaP) {
        this.idPersonaP = idPersonaP;
    }

    public int getIdProveedorV() {
        return idProveedorV;
    }

    public void setIdProveedorV(int idProveedorV) {
        this.idProveedorV = idProveedorV;
    }

    public int getTipoProveedorT() {
        return tipoProveedorT;
    }

    public void setTipoProveedorT(int tipoProveedorT) {
        this.tipoProveedorT = tipoProveedorT;
    }

    public List<TipoProveedor> getListaTipoP() {
        return listaTipoP;
    }

    public void setListaTipoP(List<TipoProveedor> listaTipoP) {
        this.listaTipoP = listaTipoP;
    }

    public List<SelectItem> getListaProv() {
        return listaProv;
    }

    public void setListaProv(List<SelectItem> listaProv) {
        this.listaProv = listaProv;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.tipoProveedorT = proveedor.getTipoProveedor().getIdTipoProveedor();
        this.proveedor = proveedor;
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

    public ProveedorDao getProveedorDao() {
        return proveedorDao;
    }

    public void setMiLista(List<Proveedor> miLista) {
        this.miLista = miLista;
    }

    public void setProveedorDao(ProveedorDao proveedorDao) {
        this.proveedorDao = proveedorDao;
    }

    public void eliminar() {
        try {
            Proveedor pr = new Proveedor();
            pr.setIdProveedor(proveedor.getIdProveedor());
            pr.setNombre(proveedor.getNombre());
            pr.setCorreo(proveedor.getCorreo());
            pr.setNit(proveedor.getNit());
            pr.setGiro(proveedor.getGiro());
            pr.setNrc(proveedor.getNrc());
            TipoProveedor tProv = new TipoProveedor();
            tProv.setIdTipoProveedor(tipoProveedorT);
            Persona per = new Persona();
            per.setIdPersona(idPersonaP);
            pr.setTipoProveedor(tProv);
            pr.setPersona(per);
            proveedorDao.borrarProveedor(pr);
            proveedor = new Proveedor();
            addMessage("Proveedor Eliminado!!");
        } catch (Exception e) {
            addMessage("Error Id:!!");
            e.printStackTrace();
        }
    }
    
    public void addProveedor(ActionEvent actionEvent) {
        try {
            Proveedor pr = new Proveedor();
            pr.setIdProveedor(proveedor.getIdProveedor());
            pr.setNombre(proveedor.getNombre());
            pr.setCorreo(proveedor.getCorreo());
            pr.setNit(proveedor.getNit());
            pr.setGiro(proveedor.getGiro());
            pr.setNrc(proveedor.getNrc());
            TipoProveedor tProv = new TipoProveedor();
            tProv.setIdTipoProveedor(tipoProveedorT);
            Persona per = new Persona();
            per.setIdPersona(idPersonaP);
            pr.setTipoProveedor(tProv);
            pr.setPersona(per);
            proveedorDao.crearProveedor(pr);
            proveedor = new Proveedor();
            addMessage("Proveedor Ingresado!!");
        } catch (Exception e) {
            addMessage("Error Id:!!");
            e.printStackTrace();
        }
    }
    
    public void actualizaProveedor(ActionEvent actionEvent) {
        try {
            Proveedor pr = new Proveedor();
            pr.setIdProveedor(proveedor.getIdProveedor());
            pr.setNombre(proveedor.getNombre());
            pr.setCorreo(proveedor.getCorreo());
            pr.setNit(proveedor.getNit());
            pr.setGiro(proveedor.getGiro());
            pr.setNrc(proveedor.getNrc());
            TipoProveedor tProv = new TipoProveedor();
            tProv.setIdTipoProveedor(tipoProveedorT);
            Persona per = new Persona();
            per.setIdPersona(idPersonaP);
            pr.setTipoProveedor(tProv);
            pr.setPersona(per);
            proveedorDao.modificarProveedor(pr);
            proveedor = new Proveedor();
            addMessage("Proveedor Actualizado:!!");
        } catch (Exception e) {
            addMessage("Error Id:!!");
            e.printStackTrace();
        }
    }
    
    public List<SelectItem> getlistaProv() {
        try {
            listaTipoP = proveedorDao.listaTipoProveedor();
            listaProv.clear();
            SelectItemGroup g2 = new SelectItemGroup("Tipos de Proveedores");
            SelectItem[] asi = new SelectItem[listaTipoP.size()];
            for(int i=0; i<listaTipoP.size(); i++){
                TipoProveedor prAux = (TipoProveedor) listaTipoP.get(i);
                asi[i] = new SelectItem(prAux.getIdTipoProveedor(), prAux.getNombre());
            }
            g2.setSelectItems(asi);
            listaProv.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
            listaProv = new ArrayList<SelectItem>();
        }
        return listaProv;
    }

    private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
