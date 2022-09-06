<%-- 
    Document   : ActualizarCliente
    Created on : 16/08/2022, 06:46:39 PM
    Author     : User
--%>

<%@page import="ModeloVO.ClienteVO"%>
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
      <%
        if (request.getAttribute("clienteConsultado") != null) {
            ClienteVO ClVO = (ClienteVO) request.getAttribute("clienteConsultado");
      

    %>
<center>
<body>

    <div class="contenedor">      

        <center>
            <h1 class="titulo">Actualizar Cliente</h1>
        <form method="post" action="Cliente">
            <table>
                
                <tr>
                   
                <div class="campos">ID Cliente</div>
                <input type="Number" name="TextId" value="<%=ClVO.getIdCliente()%>" readonly><br><br>
                
               
                <div class="campos">Nombre Cliente</div>
                <input type="text" name="TextNombre"value="<%=ClVO.getNombreCliente()%>"><br><br>
                        
                    <div class="campos"> Apellido Cliente</div>
                    <input type="text" name="TextApellido"value="<%=ClVO.getApellidoCliente()%>"><br><br>
                                       
                    <div class="campos">  Tipo Documento</div>
                    <input type="text" name="TextTipo"readonly="" value="<%=ClVO.getTipoDocCliente()%>"><br><br>
                    
                      <div class="campos">  Numero Documento</div>
                      <input type="number" name="TextNumDoc" readonly=""value="<%=ClVO.getNumeroDocCliente()%>"><br><br>
                  
                     <div class="campos">  Telefono Cliente</div>
                     <input type="number" name="TextTelefono"value="<%=ClVO.getTelefonoCliente()%>"><br><br>
                    
                     <div class="campos"> Direccion Cliente</div>
                     <input type="text" name="TextDir"value="<%=ClVO.getDirecionCliente()%>"><br><br>
                    
                      <div class="campos">  Correo Cliente</div>
                      <input type="email" name="TextCorreo"value="<%=ClVO.getCorreoCliente()%>"><br><br>
                    
                      <div class="campos">  Estado Cliente</div>
                      <input type="text" name="TextEstado"value="<%=ClVO.getEstadoCliente()%>"><br><br>
                    
                    
                </tr>
                
                 
                    
                
            </table><br>
           
      
        <div class="form-group">	
        <input type="hidden" value="2" name="opcion" class="btn float-right login_btn">
        <button type="submit" class="btn float-right login_btn" > Actualizar</button>
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
                                        <%}%>
                    </div>
    </body>
    </center>
</html>
