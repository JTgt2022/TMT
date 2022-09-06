<%-- 
    Document   : actualizarpedido
    Created on : 6/08/2022, 07:40:21 PM
    Author     : Alexis
--%>

<%@page import="ModeloVO.PedidoVO"%>
<%@include file="Sesiones.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar</title>
    </head>
    <body>
     
        <%
        if(request.getAttribute("PedidoConsultado") != null)
{
    PedidoVO PVO=(PedidoVO)request.getAttribute("PedidoConsultado");
    

%>
   <center>
<form method="post" action="Pedido">
            <table>
                <tr>
                    <th>
                        
                    Id Pedido<br>
                    <input type="number" readonly read name="txtPedido" value="<%= PVO.getIdpedido()%>"><br><br>
                      No.Factura Pedido<br>
                    <input type="text" readonly read name="txtNumeroFacturaPedido" value="<%= PVO.getNumeroFacturaPedido()%>"><br><br>
                      Fecha Pedido<br>
                    <input type="date" readonly read name="txtFechaPedido" value="<%= PVO.getFechaPedido()%>"><br><br>
                      Fecha Recibido<br>
                    <input type="date" readonly read name="txtFechaRecibido" value="<%= PVO.getFechaRecibido()%>"><br><br>
                     Fecha Vencimiento Pago<br>
                    <input type="date" readonly read name="txtFechaVencimientoPago" value="<%= PVO.getFechaVencimientoPago()%>"><br><br>
                      Id Empresa Proveedora<br>
                    <input type="number" name="txtIdEmpresaProveedora" value="<%= PVO.getIdEmpresaProveedoraFK()%>"><br><br>
                      IVA<br>
                      <input type="number" name="txtIVA" value="<%= PVO.getIVA()%>"><br><br>
                      Descuento<br>
                    <input type="number" name="txtDescuento" value="<%= PVO.getDescuento()%>"><br><br>
                      Estado Pedido<br>
                    <input type="text" name="txtEstadoPedido" value="<%= PVO.getEstadoPedido()%>"><br><br>
                    
                    
                
                
                </th>
                </tr>
            </table><br>
             <button>Actualizar</button>
            <input type="hidden" value="2" name="opcion">
</form><br><br></center>



       <%
         if (request.getAttribute("MensajeError") != null) {%>
                ${MensajeError}
           <% }else{ %>
           ${MensajeExito}
           <%}%>
           
     
        <% } %>
</body>
</html>
