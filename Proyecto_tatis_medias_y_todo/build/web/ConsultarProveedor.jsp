
<%@page import="Util.ConexionDB"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloVO.EmpresaProveedoraVO"%>
<%@page import="ModeloDAO.EmpresaProveedoraDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <!--Made with love by Mutiullah Samim -->

        <!--Bootsrap 4 CDN-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <!--Fontawesome CDN-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

        <!--Custom styles-->
        <link href="Estilos/estilos2.css" rel="stylesheet" type="text/css"/>
        

    </head>

    <body>

    <center>
        <div>

            <h1>Consultar Empresa</h1>
   <%
    ConexionDB con = new ConexionDB();
    Statement smt;
    ResultSet rs;
    smt = con.obtenerConexion().createStatement();
    rs = smt.executeQuery("select * from empresaproveedora");
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
    rs=smt.executeQuery("select* from empresaproveedora where RazonSocialEmpresaProveedora LIKE"+"'%"+nombuscar+"%' OR  NombreComercialEmpresaProveedora LIKE"+"'%"+nombuscar+"%' OR  EstadoEmpresaProveedora LIKE"+"'%"+nombuscar+"%'");

}else{
    System.err.print("Error");
}
                 %>
                     
        </div>
                  <div class="container">               
            <a  class="btn btn-success" href="registrarProveedor.jsp">Nuevo Registro</a>         
             <table class="table table-bordered"  id="tablaDatos">
                    <thead>
                        <tr>
                            
                           <th class="text-center">Razon Social</th>
                            <th class="text-center">Nombre Empresa</th>
                            <th class="text-center">Estado Empresa</th>
                            <th class="text-center">Acciones</th>
                        </tr>
                    </thead>
                    <tbody id="tbodys">
                        <%
                            while (rs.next()) {
                        %>
                        <tr>
                             <td class="text-center"><%= rs.getString("RazonSocialEmpresaProveedora")%></td>
                             <td class="text-center"><%= rs.getString("NombreComercialEmpresaProveedora")%></td>
                             <td class="text-center"><%= rs.getString("EstadoEmpresaProveedora")%></td>
                             <td class="text-center">
                                
                                <!-- <input type="hidden" value="<//%= rs.getInt("IdPedido")%>" id="Editar"/>
                                <input type="submit" class="btn btn-warning" data-toggle="modal" data-target="#myModal1" value="Editar"/>  -->
                                <a href="ActualizarProveedor.jsp?IdEmpresaProveedora=<%= rs.getInt("IdEmpresaProveedora")%>" class="btn btn-primary">Editar</a>
                                <a href="Eliminar.jsp?IdEmpresaProveedora=<%= rs.getInt("IdEmpresaProveedora")%>" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                        <%}%>
                </table>
                       
        <script src="js/jquery.js" type="text/javascript"></script>             
        <script src="js/bootstrap.min.js" type="text/javascript"></script>    

          


    </center>
</body>

</html>