<%-- 
    Document   : RegistrarCategoria
    Created on : 9/08/2022, 05:00:53 PM
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
      <link href="css/default.min.css" rel="stylesheet" type="text/css"/>
      <link href="css/alertify.min.css" rel="stylesheet" type="text/css"/>
</head>
  
<center>
<body>

    <div class="contenedor">      

        <center>
            <h1 class="titulo">Registrar Categoarias productos</h1>
            <form name="fmrCategorias" method="post" action="Categoria" onsubmit="return  validarCategorias()">
            <table>
                
                <tr>
                 
                    <div class="campos"> Nombre Categoría </div>
                    
                    <input type="text" name="txtNombre" onkeypress="return validarTexto(event) "><br><br>
                    </select> <br> <br>
           
                </tr>
                
                 </div>
                    
                
            </table><br>
                                         <div class="form-group">	
                                         <input type="hidden" value="1" name="opcion" class="btn float-right login_btn">
                                         <button type="submit" class="btn float-right login_btn" > Registrar Categoría</button>
            
                                         
                                         <button type="submit"  class="btn float-right login_btn"> <a href="ConsultarCategoria.jsp"> Ver Categorias Regitradas</a> </button>
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
       <script src="css/alertify.min.js" type="text/javascript"></script>
       
       <script>
        function validarCategorias(){
            nom = document.fmrCategorias.txtNombre.value;
            if(nom.length === 0){
                alertify.alert("Error","Ingrese Nombre de la categoría").set('label','OK');
                return  false;
            }else{
                alertify.success("Categoría Ingresada con exito");
                return true;
            }    
        }
        
        
        function validarTexto(){
            tecla = e.keyCode; 
            teclado = String.fromCharCode(tecla);
            if ((teclado <'A' || teclado >'z') && teclado != " "){
                return false;
            }    
    }
        
        
        
    </script>     
    </body>
    </center>
</html>