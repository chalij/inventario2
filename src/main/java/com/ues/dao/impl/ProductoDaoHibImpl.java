package com.ues.dao.impl;

import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.ClienteDao;
import com.ues.dao.ProductoDao;
import com.ues.exception.DAOException;
import com.ues.model.TipoCliente;
import com.ues.model.Cliente;
import com.ues.model.Persona;
import com.ues.model.Producto;
import com.ues.model.Proveedor;
import com.ues.model.TipoProducto;
import java.util.List;

/**
 *
 * @author Jocelyn
 *
 */
public class ProductoDaoHibImpl extends CustomHibernateDaoSupport implements ProductoDao {



    @Override
    public int maxId() throws DAOException {

        List list = getHibernateTemplate().find("select max(p.idProducto) from Producto p");
        System.out.println(list.get(0));

        return (Integer) list.get(0);
    }

    @Override
    public void crearProducto(Producto producto) throws DAOException {
        getHibernateTemplate().save(producto);
    }

    @Override
    public Producto buscaProducto(Integer idProducto) throws DAOException {
        List list = getHibernateTemplate().find(" from Producto WHERE idProducto=?", idProducto);
        return (Producto) list.get(0);
    }

    @Override
    public List<Producto> listaProductos() throws DAOException {
        List<Producto> lista = getHibernateTemplate().find("from Producto c inner join fetch c.proveedor inner join fetch c.tipoProducto order by c.idProducto");
        return lista;
    }

    @Override
    public void modificarProducto(Producto producto) throws DAOException {
        getHibernateTemplate().update(producto);
    }

    
    @Override
    public void borrarProducto(Producto tipoProducto) throws DAOException {
        getHibernateTemplate().delete(tipoProducto);
    }


    @Override
    public List<Proveedor> listaProveedores() throws DAOException {
        List<Proveedor> lista = getHibernateTemplate().find("from Proveedor p order by p.idProveedor");

        return lista;
    }

    @Override
    public List<TipoProducto> listaTiposProducto() throws DAOException {
        List<TipoProducto> lista = getHibernateTemplate().find("from TipoProducto tc order by tc.idTipoProducto");

        return lista;
    }

}
