<%-- 
    Document   : consultarDP
    Created on : 9/08/2022, 08:29:20 PM
    Author     : Alexis
--%>

<%@page import="ModeloDAO.DetallePDAO"%>
<%@page import="java.util.ArrayList"%>

<%@page import="ModeloVO.DetallePedidoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Detalle Pedido</h1>
        <form method="post" action="DetallePedido">
            <table>
                <tr>
                    <th> Id Pedido
                        <input type="number" name="textIdPedidoFK" >
                        <button>Consultar  detalle Pedido</button>
                    </th>
                </tr>
                 
             
            </table><br><br>
            <input type="hidden"value="4"  name="opcion">
                              <%
        if (request.getAttribute("MensajeError")  !=null) {%>
         ${MensajeError} 
           <%  }  else {%>
                   ${MensajeExito}
                   <%}%><br><br>
                   
                      <form>
                       <table border="1">
                           <tr>
                               <th>IdPedidoFK</th>
                               <th>IdProductoFK</th>
                               <th>Preciounitario</th>
                                <th>cantidad</th>
                                 
                          
                             
                           </tr>
                           <%
                               DetallePedidoVO  DPVO= new DetallePedidoVO();
                               DetallePDAO DPDAO= new DetallePDAO();
                               ArrayList<DetallePedidoVO> Listadetallepedido=DPDAO.listar();
                               for (int i = 0; i < Listadetallepedido .size(); i++) {
                                       DPVO =Listadetallepedido.get(i);
                                   
                           %>
                           <tr>
                               <td><%=DPVO.getIdPedidoFK()%></td>
                               <td><%=DPVO.getIdProductoFK()%></td>
                               <td><%=DPVO.getPrecioUnitario()%></td>
                               <td><%=DPVO.getCantidad()%></td>

                               
                               
                           </tr>
                           <%}%>
                       </table>
                   </form>
          </center>
    </body>
          
</html>

    </body>
</html>
