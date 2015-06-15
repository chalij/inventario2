package com.ues.model;
// Generated 13-jun-2015 20:08:50 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Menu generated by hbm2java
 */
public class Menu  implements java.io.Serializable {


     private BigDecimal idMenu;
     private TipoMenu tipoMenu;
     private Recursos recursos;
     private String nombre;

    public Menu() {
    }

	
    public Menu(BigDecimal idMenu, String nombre) {
        this.idMenu = idMenu;
        this.nombre = nombre;
    }
    public Menu(BigDecimal idMenu, TipoMenu tipoMenu, Recursos recursos, String nombre) {
       this.idMenu = idMenu;
       this.tipoMenu = tipoMenu;
       this.recursos = recursos;
       this.nombre = nombre;
    }
   
    public BigDecimal getIdMenu() {
        return this.idMenu;
    }
    
    public void setIdMenu(BigDecimal idMenu) {
        this.idMenu = idMenu;
    }
    public TipoMenu getTipoMenu() {
        return this.tipoMenu;
    }
    
    public void setTipoMenu(TipoMenu tipoMenu) {
        this.tipoMenu = tipoMenu;
    }
    public Recursos getRecursos() {
        return this.recursos;
    }
    
    public void setRecursos(Recursos recursos) {
        this.recursos = recursos;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}


