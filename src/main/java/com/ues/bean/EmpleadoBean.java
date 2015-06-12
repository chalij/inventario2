package com.ues.bean;

import com.ues.dao.EmpleadosDao;
import com.ues.model.Empleado;
import com.ues.model.Persona;
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
public class EmpleadoBean {
    
    private int idEmpleadoE;
    private List<Empleado> miLista;
    private List<Persona> miListaPer;
    private EmpleadosDao empleadoDao;
    private Empleado empleado = new Empleado();
    //Para las foraneas
    private int idPersonaP;
    private List<Persona> listaPe;
    
    private List<SelectItem> listaEmpleado = new ArrayList<SelectItem>();

    public EmpleadoBean() {
        empleado = new Empleado();
    }

    public int getIdEmpleadoE() {
        return idEmpleadoE;
    }

    public void setIdEmpleadoE(int idEmpleadoE) {
        this.idEmpleadoE = idEmpleadoE;
    }

    public List<Empleado> getMiLista() {
        try {
            miLista = empleadoDao.listaEmpleados();
        } catch (Exception e) {
            e.printStackTrace();
            miLista = new ArrayList<Empleado>();
        }
        empleado = new Empleado();
        return miLista;
    }
    
    public void addEmpleado(ActionEvent actionEvent) {
        try {
            Empleado e = new Empleado();
            Persona p = new Persona();

            e.setIdEmpleado(empleado.getIdEmpleado());
            p.setIdPersona(idPersonaP);
            e.setRol(empleado.getRol());
            e.setPersona(p);
            empleadoDao.crearEmpleado(e);
            addMessage("Empleado Ingresado:!!" + empleado.getRol());
        } catch (Exception e) {
            addMessage("Error Id:!!" + empleado.getIdEmpleado() + " " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void updateEmpleado(ActionEvent actionEvent) {
        try {
            Empleado e = new Empleado();
            Persona p = new Persona();

            e.setIdEmpleado(empleado.getIdEmpleado());
            p.setIdPersona(idPersonaP);
            e.setRol(empleado.getRol());
            e.setPersona(p);
            empleadoDao.modificarEmpleados(e);
            addMessage("Empleado Modificado:!!" + empleado.getRol());
        } catch (Exception e) {
            addMessage("Error Id:!!" + empleado.getIdEmpleado() + " " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void eliminar() {
        try {
            Empleado e = new Empleado();
            Persona p = new Persona();

            e.setIdEmpleado(empleado.getIdEmpleado());
            p.setIdPersona(idPersonaP);
            e.setRol(empleado.getRol());
            e.setPersona(p);
            empleadoDao.borrarEmpleados(e);
            addMessage("Empleado Eliminado!" + empleado.getRol());
        } catch (Exception e) {
            addMessage("Error Id:!!" + empleado.getIdEmpleado() + " " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void setMiLista(List<Empleado> miLista) {
        this.miLista = miLista;
    }

    public List<Persona> getMiListaPer() {
        return miListaPer;
    }

    public void setMiListaPer(List<Persona> miListaPer) {
        this.miListaPer = miListaPer;
    }

    public EmpleadosDao getEmpleadoDao() {
        return empleadoDao;
    }

    public void setEmpleadoDao(EmpleadosDao empleadoDao) {
        this.empleadoDao = empleadoDao;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getIdPersonaP() {
        return idPersonaP;
    }

    public void setIdPersonaP(int idPersonaP) {
        this.idPersonaP = idPersonaP;
    }

    public List<Persona> getListaPe() {
        return listaPe;
    }

    public void setListaPe(List<Persona> listaPe) {
        this.listaPe = listaPe;
    }

    public List<SelectItem> getListaEmpleado() {
        try {
            miListaPer= empleadoDao.listaPersonas();
            listaEmpleado.clear();
            SelectItemGroup g2 = new SelectItemGroup("Personas");
            SelectItem[] asi = new SelectItem[miListaPer.size()];
            for (int i = 0; i < miListaPer.size(); i++) {
                Persona pAux = (Persona) miListaPer.get(i);
                asi[i] = new SelectItem(pAux.getIdPersona(), pAux.getNombre());
            }
            g2.setSelectItems(asi);
            listaEmpleado.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
           listaEmpleado = new ArrayList<SelectItem>();
        }
        return listaEmpleado;
    }

    public void setListaEmpleado(List<SelectItem> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }
}