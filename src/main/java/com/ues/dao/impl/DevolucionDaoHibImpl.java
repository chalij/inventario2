package com.ues.dao.impl;

import com.ues.dao.RecursosDao;
import com.ues.dao.RequisicionDao;
import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.UsuariosDao;
import com.ues.exception.DAOException;
import com.ues.model.Cliente;
import com.ues.model.Empleado;
import com.ues.model.Menu;
import com.ues.model.Recursos;
import com.ues.model.Requisicion;
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
public class DevolucionDaoHibImpl extends CustomHibernateDaoSupport implements RequisicionDao {


    @Override
    public void crearRequisicion(Requisicion requisicion) throws DAOException {
        getHibernateTemplate().save(requisicion);
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
    public int maxID(String table) throws DAOException {
        List list = getHibernateTemplate().find("select max(p.id"+table+") from "+table+" p");
        System.out.println(list.get(0));
        return (Integer) list.get(0);
    }
}
