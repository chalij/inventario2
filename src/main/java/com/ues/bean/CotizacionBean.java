package com.ues.bean;

import com.ues.dao.CotizacionDao;
import com.ues.model.Cotizacion;
import com.ues.model.Pedido;
import com.ues.model.Proveedor;
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
public class CotizacionBean {

    private int idCotizacionC;
    private List<Cotizacion> miLista;
    private List<Proveedor> miListaProve;
    private List<Pedido> miListaPedi;
    private CotizacionDao cotizacionDao;
    private Cotizacion cotizacion = new Cotizacion();
    //para las foraneas
    private int idProveedorPro;
    private int idPedidoPed;
    private List<Proveedor> listaPro;
    private List<Pedido> listaPed;

    private List<SelectItem> listaCoti = new ArrayList<SelectItem>();
    private List<SelectItem> listaCoti2 = new ArrayList<SelectItem>();

    public CotizacionBean() {
        cotizacion = new Cotizacion();
    }

    public int getIdCotizacionC() {
        return idCotizacionC;
    }

    public void setIdCotizacionC(int idCotizacionC) {
        this.idCotizacionC = idCotizacionC;
    }

    public List<Cotizacion> getMiLista() {
        try {
            miLista = cotizacionDao.listaCotizaciones();
        } catch (Exception e) {
            e.printStackTrace();
            miLista = new ArrayList<Cotizacion>();
        }
        cotizacion = new Cotizacion();
        return miLista;
    }
    
    public void addCotizacion(ActionEvent actionEvent) {
        try {
            Cotizacion c = new Cotizacion();
            Proveedor pr = new Proveedor();
            Pedido pe = new Pedido();
            
            c.setIdCotizacion(cotizacion.getIdCotizacion());
            pr.setIdProveedor(idProveedorPro);
            pe.setIdPedido(idPedidoPed);
            c.setProveedor(pr);
            c.setPedido(pe);
            c.setEstadoCot(cotizacion.getEstadoCot());
            cotizacionDao.crearCotizacion(c);
           
            addMessage("Cotizacion insertada" + cotizacion.getIdCotizacion());
        } catch (Exception e) {
            addMessage("Error Id:!!" + cotizacion.getIdCotizacion() + " " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void updateCotizacion(ActionEvent actionEvent) {
        try {
            Cotizacion c = new Cotizacion();
            Proveedor pr = new Proveedor();
            Pedido pe = new Pedido();
            
            c.setIdCotizacion(cotizacion.getIdCotizacion());
            pr.setIdProveedor(idProveedorPro);
            pe.setIdPedido(idPedidoPed);
            c.setProveedor(pr);
            c.setPedido(pe);
            c.setEstadoCot(cotizacion.getEstadoCot());
            cotizacionDao.modificarCotizaciones(c);
           
            addMessage("Cotizacion Actualizada" + cotizacion.getIdCotizacion());
        } catch (Exception e) {
            addMessage("Error Id:!!" + cotizacion.getIdCotizacion() + " " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void eliminar() {
        try {
            Cotizacion c = new Cotizacion();
            Proveedor pr = new Proveedor();
            Pedido pe = new Pedido();
            
            c.setIdCotizacion(cotizacion.getIdCotizacion());
            pr.setIdProveedor(idProveedorPro);
            pe.setIdPedido(idPedidoPed);
            c.setProveedor(pr);
            c.setPedido(pe);
            c.setEstadoCot(cotizacion.getEstadoCot());
            cotizacionDao.borrarCotizacion(c);
           
            addMessage("Cotizacion Actualizada" + cotizacion.getIdCotizacion());
        } catch (Exception e) {
            addMessage("Error Id:!!" + cotizacion.getIdCotizacion() + " " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void setMiLista(List<Cotizacion> miLista) {
        this.miLista = miLista;
    }
    
    private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Proveedor> getMiListaProve() {
        return miListaProve;
    }

    public void setMiListaProve(List<Proveedor> miListaProve) {
        this.miListaProve = miListaProve;
    }

    public List<Pedido> getMiListaPedi() {
        return miListaPedi;
    }

    public void setMiListaPedi(List<Pedido> miListaPedi) {
        this.miListaPedi = miListaPedi;
    }

    public CotizacionDao getCotizacionDao() {
        return cotizacionDao;
    }

    public void setCotizacionDao(CotizacionDao cotizacionDao) {
        this.cotizacionDao = cotizacionDao;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public int getIdProveedorPro() {
        return idProveedorPro;
    }

    public void setIdProveedorPro(int idProveedorPro) {
        this.idProveedorPro = idProveedorPro;
    }

    public int getIdPedidoPed() {
        return idPedidoPed;
    }

    public void setIdPedidoPed(int idPedidoPed) {
        this.idPedidoPed = idPedidoPed;
    }

    public List<Proveedor> getListaPro() {
        return listaPro;
    }

    public void setListaPro(List<Proveedor> listaPro) {
        this.listaPro = listaPro;
    }

    public List<Pedido> getListaPed() {
        return listaPed;
    }

    public void setListaPed(List<Pedido> listaPed) {
        this.listaPed = listaPed;
    }

    public List<SelectItem> getListaCoti() {
        try {
            miListaPedi=cotizacionDao.listaPedidos();
            listaCoti.clear();
            SelectItemGroup g2 = new SelectItemGroup("Pedidos");
            SelectItem[] asi = new SelectItem[miListaPedi.size()];
            for (int i = 0; i < miListaPedi.size(); i++) {
                Pedido peAux = (Pedido) miListaPedi.get(i);
                asi[i] = new SelectItem(peAux.getIdPedido());
            }
            g2.setSelectItems(asi);
            listaCoti.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
           listaCoti = new ArrayList<SelectItem>();
        }
        return listaCoti;
    }

    public void setListaCoti(List<SelectItem> listaCoti) {
        this.listaCoti = listaCoti;
    }

    public List<SelectItem> getListaCoti2() {
        try {
            miListaProve = cotizacionDao.listaProveedores();
            listaCoti2.clear();
            SelectItemGroup g2 = new SelectItemGroup("Proveedores");
            SelectItem[] asi = new SelectItem[miListaProve.size()];
            for (int i = 0; i < miListaProve.size(); i++) {
                Proveedor peAux = (Proveedor) miListaProve.get(i);
                asi[i] = new SelectItem(peAux.getIdProveedor(), peAux.getNombre());
            }
            g2.setSelectItems(asi);
            listaCoti2.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
           listaCoti2 = new ArrayList<SelectItem>();
        }
        return listaCoti2;
    }

    public void setListaCoti2(List<SelectItem> listaCoti2) {
        this.listaCoti2 = listaCoti2;
    }

}
