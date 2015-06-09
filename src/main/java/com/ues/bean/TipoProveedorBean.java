package com.ues.bean;

import com.ues.dao.TipoProveedorDao;
import com.ues.model.TipoProveedor;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Ibrahim
 */
public class TipoProveedorBean {

    private TipoProveedor tipoProveedor = new TipoProveedor();
    int tipoProveedorV;
    private List<TipoProveedor> miLista;
    private TipoProveedorDao tipoProveedorDao;
    
    public TipoProveedorBean() {
        tipoProveedor = new TipoProveedor();
    }
    
    public int getTipoProveedorV() {
        return tipoProveedorV;
    }

    public void setTipoProveedorV(int tipoProveedorV) {
        this.tipoProveedorV = tipoProveedorV;
    }

    public TipoProveedor getTipoProveedor() {
        return tipoProveedor;
    }

    public void setTipoProveedor(TipoProveedor tipoProveedor) {
        this.tipoProveedor = tipoProveedor;
    }
    
    public List<TipoProveedor> getMiLista() {
        try {
            miLista = getTipoProveedorDao().listaTipoProveedor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miLista;
    }

    public TipoProveedorDao getTipoProveedorDao() {
        return tipoProveedorDao;
    }

    public void setMiLista(List<TipoProveedor> miLista) {
        this.miLista = miLista;
    }

    public void setTipoProveedorDao(TipoProveedorDao tipoProveedorDao) {
        this.tipoProveedorDao = tipoProveedorDao;
    }
    
    public void eliminar() {

        try {
            TipoProveedor tp = new TipoProveedor();
            tp.setIdTipoProveedor(tipoProveedor.getIdTipoProveedor());
            tp.setNombre(tipoProveedor.getNombre());
            tp.setDescripcion(tipoProveedor.getDescripcion());
            tipoProveedorDao.borrarTipoProveedor(tp);
            tipoProveedor = new TipoProveedor();
            addMessage("Eliminado Id:!!");
        } catch (Exception e) {
            addMessage("Error Id:!!");
            e.printStackTrace();
        }
    }
    public void actualizar(ActionEvent actionEvent) {
        try {
            TipoProveedor tp = new TipoProveedor();
            tp.setIdTipoProveedor(tipoProveedor.getIdTipoProveedor());
            tp.setNombre(tipoProveedor.getNombre());
            tp.setDescripcion(tipoProveedor.getDescripcion());
            tipoProveedorDao.modificarTipoProveedor(tp);
            tipoProveedor = new TipoProveedor();
            addMessage("Actualizado : " + tp.getNombre());
        } catch (Exception e) {
            addMessage("Error Id:!!" + e.getMessage());
            e.printStackTrace();
        }

    }
    
    private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
