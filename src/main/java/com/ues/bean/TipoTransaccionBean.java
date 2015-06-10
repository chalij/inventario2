package com.ues.bean;

//import static com.sun.javafx.logging.PulseLogger.addMessage;
import com.ues.dao.TipoTransaccionDao;
import com.ues.model.TipoTransaccion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
/**
 *
 * @author Jocelyn
 */
public class TipoTransaccionBean {

    private int idTipoTransaccionTT;
    private List<TipoTransaccion> miLista;
    private TipoTransaccionDao tipotransaccionDao;
    private TipoTransaccion tipotransaccion = new TipoTransaccion();
   
    //constructor
    public TipoTransaccionBean() {
        tipotransaccion = new TipoTransaccion();
    }

    /**
     * @return the miLista
     */
    public List<TipoTransaccion> getMiLista() {
        try
        {
            miLista=tipotransaccionDao.listaTipoTransacciones();
        }
        catch(Exception e)
        {
            miLista=new ArrayList<TipoTransaccion>();
        }
        setTipotransaccion(new TipoTransaccion());
        return miLista;
    }

    /**
     * @param miLista the miLista to set
     */
    public void setMiLista(List<TipoTransaccion> miLista) {
        this.miLista = miLista;
    }
    
     public void addTipoTransaccion(ActionEvent actionEvent) {
        try {
            TipoTransaccion tt = new TipoTransaccion();
            
            tt.setIdTipoTransaccion(tipotransaccion.getIdTipoTransaccion());
            tt.setNombre(tipotransaccion.getNombre());
            tt.setDescripcion(tipotransaccion.getDescripcion());
            
            tipotransaccionDao.crearTipoTransaccion(tt);
          
            addMessage("Insertado Id:!!" + tipotransaccion.getIdTipoTransaccion());
        } catch (Exception e) {
            addMessage("Error Id:!!" + tipotransaccion.getIdTipoTransaccion() + " " + e.getMessage());
            e.printStackTrace();
        }

    }
    
    
    public void updateTipoTransaccion(ActionEvent actionEvent) {
        try {
            TipoTransaccion tt = new TipoTransaccion();
            
            tt.setIdTipoTransaccion(tipotransaccion.getIdTipoTransaccion());
            tt.setNombre(tipotransaccion.getNombre());
            tt.setDescripcion(tipotransaccion.getDescripcion());
            
            tipotransaccionDao.modificarTipoTransaccion(tt);
          
            addMessage("Modificado Id:!!" + tipotransaccion.getIdTipoTransaccion());
        } catch (Exception e) {
            addMessage("Error Id:!!" + tipotransaccion.getIdTipoTransaccion() + " " + e.getMessage());
            e.printStackTrace();
        }

    }
    
    public void eliminar(ActionEvent actionEvent) {
        try {
            TipoTransaccion tt = new TipoTransaccion();
            
            tt.setIdTipoTransaccion(tipotransaccion.getIdTipoTransaccion());
            tt.setNombre(tipotransaccion.getNombre());
            tt.setDescripcion(tipotransaccion.getDescripcion());
            
            tipotransaccionDao.borrarTipoTransaccion(tt);
            tipotransaccion=new TipoTransaccion();
          
            addMessage("Eliminado Id:!!" + tipotransaccion.getIdTipoTransaccion());
        } catch (Exception e) {
            addMessage("Error Id:!!" + tipotransaccion.getIdTipoTransaccion() + " " + e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * @return the tipotransaccionDao
     */
    public TipoTransaccionDao getTipotransaccionDao() {
        return tipotransaccionDao;
    }

    /**
     * @param tipotransaccionDao the tipotransaccionDao to set
     */
    public void setTipotransaccionDao(TipoTransaccionDao tipotransaccionDao) {
        this.tipotransaccionDao = tipotransaccionDao;
    }

    /**
     * @return the idTipoTransaccionTT
     */
    public int getIdTipoTransaccionTT() {
        return idTipoTransaccionTT;
    }

    /**
     * @param idTipoTransaccionTT the idTipoTransaccionTT to set
     */
    public void setIdTipoTransaccionTT(int idTipoTransaccionTT) {
        this.idTipoTransaccionTT = idTipoTransaccionTT;
    }

    /**
     * @return the tipotransaccion
     */
    public TipoTransaccion getTipotransaccion() {
        return tipotransaccion;
    }

    /**
     * @param tipotransaccion the tipotransaccion to set
     */
    public void setTipotransaccion(TipoTransaccion tipotransaccion) {
        this.tipotransaccion = tipotransaccion;
    }
    
     private void addMessage(String welcome_to_Primefaces) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, welcome_to_Primefaces, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}//fin clase