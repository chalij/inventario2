
package com.ues.bean;

import com.ues.dao.TransaccionDao;
import com.ues.model.Transaccion;
import java.text.ParseException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import com.ues.dao.impl.TransaccionDaoHibImpl;
import com.ues.exception.DAOException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import com.ues.model.Inventario;
import com.ues.model.TipoTransaccion;
import com.ues.model.Devolucion;
import com.ues.model.Requisicion;
import com.ues.model.OrdenDeCompra;
import com.ues.model.Persona;

public class TransaccionBean {
    
     private int idTransaccionT;
    private List<Transaccion> miLista;

    private TransaccionDao transaccionDao;
    private Transaccion transaccion = new Transaccion();
    
    //para foráneas
    
     private int idInventarioI;
     private int idTipoTransaccionT;
     private int idDevolucionD;
     private int idRequisicionR;
     private int idOrdenO;
    
     private List<Inventario> miListaI;
    private List<SelectItem> listaitemI = new ArrayList<SelectItem>();
    
    private List<TipoTransaccion> miListaTT;
    private List<SelectItem> listaitemTT = new ArrayList<SelectItem>();
    
     private List<Devolucion> miListaD;
    private List<SelectItem> listaitemD = new ArrayList<SelectItem>();
    
     private List<Requisicion> miListaR;
    private List<SelectItem> listaitemR = new ArrayList<SelectItem>();
    
     private List<OrdenDeCompra> miListaO;
    private List<SelectItem> listaitemO = new ArrayList<SelectItem>();
    
   
    
    //constructor
     public TransaccionBean() {
       transaccion = new Transaccion () ;
    }
  
    /**
     * @return the idTransaccionT
     */
    public int getIdTransaccionT() {
        return idTransaccionT;
    }

    /**
     * @param idTransaccionT the idTransaccionT to set
     */
    public void setIdTransaccionT(int idTransaccionT) {
        this.idTransaccionT = idTransaccionT;
    }

    /**
     * @return the miLista
     */
    public List<Transaccion> getMiLista() {
        
          try {
            miLista = transaccionDao.listaTransacciones();
        } catch (Exception e) {
            e.printStackTrace();
            miLista = new ArrayList<Transaccion>();
        }
       transaccion = new Transaccion();
        
        return miLista;
    }
    
    
    public void addTransaccion(ActionEvent actionEvent) {
        try {
            
            Transaccion t = new Transaccion();
            Inventario i= new Inventario ();
            TipoTransaccion tt = new TipoTransaccion ();
            Devolucion d =  new Devolucion();
            Requisicion r = new Requisicion();
            OrdenDeCompra o = new OrdenDeCompra();
            
            t.setIdTransaccion(transaccion.getIdTransaccion());
            i.setIdInventario(idInventarioI);
            tt.setIdTipoTransaccion(idTipoTransaccionT);
            d.setIdDevolucion(idDevolucionD);
            r.setIdRequisicion(idRequisicionR);
            o.setIdOrden(idOrdenO);
            
            t.setInventario(i);
            t.setTipoTransaccion(tt);
            t.setDevolucion(d);
            t.setRequisicion(r);
            t.setOrdenDeCompra(o);
            
            transaccionDao.crearTransaccion(t);
           
            addMessage("Insertado Id:!!" + transaccion.getIdTransaccion());
        } catch (Exception e) {
            addMessage("Error Id:!!" + transaccion.getIdTransaccion() + " " + e.getMessage());
            e.printStackTrace();
        }
    
     }
    
    
    
     public void updateTransaccion(ActionEvent actionEvent) {
        try {
            
            Transaccion t = new Transaccion();
            Inventario i= new Inventario ();
            TipoTransaccion tt = new TipoTransaccion ();
            Devolucion d =  new Devolucion();
            Requisicion r = new Requisicion();
            OrdenDeCompra o = new OrdenDeCompra();
            
            t.setIdTransaccion(transaccion.getIdTransaccion());
            i.setIdInventario(idInventarioI);
            tt.setIdTipoTransaccion(idTipoTransaccionT);
            d.setIdDevolucion(idDevolucionD);
            r.setIdRequisicion(idRequisicionR);
            o.setIdOrden(idOrdenO);
            
            t.setInventario(i);
            t.setTipoTransaccion(tt);
            t.setDevolucion(d);
            t.setRequisicion(r);
            t.setOrdenDeCompra(o);
            
            transaccionDao.modificarTransaccion(t);
           
            addMessage("Modificado Id:!!" + transaccion.getIdTransaccion());
        } catch (Exception e) {
            addMessage("Error Id:!!" + transaccion.getIdTransaccion() + " " + e.getMessage());
            e.printStackTrace();
        }
    
     }
    
    
    
