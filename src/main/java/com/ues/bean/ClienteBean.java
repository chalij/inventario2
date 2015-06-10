package com.ues.bean;

import com.ues.dao.ClienteDao;
import com.ues.model.Cliente;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import com.ues.dao.impl.ClienteDaoHibImpl;
import com.ues.exception.DAOException;
import com.ues.model.Persona;
import com.ues.model.TipoCliente;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 *
 * @author Jocelyn
 */
public class ClienteBean {
    
    private int idClienteC;
    private List<Cliente> miLista;
    private List<Persona> miListaP;
     private List<TipoCliente> miListaTC;
    private ClienteDao clienteDao;
    private Cliente cliente = new Cliente();
    //Para las foráneas
    private int idPersonaP;
    private int idTipoClientTC;
    private List<Persona> listaP;
    private List<TipoCliente> listaTC;
   
    private List<SelectItem> listaCli = new ArrayList<SelectItem>();
    private List<SelectItem> listaCli2 = new ArrayList<SelectItem>();
   
    public ClienteBean() {
         cliente = new Cliente();
    }

    public List<Cliente> getMiLista() {
        try {
            miLista = clienteDao.listaClientes();
        } catch (Exception e) {
            e.printStackTrace();
            miLista = new ArrayList<Cliente>();
        }
       cliente = new Cliente();
        return miLista;
    }
    
    public void addCliente(ActionEvent actionEvent) {
        try {
            Cliente c = new Cliente();
            Persona p= new Persona ();
            TipoCliente tc = new TipoCliente();
            
            c.setIdCliente(cliente.getIdCliente());
            p.setIdPersona(idPersonaP);
            tc.setIdTipoCliente(idTipoClientTC);
            c.setPersona(p);
            c.setTipoCliente(tc);
            clienteDao.crearCliente(c);
           
            addMessage("Insertado Id:!!" + cliente.getIdCliente());
        } catch (Exception e) {
            addMessage("Error Id:!!" + cliente.getIdCliente() + " " + e.getMessage());
            e.printStackTrace();
        }

    }
         public void updateCliente(ActionEvent actionEvent) {
        try {
            Cliente c = new Cliente();
            Persona p= new Persona ();
            TipoCliente tc = new TipoCliente();
            
            c.setIdCliente(cliente.getIdCliente());
            p.setIdPersona(idPersonaP);
            tc.setIdTipoCliente(idTipoClientTC);
            c.setPersona(p);
            c.setTipoCliente(tc);
             clienteDao.modificarCliente(c);
           
            addMessage("Modificado Id:!!" + cliente.getIdCliente());
        } catch (Exception e) {
            addMessage("Error Id:!!" + cliente.getIdCliente() + " " + e.getMessage());
            e.printStackTrace();
        }
    }
     
     public void eliminar() {

        try {
            Cliente c= new Cliente();
          Persona p= new Persona ();
            TipoCliente tc = new TipoCliente();
           
            c.setIdCliente(cliente.getIdCliente());
            p.setIdPersona(idPersonaP);
            tc.setIdTipoCliente(idTipoClientTC);
            c.setPersona(p);
            c.setTipoCliente(tc);
            clienteDao.borrarCliente(c);
            cliente=new Cliente();
            
            addMessage("Eliminado Id:!!");
        } catch (Exception e) {
            addMessage("Error Id:!!");
            e.printStackTrace();
        }
    }
 
    public void setMiLista(List<Cliente> miLista) {
        this.miLista = miLista;
    }

    private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the idClienteC
     */
    public int getIdClienteC() {
        return idClienteC;
    }

    /**
     * @param idClienteC the idClienteC to set
     */
    public void setIdClienteC(int idClienteC) {
        this.idClienteC = idClienteC;
    }

    /**
     * @return the clienteDao
     */
    public ClienteDao getClienteDao() {
        return clienteDao;
    }

    /**
     * @param clienteDao the clienteDao to set
     */
    public void setClienteDao(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    /**
     * @return the idPersonaP
     */
    public int getIdPersonaP() {
        return idPersonaP;
    }

    /**
     * @param idPersonaP the idPersonaP to set
     */
    public void setIdPersonaP(int idPersonaP) {
        this.idPersonaP = idPersonaP;
    }

    /**
     * @return the idTipoClientTC
     */
    public int getIdTipoClientTC() {
        return idTipoClientTC;
    }

    /**
     * @param idTipoClientTC the idTipoClientTC to set
     */
    public void setIdTipoClientTC(int idTipoClientTC) {
        this.idTipoClientTC = idTipoClientTC;
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
     * @return the listaP
     */
    public List<Persona> getListaP() {
        return listaP;
    }

    /**
     * @param listaP the listaP to set
     */
    public void setListaP(List<Persona> listaP) {
        this.listaP = listaP;
    }

    /**
     * @return the listaTC
     */
    public List<TipoCliente> getListaTC() {
        return listaTC;
    }

    /**
     * @param listaTC the listaTC to set
     */
    public void setListaTC(List<TipoCliente> listaTC) {
        this.listaTC = listaTC;
    }

    /**
     * @return the listaCli
     */
    public List<SelectItem> getListaCli() {
        
          try {
            miListaTC= clienteDao.listaTiposCliente();
            listaCli.clear();
            SelectItemGroup g2 = new SelectItemGroup("Tipos Cliente");
            SelectItem[] asi = new SelectItem[miListaTC.size()];
            for (int i = 0; i < miListaTC.size(); i++) {
                TipoCliente usAux = (TipoCliente) miListaTC.get(i);
                asi[i] = new SelectItem(usAux.getIdTipoCliente(), usAux.getNombre());
            }
            g2.setSelectItems(asi);
            listaCli.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
           listaCli = new ArrayList<SelectItem>();
        }
      
        return listaCli;
    }
    
    /**
     * @return the listaCli2
     */
    public List<SelectItem> getListaCli2() {
        try {
            miListaP= clienteDao.listaPersonas();
            listaCli2.clear();
            SelectItemGroup g2 = new SelectItemGroup("Personas");
            SelectItem[] asi = new SelectItem[miListaP.size()];
            for (int i = 0; i < miListaP.size(); i++) {
                Persona perAux = (Persona) miListaP.get(i);
                asi[i] = new SelectItem(perAux.getIdPersona(), perAux.getNombre()+" "+perAux.getApellido());
            }
            g2.setSelectItems(asi);
            listaCli2.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
           listaCli2 = new ArrayList<SelectItem>();
        }
        return listaCli2;
    }

    /**
     * @param listaCli the listaCli to set
     */
    public void setListaCli(List<SelectItem> listaCli) {
        this.listaCli = listaCli;
    }

    /**
     * @param listaCli2 the listaCli2 to set
     */
    public void setListaCli2(List<SelectItem> listaCli2) {
        this.listaCli2 = listaCli2;
    }

}

