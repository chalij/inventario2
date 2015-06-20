/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.bean;

import com.ues.dao.RecursosDao;
import com.ues.model.Menu;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;

/**
 *
 * @author Administrador
 */
public class MenuBean {

    private DefaultMenuModel model = new DefaultMenuModel();
    private DefaultMenuModel clientes = new DefaultMenuModel();
    private DefaultMenuModel usuarios = new DefaultMenuModel();
    private DefaultMenuModel pedidos = new DefaultMenuModel();
    private DefaultMenuModel devoluciones = new DefaultMenuModel();
    private DefaultMenuModel inventarios = new DefaultMenuModel();
    private DefaultMenuModel ordenes = new DefaultMenuModel();
    private RecursosDao recursosDao;

    public void MenuBean() {

    }

    /**
     * @return the model
     */
    public DefaultMenuModel getModel() {
        try {

            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            System.out.println("----------Nombre del usuario---------------");
            System.out.println(session.getAttribute("username"));
            System.out.println(session.getAttribute("tipoUsuario"));
            int tipoUsuario=(Integer)session.getAttribute("tipoUsuario");
            model = new DefaultMenuModel();
            clientes = new DefaultMenuModel();
            usuarios = new DefaultMenuModel();
            pedidos = new DefaultMenuModel();
            devoluciones = new DefaultMenuModel();
            inventarios = new DefaultMenuModel();
            ordenes = new DefaultMenuModel();

            //First submenu
            DefaultSubMenu firstSubmenu = new DefaultSubMenu("");
            DefaultSubMenu firstSubmenu2 = new DefaultSubMenu("");
            DefaultSubMenu firstSubmenu3 = new DefaultSubMenu("");
            DefaultSubMenu firstSubmenu4 = new DefaultSubMenu("");
            DefaultSubMenu firstSubmenu5 = new DefaultSubMenu("");
            DefaultSubMenu firstSubmenu6 = new DefaultSubMenu("");
            DefaultSubMenu firstSubmenu7 = new DefaultSubMenu("");

            DefaultMenuItem item;
            List<Menu> listAux = recursosDao.listaMenus(tipoUsuario);
            System.out.println("aqui");
            for (int i = 0; i < listAux.size(); i++) {
                Menu men = listAux.get(i);

                /*    item = new DefaultMenuItem(men.getNombre());
                 item.setUrl(men.getRecursos().getUrl());
                 item.setIcon("ui-icon-home");
                 firstSubmenu.addElement(item);*/
                System.out.println(men.getTipoMenu().getNombre());
                if (men.getTipoMenu().getNombre().equals("proveedor")) {
                    item = new DefaultMenuItem(men.getNombre());
                    item.setUrl(men.getRecursos().getUrl());
                    item.setIcon("ui-icon-home");
                    firstSubmenu.addElement(item);
                }
                if (men.getTipoMenu().getNombre().equals("cliente")) {
                    item = new DefaultMenuItem(men.getNombre());
                    item.setUrl(men.getRecursos().getUrl());
                    item.setIcon("ui-icon-home");
                    firstSubmenu2.addElement(item);
                }
                if (men.getTipoMenu().getNombre().equals("usuario")) {
                    item = new DefaultMenuItem(men.getNombre());
                    item.setUrl(men.getRecursos().getUrl());
                    item.setIcon("ui-icon-home");
                    firstSubmenu3.addElement(item);
                }
                if (men.getTipoMenu().getNombre().equals("pedido")) {
                    item = new DefaultMenuItem(men.getNombre());
                    item.setUrl(men.getRecursos().getUrl());
                    item.setIcon("ui-icon-home");
                    firstSubmenu4.addElement(item);
                }
                if (men.getTipoMenu().getNombre().equals("devoluciones")) {
                    item = new DefaultMenuItem(men.getNombre());
                    item.setUrl(men.getRecursos().getUrl());
                    item.setIcon("ui-icon-home");
                    firstSubmenu5.addElement(item);
                }
                if (men.getTipoMenu().getNombre().equals("inventario")) {
                    item = new DefaultMenuItem(men.getNombre());
                    item.setUrl(men.getRecursos().getUrl());
                    item.setIcon("ui-icon-home");
                    firstSubmenu6.addElement(item);
                }
                if (men.getTipoMenu().getNombre().equals("orden de compra")) {
                    item = new DefaultMenuItem(men.getNombre());
                    item.setUrl(men.getRecursos().getUrl());
                    item.setIcon("ui-icon-home");
                    firstSubmenu7.addElement(item);
                }

            }

            this.model.addElement(firstSubmenu);
            this.clientes.addElement(firstSubmenu2);
            this.usuarios.addElement(firstSubmenu3);
            this.pedidos.addElement(firstSubmenu4);
            this.devoluciones.addElement(firstSubmenu5);
            this.inventarios.addElement(firstSubmenu6);
            this.ordenes.addElement(firstSubmenu7);
        } catch (Exception e) {
            this.model = new DefaultMenuModel();
            this.clientes = new DefaultMenuModel();
            this.usuarios = new DefaultMenuModel();
            this.pedidos = new DefaultMenuModel();
            this.devoluciones = new DefaultMenuModel();
            this.inventarios = new DefaultMenuModel();
            this.ordenes = new DefaultMenuModel();
        }

        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(DefaultMenuModel model) {
        this.model = model;
    }

    /**
     * @return the recursosDao
     */
    public RecursosDao getRecursosDao() {
        return recursosDao;
    }

    /**
     * @param recursosDao the recursosDao to set
     */
    public void setRecursosDao(RecursosDao recursosDao) {
        this.recursosDao = recursosDao;
    }

    /**
     * @return the clientes
     */
    public DefaultMenuModel getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(DefaultMenuModel clientes) {
        this.clientes = clientes;
    }

    /**
     * @return the usuarios
     */
    public DefaultMenuModel getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(DefaultMenuModel usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * @return the pedidos
     */
    public DefaultMenuModel getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(DefaultMenuModel pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * @return the devoluciones
     */
    public DefaultMenuModel getDevoluciones() {
        return devoluciones;
    }

    /**
     * @param devoluciones the devoluciones to set
     */
    public void setDevoluciones(DefaultMenuModel devoluciones) {
        this.devoluciones = devoluciones;
    }

    /**
     * @return the inventarios
     */
    public DefaultMenuModel getInventarios() {
        return inventarios;
    }

    /**
     * @param inventarios the inventarios to set
     */
    public void setInventarios(DefaultMenuModel inventarios) {
        this.inventarios = inventarios;
    }

    /**
     * @return the ordenes
     */
    public DefaultMenuModel getOrdenes() {
        return ordenes;
    }

    /**
     * @param ordenes the ordenes to set
     */
    public void setOrdenes(DefaultMenuModel ordenes) {
        this.ordenes = ordenes;
    }
}
