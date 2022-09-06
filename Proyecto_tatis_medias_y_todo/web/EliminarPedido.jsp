<%-- 
    Document   : EliminarPedido
    Created on : 6/08/2022, 08:28:44 PM
    Author     : Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedido</title>
    </head>
    <body>
        
                <center>
        <h1>Pedido</h1>
        <form method="post" action="Pedido">
            <table>
                <tr>
                    <th>No.Factura
                        <input type="text" name="txtNumeroFacturaPedido" >
                        <button>Eliminar</button>
                    </th>
                </tr>
                 
             
            </table><br><br>
            <input type="hidden"value="3"  name="opcion">
            
            
            
            
        </form><br><br>
               <%
        if (request.getAttribute("MensajeError")  !=null) {%>
         ${MensajeError} 
           <%  }  else {%>
                   ${MensajeExito}
                   <%}%><br><br>
    </body>
</html>

