package com.ues.dao.impl;

import com.ues.dao.EmpleadosDao;
import com.ues.exception.DAOException;
import com.ues.model.CustomHibernateDaoSupport;
import com.ues.model.Empleado;
import com.ues.model.Persona;
import java.util.List;
/**
 *
 * @author Ibrahim
 */

public class EmpleadoDaoHibImpl extends CustomHibernateDaoSupport implements EmpleadosDao{
    @Override
    public void crearEmpleado(Empleado creaEmpleado) throws DAOException {
        getHibernateTemplate().saveOrUpdate(creaEmpleado);
    }

    @Override
    public Empleado buscaEmpleado(String buscaEmpleado) throws DAOException {
        List list = getHibernateTemplate().find(" from Empleado WHERE idEmpleado=?", buscaEmpleado);
        return (Empleado) list.get(0);
    }

     @Override
    public List<Persona> listaPersonas() throws DAOException {
        List<Persona> lista = getHibernateTemplate().find("from Persona p order by p.idPersona");        
        return lista;
    }
    
    @Override
    public List<Empleado> listaEmpleados() throws DAOException {
        List<Empleado> lista = getHibernateTemplate().find("from Empleado e  inner join fetch e.persona  order by e.idEmpleado");
        return lista;
    }

    @Override
    public void borrarEmpleados(Empleado borraEmpleado) throws DAOException {
        getHibernateTemplate().delete(borraEmpleado);
    }

    @Override
    public void modificarEmpleados(Empleado modificaEmpleado) throws DAOException {
        getHibernateTemplate().update(modificaEmpleado);
    }    

    @Override
    public int maxId() throws DAOException {
        List list = getHibernateTemplate().find("select max(p.idPersona) from Persona p");
        System.out.println(list);
        
        return (Integer) list.get(0);
    }
}
