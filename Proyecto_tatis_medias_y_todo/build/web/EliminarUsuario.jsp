<%-- 
    Document   : EliminarUsuario
    Created on : 12/08/2022, 10:35:46 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar</title>
    </head>
     <body>
        
                <center>
        <h1>Pedido</h1>
        <form method="post" action="Usuario">
            <table>
                <tr>
                    <th>Id Usuario
                        <input type="text" name="textId" >
                        <button>Eliminar</button>
                        <input type="hidden"value="5"  name="opcion">
                    </th>
                </tr>
                 
             
            </table><br><br>
            
            
            
            
            
        </form><br><br>
               <%
        if (request.getAttribute("MensajeError")  !=null) {%>
         ${MensajeError} 
           <%  }  else {%>
                   ${MensajeExito}
                   <%}%><br><br>
    </body>
</html>
