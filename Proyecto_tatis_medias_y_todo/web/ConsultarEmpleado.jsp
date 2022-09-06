<%-- 
    Document   : consultarEmpleado
    Created on : 15/08/2022, 06:25:15 PM
    Author     : User
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Util.ConexionDB"%>
<%@page import="Util.ConexionDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.EmpleadoDAO"%>
<%@page import="ModeloVO.EmpleadoVO"%>
<%@page import="ModeloVO.UsuarioVO"%> 
<%@page import="ModeloDAO.UsuarioDAO"%> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="Estilos/estilos2.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Consultar</title>
    </head>
 
          <center>
        <h1>Empleado</h1>
         <%
    ConexionDB con = new ConexionDB();
    Statement smt;
    ResultSet rs;
    smt = con.obtenerConexion().createStatement();
    rs = smt.executeQuery("select * from Empleado");
%>
   <body>
        <center>
         
            <div style="padding-left: 800px">    
             <div  class="container buscar">
                 <center>
                 <form class="form">
                <input type="text" name="txtbuscar">
                <input type="submit" value="Buscar">
                 </form></center></center>
                 <% 
String nombuscar=request.getParameter("txtbuscar");
if(nombuscar!=null){
    smt=con.obtenerConexion().createStatement();
    rs=smt.executeQuery("select* from empleado where NombreEmpleado LIKE"+"'%"+nombuscar+"%' OR ApellidoEmpleado LIKE"+"'%"+nombuscar+"%' OR TipoDocEmpleado LIKE"+"'%"+nombuscar+"%' OR NumeroDocEmpleado LIKE"+"'%"+nombuscar+"%' OR TelefonoCelularEmpleado LIKE"+"'%"+nombuscar+"%' OR DirecionEmpleado LIKE"+"'%"+nombuscar+"%' OR CorreoEmpleado LIKE"+"'%"+nombuscar+"%' OR EstadoEmpleado LIKE"+"'%"+nombuscar+"%'");

}else{
    System.err.print("Error");
}
                 %>
                     
        </div>
                  <div class="container">               
            <a  class="btn btn-success" href="registrarEmpleado.jsp">Nuevo Registro</a>         
             <table class="table table-bordered"  id="tablaDatos">
                    <thead>
                        <tr>
                            <th class="text-center">IdEmpleado</th>
                            <th class="text-center">NombreEmpleado</th>
                            <th class="text-center">ApellidoEmpleado</th>
                            <th class="text-center">TipoDocumento</th>
                            <th class="text-center">NumeroDocumento</th>
                            <th class="text-center">Telefono</th>
                            <th class="text-center">Direccion</th>
                            <th class="text-center">Correo Electronico</th>
                            <th class="text-center">Estado</th>
                            <th class="text-center">IdUsuarioFK</th>
                            <th class="text-center">Acciones</th>
                        </tr>
                    </thead>
                    <tbody id="tbodys">
                        <%
                            while (rs.next()) {
                        %>
                        <tr>
                             
                             <td class="text-center"><%= rs.getInt("IdEmpleado")%></td>
                             <td class="text-center"><%= rs.getString("NombreEmpleado")%></td>
                             <td class="text-center"><%= rs.getString("ApellidoEmpleado")%></td>
                             <td><%= rs.getString("TipoDocEmpleado")%></td>
                             <td class="text-center"><%= rs.getString("NumeroDocEmpleado")%></td>
                             <td><%= rs.getString("TelefonoCelularEmpleado")%></td>
                             <td><%= rs.getString("DirecionEmpleado")%></td>
                             <td><%= rs.getString("CorreoEmpleado")%></td>
                             <td><%= rs.getString("EstadoEmpleado")%></td>
                             <td><%= rs.getString("IdUsuarioFK")%></td>
                            <td class="text-center">
                                
                                <!-- <input type="hidden" value="<//%= rs.getInt("IdPedido")%>" id="Editar"/>
                                <input type="submit" class="btn btn-warning" data-toggle="modal" data-target="#myModal1" value="Editar"/>  -->
                                <a href="ActualizarEmpleado.jsp?IdEmpleado=<%= rs.getInt("IdEmpleado")%>" class="btn btn-primary">Editar</a>
                                <a href="EliminarEmpleado.jsp?IdEmpleado=<%= rs.getInt("IdEmpleado")%>" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                        <%}%>
                </table>
                       
        <script src="js/jquery.js" type="text/javascript"></script>             
        <script src="js/bootstrap.min.js" type="text/javascript"></script>        
                    
      <%-- <form method="post" action="Empleado">
            <table>
                <tr>
                    <th> Numero de documento
                        <input type="number" name="textNumDoc" >
                        <button>Consultar </button>
                        
                    </th>
                </tr>
                 
             
            </table><br><br>
            <input type="hidden" value="3"  name="opcion">--%>
            
            
            
            
        
          </center>
    </body>
</html>
