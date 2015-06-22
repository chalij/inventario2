package com.ues.bean;

import com.ues.dao.MenusDao;
import com.ues.dao.PedidoDao;
import com.ues.dao.RecursosDao;
import com.ues.dao.RequisicionDao;
import com.ues.dao.UsuariosDao;
import com.ues.dao.impl.UsuariosDaoHibImpl;
import com.ues.exception.DAOException;
import com.ues.model.Cliente;
import com.ues.model.DetalleRequisicion;
import com.ues.model.Empleado;
import com.ues.model.Menu;
import com.ues.model.Pedido;
import com.ues.model.Producto;
import com.ues.model.Recursos;
import com.ues.model.Requisicion;
import com.ues.model.TipoMenu;
import com.ues.model.TipoUsuario;
import com.ues.model.Usuario;
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
public class PedidoBean {

    private Pedido pedido = new Pedido();
    private int pedidoIdV;
    private List<Pedido> listaPedido;
    private PedidoDao pedidoDao;
    private int prodIdV;
    private int valorEx;
    private List<SelectItem> listaUsu = new ArrayList<SelectItem>();
    private List<Producto> listaProd = new ArrayList<Producto>();
    private List<Producto> listProdV;

    public void addPedido() {
        try {
            
            Pedido pd=new Pedido();
            pd.setFechaPedido(new Date());
            
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            Empleado emp= pedidoDao.buscarEmpleado((Integer)session.getAttribute("persona"));
            pd.setEmpleado(emp);
            pedidoDao.crearPedido(pd, null);
            pedido=new Pedido();
            addMessage("Insertado !!");
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }

    }
    
    
    
    public void eliminar() {

        try {
            pedidoDao.borrarPedido(pedido);
            pedido=new Pedido();
            addMessage("Eliminado!!");
        } catch (Exception e) {
            addMessage("Error!!");
            e.printStackTrace();
        }
    }
    
    

    private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the pedido
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * @return the pedidoIdV
     */
    public int getPedidoIdV() {
        return pedidoIdV;
    }

    /**
     * @param pedidoIdV the pedidoIdV to set
     */
    public void setPedidoIdV(int pedidoIdV) {
        this.pedidoIdV = pedidoIdV;
    }

    /**
     * @return the listaPedido
     */
    public List<Pedido> getListaPedido() {
        try {
            listaPedido = pedidoDao.listaPedido();
        } catch (Exception e) {
            listaPedido = new ArrayList<Pedido>();
        }
        pedido = new Pedido();
        return listaPedido;
    }

    /**
     * @param listaPedido the listaPedido to set
     */
    public void setListaPedido(List<Pedido> listaPedido) {
        this.listaPedido = listaPedido;
    }

    /**
     * @return the pedidoDao
     */
    public PedidoDao getPedidoDao() {
        return pedidoDao;
    }

    /**
     * @param pedidoDao the pedidoDao to set
     */
    public void setPedidoDao(PedidoDao pedidoDao) {
        this.pedidoDao = pedidoDao;
    }

    /**
     * @return the prodIdV
     */
    public int getProdIdV() {
        return prodIdV;
    }

    /**
     * @param prodIdV the prodIdV to set
     */
    public void setProdIdV(int prodIdV) {
        this.prodIdV = prodIdV;
    }

    /**
     * @return the valorEx
     */
    public int getValorEx() {
        return valorEx;
    }

    /**
     * @param valorEx the valorEx to set
     */
    public void setValorEx(int valorEx) {
        this.valorEx = valorEx;
    }

    
    public List<SelectItem> getListaUsu() {

        try {
            this.setListProdV(pedidoDao.listaProducto());
            listaUsu.clear();
            SelectItemGroup g2 = new SelectItemGroup("Producto");
            SelectItem[] asi = new SelectItem[getListProdV().size()];
            for (int i = 0; i < getListProdV().size(); i++) {
                Producto usAux = (Producto) getListProdV().get(i);
                asi[i] = new SelectItem(usAux.getIdProducto(), usAux.getNombre4());
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

    public void agreegarProducto() {
        //listaProd=new ArrayList<Producto>();
        Producto pd = new Producto();
        pd.setNombre4(this.prodIdV + "");
        pd.setIdProducto(prodIdV);
        pd.setExistencias(this.valorEx);
        getListaProd().add(pd);
    }

    /**
     * @return the listaProd
     */
    public List<Producto> getListaProd() {
        return listaProd;
    }

    /**
     * @param listaProd the listaProd to set
     */
    public void setListaProd(List<Producto> listaProd) {
        this.listaProd = listaProd;
    }

    /**
     * @return the listProdV
     */
    public List<Producto> getListProdV() {
        return listProdV;
    }

    /**
     * @param listProdV the listProdV to set
     */
    public void setListProdV(List<Producto> listProdV) {
        this.listProdV = listProdV;
    }
    
}
