<%-- 
    Document   : registrarEmpleado
    Created on : 12/08/2022, 11:58:32 PM
    Author     : User
--%>

<%@page import="ModeloVO.UsuarioVO"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<!--Custom styles-->
      
      <link href="Estilos/estilos2.css" rel="stylesheet" type="text/css"/>
</head>
  
<center>
<body>

    <div class="contenedor">      

        <center>
            <h1 class="titulo">Registrar Empleado</h1>
        <form method="post" action="Empleado">
            <table>
                
                <tr>
                   
                <div class="campos">Nombre Empleado</div>
                <input type="text" name="textNombre"><br><br>
                        
                    <div class="campos"> Apellido Empleado </div>
                    <input type="text" name="textApellido"><br><br>
                  
                     <div class="campos">  Tipo Documento</div>
                     <select name="textTipo">
                        <option>Seleccione una opción</option>
                       <option>CC</option>
                       <option>CE</option>
                    </select> <br> <br>
                    
                      <div class="campos">  Numero Documento</div>
                     <input type="number" name="textNumDoc"><br><br>
                  
                     <div class="campos">  Telefono Empleado</div>
                     <input type="number" name="textTelefono"><br><br>
                    
                     <div class="campos"> Direccion Empleado</div>
                    <input type="text" name="textDireccion"><br><br>
                    
                      <div class="campos">  Correo Empleado</div>
                      <input type="email" name="textCorreo"><br><br>
                    
                      <div class="campos">  Estado Empleado</div>
                      <input type="text" name="textEstado"><br><br>
                    
                    <select name="textUsuario">
                    <option>Seleccione Usuario</option>
                    <%
                        UsuarioDAO usuDAO = new UsuarioDAO();
                        for(UsuarioVO usuVO: usuDAO.listar()){
                    %> 
                    <option value="<%=usuVO.getIdUsuario()%>"><%=usuVO.getNombreUsuario()%></option>
                   <%}%>
                    </select><br><br>
                </tr>
                
                 </div>
                    
                
            </table><br>
           
      
        <div class="form-group">	
        <input type="hidden" value="1" name="opcion" class="btn float-right login_btn">
        <button type="submit" class="btn float-right login_btn" > Registrarse</button>
        </div>
        </form>
                   
        </center>
      
        </div>
      
          <div class="tres"> 
                         
                                         <% 
                                         if  (request.getAttribute("mensajeError") !=null) {%>
                                         ${mensajeError}           
               
                                         <%}else {%>
                                        ${mensajeExito}  
                                        <%}%>
                                        
                    </div>
    </body>
    </center>
</html>
