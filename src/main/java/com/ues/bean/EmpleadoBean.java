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

    private Empleado empleado = new Empleado();
    private int idEmpleadoE;
    private int idPersonaP;
    private List<Empleado> miLista;
    private List<Persona> listaPersona;
    private EmpleadosDao empleadosDao;
    private List<SelectItem> listaEmp = new ArrayList<SelectItem>();

    public EmpleadoBean() {
        empleado = new Empleado();
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.idPersonaP = empleado.getPersona().getIdPersona();
        this.empleado = empleado;
    }

    public int getIdEmpleadoE() {
        return idEmpleadoE;
    }

    public void setIdEmpleadoE(int idEmpleadoE) {
        this.idEmpleadoE = idEmpleadoE;
    }

    public int getIdPersonaP() {
        return idPersonaP;
    }

    public void setIdPersonaP(int idPersonaP) {
        this.idPersonaP = idPersonaP;
    }
//voy a comenzar a revisar los list

    public List<Empleado> getMiLista() {
        try {
            miLista = empleadosDao.listaEmpleados();
        } catch (Exception e) {
            e.printStackTrace();
            miLista = new ArrayList<Empleado>();
        }
        empleado = new Empleado();
        return miLista;
    }

    public void setMiLista(List<Empleado> miLista) {
        this.miLista = miLista;
    }

    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public EmpleadosDao getEmpleadosDao() {
        return empleadosDao;
    }

    public void setEmpleadosDao(EmpleadosDao empleadosDao) {
        this.empleadosDao = empleadosDao;
    }

    public List<SelectItem> getListaEmp() {
        try {
            listaPersona = empleadosDao.listaPersonas();
            listaEmp.clear();
            SelectItemGroup g2 = new SelectItemGroup("Empleados");
            SelectItem[] asi = new SelectItem[listaPersona.size()];
            for (int i = 0; i < listaPersona.size(); i++) {
                Persona perAux = (Persona) listaPersona.get(i);
                asi[i] = new SelectItem(perAux.getIdPersona(), perAux.getNombre());
            }
            g2.setSelectItems(asi);
            listaEmp.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
            listaEmp = new ArrayList<SelectItem>();
        }
        return listaEmp;
    }

    public void setListaEmp(List<SelectItem> listaEmp) {
        this.listaEmp = listaEmp;
    }

    private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addEmpleado(ActionEvent actionEvent) {
        try {
            Empleado em = new Empleado();
            Persona per = new Persona();
            per.setIdPersona(idPersonaP);
            em.setIdEmpleado(empleado.getIdEmpleado());
            em.setRol(empleado.getRol());
            empleadosDao.crearEmpleado(em);
            empleado = new Empleado();
            addMessage("Empleado Insertado: " + em.getRol());
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void eliminar() {
        try {
            Empleado em = new Empleado();
            Persona per = new Persona();
            per.setIdPersona(idPersonaP);
            em.setIdEmpleado(empleado.getIdEmpleado());
            em.setRol(empleado.getRol());
            empleadosDao.borrarEmpleados(em);
            empleado = new Empleado();
            addMessage("Empleado Eliminado ");
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateUsuario(ActionEvent actionEvent) {
        try {
            Empleado em = new Empleado();
            Persona per = new Persona();
            per.setIdPersona(idPersonaP);
            em.setIdEmpleado(empleado.getIdEmpleado());
            em.setRol(empleado.getRol());
            empleadosDao.modificarEmpleados(em);
            empleado = new Empleado();
            addMessage("Empleado Eliminado ");
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }
    }
}
