package com.ues.bean;

import com.ues.dao.EmpleadosDao;
import com.ues.dao.PersonasDao;
import com.ues.dao.UsuariosDao;
import com.ues.model.Empleado;
import com.ues.model.Persona;
import com.ues.model.TipoUsuario;
import com.ues.model.Usuario;
import java.util.ArrayList;
import java.util.Date;
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
    private PersonasDao personasDao; //esto se agrego
    private Empleado empleado = new Empleado();
    private Persona persona; //esto se agrego
    //Para las foraneas
    private int idPersonaP;
    private int empAux;
    private String clave;
    private String nombreUsuario;
    private List<Persona> listaPe;
    private Date fecha = new Date(); //esto se agrego
    private List<SelectItem> listaEmpleado = new ArrayList<SelectItem>();
    private UsuariosDao usuariosDao;
    private Usuario usuario = new Usuario();
    private int idUsuarioV;
    private int tipoUsuarioT;
    private List<TipoUsuario> listaTipoU;
    private List<SelectItem> listaUsu = new ArrayList<SelectItem>();

    public EmpleadoBean() {
        empleado = new Empleado();
        persona = new Persona(); //esto se agrego
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
        persona = new Persona();
        usuario = new Usuario();
        return miLista;
    }

    public void addEmpleado(ActionEvent actionEvent) {
        try {
            Empleado e = new Empleado();
            Persona p = new Persona();
            p.setNombre(persona.getNombre());
            p.setApellido(persona.getApellido());
            p.setGenero(persona.getGenero());
            p.setDui(persona.getDui());
            p.setNit(persona.getNit());
            p.setFechaNac(fecha);
            p.setDireccion(persona.getDireccion());
            p.setCorreo(persona.getCorreo());
            personasDao.crearPersona(p);

            e.setIdEmpleado(empleado.getIdEmpleado());
            //NO SE HACE UN e.setIdEmpleado(empleado.getIdEmpleado) porque es autogenerado
            p.setIdPersona(empleadoDao.maxId());
            e.setRol(empleado.getRol());
            e.setPersona(p);
            empleadoDao.crearEmpleado(e);

            Usuario us = new Usuario();
            TipoUsuario tus = new TipoUsuario();
            tus.setIdTipoUsuario(tipoUsuarioT);
            us.setNombreUsuario(this.nombreUsuario);
            us.setContrasena(this.clave);
            us.setFechaCreacion(new Date());
            us.setTipoUsuario(tus);
            p.setIdPersona(usuariosDao.maxID());
            us.setPersona(p);
            usuariosDao.crearUsuario(us);
            System.out.println("AQUI");
            usuario = new Usuario();
            addMessage("Empleado Ingresado:!!" + empleado.getRol());
        } catch (Exception e) {
            addMessage("Error Id:!!" + empleado.getIdEmpleado() + " " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void updateEmpleado(ActionEvent actionEvent) {
        try {
            Persona p = new Persona();
            p.setIdPersona(persona.getIdPersona());
            p.setNombre(persona.getNombre());
            p.setApellido(persona.getApellido());
            p.setGenero(persona.getGenero());
            p.setDui(persona.getDui());
            p.setNit(persona.getNit());
            p.setFechaNac(fecha);
            p.setDireccion(persona.getDireccion());
            p.setCorreo(persona.getCorreo());
            personasDao.modificarPersona(p);

            Empleado e = new Empleado();
            Persona per = new Persona();
            e.setIdEmpleado(empleado.getIdEmpleado());
            per.setIdPersona(empleadoDao.maxId());
            e.setRol(empleado.getRol());
            e.setPersona(per);
            empleadoDao.modificarEmpleados(e);

            Usuario us = new Usuario();
            Usuario usv = usuariosDao.buscaUsuario(persona.getIdPersona());
            us.setIdUsuario(usv.getIdUsuario());
            TipoUsuario tus = new TipoUsuario();
            tus.setIdTipoUsuario(tipoUsuarioT);
            us.setNombreUsuario(this.getNombreUsuario());
            us.setContrasena(this.clave);
            us.setFechaCreacion(usv.getFechaCreacion());
            us.setFechaModificacion(new Date());
            us.setTipoUsuario(tus);
            per.setIdPersona(usuariosDao.maxID());
            us.setPersona(per);
            usuariosDao.modificarUsuario(us);
            System.out.println("AQUI");
            usuario = new Usuario();

            addMessage("Empleado Modificado" + empleado.getRol());
        } catch (Exception e) {
            addMessage("Error Id:!!" + empleado.getIdEmpleado() + " " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void eliminar() {
        try {
            
            
            Usuario us = new Usuario();
            Usuario usv = usuariosDao.buscaUsuario(persona.getIdPersona());
            us.setIdUsuario(usv.getIdUsuario());
            TipoUsuario tus = new TipoUsuario();
            tus.setIdTipoUsuario(usv.getTipoUsuario().getIdTipoUsuario());
            us.setNombreUsuario(this.getNombreUsuario());
            us.setContrasena(this.clave);
            us.setFechaCreacion(usv.getFechaCreacion());
            us.setFechaModificacion(new Date());
            us.setTipoUsuario(tus);
            us.setPersona(persona);
            usuariosDao.borrarUsuario(us);
            usuario = new Usuario();
            
            Empleado e = new Empleado();
            Persona p = new Persona();
            //primero elimina la hija...
            System.out.println("AQUI");
            System.out.println(empleado.getIdEmpleado());
            e.setIdEmpleado(empleado.getIdEmpleado());
            p.setIdPersona(empleadoDao.maxId());
            e.setRol(empleado.getRol());
            e.setPersona(p);
            empleadoDao.borrarEmpleados(e);

            //luego se mocha la padre
            Persona per = new Persona();
            per.setIdPersona(persona.getIdPersona());
            per.setNombre(persona.getNombre());
            per.setApellido(persona.getApellido());
            per.setGenero(persona.getGenero());
            per.setDui(persona.getDui());
            per.setNit(persona.getNit());
            per.setFechaNac(fecha);
            per.setDireccion(persona.getDireccion());
            per.setCorreo(persona.getCorreo());
            personasDao.borrarPersona(per);
            addMessage("Empleado Borrado" + empleado.getRol());
        } catch (Exception e) {
            addMessage("Error Id:!!" + empleado.getIdEmpleado() + " " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public PersonasDao getPersonasDao() {
        return personasDao;
    }

    public void setPersonasDao(PersonasDao personasDao) {
        this.personasDao = personasDao;
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
        int empAux2 = empleado.getPersona().getIdPersona();
        System.out.println(empAux2);
        try {
            System.out.println("+++++++++++++Aqui1++++++++++++");
            Usuario us = usuariosDao.buscaUsuario(empAux2);
            this.clave = us.getContrasena();
            this.nombreUsuario = us.getNombreUsuario();
            System.out.println("+++++++++++++Aqui++++++++++++");
            System.out.println(clave);
            System.out.println(nombreUsuario);

        } catch (Exception e) {
            System.out.println("Esepcion:"+e.getMessage());
        }
        this.persona = empleado.getPersona();
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
            miListaPer = empleadoDao.listaPersonas();
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
     * @return the listaTipoU
     */
    public List<TipoUsuario> getListaTipoU() {
        return listaTipoU;
    }

    /**
     * @param listaTipoU the listaTipoU to set
     */
    public void setListaTipoU(List<TipoUsuario> listaTipoU) {
        this.listaTipoU = listaTipoU;
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

    /**
     * @return the empAux
     */
    public int getEmpAux() {
        return empAux;
    }

    /**
     * @param empAux the empAux to set
     */
    public void setEmpAux(int empAux) {
        this.empAux = empAux;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
