<%-- 
    Document   : registrarDP
    Created on : 9/08/2022, 07:51:28 PM
    Author     : Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar</title>
    </head>
    <body>
        <center>
        <h1>Registrar Detalle Pedido</h1>
        <form method="post" action="DetallePedido" onsubmit="validarFormulario()">
            <table>
                <tr>Id pedido FK<br>
                <input type="number" id="textIdPedidoFK" name="textIdPedidoFK"><br>
                <tr>Id Producto FK<br>
                <input type="number" id="textIdProductoFK" name="textIdProductoFK"><br>
                </tr>
                <tr>Precio Unidad<br>
                <input type="number" id="textPrecio" name="textPrecio"><br>
                </tr>
                <tr>Cantidad<br>
                <input type="number" id="textCantidad"  name="textCantidad"><br>
                </tr>
            </table><br>
            <button>Registrar detalle pedido</button>
            <input type="hidden"value="1"  name="opcion" >
        </form><br>
        <%
        if (request.getAttribute("MensajeError")  !=null) {%>
         ${MensajeError} 
           <%  }  else {%>
                   ${MensajeExito}
                   <%}%>
        
        
       
        </center>
    </body>
</html>
