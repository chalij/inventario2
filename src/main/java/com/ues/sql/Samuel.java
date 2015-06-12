// APPLICATION CONTEXT - VIERNES 12 JUNIO 2015
/*<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

    <bean id="dataSource" destroy-method="close" class="org.apache.commons.dbcp.BasicDataSource">
        <property name="driverClassName" value="oracle.jdbc.OracleDriver"/>
        <property name="url" value="jdbc:oracle:thin:@localhost:1521:XE" /> 
        <property name="username" value="inventario"/>
        <property name="password" value="inventario"/>
    </bean>
 
    <bean id="mySessionFactory" class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        
        <property name="mappingResources">
            <list>
    <!--
    Usuario
INSERT INTO usuario VALUES (2,1,'Joy','123','02-02-2015',null);
INSERT INTO usuario VALUES (3,1,'Samuel','123','02-02-2015',null);
commit;
Persona
insert into persona VALUES (1,2,'Ligia','Aguilar','F','514541541','65465464','18/10/1988','Mi casa','ligia.jocelyn@gmail.com');
commit;
                -->
                <value>Transaccion.hbm.xml</value>
                <value>Recursos.hbm.xml</value>
                <value>DetalleRequisicion.hbm.xml</value>
                <value>Cotizacion.hbm.xml</value>
                <value>Telefono.hbm.xml</value>
                <value>TipoProducto.hbm.xml</value>
                <value>DetalleDevolucion.hbm.xml</value>
                <value>OrdenDeCompra.hbm.xml</value>
                <value>DetallePedido.hbm.xml</value>
                <value>Bodega.hbm.xml</value>
                <value>TipoTransaccion.hbm.xml</value>
                <value>Proveedor.hbm.xml</value>
                <value>TipoCliente.hbm.xml</value>
                <value>Cliente.hbm.xml</value>
                <value>Requisicion.hbm.xml</value>
                <value>TipoProveedor.hbm.xml</value>
                <value>TipoDevolucion.hbm.xml</value>
                <value>DetalleProducto.hbm.xml</value>
                <value>Usuario.hbm.xml</value>
                <value>Inventario.hbm.xml</value>
                <value>Lote.hbm.xml</value>
                <value>Devolucion.hbm.xml</value>
                <value>TipoUsuario.hbm.xml</value>
                <value>Pedido.hbm.xml</value>
                <value>DetalleDeOrdenCompra.hbm.xml</value>
                <value>Persona.hbm.xml</value>
                <value>Empleado.hbm.xml</value>
                <value>Producto.hbm.xml</value>
            </list>
        </property>
        
        <property name="hibernateProperties">
            <props>
                <prop key="hibernate.dialect">org.hibernate.dialect.OracleDialect</prop>
                <prop key="hibernate.show_sql">true</prop>
            </props>
        </property>
        
    </bean>
    
    <bean id="usuariosDao" class="com.ues.dao.impl.UsuariosDaoHibImpl">
        <property name="sessionFactory" ref="mySessionFactory"/>
    </bean>
   
    
    
     <bean id="personasDao" class="com.ues.dao.impl.PersonasDaoHibImpl">
        <property name="sessionFactory" ref="mySessionFactory"/>
    </bean>
    
    
     <bean id="tipoUsuariosDao" class="com.ues.dao.impl.TipoUsuariosDaoHibImpl">
        <property name="sessionFactory" ref="mySessionFactory"/>
    </bean>
    
    
     <bean id="tipoProductosDao" class="com.ues.dao.impl.TipoProductosDaoHibImpl">
        <property name="sessionFactory" ref="mySessionFactory"/>
    </bean>
    
    
     <bean id="tipoDevolucionesDao" class="com.ues.dao.impl.TipoDevolucionesDaoHibImpl">
        <property name="sessionFactory" ref="mySessionFactory"/>
    </bean>
    
    
     <bean id="recursosDao" class="com.ues.dao.impl.RecursosDaoHibImpl">
        <property name="sessionFactory" ref="mySessionFactory"/>
    </bean>
    
    
    
    <bean id="tipoclienteDao" class="com.ues.dao.impl.TipoClienteDaoHibImpl">
        <property name="sessionFactory" ref="mySessionFactory"/>
    </bean>
    
    <bean id="clienteDao" class="com.ues.dao.impl.ClienteDaoHibImpl">
        <property name="sessionFactory" ref="mySessionFactory"/>
    </bean>
    
    <bean id="tipotransaccionDao" class="com.ues.dao.impl.TipoTransaccionDaoHibImpl">
        <property name="sessionFactory" ref="mySessionFactory"/>
    </bean>
    
    <bean id="telefonoDao" class="com.ues.dao.impl.TelefonoDaoHibImpl">
        <property name="sessionFactory" ref="mySessionFactory"/>
    </bean>
    
    <bean id="transaccionDao" class="com.ues.dao.impl.TransaccionDaoHibImpl">
        <property name="sessionFactory" ref="mySessionFactory"/>
    </bean>
    
    <bean id="bodegaDao" class="com.ues.dao.impl.BodegaDaoHibImpl">
        <property name="sessionFactory" ref="mySessionFactory"/>
    </bean>
    <bean id="tipoProveedorDao" class="com.ues.dao.impl.TipoProveedorDaoHibImpl">
        <property name="sessionFactory" ref="mySessionFactory"/>
    </bean>
    
    <bean id="proveedorDao" class="com.ues.dao.impl.ProveedorDaoHibImpl">
        <property name="sessionFactory" ref="mySessionFactory"/>
    </bean>
    
    <bean id="empleadoDao" class="com.ues.dao.impl.EmpleadoDaoHibImpl">
        <property name="sessionFactory" ref="mySessionFactory"/>
    </bean>
    
    <bean id="loteDao" class="com.ues.dao.impl.LoteDaoHibImpl">
        <property name="sessionFactory" ref="mySessionFactory"/>
    </bean>
    
</beans>

// FACESCONFIG.XML - VIERNES 12 DE JUNIO 2015
<?xml version='1.0' encoding='UTF-8'?>
<faces-config xmlns="http://java.sun.com/xml/ns/javaee" version="2.0">
    <application>
        
        <el-resolver>org.springframework.web.jsf.el.SpringBeanFacesELResolver</el-resolver>

        <locale-config>
            <default-locale>es_MX</default-locale>
            <supported-locale>es_MX</supported-locale>
        </locale-config>
    </application>

    <managed-bean>
        <managed-bean-name>usuariosBean</managed-bean-name>
        <managed-bean-class>com.ues.bean.UsuariosBean</managed-bean-class>
    
        <managed-bean-scope>session</managed-bean-scope>
        <managed-property>
            <property-name>usuariosDao</property-name>
            <property-class>com.ues.dao.UsuariosDao</property-class>
            <value>#{usuariosDao}</value>
        </managed-property>
    </managed-bean>
    
    
    
     <managed-bean>
        <managed-bean-name>personasBean</managed-bean-name>
        <managed-bean-class>com.ues.bean.PersonasBean</managed-bean-class>
    
        <managed-bean-scope>session</managed-bean-scope>
        <managed-property>
            <property-name>personasDao</property-name>
            <property-class>com.ues.dao.PersonasDao</property-class>
            <value>#{personasDao}</value>
        </managed-property>
    </managed-bean>
    
    
     <managed-bean>
        <managed-bean-name>tipoUsuariosBean</managed-bean-name>
        <managed-bean-class>com.ues.bean.TipoUsuariosBean</managed-bean-class>
    
        <managed-bean-scope>session</managed-bean-scope>
        <managed-property>
            <property-name>tipoUsuariosDao</property-name>
            <property-class>com.ues.dao.TipoUsuariosDao</property-class>
            <value>#{tipoUsuariosDao}</value>
        </managed-property>
    </managed-bean>
    
    
     <managed-bean>
        <managed-bean-name>tipoProductosBean</managed-bean-name>
        <managed-bean-class>com.ues.bean.TipoProductosBean</managed-bean-class>
    
        <managed-bean-scope>session</managed-bean-scope>
        <managed-property>
            <property-name>tipoProductosDao</property-name>
            <property-class>com.ues.dao.TipoProductosDao</property-class>
            <value>#{tipoProductosDao}</value>
        </managed-property>
    </managed-bean>
    
    
     <managed-bean>
        <managed-bean-name>tipoDevolucionesBean</managed-bean-name>
        <managed-bean-class>com.ues.bean.TipoDevolucionesBean</managed-bean-class>
    
        <managed-bean-scope>session</managed-bean-scope>
        <managed-property>
            <property-name>tipoDevolucionesDao</property-name>
            <property-class>com.ues.dao.TipoDevolucionesDao</property-class>
            <value>#{tipoDevolucionesDao}</value>
        </managed-property>
    </managed-bean>
    
    
     <managed-bean>
        <managed-bean-name>recursosBean</managed-bean-name>
        <managed-bean-class>com.ues.bean.RecursosBean</managed-bean-class>
    
        <managed-bean-scope>session</managed-bean-scope>
        <managed-property>
            <property-name>recursosDao</property-name>
            <property-class>com.ues.dao.RecursosDao</property-class>
            <value>#{recursosDao}</value>
        </managed-property>
    </managed-bean>
    
    
    
    <managed-bean>
        <managed-bean-name>tipoclienteBean</managed-bean-name>
        <managed-bean-class>com.ues.bean.TipoClienteBean</managed-bean-class>
    
        <managed-bean-scope>session</managed-bean-scope>
        <managed-property>
            <property-name>tipoclienteDao</property-name>
            <property-class>com.ues.dao.TipoClienteDao</property-class>
            <value>#{tipoclienteDao}</value>
        </managed-property>
    </managed-bean>
    
    
    
    <managed-bean>
        <managed-bean-name>clienteBean</managed-bean-name>
        <managed-bean-class>com.ues.bean.ClienteBean</managed-bean-class>
    
        <managed-bean-scope>session</managed-bean-scope>
        <managed-property>
            <property-name>clienteDao</property-name>
            <property-class>com.ues.dao.ClienteDao</property-class>
            <value>#{clienteDao}</value>
        </managed-property>
    </managed-bean>
    
    <managed-bean>
        <managed-bean-name>tipotransaccionBean</managed-bean-name>
        <managed-bean-class>com.ues.bean.TipoTransaccionBean</managed-bean-class>
    
        <managed-bean-scope>session</managed-bean-scope>
        <managed-property>
            <property-name>tipotransaccionDao</property-name>
            <property-class>com.ues.dao.TipoTransaccionDao</property-class>
            <value>#{tipotransaccionDao}</value>
        </managed-property>
    </managed-bean>
    
    
    <managed-bean>
        <managed-bean-name>telefonoBean</managed-bean-name>
        <managed-bean-class>com.ues.bean.TelefonoBean</managed-bean-class>
    
        <managed-bean-scope>session</managed-bean-scope>
        <managed-property>
            <property-name>telefonoDao</property-name>
            <property-class>com.ues.dao.TelefonoDao</property-class>
            <value>#{telefonoDao}</value>
        </managed-property>
    </managed-bean>
    
    
    
     <managed-bean>
        <managed-bean-name>transaccionBean</managed-bean-name>
        <managed-bean-class>com.ues.bean.TransaccionBean</managed-bean-class>
    
        <managed-bean-scope>session</managed-bean-scope>
        <managed-property>
            <property-name>transaccionDao</property-name>
            <property-class>com.ues.dao.TransaccionDao</property-class>
            <value>#{transaccionDao}</value>
        </managed-property>
    </managed-bean>
    
    <managed-bean>
        <managed-bean-name>tipoProveedorBean</managed-bean-name>
        <managed-bean-class>com.ues.bean.TipoProveedorBean</managed-bean-class>    
        <managed-bean-scope>session</managed-bean-scope>
        <managed-property>
            <property-name>tipoProveedorDao</property-name>
            <property-class>com.ues.dao.TipoProveedorDao</property-class>
            <value>#{tipoProveedorDao}</value>
        </managed-property>
    </managed-bean>
    
    <managed-bean>
        <managed-bean-name>proveedorBean</managed-bean-name>
        <managed-bean-class>com.ues.bean.ProveedorBean</managed-bean-class>    
        <managed-bean-scope>session</managed-bean-scope>
        <managed-property>
            <property-name>proveedorDao</property-name>
            <property-class>com.ues.dao.ProveedorDao</property-class>
            <value>#{proveedorDao}</value>
        </managed-property>
    </managed-bean>

    <managed-bean>
        <managed-bean-name>bodegaBean</managed-bean-name>
        <managed-bean-class>com.ues.bean.BodegaBean</managed-bean-class>
    
        <managed-bean-scope>session</managed-bean-scope>
        <managed-property>
            <property-name>bodegaDao</property-name>
            <property-class>com.ues.dao.BodegaDao</property-class>
            <value>#{bodegaDao}</value>
        </managed-property>
    </managed-bean>
    
    <managed-bean>
        <managed-bean-name>empleadoBean</managed-bean-name>
        <managed-bean-class>com.ues.bean.EmpleadoBean</managed-bean-class>
    
        <managed-bean-scope>session</managed-bean-scope>
        <managed-property>
            <property-name>empleadoDao</property-name>
            <property-class>com.ues.dao.EmpleadosDao</property-class>
            <value>#{empleadoDao}</value>
        </managed-property>
    </managed-bean>
    
    <managed-bean>
        <managed-bean-name>loteBean</managed-bean-name>
        <managed-bean-class>com.ues.bean.LoteBean</managed-bean-class>
    
        <managed-bean-scope>session</managed-bean-scope>
        <managed-property>
            <property-name>loteDao</property-name>
            <property-class>com.ues.dao.LoteDao</property-class>
            <value>#{loteDao}</value>
        </managed-property>
    </managed-bean>
    
</faces-config>

// IDEX.XHTML VIERNES 12 DE JUNIO
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:fn="http://java.sun.com/jsp/jstl/functions"
      xmlns:p="http://primefaces.org/ui">
    <f:view>
        <h:head>
            <title>Ejemplo JSF 2.0, Spring 3, Hibernate 3, MySQL</title>
            <style type="text/css">
                .liga {
                    border: 1px;
                    text-decoration: none;
                    color: darkgray;
                }
            </style>
        </h:head>
        <h:body>
            <br/>
            <h3>Ejemplo de JSF 2.0, Spring 3, Hibernate 3, MySQL</h3>
            ver : <h:outputLink value="usuarios.jsf" styleClass="liga"><h:outputText value="usuarios" /></h:outputLink>
            ver : <h:outputLink value="personas.jsf" styleClass="liga"><h:outputText value="personas" /></h:outputLink>
            ver : <h:outputLink value="tipo_usuarios.jsf" styleClass="liga"><h:outputText value="tipo usuarios" /></h:outputLink>
            ver : <h:outputLink value="tipo_productos.jsf" styleClass="liga"><h:outputText value="tipo productos" /></h:outputLink>
            ver : <h:outputLink value="tipo_devolucion.jsf" styleClass="liga"><h:outputText value="tipo devolucion" /></h:outputLink>
            ver : <h:outputLink value="recursos.jsf" styleClass="liga"><h:outputText value="recursos" /></h:outputLink>
            ver : <h:outputLink value="tiposcliente.jsf" styleClass="liga"><h:outputText value="tipos cliente" /></h:outputLink>
            ver : <h:outputLink value="clientes.jsf" styleClass="liga"><h:outputText value="cliente" /></h:outputLink>
            ver : <h:outputLink value="tipotransacciones.jsf" styleClass="liga"><h:outputText value="tipo transaccion" /></h:outputLink>       
            ver : <h:outputLink value="telefonos.jsf" styleClass="liga"><h:outputText value="teléfono" /></h:outputLink>   
            ver : <h:outputLink value="transacciones.jsf" styleClass="liga"><h:outputText value="transacciones" /></h:outputLink>   
            ver : <h:outputLink value="tipoproveedor.jsf" styleClass="liga"><h:outputText value="TIPO PROVEEDOR" /></h:outputLink>
            ver : <h:outputLink value="bodega.jsf" styleClass="liga"><h:outputText value="BODEGA" /></h:outputLink>
            ver : <h:outputLink value="proveedor.jsf" styleClass="liga"><h:outputText value="PROVEEDOR" /></h:outputLink>
            ver : <h:outputLink value="empleado.jsf" styleClass="liga"><h:outputText value="EMPLEADO" /></h:outputLink>  
            ver : <h:outputLink value="lote.jsf" styleClass="liga"><h:outputText value="LOTE" /></h:outputLink>  




            <h:form>
                <p:dataTable id="tbl" var="car" value="fghfgh"
                             paginatorTemplate="{CurrentPageReport}  {FirstPageLink} {PreviousPageLink} {PageLinks} {NextPageLink} {LastPageLink} {Exporters}"
                             paginator="true" rows="10" style="margin-bottom:20px">



                    <p:column>
                        <f:facet name="header">
                            <h:outputText value="Id" />
                        </f:facet>
                        <h:outputText value="fghfghf" />
                    </p:column>

                    <p:column>
                        <f:facet name="header">
                            <h:outputText value="Year"/>
                        </f:facet>
                        <h:outputText value="fghgfhfh" />
                    </p:column>

                    <p:column>
                        <f:facet name="header">
                            <h:outputText value="Brand" />
                        </f:facet>
                        <h:outputText value="fghgfh" />
                    </p:column>

                    <p:column>
                        <f:facet name="header">
                            <h:outputText value="Color" />
                        </f:facet>
                        <h:outputText value="fghfh" />
                    </p:column>
                </p:dataTable>


            </h:form>
        </h:body>
    </f:view>
</html>*/