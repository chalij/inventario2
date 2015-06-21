/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.sql;

/**
 *
 * @author Administrador
 */
public class Chali {
    /* 
     -----------------Tipo Usuario--------------------
     INSERT INTO tipo_usuario VALUES (2,'administrador',null);
     INSERT INTO tipo_usuario VALUES (3,'empleado',null);
     COMMIT;

     -------------------Usuario------------------------
    
     ------------------Tipo Menu----------------------
     INSERT INTO tipo_menu( NOMBRE ) VALUES('cliente');
     INSERT INTO tipo_menu( NOMBRE ) VALUES('proveedor');
     INSERT INTO tipo_menu( NOMBRE ) VALUES('usuario');
     INSERT INTO tipo_menu( NOMBRE ) VALUES('pedido');
     INSERT INTO tipo_menu( NOMBRE ) VALUES('devoluciones');
     INSERT INTO tipo_menu( NOMBRE ) VALUES('inventario');
     INSERT INTO tipo_menu( NOMBRE ) VALUES('orden de compra');
     commit;


     ------------------Recursos----------------------

     INSERT INTO recursos(ID_TIPO_USUARIO,URL) VALUES(1,'clientes.xhtml');
     INSERT INTO recursos(ID_TIPO_USUARIO,URL) VALUES(1,'usuarios.xhtml');
     INSERT INTO recursos(ID_TIPO_USUARIO,URL) VALUES(1,'tipo_devolucion.xhtml');
     INSERT INTO recursos(ID_TIPO_USUARIO,URL) VALUES(1,'tipo_productos.xhtml');
     INSERT INTO recursos(ID_TIPO_USUARIO,URL) VALUES(1,'proveedor.xhtml');
     INSERT INTO recursos(ID_TIPO_USUARIO,URL) VALUES(1,'bodega.xhtml');
     INSERT INTO recursos(ID_TIPO_USUARIO,URL) VALUES(1,'empleado.xhtml');
     INSERT INTO recursos(ID_TIPO_USUARIO,URL) VALUES(1,'recursos.xhtml');
     INSERT INTO recursos(ID_TIPO_USUARIO,URL) VALUES(1,'tipo_usuarios.xhtml');
     commit;



     ------------------Menu----------------------
     INSERT INTO menu(ID_RECURSOS,ID_TIPO_MENU,NOMBRE) VALUES (41,25,'Tipo de Devoluciones');
     INSERT INTO menu(ID_RECURSOS,ID_TIPO_MENU,NOMBRE) VALUES (42,27,'Tipo de Productos');
     INSERT INTO menu(ID_RECURSOS,ID_TIPO_MENU,NOMBRE) VALUES (43,22,'Proveedor');
     INSERT INTO menu(ID_RECURSOS,ID_TIPO_MENU,NOMBRE) VALUES (44,26,'Bodega');
     INSERT INTO menu(ID_RECURSOS,ID_TIPO_MENU,NOMBRE) VALUES (45,24,'Empleado');
     INSERT INTO menu(ID_RECURSOS,ID_TIPO_MENU,NOMBRE) VALUES (46,23,'Recursos');
     INSERT INTO menu(ID_RECURSOS,ID_TIPO_MENU,NOMBRE) VALUES (47,23,'Tipo de Usuarios');
     commit;
    
    
     ----------------Tipo Cliente-------------------------
     insert into tipo_cliente(nombre,descripcion) values('VIP','Buen Ciente');
     commit;
    
     ------------------Cliente-----------------------------
     insert into cliente(id_persona,id_tipo_cliente) values(101,1);
     commit;
    
    -------------------Empleado------------------------------
    
     insert into empleado(id_persona,rol) values(101,'chaneque');
     commit;
    
    -------------------Requisicion------------------------------
    
     insert into requisicion(id_cliente,id_empleado,fecha_req) values(1,1,sysdate);
     commit;
    
    
     */
}