    public void eliminar(ActionEvent actionEvent) {
        try {
            
            Transaccion t = new Transaccion();
            Inventario i= new Inventario ();
            TipoTransaccion tt = new TipoTransaccion ();
            Devolucion d =  new Devolucion();
            Requisicion r = new Requisicion();
            OrdenDeCompra o = new OrdenDeCompra();
            
            t.setIdTransaccion(transaccion.getIdTransaccion());
            i.setIdInventario(idInventarioI);
            tt.setIdTipoTransaccion(idTipoTransaccionT);
            d.setIdDevolucion(idDevolucionD);
            r.setIdRequisicion(idRequisicionR);
            o.setIdOrden(idOrdenO);
            
            t.setInventario(i);
            t.setTipoTransaccion(tt);
            t.setDevolucion(d);
            t.setRequisicion(r);
            t.setOrdenDeCompra(o);
            
            transaccionDao.borrarTransaccion(t);
            transaccion=new Transaccion();
           
            addMessage("Eliminado Id:!!" + transaccion.getIdTransaccion());
        } catch (Exception e) {
            addMessage("Error Id:!!" + transaccion.getIdTransaccion() + " " + e.getMessage());
            e.printStackTrace();
        }
    
     }
    
    
    

    /**
     * @param miLista the miLista to set
     */
    public void setMiLista(List<Transaccion> miLista) {
        this.miLista = miLista;
    }

    /**
     * @return the transaccionDao
     */
    public TransaccionDao getTransaccionDao() {
        return transaccionDao;
    }

    /**
     * @param transaccionDao the transaccionDao to set
     */
    public void setTransaccionDao(TransaccionDao transaccionDao) {
        this.transaccionDao = transaccionDao;
    }

    /**
     * @return the transaccion
     */
    public Transaccion getTransaccion() {
        return transaccion;
    }

    /**
     * @param transaccion the transaccion to set
     */
    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    /**
     * @return the idInventarioI
     */
    public int getIdInventarioI() {
        return idInventarioI;
    }

    /**
     * @param idInventarioI the idInventarioI to set
     */
    public void setIdInventarioI(int idInventarioI) {
        this.idInventarioI = idInventarioI;
    }

    /**
     * @return the idTipoTransaccionT
     */
    public int getIdTipoTransaccionT() {
        return idTipoTransaccionT;
    }

    /**
     * @param idTipoTransaccionT the idTipoTransaccionT to set
     */
    public void setIdTipoTransaccionT(int idTipoTransaccionT) {
        this.idTipoTransaccionT = idTipoTransaccionT;
    }

    /**
     * @return the idDevolucionD
     */
    public int getIdDevolucionD() {
        return idDevolucionD;
    }

    /**
     * @param idDevolucionD the idDevolucionD to set
     */
    public void setIdDevolucionD(int idDevolucionD) {
        this.idDevolucionD = idDevolucionD;
    }

    /**
     * @return the idRequisicionR
     */
    public int getIdRequisicionR() {
        return idRequisicionR;
    }

    /**
     * @param idRequisicionR the idRequisicionR to set
     */
    public void setIdRequisicionR(int idRequisicionR) {
        this.idRequisicionR = idRequisicionR;
    }

    /**
     * @return the idOrdenO
     */
    public int getIdOrdenO() {
        return idOrdenO;
    }

    /**
     * @param idOrdenO the idOrdenO to set
     */
    public void setIdOrdenO(int idOrdenO) {
        this.idOrdenO = idOrdenO;
    }

    
       private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the miListaI
     */
    public List<Inventario> getMiListaI() {
        return miListaI;
    }

    /**
     * @param miListaI the miListaI to set
     */
    public void setMiListaI(List<Inventario> miListaI) {
        this.miListaI = miListaI;
    }

    /**
     * @return the listaitemI
     */
    public List<SelectItem> getListaitemI() {
        try {
            miListaI=transaccionDao.listaInventarios();
            listaitemI.clear();
            
            SelectItemGroup g2 = new SelectItemGroup("Inventario");
            SelectItem[] asi = new SelectItem[miListaI.size()];
            for (int i = 0; i < miListaI.size(); i++) {
                Inventario iAux = (Inventario) miListaI.get(i);
                asi[i] = new SelectItem(iAux.getIdInventario(), iAux.getNombre3());
            }
            g2.setSelectItems(asi);
            listaitemI.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
           listaitemI = new ArrayList<SelectItem>();
        }
      
        
        
        
        
        return listaitemI;
    }

    /**
     * @param listaitemI the listaitemI to set
     */
    public void setListaitemI(List<SelectItem> listaitemI) {
        this.listaitemI = listaitemI;
    }

    /**
     * @return the miListaTT
     */
    public List<TipoTransaccion> getMiListaTT() {
        
         
        return miListaTT;
    }

