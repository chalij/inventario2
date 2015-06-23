package com.ues.dao.impl;

import com.ues.dao.DevolucionDao;
import com.ues.dao.RecursosDao;
import com.ues.dao.RequisicionDao;
import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.UsuariosDao;
import com.ues.exception.DAOException;
import com.ues.model.Cliente;
import com.ues.model.DetalleDevolucion;
import com.ues.model.DetalleProducto;
import com.ues.model.Devolucion;
import com.ues.model.Empleado;
import com.ues.model.Menu;
import com.ues.model.OrdenDeCompra;
import com.ues.model.Producto;
import com.ues.model.Proveedor;
import com.ues.model.Recursos;
import com.ues.model.Requisicion;
import com.ues.model.TipoDevolucion;
import com.ues.model.TipoUsuario;
import com.ues.model.Usuario;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Airy
 */
public class DevolucionDaoHibImpl extends CustomHibernateDaoSupport implements DevolucionDao {

    @Override
    public int maxID(String table, String id) throws DAOException {
        List list = getHibernateTemplate().find("select max(p." + id + ") from " + table + " p");
        System.out.println(list.get(0));
        return (Integer) list.get(0);
    }

    @Override
    public void crearDevolucion(Devolucion devolucion, List<Producto> listProd, int td) throws DAOException {
        getHibernateTemplate().save(devolucion);
        int imd = maxID("Devolucion", "idDevolucion");
        Devolucion dv = new Devolucion();
        dv.setIdDevolucion(imd);
        for (int i = 0; i < listProd.size(); i++) {
            Producto prod = listProd.get(i);
            DetalleDevolucion dd = new DetalleDevolucion();
            dd.setDevolucion(dv);
            dd.setCantidad(prod.getExistencias());
            getHibernateTemplate().save(dd);
            int imdd = maxID("DetalleDevolucion", "idDetalleDevolucion");
            DetalleProducto dprod=new DetalleProducto();
            dprod.setCantidad(prod.getExistencias());
            dprod.setProducto(prod);
            dd.setIdDetalleDevolucion(imdd);
            dprod.setNombre(prod.getNombre4());
            dprod.setDetalleDevolucion(dd);
            getHibernateTemplate().save(dprod);
        }
    }

    @Override
    public List<Devolucion> listaDevolucion() throws DAOException {
        List<Devolucion> lista = getHibernateTemplate().find("from Devolucion rq  inner join fetch  rq.tipoDevolucion order by rq.idDevolucion");

        return lista;
    }

    @Override
    public void borrarDevolucion(Devolucion devolucion) throws DAOException {
        getHibernateTemplate().delete(devolucion);
    }

    @Override
    public void modificarDevolucion(Devolucion devolucion) throws DAOException {
        getHibernateTemplate().update(devolucion);
    }

    @Override
    public List<Requisicion> listaRequisicion() throws DAOException {

        List<Requisicion> lista = getHibernateTemplate().find("from Requisicion m  inner join fetch  m.empleado inner join fetch m.cliente  join fetch m.cliente.persona  inner join fetch  m.empleado.persona order by m.idRequisicion");

        return lista;
    }

    @Override
    public List<Cliente> listaCliente() throws DAOException {
        List<Cliente> lista = getHibernateTemplate().find("from Cliente rq  join fetch rq.persona order by rq.idCliente");

        return lista;
    }

    @Override
    public List<Proveedor> listaProveedor() throws DAOException {
        List<Proveedor> lista = getHibernateTemplate().find("from Proveedor rq order by rq.idProveedor");

        return lista;
    }

    @Override
    public List<OrdenDeCompra> listaOrden() throws DAOException {
        List<OrdenDeCompra> lista = getHibernateTemplate().find("from OrdenDeCompra rq order by rq.idOrden");

        return lista;
    }

    @Override
    public List<TipoDevolucion> listaTipoDevolucion() throws DAOException {
        List<TipoDevolucion> lista = getHibernateTemplate().find("from TipoDevolucion rq  order by rq.idTipoDevolucion");

        return lista;
    }

    @Override
    public List<Producto> listaProducto() throws DAOException {
        List<Producto> lista = getHibernateTemplate().find("from Producto rq  order by rq.idProducto");

        return lista;
    }

}
