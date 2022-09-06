<%-- 
    Document   : ActualizarUsuario
    Created on : 12/08/2022, 05:41:14 PM
    Author     : User
--%>

<%@page import="ModeloVO.UsuarioVO"%>
<%@page import="ModeloVO.RolVO"%>
<%@page import="ModeloDAO.RolDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jsp Page</title>
        <!--Made with love by Mutiullah Samim -->

        <!--Bootsrap 4 CDN-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <!--Fontawesome CDN-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

        <!--Custom styles-->

        <link href="Estilos/estilos2.css" rel="stylesheet" type="text/css"/>
        <link href="Estilos/estilos2.css" rel="stylesheet" type="text/css"/>
    </head>

    <%
        if (request.getAttribute("usuarioConsultado") != null) {
            UsuarioVO usuVO = (UsuarioVO) request.getAttribute("usuarioConsultado");
      

    %>
    <center>
        <body>
            <h1>Actualizar Usuario</h1>
            <form method="post" action="Usuario">
                <table>

                    <tr>
                        Id Usuario<br>
                    <input type="text" readonly name="textId" value="<%=usuVO.getIdUsuario()%>"><br><br>


                    Nombre Usuario<br>
                    <input type="text" name="textUsuario" value="<%=usuVO.getNombreUsuario()%>"><br><br>


                    Contraseña<br>

                    <input type="password" name="textClave" value="<%=usuVO.getPasswordUsuario()%>"><br><br>

                    Estado Usuario<br>

                    <input type="Text" name="textEstado" value="<%=usuVO.getEstadoUsuario()%>"><br><br>
                    
                   
                   
                    </select><br><br>
                    </tr>


                </table><br>
                <button> Actualizar Usuario</button>
                <input type="hidden" value="2" name="opcion">



            </form>
           
       <%
         if (request.getAttribute("MensajeError") != null) {%>
                ${MensajeError}
           <% }else{ %>
           ${MensajeExito}
           <%}%>
        <% } %>

            </div>
    </center>
</body>
</html>