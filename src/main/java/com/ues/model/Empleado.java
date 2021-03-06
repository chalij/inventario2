package com.ues.model;
// Generated 30-may-2015 11:21:15 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Empleado generated by hbm2java
 */
public class Empleado  implements java.io.Serializable {


     private int idEmpleado;
     private Persona persona;
     private String rol;
     private Set<Requisicion> requisicions = new HashSet<Requisicion>(0);
     private Set<Pedido> pedidos = new HashSet<Pedido>(0);
     private Set<Inventario> inventarios = new HashSet<Inventario>(0);
     private Set<OrdenDeCompra> ordenDeCompras = new HashSet<OrdenDeCompra>(0);

    public Empleado() {
    }

	
    public Empleado(int idEmpleado, Persona persona, String rol) {
        this.idEmpleado = idEmpleado;
        this.persona = persona;
        this.rol = rol;
    }
    public Empleado(int idEmpleado, Persona persona, String rol, Set<Requisicion> requisicions, Set<Pedido> pedidos, Set<Inventario> inventarios, Set<OrdenDeCompra> ordenDeCompras) {
       this.idEmpleado = idEmpleado;
       this.persona = persona;
       this.rol = rol;
       this.requisicions = requisicions;
       this.pedidos = pedidos;
       this.inventarios = inventarios;
       this.ordenDeCompras = ordenDeCompras;
    }
   
    public int getIdEmpleado() {
        return this.idEmpleado;
    }
    
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    public Set<Requisicion> getRequisicions() {
        return this.requisicions;
    }
    
    public void setRequisicions(Set<Requisicion> requisicions) {
        this.requisicions = requisicions;
    }
    public Set<Pedido> getPedidos() {
        return this.pedidos;
    }
    
    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    public Set<Inventario> getInventarios() {
        return this.inventarios;
    }
    
    public void setInventarios(Set<Inventario> inventarios) {
        this.inventarios = inventarios;
    }
    public Set<OrdenDeCompra> getOrdenDeCompras() {
        return this.ordenDeCompras;
    }
    
    public void setOrdenDeCompras(Set<OrdenDeCompra> ordenDeCompras) {
        this.ordenDeCompras = ordenDeCompras;
    }




}


