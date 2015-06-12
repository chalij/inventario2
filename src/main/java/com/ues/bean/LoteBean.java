package com.ues.bean;

import com.ues.dao.LoteDao;
import com.ues.model.Bodega;
import com.ues.model.Lote;
import com.ues.model.Producto;
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
public class LoteBean {

    private int idLoteL;
    private List<Lote> miLista;
    private List<Bodega> miListaB;
    private List<Producto> miListaP;
    private LoteDao loteDao;
    private Lote lote = new Lote();
    //Para las foraneas
    private int idBodegaB;
    private int idProductoP;
    private List<Bodega> listaB;
    private List<Producto> listaP;

    private List<SelectItem> listaLote = new ArrayList<SelectItem>();
    private List<SelectItem> listaLote2 = new ArrayList<SelectItem>();

    public LoteBean() {
        lote = new Lote();
    }

    public int getIdLoteL() {
        return idLoteL;
    }

    public void setIdLoteL(int idLoteL) {
        this.idLoteL = idLoteL;
    }

    public List<Lote> getMiLista() {
        try {
            miLista = loteDao.listaLote();
        } catch (Exception e) {
            e.printStackTrace();
            miLista = new ArrayList<Lote>();
        }
        lote = new Lote();
        return miLista;
    }

    public void addLote(ActionEvent actionEvent) {
        try {
            Lote l = new Lote();
            Bodega b = new Bodega();
            Producto p = new Producto();

            l.setIdLote(lote.getIdLote());
            b.setIdBodega(idBodegaB);
            p.setIdProducto(idProductoP);
            l.setCantidad(lote.getCantidad());
            l.setDescripcion(lote.getDescripcion());
            l.setBodega(b);
            l.setProducto(p);
            loteDao.crearLote(l);

            addMessage("Lote Insertado:!!" + lote.getIdLote());
        } catch (Exception e) {
            addMessage("Error Id:!!" + lote.getIdLote() + " " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateLote(ActionEvent actionEvent) {
        try {
            Lote l = new Lote();
            Bodega b = new Bodega();
            Producto p = new Producto();

            l.setIdLote(lote.getIdLote());
            b.setIdBodega(idBodegaB);
            p.setIdProducto(idProductoP);
            l.setCantidad(lote.getCantidad());
            l.setDescripcion(lote.getDescripcion());
            l.setBodega(b);
            l.setProducto(p);
            loteDao.modificarLote(l);

            addMessage("Lote Insertado:!!" + lote.getIdLote());
        } catch (Exception e) {
            addMessage("Error Id:!!" + lote.getIdLote() + " " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void eliminar() {
        try {
            Lote l = new Lote();
            Bodega b = new Bodega();
            Producto p = new Producto();

            l.setIdLote(lote.getIdLote());
            b.setIdBodega(idBodegaB);
            p.setIdProducto(idProductoP);
            l.setCantidad(lote.getCantidad());
            l.setDescripcion(lote.getDescripcion());
            l.setBodega(b);
            l.setProducto(p);
            loteDao.borrarLote(l);

            addMessage("Lote Insertado:!!" + lote.getIdLote());
        } catch (Exception e) {
            addMessage("Error Id:!!" + lote.getIdLote() + " " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void setMiLista(List<Lote> miLista) {
        this.miLista = miLista;
    }
    
    private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Bodega> getMiListaB() {
        return miListaB;
    }

    public void setMiListaB(List<Bodega> miListaB) {
        this.miListaB = miListaB;
    }

    public List<Producto> getMiListaP() {
        return miListaP;
    }

    public void setMiListaP(List<Producto> miListaP) {
        this.miListaP = miListaP;
    }

    public LoteDao getLoteDao() {
        return loteDao;
    }

    public void setLoteDao(LoteDao loteDao) {
        this.loteDao = loteDao;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public int getIdBodegaB() {
        return idBodegaB;
    }

    public void setIdBodegaB(int idBodegaB) {
        this.idBodegaB = idBodegaB;
    }

    public int getIdProductoP() {
        return idProductoP;
    }

    public void setIdProductoP(int idProductoP) {
        this.idProductoP = idProductoP;
    }

    public List<Bodega> getListaB() {
        return listaB;
    }

    public void setListaB(List<Bodega> listaB) {
        this.listaB = listaB;
    }

    public List<Producto> getListaP() {
        return listaP;
    }

    public void setListaP(List<Producto> listaP) {
        this.listaP = listaP;
    }

    public List<SelectItem> getListaLote() {
        try {
            miListaB= loteDao.listaBodegas();
            listaLote.clear();
            SelectItemGroup g2 = new SelectItemGroup("Bodegas");
            SelectItem[] asi = new SelectItem[miListaB.size()];
            for (int i = 0; i < miListaB.size(); i++) {
                Bodega bAux = (Bodega) miListaB.get(i);
                asi[i] = new SelectItem(bAux.getIdBodega(), bAux.getNombre2());
            }
            g2.setSelectItems(asi);
            listaLote.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
           listaLote = new ArrayList<SelectItem>();
        }
        return listaLote;
    }

    public void setListaLote(List<SelectItem> listaLote) {
        this.listaLote = listaLote;
    }

    public List<SelectItem> getListaLote2() {
        try {
            miListaP= loteDao.listaProductos();
            listaLote2.clear();
            SelectItemGroup g2 = new SelectItemGroup("Productos");
            SelectItem[] asi = new SelectItem[miListaP.size()];
            for (int i = 0; i < miListaP.size(); i++) {
                Producto pAux = (Producto) miListaP.get(i);
                asi[i] = new SelectItem(pAux.getIdProducto(), pAux.getNombre4());
            }
            g2.setSelectItems(asi);
            listaLote2.add(g2);
        } catch (Exception e) {
            e.printStackTrace();
           listaLote2 = new ArrayList<SelectItem>();
        }
        return listaLote2;
    }

    public void setListaLote2(List<SelectItem> listaLote2) {
        this.listaLote2 = listaLote2;
    }

}
