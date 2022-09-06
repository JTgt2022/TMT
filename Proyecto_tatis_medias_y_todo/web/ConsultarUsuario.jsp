<%-- 
    Document   : ConsultarUsuario
    Created on : 12/08/2022, 05:26:13 PM
    Author     : User
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Util.ConexionDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link href="Estilos/estilos2.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Consultar</title>
    </head>
  <body>
          <center>
              <h1>Usuario</h1>
         <%
            //CONECTANOD A LA BASE DE DATOS:
                  
    ConexionDB con = new ConexionDB();
    Statement smt;
    ResultSet rs;
    smt = con.obtenerConexion().createStatement();
    rs = smt.executeQuery("select * from Usuario");
%>
 <div class="container">            
            
             <a  class="btn btn-success" href="registrarUsuario.jsp">Nuevo Registro</a>  
            <div style="padding-left: 800px">                  
               <div  class="container buscar">
                 <form class="form">
                <input type="text" name="txtbuscar">
                <input type="submit" value="Buscar">
            </form></center>
                         <% 
String nombuscar=request.getParameter("txtbuscar");
if(nombuscar!=null){
    smt=con.obtenerConexion().createStatement();
    rs=smt.executeQuery("select* from Usuario where NombreUsuario LIKE"+"'%"+nombuscar+"%' OR EstadoUsuario LIKE"+"'%"+nombuscar+"%'");
}else{
    System.err.print("Error");
}
                 %> 
                   
        <for<div class="container">               
            <!--<a  class="btn btn-success" href="Agregar.jsp">Nuevo Registro</a> Esto es Cuando se Crea un nuevo Archivo Agregar.jsp -->         
             <table class="table table-bordered"  id="tablaDatos">
                 <thead>
                        <tr>
                            <th class="text-center">Id </th>
                            <th class="text-center">Nombres</th>
                            <th class="text-center">Estado</th>
                                 <th class="text-center">Acciones</th>
                        </tr>
                        </thead>
v                    <tbody id="tbodys">
                        <%
                            while (rs.next()) {
                        %>
                        <tr>
                            <td class="text-center"><%= rs.getInt("IdUsuario")%></td>
                             <td class="text-center"><%= rs.getString("NombreUsuario")%></td>                                                
                            <td class="text-center"><%= rs.getString("EstadoUsuario")%></td>
                            <td class="text-center">
                                
                                <!-- <input type="hidden" value="<//%= rs.getInt("Id_Usuario")%>" id="Editar"/>
                                <input type="submit" class="btn btn-warning" data-toggle="modal" data-target="#myModal1" value="Editar"/>  -->
                                <a href="ActualizarUsuario.jsp?IdUsuario=<%= rs.getInt("IdUsuario")%>" class="btn btn-primary">Editar</a>
                                <a href="EliminarUsuario.jsp?IdUsuario=<%= rs.getInt("IdUsuario")%>" class="btn btn-danger">Delete</a>
                            </td>
                            </tr>
                        <%}%>
                       
                        
                </table>
                       
        <script src="js/jquery.js" type="text/javascript"></script>             
        <script src="js/bootstrap.min.js" type="text/javascript"></script>        
                    
    </body>
</html>


 
