<%@page import="Util.ConexionDB"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloVO.ProductoVO"%>
<%@page import="ModeloDAO.ProductoDAO"%>
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

            <h1>Consultar Producto</h1>
  <%
    ConexionDB con = new ConexionDB();
    Statement smt;
    ResultSet rs;
    smt = con.obtenerConexion().createStatement();
    rs = smt.executeQuery("select * from producto");
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
    rs=smt.executeQuery("select* from producto where CodigoDeBarrasProducto LIKE"+"'%"+nombuscar+"%' OR ReferenciaProducto  LIKE"+"'%"+nombuscar+"%' OR DescripcionProducto LIKE"+"'%"+nombuscar+"%' OR StockProducto  LIKE"+"'%"+nombuscar+"%' OR  PrecioUnitario LIKE"+"'%"+nombuscar+"%'");

}else{
    System.err.print("Error");
}
                 %>

            

                    <div class="container">               
                         <a  class="btn btn-success" href="registrarProducto.jsp">Nuevo Registro</a>
                        <table class="table table-bordered"  id="tablaDatos">
                            <thead>
                                <tr>
                                    <th class="text-center">Codigos Disponibles</th>
                                    <th class="text-center">Referencia</th>
                                    <th class="text-center">Descripcion</th>
                                    <th class="text-center">Stock disponible</th>
                                    <th class="text-center">Precio por unidad</th>
                                    <th class="text-center">Acciones</th>
                                </tr>
                            </thead>
                            <tbody id="tbodys">
                            <br><br><br>

                            <%
                                while (rs.next()) {
                            %>

                            <tr>
                                <td class="text-center"><%= rs.getString("CodigoDeBarrasProducto")%></td>
                                <td class="text-center"><%= rs.getString("ReferenciaProducto")%></td>
                                <td class="text-center"><%= rs.getString("DescripcionProducto")%></td>
                                 <td class="text-center"><%= rs.getString("StockProducto")%></td>
                                  <td class="text-center"><%= rs.getString("PrecioUnitario")%></td>

                        <td class="text-center">
                                
                                <!-- <input type="hidden" value="<//%= rs.getInt("IdPedido")%>" id="Editar"/>
                                <input type="submit" class="btn btn-warning" data-toggle="modal" data-target="#myModal1" value="Editar"/>  -->
                                <a href="ActuaizarProducto.jsp?IdProducto=<%= rs.getInt("IdProducto")%>" class="btn btn-primary">Editar</a>
                                <a href=".jsp?IdProducto=<%= rs.getInt("IdProducto")%>" class="btn btn-danger">Delete</a>
                            </td>


                            </tr>
                            <%}%>
                        </table>    
                    </div>   


                </form>
            </div>




            <%
                if (request.getAttribute("MensajeError") != null) {%>

            ${MensajeError}
            <% } else { %>
            ${MensajeExito}


            <% }%>



    </center>
</body>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</html>