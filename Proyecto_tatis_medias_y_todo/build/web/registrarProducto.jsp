<%-- 
    Document   : registrarProducto
    Created on : 3/08/2022, 04:35:47 PM
    Author     : jtgt2
--%>

<%@page import="ModeloVO.EmpresaProveedoraVO"%>
<%@page import="ModeloDAO.EmpresaProveedoraDAO"%>
<%@page import="ModeloVO.CategoriaVO"%>
<%@page import="ModeloDAO.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp"%>
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
            <h1 class="titulo">Registrar Producto</h1>
        <form method="post" action="Producto">
            <table>
                
                <tr>
                   
                <div class="campos">Codigo De barras Producto</div>
                <input type="text" name="txtcodigoB"><br><br>
                        
                    <div class="campos"> Referencia</div>
                    
                    <input type="text" name="txtreferencia"><br><br>
                    
                    <div class="campos">Descripcion de Producto</div>
                    
                <input type="text" name="txtdescripcion"><br><br>
                    
                    <div class="campos">Stock Dsiponible</div>
                    
                    <input type="number" name="txtstock"><br><br>
                    
                    
                      <div class="campos">Precio Unitario Producto</div>
                <input type="number" name="txtprecio"><br><br>
                   
                <div class="campos">Estado del producto</div>
                <input type="text" name="txtestado"><br><br>
                   

              <div class="campos">Categoría</div>
                    
                    <select name="txtcategoria">
                        <option>Seleccione una opción</option>
                        <%
                            CategoriaDAO catDAO = new CategoriaDAO();
                            for(CategoriaVO catVO : catDAO.Listar()) {
                         %>
                         <option value="<%=catVO.getIdCategoria()%>"><%=catVO.getNombreCategoria()%></option>
                                 
                                 
                          <%}%>       
                    </select> <br> <br>
                    
                    
                    <div class="campos">Empresa</div>
                    
                    <select name="txtempresa">
                        <option>Seleccione una opción</option>
                        <%
                            EmpresaProveedoraDAO epDAO = new EmpresaProveedoraDAO();
                            for(EmpresaProveedoraVO epVO : epDAO.Listar()) {
                         %>
                         <option value="<%=epVO.getIdEmpresaProveedora()%>"><%=epVO.getRazonSocialEmpresaProveedora()%></option>
                                 
                                 
                          <%}%>       
                    </select> <br> <br>

                   

                    
                    
                </tr>
                
                 </div>
                    
                
            </table><br>
                                         <div class="form-group">	
                                         <input type="hidden" value="1" name="opcion" class="btn float-right login_btn">
                                         <button type="submit" class="btn float-right login_btn" > Registrar Producto</button>
            
                                         
                                         <button type="submit"  class="btn float-right login_btn"> <a href="ConsultarProducto.jsp"> Ver Productos registrados </a> </button>
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