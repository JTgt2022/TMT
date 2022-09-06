<%-- 
    Document   : Menu
    Created on : 9/08/2022, 07:01:38 PM
    Author     : jtgt2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenido</title>
    <link href="Estilos/css4.css" rel="stylesheet" type="text/css"/>
    <link href="Estilos/estilos2.css" rel="stylesheet" type="text/css"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
</head>
<body>
    <nav>
        <input type="checkbox" id="check">
        <label for="check" class="checkbtn">
            <i class="fas fa-bars"></i>
        </label>
        <a href="#" class="enlace">
            <img src="logo.png" alt="" class="logo">
        </a>
        <ul>
            <li><a class="active" href="#">Inicio</a></li>
            <li><a href="registrarCliente.jsp">Clientes</a></li>
            <li><a href="registrarEmpleado.jsp">Empleados</a></li>
            <li><a href="registrarPedido.jsp">Pedidos</a></li>
            <li><a href="RegistrarVenta.jsp">Ventas</a></li>
             <li><a href="registrarProducto.jsp">Productos</a></li>
             <li><a href="registrarProveedor.jsp">Proveedores</a></li>
              <li><a href="RegistrarCategoria.jsp">Categorias</a></li>
             
        </ul>
    </nav>
    <section></section>
</body>
</html>