<%-- 
    Document   : eliminarDP
    Created on : 16/08/2022, 05:52:09 PM
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
        <form method="post" action="DetallePedido">
            <table>
                <tr>
                    <th>Id pedido
                        <input type="number" name="textIdPedidoFK" >
                        <button>Eliminar</button>
                    </th>
                </tr>
                 
             
            </table><br><br>
            <input type="hidden"value="3"  name="opcion">
            
            
            
            
        </form><br><br>
               <%
        if (request.getAttribute("mensajeError")  !=null) {%>
         ${MensajeError} 
           <%  }  else {%>
                   ${mensajeExito}
                   <%}%><br><br>
    </body>
</html>