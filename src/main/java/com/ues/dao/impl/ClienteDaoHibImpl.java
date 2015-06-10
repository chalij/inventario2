package com.ues.dao.impl;

import com.ues.model.CustomHibernateDaoSupport;
import com.ues.dao.ClienteDao;
import com.ues.exception.DAOException;
import com.ues.model.TipoCliente;
import com.ues.model.Cliente;
import com.ues.model.Persona;
import java.util.List;

/**
 *
 * @author Jocelyn
 * 
 */
public class ClienteDaoHibImpl extends CustomHibernateDaoSupport implements ClienteDao {

        
    public void crearCliente(Cliente cliente) throws DAOException {
        getHibernateTemplate().saveOrUpdate(cliente);
    }

    public Cliente buscaCliente(Integer idCliente) throws DAOException {
        List list = getHibernateTemplate().find(" from Cliente WHERE idCliente=?",idCliente);
        return (Cliente) list.get(0);
    }

    public List<Cliente> listaClientes() throws DAOException {
        List<Cliente> lista = getHibernateTemplate().find("from Cliente c inner join fetch c.persona inner join fetch c.tipoCliente order by c.idCliente");
        return lista;
    }

    public void modificarCliente(Cliente cliente) throws DAOException {
        getHibernateTemplate().update(cliente);
    }

    public void borrarCliente(Cliente cliente) throws DAOException {
        getHibernateTemplate().delete(cliente);
    }

    @Override
    public List<Persona> listaPersonas() throws DAOException{
        List<Persona> lista = getHibernateTemplate().find("from Persona p order by p.idPersona");
     
         return lista;}
        
          @Override
    public List<TipoCliente> listaTiposCliente() throws DAOException{
        List<TipoCliente> lista = getHibernateTemplate().find("from TipoCliente tc order by tc.idTipoCliente");
        
        
        return lista;}
    }

