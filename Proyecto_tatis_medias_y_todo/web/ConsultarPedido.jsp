<%-- 
    Document   : ConsultarPedido
    Created on : 6/08/2022, 07:02:53 PM
    Author     : Alexis
--%>

<%@page import="Util.ConexionDB"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloVO.PedidoVO"%>
<%@page import="ModeloDAO.PedidoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
     <link href="Estilos/estilos2.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Pedido</title>
         <center>  <h1>Pedido</h1></center>
        <%
    ConexionDB con = new ConexionDB();
    Statement smt;
    ResultSet rs;
    smt = con.obtenerConexion().createStatement();
    rs = smt.executeQuery("select * from pedido");
%>
    </head>
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
    rs=smt.executeQuery("select* from pedido where NumeroFacturaPedido LIKE"+"'%"+nombuscar+"%'");

}else{
    System.err.print("Error");
}
                 %>
                     
        </div>
                  <div class="container">               
            <a  class="btn btn-success" href="registrarPedido.jsp">Nuevo Registro</a>         
             <table class="table table-bordered"  id="tablaDatos">
                    <thead>
                        <tr>
                            <th class="text-center">Id Pedido </th>
                            <th class="text-center">No. Factura</th>
                            <th class="text-center">Fecha Pedido</th>
                            <th class="text-center">Fecha Recibido</th>
                            <th class="text-center">Fecha Vencimiento de Pago</th>
                            <th class="text-center">Id Empresa Proveedora FK</th>
                             <th class="text-center">Iva</th>
                              <th class="text-center">Estado Pedido</th>
                              <th class="text-center">Acciones</th>
                        </tr>
                    </thead>
                    <tbody id="tbodys">
                        <%
                            while (rs.next()) {
                        %>
                        <tr>
                            <td class="text-center"><%= rs.getInt("IdPedido")%></td>
                             <td class="text-center"><%= rs.getString("NumeroFacturaPedido")%></td>
                             <td class="text-center"><%= rs.getString("FechaPedido")%></td>
                            <td><%= rs.getString("FechaRecibido")%></td>
                            <td class="text-center"><%= rs.getString("FechaVencimientoPago")%></td>
                             <td><%= rs.getString("IdEmpresaProveedoraFK")%></td>
                              <td><%= rs.getString("IVA")%></td>
                               <td><%= rs.getString("EstadoPedido")%></td>
                            <td class="text-center">
                                
                                <!-- <input type="hidden" value="<//%= rs.getInt("IdPedido")%>" id="Editar"/>
                                <input type="submit" class="btn btn-warning" data-toggle="modal" data-target="#myModal1" value="Editar"/>  -->
                                <a href="actualizarPedido.jsp?IdPedido=<%= rs.getInt("IdPedido")%>" class="btn btn-primary">Editar</a>
                                <a href="EliminarPedido.jsp?IdPedido=<%= rs.getInt("IdPedido")%>" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                        <%}%>
                </table>
                       
        <script src="js/jquery.js" type="text/javascript"></script>             
        <script src="js/bootstrap.min.js" type="text/javascript"></script>        
                    

         
       
        
       <%--<form method="post" action="Pedido">
            
            <table>
                <tr>
                    <th> Id Pedido
                        <input type="number" name="txtPedido" >
                        <button>Consultar Pedido</button>
                    </th>
                </tr>
                 
             
            </table><br><br>
            <input type="hidden"value="4"  name="opcion">
            
            
            
            
        </form><br><br>--%>

    </body>
          
</html>
