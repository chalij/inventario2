package com.ues.bean;

import com.ues.dao.DevolucionDao;
import com.ues.model.Cliente;
import com.ues.model.Devolucion;
import com.ues.model.OrdenDeCompra;
import com.ues.model.Producto;
import com.ues.model.Requisicion;
import com.ues.model.TipoDevolucion;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 *
 * @author Airy
 */
public class DevolucionBean {

    private Devolucion devolucion;
    private List<Devolucion> listaDevolucion;
    private DevolucionDao devolucionDao;
    private Producto producto;
    private int devIdV;
    private int ordenIdV;
    private int requiIdV;
    private int prodIdV;
    private int valorEx;
    private int tipoDevId;
    private List<SelectItem> listaUsu = new ArrayList<SelectItem>();
    private List<SelectItem> listaUsu2 = new ArrayList<SelectItem>();
    private List<SelectItem> listaUsu3 = new ArrayList<SelectItem>();
    private List<SelectItem> listaUsu4 = new ArrayList<SelectItem>();
    private List<SelectItem> listaUsu5 = new ArrayList<SelectItem>();
    private List<OrdenDeCompra> listaOrd = new ArrayList<OrdenDeCompra>();
    private List<Requisicion> listaReq = new ArrayList<Requisicion>();
    private List<TipoDevolucion> listaDev = new ArrayList<TipoDevolucion>();
    private List<Cliente> listClienteV = new ArrayList<Cliente>();
    private List<Producto> listProductoV = new ArrayList<Producto>();

    private List<Producto> listaProd = new ArrayList<Producto>();

    /**
     * @return the devolucion
     */
    public Devolucion getDevolucion() {
        return devolucion;
    }

    public void addDevolucion() {
        try {

            Devolucion dv = new Devolucion();
            Requisicion rq = new Requisicion();
            rq.setIdRequisicion(requiIdV);
            dv.setCantidad(0);
            TipoDevolucion td = new TipoDevolucion();
            if (tipoDevId == 1) {
                dv.setRequisicion(rq);
            } else {
                dv.setOrdenDeCompra(null);
            }
            td.setIdTipoDevolucion(tipoDevId);
            dv.setTipoDevolucion(td);
            devolucionDao.crearDevolucion(dv, listaProd, tipoDevId);

            //  dv.se
            addMessage("Insertado!!");
        } catch (Exception e) {
            addMessage("Error!!" + e.getMessage());
            e.printStackTrace();
        }

    }

