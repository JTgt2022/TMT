<%-- 
    Document   : ConsultarCliente
    Created on : 16/08/2022, 06:38:46 PM
    Author     : User
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="Util.ConexionDB"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.ClienteDAO"%>
<%@page import="ModeloVO.ClienteVO"%>
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
  <center>   <h1>Cliente</h1></center>
           <%
            //CONECTANOD A LA BASE DE DATOS:
                  
    ConexionDB con = new ConexionDB();
    Statement smt;
    ResultSet rs;
    smt = con.obtenerConexion().createStatement();
    rs = smt.executeQuery("select * from Cliente");
%>
    
            
        %>
        <div class="container">            
            <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#myModal">New Add</button>
            <div style="padding-left: 800px">                  
               <div  class="container buscar">
                 <form class="form">
                <input type="text" name="txtbuscar">
                <input type="submit" value="Buscar">
            </form>            
                   
                      <% 
String nombuscar=request.getParameter("txtbuscar");
if(nombuscar!=null){
    smt=con.obtenerConexion().createStatement();
    rs=smt.executeQuery("select* from Cliente where NumeroDocCliente LIKE "+"'%"+nombuscar+"%'OR NombreCliente LIKE"+"'%"+nombuscar+"%' OR ApellidoCliente LIKE"+"'%"+nombuscar+"%' OR EstadoCliente LIKE"+"'%"+nombuscar+"%'");
    
    
    
}else{
    System.err.print("Error");
}
                 %> 
            </div>
        </div>  
              
        <br>
        <div class="container">               
            <!--<a  class="btn btn-success" href="Agregar.jsp">Nuevo Registro</a> Esto es Cuando se Crea un nuevo Archivo Agregar.jsp -->         
             <table class="table table-bordered"  id="tablaDatos">
                    <thead>
                        <tr>
                            <th class="text-center">Id</th>
                            <th class="text-center">Nombres</th>
                            <th class="text-center">Apellidos</th>
                            <th class="text-center">Numero Documento</th>
                            <th class="text-center">Estado</th>
                            <th class="text-center">Acciones</th>
                        </tr>
                    </thead>
                    <tbody id="tbodys">
                        <%
                            while (rs.next()) {
                        %>
                        <tr>
                            <td class="text-center"><%= rs.getInt("IdCliente")%></td>
                             <td class="text-center"><%= rs.getString("NombreCliente")%></td>
                             <td class="text-center"><%= rs.getString("ApellidoCliente")%></td>
                            <td><%= rs.getString("NumeroDocCliente")%></td>
                            <td class="text-center"><%= rs.getString("EstadoCliente")%></td>
                            <td class="text-center">
                                
                                <!-- <input type="hidden" value="<//%= rs.getInt("Id_Usuario")%>" id="Editar"/>
                                <input type="submit" class="btn btn-warning" data-toggle="modal" data-target="#myModal1" value="Editar"/>  -->
                                <a href="ActualizarCliente.jsp?IdCliente=<%= rs.getInt("IdCliente")%>" class="btn btn-primary">Editar</a>
                                <a href="EliminarCliente.jsp?IdCliente=<%= rs.getInt("IdCliente")%>" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                        <%}%>
                </table>
                       
        <script src="js/jquery.js" type="text/javascript"></script>             
        <script src="js/bootstrap.min.js" type="text/javascript"></script>        
                    
    </body>
</html>
