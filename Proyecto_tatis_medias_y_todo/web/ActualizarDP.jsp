<%-- 
    Document   : ActualizarDP
    Created on : 16/08/2022, 04:48:37 PM
    Author     : Alexis
--%>

<%@page import="ModeloVO.DetallePedidoVO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar</title>
    </head>
    <body>
     
        <%
        if(request.getAttribute("DetallePedidoConsultado") != null)
{
    DetallePedidoVO DPVO=(DetallePedidoVO)request.getAttribute("DetallePedidoConsultado");
    

%>
   <center>
<form method="post" action="DetallePedido">
            <table>
                <tr>
                    <th>
                        
                    Id Pedido<br>
                    <input type="number" readonly read name="textIdpedidoFK" value="<%= DPVO.getIdPedidoFK()%>"><br><br>
                    Id Producto<br>
                    <input type="number" readonly read name="textIdProductoFK" value="<%= DPVO.getIdProductoFK()%>"><br><br>
                      Precio Unitario<br>
                    <input type="number" readonly read name="textPrecio" value="<%= DPVO.getPrecioUnitario()%>"><br><br>
                      Cantidad<br>
                    <input type="number"  name="textCantidad" value="<%= DPVO.getCantidad()%>"><br><br>
                   
                    
                    
                
                
                </th>
                </tr>
            </table><br>
             <button>Actualizar</button>
            <input type="hidden" value="2" name="opcion">
</form><br><br></center>



       <%
         if (request.getAttribute("mensajeError") != null) {%>
                ${mensajeError}
           <% }else{ %>
           ${mensajeExito}
           <%}%>
           
     
        <% } %>
</body>
</html>

