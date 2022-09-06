<%-- 
    Document   : EliminarCliente
    Created on : 16/08/2022, 07:31:07 PM
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
        <h1>Eliminar</h1>
        <form method="post" action="Cliente">
            <table>
                <tr>
                    <th>No.Documento
                        <input type="text" name="TextNumDoc" >
                        <button>Eliminar</button>
                        <input type="hidden"value="4"  name="opcion">
                    </th>
                </tr>
                 
             
            </table><br><br>
            
            
            
            
            
        </form><br><br>
               <%
        if (request.getAttribute("mensajeError")  !=null) {%>
         ${mensajeError} 
           <%  }  else {%>
                   ${mensajeExito}
                   <%}%><br><br>
    </body>
</html>

