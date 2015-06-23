package com.ues.dao.impl;

import com.ues.dao.PedidoDao;
import com.ues.dao.RecursosDao;
import com.ues.dao.RequisicionDao;
import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.UsuariosDao;
import com.ues.exception.DAOException;
import com.ues.model.Cliente;
import com.ues.model.DetallePedido;
import com.ues.model.DetalleProducto;
import com.ues.model.DetalleRequisicion;
import com.ues.model.Empleado;
import com.ues.model.Menu;
import com.ues.model.Pedido;
import com.ues.model.Producto;
import com.ues.model.Recursos;
import com.ues.model.Requisicion;
import com.ues.model.TipoUsuario;
import com.ues.model.Usuario;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Airy
 */
public class PedidoDaoHibImpl extends CustomHibernateDaoSupport implements PedidoDao {

    /* @Override
     public void crearRequisicion(Requisicion requisicion, List<Producto> lprod) throws DAOException {
     getHibernateTemplate().save(requisicion);
     int req = maxID("Requisicion", "idRequisicion");
     Requisicion rq = new Requisicion();
     rq.setIdRequisicion(req);
     for (int i = 0; i < lprod.size(); i++) {
     Producto pd = lprod.get(i);
     DetalleRequisicion dr = new DetalleRequisicion();
     dr.setRequisicion(rq);
     dr.setCantidad(pd.getExistencias());
     getHibernateTemplate().save(dr);
     int dreq = maxID("DetalleRequisicion", "idDeastalleRequisicion");
     DetalleRequisicion dra = new DetalleRequisicion();
     dra.setIdDeastalleRequisicion(dreq);
     DetalleProducto dpp = new DetalleProducto();
     dpp.setDetalleRequisicion(dra);
     dpp.setProducto(pd);
     dpp.setNombre(pd.getNombre4());
     dpp.setCantidad(pd.getExistencias());
     getHibernateTemplate().save(dpp);
     }
     System.out.println(req);
     // getHibernateTemplate().find("");

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
     public void borrarRequisicion(Requisicion requisicion) throws DAOException {
     List<DetalleRequisicion> ldetreq = listaDetalleRequisicion(requisicion.getIdRequisicion());

     for (int i = 0; i < ldetreq.size(); i++) {
     DetalleRequisicion dr = ldetreq.get(i);
     DetalleProducto pd = listaDetalleProducto(dr.getIdDeastalleRequisicion());
     getHibernateTemplate().delete(pd);
     getHibernateTemplate().delete(dr);
     }
     getHibernateTemplate().delete(requisicion);
     }

     @Override
     public void modificarRequisicion(Requisicion requisicion) throws DAOException {
     getHibernateTemplate().update(requisicion);
     }

     @Override
     public List<Empleado> listaEmpleado() throws DAOException {
     List<Empleado> lista = getHibernateTemplate().find("from Empleado rq join fetch rq.persona order by rq.idEmpleado");

     return lista;
     }

     @Override
     public Empleado listaBuscarEmp(int persona) throws DAOException {
     List<Empleado> lista = getHibernateTemplate().find("from Empleado rq join fetch rq.persona where rq.persona.idPersona=" + persona);

     return lista.get(0);
     }

     @Override
     public int maxID(String table, String id) throws DAOException {
     List list = getHibernateTemplate().find("select max(p." + id + ") from " + table + " p");
     System.out.println(list.get(0));
     return (Integer) list.get(0);
     }

     @Override
     public void ingresoProceso(List<Producto> listP, Requisicion requiscion) throws DAOException {
     // Session sesion = getHibernateTemplate().getSessionFactory().getCurrentSession();
     // sesion.createSQLQuery("select * from usuario");
     }

     @Override
     public List<Producto> listaProducto() throws DAOException {
     List<Producto> lista = getHibernateTemplate().find("from Producto rq  order by rq.idProducto");

     return lista;
     }

     @Override
     public DetalleProducto listaDetalleProducto(int id) throws DAOException {
     List<DetalleProducto> lista = getHibernateTemplate().find("from DetalleProducto rq inner join fetch rq.detalleRequisicion where rq.detalleRequisicion.idDeastalleRequisicion=" + id);

     return (DetalleProducto) lista.get(0);
     }

     @Override
     public List<DetalleRequisicion> listaDetalleRequisicion(int id) throws DAOException {
     List<DetalleRequisicion> lista = getHibernateTemplate().find("from DetalleRequisicion rq  where  rq.requisicion.idRequisicion=" + id);

     return lista;
     }*/
    @Override
    public void crearPedido(Pedido pedido, List<Producto> lprod) throws DAOException {
        getHibernateTemplate().save(pedido);
        int maxP = maxID("Pedido", "idPedido");
        Pedido ped = new Pedido();
        ped.setIdPedido(maxP);
        for (int i = 0; i < lprod.size(); i++) {
            Producto prod = lprod.get(0);
            DetallePedido dt = new DetallePedido();
            dt.setProducto(prod);
            dt.setCantidad(prod.getExistencias());
            dt.setPedido(ped);
            getHibernateTemplate().save(dt);

        }
    }

    @Override
    public List<Pedido> listaPedido() throws DAOException {

        List<Pedido> lista = getHibernateTemplate().find("from Pedido m  inner join fetch  m.empleado  inner join fetch  m.empleado.persona order by m.idPedido");

        return lista;
    }

    @Override
    public Empleado buscarEmpleado(int id) throws DAOException {
        List<Empleado> lista = getHibernateTemplate().find("from Empleado rq inner join fetch rq.persona where rq.persona.idPersona=" + id);

        return (Empleado) lista.get(0);
    }

    @Override
    public void borrarPedido(Pedido pedido) throws DAOException {
        getHibernateTemplate().delete(pedido);
    }

    @Override
    public List<Producto> listaProducto() throws DAOException {
        List<Producto> lista = getHibernateTemplate().find("from Producto rq  order by rq.idProducto");

        return lista;
    }

    @Override
    public int maxID(String table, String id) throws DAOException {
        List list = getHibernateTemplate().find("select max(p." + id + ") from " + table + " p");
        System.out.println(list.get(0));
        return (Integer) list.get(0);
    }
}