    /**
     * @param miListaTT the miListaTT to set
     */
    public void setMiListaTT(List<TipoTransaccion> miListaTT) {
        this.miListaTT = miListaTT;
    }

    /**
     * @return the listaitemTT
     */
    public List<SelectItem> getListaitemTT() {
        try {
            miListaTT=transaccionDao.listaTipoTransacciones();
            listaitemTT.clear();
            
            SelectItemGroup g2 = new SelectItemGroup("Tipo de Transacciones");
            SelectItem[] asi = new SelectItem[miListaTT.size()];
            for (int i = 0; i < miListaTT.size(); i++) {
                TipoTransaccion ttAux = (TipoTransaccion) miListaTT.get(i);
                asi[i] = new SelectItem(ttAux.getIdTipoTransaccion(), ttAux.getNombre());
            }
            g2.setSelectItems(asi);
            listaitemTT.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
           listaitemTT = new ArrayList<SelectItem>();
        }
        
        
        return listaitemTT;
    }

    /**
     * @param listaitemTT the listaitemTT to set
     */
    public void setListaitemTT(List<SelectItem> listaitemTT) {
        this.listaitemTT = listaitemTT;
    }

    /**
     * @return the miListaD
     */
    public List<Devolucion> getMiListaD() {
        return miListaD;
    }

    /**
     * @param miListaD the miListaD to set
     */
    public void setMiListaD(List<Devolucion> miListaD) {
        this.miListaD = miListaD;
    }

    /**
     * @return the listaitemD
     */
    public List<SelectItem> getListaitemD() {
        
        try {
            miListaD=transaccionDao.listaDevoluciones();
            listaitemD.clear();
            
            SelectItemGroup g2 = new SelectItemGroup("Devoluciones");
            SelectItem[] asi = new SelectItem[miListaD.size()];
            for (int i = 0; i < miListaD.size(); i++) {
                Devolucion dAux = (Devolucion) miListaD.get(i);
                asi[i] = new SelectItem(dAux.getIdDevolucion());
            }
            g2.setSelectItems(asi);
            listaitemTT.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
           listaitemTT = new ArrayList<SelectItem>();
        }
        
        return listaitemD;
    }

    /**
     * @param listaitemD the listaitemD to set
     */
    public void setListaitemD(List<SelectItem> listaitemD) {
        this.listaitemD = listaitemD;
    }

    /**
     * @return the miListaR
     */
    public List<Requisicion> getMiListaR() {
        return miListaR;
    }

    /**
     * @param miListaR the miListaR to set
     */
    public void setMiListaR(List<Requisicion> miListaR) {
        this.miListaR = miListaR;
    }

    /**
     * @return the listaitemR
     */
    public List<SelectItem> getListaitemR() {
        
         try {
            miListaR=transaccionDao.listaRequisicion();
            listaitemR.clear();
            
            SelectItemGroup g2 = new SelectItemGroup("Requisición");
            SelectItem[] asi = new SelectItem[miListaR.size()];
            for (int i = 0; i < miListaR.size(); i++) {
                Requisicion rAux = (Requisicion) miListaR.get(i);
                asi[i] = new SelectItem(rAux.getIdRequisicion());
            }
            g2.setSelectItems(asi);
            listaitemR.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
           listaitemR = new ArrayList<SelectItem>();
        }
        
        
        return listaitemR;
    }

    /**
     * @param listaitemR the listaitemR to set
     */
    public void setListaitemR(List<SelectItem> listaitemR) {
        this.listaitemR = listaitemR;
    }

    /**
     * @return the miListaO
     */
    public List<OrdenDeCompra> getMiListaO() {
        return miListaO;
    }

    /**
     * @param miListaO the miListaO to set
     */
    public void setMiListaO(List<OrdenDeCompra> miListaO) {
        this.miListaO = miListaO;
    }

    /**
     * @return the listaitemO
     */
    public List<SelectItem> getListaitemO() {
        return listaitemO;
    }

    /**
     * @param listaitemO the listaitemO to set
     */
    public void setListaitemO(List<SelectItem> listaitemO) {
        
         try {
            miListaO=transaccionDao.listaOrdenesDeCompra();
            listaitemO.clear();
            
            SelectItemGroup g2 = new SelectItemGroup("Orden de Compra");
            SelectItem[] asi = new SelectItem[miListaO.size()];
            for (int i = 0; i < miListaO.size(); i++) {
                OrdenDeCompra oAux = (OrdenDeCompra) miListaO.get(i);
                asi[i] = new SelectItem(oAux.getIdOrden());
            }
            g2.setSelectItems(asi);
            listaitemR.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
           listaitemR = new ArrayList<SelectItem>();
        }
        
        
        
        this.listaitemO = listaitemO;
    }

    
    
    
}// fin clase