    public void eliminar() { 
        try {

            devolucionDao.borrarDevolucion(devolucion);

            //  dv.se
            addMessage("Insertado!!");
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
     * @param devolucion the devolucion to set
     */
    public void setDevolucion(Devolucion devolucion) {
        this.devolucion = devolucion;
    }

    /**
     * @return the listaDevolucion
     */
    public List<Devolucion> getListaDevolucion() {
        try {
            listaDevolucion = devolucionDao.listaDevolucion();
        } catch (Exception e) {
            listaDevolucion = new ArrayList<Devolucion>();
        }
        devolucion = new Devolucion();
        return listaDevolucion;
    }

    /**
     * @param listaDevolucion the listaDevolucion to set
     */
    public void setListaDevolucion(List<Devolucion> listaDevolucion) {
        this.listaDevolucion = listaDevolucion;
    }

    /**
     * @return the devolucionDao
     */
    public DevolucionDao getDevolucionDao() {
        return devolucionDao;
    }

    /**
     * @param devolucionDao the devolucionDao to set
     */
    public void setDevolucionDao(DevolucionDao devolucionDao) {
        this.devolucionDao = devolucionDao;
    }

    /**
     * @return the devIdV
     */
    public int getDevIdV() {
        return devIdV;
    }

    /**
     * @param devIdV the devIdV to set
     */
    public void setDevIdV(int devIdV) {
        this.devIdV = devIdV;
    }

    /**
     * @return the listaUsu
     */
    public List<SelectItem> getListaUsu() {

        try {
            this.listaOrd = devolucionDao.listaOrden();
            listaUsu.clear();
            SelectItemGroup g2 = new SelectItemGroup("Orden de Compra");
            SelectItem[] asi = new SelectItem[listaOrd.size()];
            for (int i = 0; i < listaOrd.size(); i++) {
                OrdenDeCompra usAux = (OrdenDeCompra) listaOrd.get(i);
                asi[i] = new SelectItem(usAux.getIdOrden(), usAux.getIdOrden() + "");
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
     * @return the listaUsu2
     */
    public List<SelectItem> getListaUsu2() {
        try {
            this.listClienteV = devolucionDao.listaCliente();
            listaUsu2.clear();
            SelectItemGroup g2 = new SelectItemGroup("Cliente");
            SelectItem[] asi = new SelectItem[listClienteV.size()];
            for (int i = 0; i < listClienteV.size(); i++) {
                Cliente usAux = (Cliente) listClienteV.get(i);
                asi[i] = new SelectItem(usAux.getIdCliente(), usAux.getPersona().getNombre() + " " + usAux.getPersona().getApellido());
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
     * @return the listaUsu3
     */
    public List<SelectItem> getListaUsu3() {
        try {
            this.listaReq = devolucionDao.listaRequisicion();
            listaUsu3.clear();
            SelectItemGroup g2 = new SelectItemGroup("Requisicion");
            SelectItem[] asi = new SelectItem[listaReq.size()];
            for (int i = 0; i < listaReq.size(); i++) {
                Requisicion usAux = (Requisicion) listaReq.get(i);
                asi[i] = new SelectItem(usAux.getIdRequisicion(), usAux.getIdRequisicion() + "");
            }
            g2.setSelectItems(asi);
            listaUsu3.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
            listaUsu3 = new ArrayList<SelectItem>();
        }
        return listaUsu3;
    }

    /**
     * @param listaUsu3 the listaUsu3 to set
     */
    public void setListaUsu3(List<SelectItem> listaUsu3) {
        this.listaUsu3 = listaUsu3;
    }

    /**
     * @return the listaOrd
     */
    public List<OrdenDeCompra> getListaOrd() {
        return listaOrd;
    }

    /**
     * @param listaOrd the listaOrd to set
     */
    public void setListaOrd(List<OrdenDeCompra> listaOrd) {
        this.listaOrd = listaOrd;
    }

    /**
     * @return the listaReq
     */
    public List<Requisicion> getListaReq() {
        return listaReq;
    }

    /**
     * @param listaReq the listaReq to set
     */
    public void setListaReq(List<Requisicion> listaReq) {
        this.listaReq = listaReq;
    }

    /**
     * @return the listaDev
     */
    public List<TipoDevolucion> getListaDev() {
        return listaDev;
    }

    /**
     * @param listaDev the listaDev to set
     */
    public void setListaDev(List<TipoDevolucion> listaDev) {
        this.listaDev = listaDev;
    }

    /**
     * @return the ordenIdV
     */
    public int getOrdenIdV() {
        return ordenIdV;
    }

    /**
     * @param ordenIdV the ordenIdV to set
     */
    public void setOrdenIdV(int ordenIdV) {
        this.ordenIdV = ordenIdV;
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
     * @return the requiIdV
     */
    public int getRequiIdV() {
        return requiIdV;
    }

    /**
     * @param requiIdV the requiIdV to set
     */
    public void setRequiIdV(int requiIdV) {
        this.requiIdV = requiIdV;
    }

    public void agreegarProducto() {
        //listaProd=new ArrayList<Producto>();
        Producto pd = new Producto();
        pd.setNombre4(this.prodIdV + "");
        pd.setIdProducto(prodIdV);
        pd.setExistencias(this.valorEx);
        pd.setDescripcion((listaProd.size())+"");
        listaProd.add(pd);
    }

    /**
     * @return the listaUsu4
     */
    public List<SelectItem> getListaUsu4() {

        try {
            this.listProductoV = devolucionDao.listaProducto();
            listaUsu4.clear();
            SelectItemGroup g2 = new SelectItemGroup("Producto");
            SelectItem[] asi = new SelectItem[listProductoV.size()];
            for (int i = 0; i < listProductoV.size(); i++) {
                Producto usAux = (Producto) listProductoV.get(i);
                asi[i] = new SelectItem(usAux.getIdProducto(), usAux.getNombre4() + "");
            }
            g2.setSelectItems(asi);
            listaUsu4.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
            listaUsu4 = new ArrayList<SelectItem>();
        }
        return listaUsu4;
    }

    /**
     * @param listaUsu4 the listaUsu4 to set
     */
    public void setListaUsu4(List<SelectItem> listaUsu4) {
        this.listaUsu4 = listaUsu4;
    }

    /**
     * @return the listProductoV
     */
    public List<Producto> getListProductoV() {
        return listProductoV;
    }

    public void limpiar() {

        listaProd = new ArrayList<Producto>();
    }

    /**
     * @param listProductoV the listProductoV to set
     */
    public void setListProductoV(List<Producto> listProductoV) {
        this.listProductoV = listProductoV;
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
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the tipoDevId
     */
    public int getTipoDevId() {
        return tipoDevId;
    }

    /**
     * @param tipoDevId the tipoDevId to set
     */
    public void setTipoDevId(int tipoDevId) {
        this.tipoDevId = tipoDevId;
    }
    
    public void limpiarProd()
    {
        listaProd.remove(Integer.parseInt(producto.getDescripcion()));
    }

    /**
     * @return the listaUsu5
     */
    public List<SelectItem> getListaUsu5() {
        try {
            listaUsu5.clear();
            SelectItemGroup g2 = new SelectItemGroup("Tipo Devolucion");
            SelectItem[] asi = new SelectItem[2];
            asi[0] = new SelectItem(1, "Requisicion");
            asi[1] = new SelectItem(2, "Orden de Compra");
            g2.setSelectItems(asi);
            listaUsu5.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
            listaUsu5 = new ArrayList<SelectItem>();
        }
        return listaUsu5;
    }

    /**
     * @param listaUsu5 the listaUsu5 to set
     */
    public void setListaUsu5(List<SelectItem> listaUsu5) {
        this.listaUsu5 = listaUsu5;
    }

}
