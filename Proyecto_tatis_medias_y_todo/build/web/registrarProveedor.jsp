<%-- 
    Document   : registrarProducto
    Created on : 3/08/2022, 04:35:47 PM
    Author     : jtgt2
--%>

<%@page import="ModeloVO.EmpresaProveedoraVO"%>
<%@page import="ModeloDAO.EmpresaProveedoraDAO"%>z
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login Page</title>
   <!--Made with love by Mutiullah Samim -->
   
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
            <h1 class="titulo">Registrar Empresas Proveedoras</h1>
        <form method="post" action="EmpresaProveedora">
            <table>
                
                <tr>
                   
                <div class="campos">Nit Empresa</div>
                <input type="number" name="txtNit"><br><br>
                        
                    <div class="campos"> Razon social Empresa </div>
                    
                    <input type="text" name="txtRazon"><br><br>
                    
                    <div class="campos">Nombre Comercial Empresa</div>
                    
                <input type="text" name="txtNombreC"><br><br>
                    
                    <div class="campos">Direccion De empresa</div>
                    
                    <input type="text" name="txtDireccion"><br><br>
                    
                    
                      <div class="campos">Telefono Empresa</div>
                <input type="number" name="txtTelefono"><br><br>
                   
                <div class="campos">Numero de pago</div>
                <input type="text" name="txtNumero"><br><br>
                
                <div class="campos"> Estado del Provedor</div>
                     <select name="txtEstado">
                        <option>Seleccione una opción</option>
                       <option>Activo</option>
                       <option>Inactivo</option>
                    </select> <br> <br>
                   

                
                    </select> <br> <br>

                   

                    
                    
                </tr>
                
                 </div>
                    
                
            </table><br>
                                         <div class="form-group">	
                                         <input type="hidden" value="1" name="opcion" class="btn float-right login_btn">
                                         <button type="submit" class="btn float-right login_btn" > Registrar Producto</button>
            
                                         
                                         <button type="submit"  class="btn float-right login_btn"> <a href="ConsultarProveedor.jsp"> Ver Empresas registrados </a> </button>
                                         <button type="submit"  class="btn float-right login_btn"> <a href="Menu.jsp"> Volver al menú </a> </button>
                                        
                                        </div>
        </form>
                    <div class="tres"> 
                         
                                         <% 
                                         if  (request.getAttribute("MensajeError") !=null) {%>
                                         ${MensajeError}           
               
                                         <%}else {%>
                                        ${MensajeExito}  
                                        <%}%>
                                        
                    </div>
      
        </center>
      
        </div>
      
    </body>
    </center>
</html>