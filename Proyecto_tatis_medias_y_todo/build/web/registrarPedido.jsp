<%-- 
    Document   : registrarPedido
    Created on : 6/08/2022, 06:41:53 PM
    Author     : Alexis
--%>

<%@page import="ModeloVO.EmpresaProveedoraVO"%>
<%@page import="ModeloDAO.EmpresaProveedoraDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <center>
        <h1>Registrar Pedido</h1>
        <form method="post" action="Pedido">
            <table>
                <tr> No.Factura<br>
                <input type="text" name="txtNumeroFacturaPedido"><br>
                </tr>
                <tr>Fecha Pedido<br>
                <input type="date" name="txtFechaPedido"><br>
                </tr>
                <tr>Fecha Recibido<br>
                <input type="date" name="txtFechaRecibido"><br>
                </tr>
                <tr>Fecha Vencimiento pago<br>
                <input type="date" name="txtFechaVencimientoPago"><br>
                </tr>
                <tr>Id Empresa Proveedora<br>
                 <select name="txtIdEmpresaProveedora">
                        <option>Seleccione una opción</option>
                        <%
                            EmpresaProveedoraDAO epDAO = new EmpresaProveedoraDAO();
                            for(EmpresaProveedoraVO epVO : epDAO.Listar()) {
                         %>
                         <option value="<%=epVO.getIdEmpresaProveedora()%>"><%=epVO.getRazonSocialEmpresaProveedora()%></option>
                                 
                                 
                          <%}%>       
                    </select> <br> <br>

                </tr>
                <tr>IVA<br>
                <input type="number" name="txtIVA"><br>
                </tr>
                <tr>Descuento <br>
                <input type="number" name="txtDescuento"><br>
                </tr>
                <tr>Estado Pedido<br>
                <select name="txtEstadoPedido">
                    <option>Seleccione una opción</option>
                <option>Entregado</option>
                <option>Pago</option>
                </select> <br> <br>
                </tr>
            </table><br>
            <button>Registrar pedido</button>
            <input type="hidden"value="1"  name="opcion">
            
             <button type="submit"  class="btn float-right login_btn"> <a href="ConsultarPedido.jsp"> Ver Pedidos registrados </a> </button>
                                        
            
        </form><BR>
        <%
        if (request.getAttribute("MensajeError")  !=null) {%>
         ${mensajeError} 
           <%  }  else {%>
                   ${MensajeExito}
                   <%}%>
        
        
       
       </center>
    </body>
</html>
