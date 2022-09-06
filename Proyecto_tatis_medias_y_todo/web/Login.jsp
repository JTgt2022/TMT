<%-- 
    Document   : registrarUsuario
    Created on : 02/08/2022, 12:00:05 AM
    Author     : James
--%>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
             
              <link href="Estilos/estilos2.css" rel="stylesheet" type="text/css"/>

        <title>Login</title>
<!-- CSS only -->
    </head>
    <center>
         <div class="contenedor">      

    <body>

        <div class="limiter">
            <div class="container-login100" style="background-image: url('./IMG/bg-01.jpg');">
                <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
                    <form class="login100-form validate-form" method="post" action="Usuario">
                        <span class="login100-form-title p-b-49">
                            <br><br>
                            Iniciar Sesión<br><br>
                        </span>

                        <div class="wrap-input100 validate-input m-b-23" data-validate = "Usuario Obligatorio">
                            <span class="label-input100">Usuario</span>
                            <input class="input100" type="email" name="textUsuario" placeholder="Ingresar Usuario" required>
                            <span class="focus-input100" data-symbol="&#xf206;"></span>
                        </div><br><br>

                        <div class="wrap-input100 validate-input" data-validate="Contraseña Obligatorio">
                            <span class="label-input100">Contraseña</span>
                            <input class="input100" type="password" name="textClave" placeholder="Ingresar Contraseña" required>
                            <span class="focus-input100" data-symbol="&#xf190;"></span>
                        </div><br><br>
                        
                        

                        <div class="text-right p-t-8 p-b-31">
                            <a href="ConsultarUsuario.jsp">
                                ¿Contraseña olvidada?
                            </a>
                            
                            <div class="text-right p-t-8 p-b-31">
                                <a href=registrarUsuario.jsp>
                                Registrarse
                            </a>
                        </div><br><br>

                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button type="submit" class="login100-form-btn">
                                    Ingresar
                                </button>
                                <input type="hidden" value="4" name="opcion">
                            </div>
                        </div>
 <%

                        if (request.getAttribute("mensajeError") != null) {%>
                    ${mensajeError}
                    <% } else {%>
                    ${mensajeExito}
                    <%}%>
                    </form>
                   
                </div>
            </div>
        </div>


        <div id="dropDownSelect1"></div>
        </center>

    </body>
    
  </div>
</html>
