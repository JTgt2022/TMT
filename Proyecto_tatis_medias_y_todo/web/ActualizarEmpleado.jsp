<%-- 
    Document   : actualizarEmpleado
    Created on : 13/08/2022, 12:18:52 AM
    Author     : User
--%>

<%@page import="ModeloVO.EmpleadoVO"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
 <%
        if (request.getAttribute("empleadoConsultado") != null) {
            EmpleadoVO empVO = (EmpleadoVO) request.getAttribute("empleadoConsultado");
      

    %>
    <div class="contenedor">      

        <center>
            <h1 class="titulo">Actualizar Empleado</h1>
        <form method="post" action="Empleado">
            <table>
                
                <tr>
        
                    
                <div class="campos">Codigo Empleado</div>
                <input type="text"  name="textId" value="<%=empVO.getIdEmpleado()%>"><br><br>
                
                <div class="campos">Nombre Empleado</div>
                <input type="text"  name="textNombre" value="<%=empVO.getNombreEmpleado()%>"><br><br>
                        
                    <div class="campos"> Apellido Empleado </div>
                    <input type="text" name="textApellido" value="<%=empVO.getApellidoEmpleado()%>"><br><br>
                                       
                    <div class="campos">  Tipo Documento</div>
                    <input type="text" name="textTipo" value="<%=empVO.getTipoDocEmpleado()%>"><br><br>
                    
                      <div class="campos">  Numero Documento</div>
                      <input type="number" name="textNumDoc" readonly="" value="<%=empVO.getNumeroDocEmpleado()%>"><br><br>
                  
                     <div class="campos">  Telefono Empleado</div>
                     <input type="number" name="textTelefono" value="<%=empVO.getTelefonoCelularEmpleado()%>"><br><br>
                    
                     <div class="campos"> Direccion Empleado</div>
                     <input type="text" name="textDireccion" value="<%=empVO.getDirecionEmpleado()%>"><br><br>
                    
                      <div class="campos">  Correo Empleado</div>
                      <input type="email" name="textCorreo" value="<%=empVO.getCorreoEmpleado()%>"><br><br>
                    
                      <div class="campos">  Estado Empleado</div>
                      <input type="text" name="textEstado" value="<%=empVO.getEstadoEmpleado()%>"><br><br>
                    
                      <div class="campos">IdUsuario</div>
                      <input type="text" name="textUsuario" readonly="" value="<%=empVO.getIdUsuarioFK()%>"><br><br>
                    
                </tr>
                
                 </div>
                    
                
            </table><br>
           
      
        <div class="form-group">	
        <input type="hidden" value="2" name="opcion" class="btn float-right login_btn">
        <button type="submit" class="btn float-right login_btn" > Registrarse</button>
        </div>
        </form>
                   
        </center>
      
        </div>
      
          <div class="tres"> 
                         
                                         <% 
                                         if  (request.getAttribute("MensajeError") !=null) {%>
                                         ${MensajeError}           
               
                                         <%}else {%>
                                        ${MensajeExito}  
                                        <%}%>
                                        <%}%>
                    </div>
    </body>
    </center>
</html>
