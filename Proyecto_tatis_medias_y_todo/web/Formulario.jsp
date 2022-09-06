<%-- 
    Document   : Formulario
    Created on : 21/06/2022, 11:55:48 AM
    Author     : juanb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Correo con JAVA MAIl</h1>
        <form action="ParametrosCorreo" method="post">
            <label>Destino</label>
            <br>
            <input type="email" name="destinatario">
            <label>Asunto</label>
            <br>
            <input type="text" name="asunto">
            <label>Mensaje</label>
            <br>
            <textarea rows="10" name="contenido"></textarea>
            <br>
            <input type="submit" value="Enviar">

        </form>
    </body>
</html>
