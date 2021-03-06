package com.ues.model;
// Generated 30-may-2015 11:21:15 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * DetallePedido generated by hbm2java
 */
public class DetallePedido  implements java.io.Serializable {


     private int idDetallePedido;
     private Producto producto;
     private Pedido pedido;
     private int cantidad;

    public DetallePedido() {
    }

	
    public DetallePedido(int idDetallePedido, Pedido pedido, int cantidad) {
        this.idDetallePedido = idDetallePedido;
        this.pedido = pedido;
        this.cantidad = cantidad;
    }
    public DetallePedido(int idDetallePedido, Producto producto, Pedido pedido, int cantidad) {
       this.idDetallePedido = idDetallePedido;
       this.producto = producto;
       this.pedido = pedido;
       this.cantidad = cantidad;
    }
   
    public int getIdDetallePedido() {
        return this.idDetallePedido;
    }
    
    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Pedido getPedido() {
        return this.pedido;
    }
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }




}


