/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.dao;

import com.ues.exception.DAOException;
import com.ues.model.Empleado;
import com.ues.model.Persona;
import java.util.List;

/**
 *
 * @author Ibrahim
 */
public interface EmpleadosDao {
    
    public void crearEmpleado(Empleado creaEmpleado) throws DAOException;

    public Empleado buscaEmpleado(String buscaEmpleado) throws DAOException;

    public List<Empleado> listaEmpleados() throws DAOException;
    
    public List<Persona> listaPersonas() throws DAOException;

    public void borrarEmpleados(Empleado borraEmpleado) throws DAOException;

    public void modificarEmpleados(Empleado modificaEmpleado) throws DAOException;
    
    public int maxId() throws DAOException;
}
