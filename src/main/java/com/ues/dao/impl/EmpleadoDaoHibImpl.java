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
        getHibernateTemplate().save(creaEmpleado);
    }

    @Override
    public Empleado buscaEmpleado(String buscaEmpleado) throws DAOException {
        List list = getHibernateTemplate().find(" from Empleado WHERE idEmpleado=?", buscaEmpleado);
        return (Empleado) list.get(0);
    }

     @Override
    public List<Persona> listaPersonas() throws DAOException {
        List<Persona> lista = getHibernateTemplate().find("from Persona per order by per.idPersona");        
        return lista;
    }
    
    @Override
    public List<Empleado> listaEmpleados() throws DAOException {
        List<Empleado> lista = getHibernateTemplate().find("from Empleado emp  inner join fetch emp.persona order by emp.idEmpleado");        
        return lista;
    }

    @Override
    public void borrarEmpleados(Empleado borraEmpleado) throws DAOException {
        getHibernateTemplate().update(borraEmpleado);
    }

    @Override
    public void modificarEmpleados(Empleado modificaEmpleado) throws DAOException {
        getHibernateTemplate().delete(modificaEmpleado);
    }    
}
