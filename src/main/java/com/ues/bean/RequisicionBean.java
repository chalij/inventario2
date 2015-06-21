package com.ues.bean;

import com.ues.dao.MenusDao;
import com.ues.dao.RecursosDao;
import com.ues.dao.RequisicionDao;
import com.ues.dao.UsuariosDao;
import com.ues.dao.impl.UsuariosDaoHibImpl;
import com.ues.exception.DAOException;
import com.ues.model.Cliente;
import com.ues.model.Empleado;
import com.ues.model.Menu;
import com.ues.model.Recursos;
import com.ues.model.Requisicion;
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
public class RequisicionBean {

  //  private Recursos recursos = new Recursos();
    private Requisicion requisicion=new Requisicion();
   // private Menu menu = new Menu();
    private Cliente cliente=new Cliente();
    private Empleado empleado=new Empleado();
    private List<Requisicion> miLista;
    private int reqIdV;
    
    
    private int clienteIdV;
    private int empleadoIdV;
   // private int tipoUsuarioT;
    //private int tipoMenuT;
    // private int idUsuarioV;
    private int idRecursoV;
    private List<Cliente> listClienteV;
    private List<Empleado> listEpleadoV;
    //private UsuariosDao usuariosDao;
   // private RecursosDao recursosDao;
    private RequisicionDao requisicionDao;
    private MenusDao menusDao;
    private List<SelectItem> listaUsu = new ArrayList<SelectItem>();
    private List<SelectItem> listaUsu2 = new ArrayList<SelectItem>();

    public RequisicionBean() {
        //recursos = new Recursos();
        requisicion=new Requisicion();
        cliente=new Cliente();
        empleado=new Empleado();
       // menu = new Menu();
    }

    public List<Requisicion> getMiLista() {
        try {
            miLista = requisicionDao.listaRequisicion();

        } catch (Exception e) {
            e.printStackTrace();
            miLista = new ArrayList<Requisicion>();
        }
        requisicion=new Requisicion();
        cliente=new Cliente();
        empleado=new Empleado();;
        return miLista;
    }

    public void setMiLista(List<Requisicion> miLista) {
        this.miLista = miLista;
    }

    public void addRecursos() {
        try {
            Requisicion re = new Requisicion();
            Cliente cl=new Cliente();
            cl.setIdCliente(this.clienteIdV);
            Empleado em=new Empleado();
            em.setIdEmpleado(empleadoIdV);
            // re.setIdRecursos(recursos.getIdRecursos());
            re.setCliente(cl);
            re.setEmpleado(em);
            re.setFechaReq(new Date());
            requisicionDao.crearRequisicion(re);
            requisicion = new Requisicion();
            addMessage("Insertado!!");
        } catch (Exception e) {
            addMessage("Error!!" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void updateRecursos() {
       
        try {
            Requisicion re = new Requisicion();
            Cliente cl=new Cliente();
            cl.setIdCliente(this.clienteIdV);
            Empleado em=new Empleado();
            em.setIdEmpleado(empleadoIdV);
            // re.setIdRecursos(recursos.getIdRecursos());
            re.setIdRequisicion(requisicion.getIdRequisicion());
            re.setCliente(cl);
            re.setEmpleado(em);
            re.setFechaReq(new Date());
            requisicionDao.modificarRequisicion(re);
            requisicion = new Requisicion();
            addMessage("Modificado!!");
        } catch (Exception e) {
            addMessage("Error!!" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void eliminar() {

        try {
            Requisicion re = new Requisicion();
            Cliente cl=new Cliente();
            cl.setIdCliente(this.clienteIdV);
            Empleado em=new Empleado();
            em.setIdEmpleado(empleadoIdV);
            // re.setIdRecursos(recursos.getIdRecursos());
            re.setIdRequisicion(requisicion.getIdRequisicion());
            re.setCliente(cl);
            re.setEmpleado(em);
            re.setFechaReq(new Date());
            requisicionDao.borrarRequisicion(re);
            requisicion = new Requisicion();
            addMessage("Eliminado!!");
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
     * @return the listaUsu
     */
    public List<SelectItem> getListaUsu() {

       try {
            this.listEpleadoV = requisicionDao.listaEmpleado();
            listaUsu.clear();
            SelectItemGroup g2 = new SelectItemGroup("Empleado");
            SelectItem[] asi = new SelectItem[listEpleadoV.size()];
            for (int i = 0; i < listEpleadoV.size(); i++) {
                Empleado usAux = (Empleado) listEpleadoV.get(i);
                asi[i] = new SelectItem(usAux.getIdEmpleado(), usAux.getPersona().getNombre()+" "+ usAux.getPersona().getApellido());
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
            this.listClienteV = requisicionDao.listaCliente();
            listaUsu2.clear();
            SelectItemGroup g2 = new SelectItemGroup("Cliente");
            SelectItem[] asi = new SelectItem[listClienteV.size()];
            for (int i = 0; i < listClienteV.size(); i++) {
                Cliente usAux = (Cliente) listClienteV.get(i);
                asi[i] = new SelectItem(usAux.getIdCliente(), usAux.getPersona().getNombre()+" "+usAux.getPersona().getApellido());
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
     * @return the requisicion
     */
    public Requisicion getRequisicion() {
        return requisicion;
    }

    /**
     * @param requisicion the requisicion to set
     */
    public void setRequisicion(Requisicion requisicion) {
        this.requisicion = requisicion;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the empleado
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /**
     * @return the requisionDao
     */
    public RequisicionDao getRequisicionDao() {
        return requisicionDao;
    }

    /**
     * @param requisionDao the requisionDao to set
     */
    public void setRequisicionDao(RequisicionDao requisicionDao) {
        this.requisicionDao = requisicionDao;
    }

    /**
     * @return the reqIdV
     */
    public int getReqIdV() {
        return reqIdV;
    }

    /**
     * @param reqIdV the reqIdV to set
     */
    public void setReqIdV(int reqIdV) {
        this.reqIdV = reqIdV;
    }

    /**
     * @return the listClienteV
     */
    public List<Cliente> getListClienteV() {
        return listClienteV;
    }

    /**
     * @param listClienteV the listClienteV to set
     */
    public void setListClienteV(List<Cliente> listClienteV) {
        this.listClienteV = listClienteV;
    }

    /**
     * @return the listEpleadoV
     */
    public List<Empleado> getListEpleadoV() {
        return listEpleadoV;
    }

    /**
     * @param listEpleadoV the listEpleadoV to set
     */
    public void setListEpleadoV(List<Empleado> listEpleadoV) {
        this.listEpleadoV = listEpleadoV;
    }

    /**
     * @return the clienteIdV
     */
    public int getClienteIdV() {
        return clienteIdV;
    }

    /**
     * @param clienteIdV the clienteIdV to set
     */
    public void setClienteIdV(int clienteIdV) {
        this.clienteIdV = clienteIdV;
    }

    /**
     * @return the empleadoIdV
     */
    public int getEmpleadoIdV() {
        return empleadoIdV;
    }

    /**
     * @param empleadoIdV the empleadoIdV to set
     */
    public void setEmpleadoIdV(int empleadoIdV) {
        this.empleadoIdV = empleadoIdV;
    }

}
