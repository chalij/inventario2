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

    private Pedido pedido=new Pedido();
    private int pedidoIdV;
    private List<Pedido> listaPedido;
    private PedidoDao pedidoDao;

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
        try
        {
            listaPedido=pedidoDao.listaPedido();
        }
        catch(Exception e)
        {
            listaPedido=new ArrayList<Pedido>();
        }
        pedido=new Pedido();
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

}
